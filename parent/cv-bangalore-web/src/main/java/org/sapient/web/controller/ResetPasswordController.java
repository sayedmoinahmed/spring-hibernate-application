/**
 * 
 */
package org.sapient.web.controller;

import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.email.Sender;
import org.sapient.ldap.domain.User;
import org.sapient.ldap.service.LdapProvisionService;
import org.sapient.service.client.PersonalInfoVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.service.client.UserInfoVO;
import org.sapient.service.client.UserSecurityQuestionVO;
import org.sapient.service.client.UserStatus;
import org.sapient.web.controller.validator.ResetPasswordValidator;
import org.sapient.web.controller.validator.UserLoginNameValidator;
import org.sapient.web.form.LoginNameInResetPasswordForm;
import org.sapient.web.form.PersonalInformationForm;
import org.sapient.web.form.ResetPasswordForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.sapient.ldap.security.RandomPasswordGenerator;

/**
 * @author pdandi
 * 
 */
@Controller
@SessionAttributes({ "resetPasswordForm", "personalInfoVO" })
public class ResetPasswordController {

	private static Log log = LogFactory.getLog(ResetPasswordController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@Autowired
	@Qualifier("userLoginNameValidator")
	private UserLoginNameValidator userLoginNameValidator;

	@Autowired
	@Qualifier("ldapProvisionService")
	private LdapProvisionService ldapProvisionService;

	@Autowired
	@Qualifier("resetPasswordValidator")
	private ResetPasswordValidator resetPasswordValidator;

	@Autowired
	private Sender sender;

	private String answer;

	@RequestMapping("/renderDefaultPage.html")
	public String renderDefaultPage(Map<String, Object> model) {
		log.info("Entering ResetPasswordController::renderDefaultPage...");
		LoginNameInResetPasswordForm loginNameInResetPasswordForm = new LoginNameInResetPasswordForm();
		model.put("loginNameInResetPasswordForm", loginNameInResetPasswordForm);
		return "getUserLoginName";
	}

	@RequestMapping("/submitUserLoginName.html")
	public String submitUserLoginName(
			@Valid LoginNameInResetPasswordForm loginNameInResetPasswordForm,
			BindingResult result, Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		log.info("Entering ResetPasswordController::submitUserLoginName...");

		userLoginNameValidator.validate(loginNameInResetPasswordForm, result);
		log.info(String
				.format("Get User LoginNameForm was submitted with the following errors [%s]",
						loginNameInResetPasswordForm));
		if (result.hasErrors()) {
			log.info(String.format(
					"Get User Login Name Form was submitted with [%s] Errors",
					result.getErrorCount()));
			return "getUserLoginName";
		}

		String userName = loginNameInResetPasswordForm.getUserName();
		if (userName != null) {
			UserInfoVO userInfoVO = resumeManagementService
					.retrieveUserInfoByLoginName(userName);

			PersonalInfoVO personalInfoVO = userInfoVO.getPersonalDetails();
			model.put("personalInfoVO", personalInfoVO);
			PersonalInformationForm personalInformationForm = new PersonalInformationForm();
			if (personalInfoVO != null) {
				personalInformationForm.setId(personalInfoVO.getId());

				log.info(String.format("id of user is [%s]",
						personalInformationForm.getId()));

				ResetPasswordForm resetPasswordForm = new ResetPasswordForm();
				UserSecurityQuestionVO userSecurityQuestionVO = resumeManagementService
						.retrieveUserSecurityQuestionByUserId(personalInformationForm
								.getId());
				if (userSecurityQuestionVO != null) {
					log.info(String.format("user security question [%s]",
							userSecurityQuestionVO.getDescription()));
					resetPasswordForm
							.setSecurityQuestion(userSecurityQuestionVO
									.getDescription());
					resetPasswordForm
							.setUserId(personalInformationForm.getId());
					resetPasswordForm.setUserName(userName);
					model.put("resetPasswordForm", resetPasswordForm);
				} else {
					return "unableToResetPassword";
				}
			}
		} else {
			return "invalidSession";
		}
		return "securityChallenge";
	}

	@RequestMapping("/submitSecurityQuestionAndAnswer.html")
	public String submitSecurityQuestionAndAnswer(
			@Valid ResetPasswordForm resetPasswordForm, BindingResult result,
			Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		log.info("Entering ResetPasswordController::submitSecurityQuestionAndAnswer...");
		resetPasswordValidator.validate(resetPasswordForm, result);
		if (!result.hasErrors()) {
			User provisionedUser = ldapProvisionService
					.getUser(resetPasswordForm.getUserName());
			log.info(String.format(
					"The LDAP Provisioned User details found [%s] [%s] [%s]",
					provisionedUser.getFirstName(),
					provisionedUser.getLastName(),
					provisionedUser.getUserName()));
			ldapProvisionService.delete(provisionedUser);
			String randomPassword = RandomPasswordGenerator.generatePassword();
			log.info(String
					.format("Updating the Password for the Provisioned User from [%s] to [%s]",
							provisionedUser.getPassword(), randomPassword));
			provisionedUser.setPassword(randomPassword);
			ldapProvisionService.save(provisionedUser);
			resumeManagementService.updateUserStatus(
					resetPasswordForm.getUserId(), UserStatus.NEW);
			SimpleMailMessage msg = new SimpleMailMessage();

			if (request.getSession().getAttribute("personalInfoVO") != null) {
				PersonalInfoVO personalInfoVO = (PersonalInfoVO) request
						.getSession().getAttribute("personalInfoVO");
				msg.setTo(personalInfoVO.getEmailAddress());
				msg.setFrom("spasha@sapient.com");
				msg.setSubject("Password Change Notification");
				Properties props = new Properties();
				props.setProperty("firstName", personalInfoVO.getFirstName());
				props.setProperty("lastName", personalInfoVO.getLastName());
				props.setProperty("randomPassword", randomPassword);
				sender.notifyPasswordChange(msg, props);
			}
			return "passwordChanged";
		}
		return "securityChallenge";
	}
}
