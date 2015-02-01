package org.sapient.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.ldap.domain.User;
import org.sapient.ldap.service.LdapProvisionService;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.service.client.SecurityQuestionVO;
import org.sapient.service.client.UserSecurityQuestionVO;
import org.sapient.service.client.UserStatus;
import org.sapient.web.controller.validator.UpdateCredientialValidator;
import org.sapient.web.form.PasswordUpdateForm;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("securityQuestionList")
public class UpdatePasswordController {

	private static Log log = LogFactory.getLog(UpdatePasswordController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@Autowired
	@Qualifier("updateCredientialValidator")
	private UpdateCredientialValidator updateCredientialValidator;

	@Resource
	@Qualifier("ldapProvisionService")
	private LdapProvisionService ldapProvisionService;

	@RequestMapping("/showUpdatePassword.html")
	public String renderUpdatePassword(HttpServletRequest request,
			Map<String, Object> model) {
		List<SecurityQuestionVO> securityQuestionList = null;
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		PasswordUpdateForm passwordUpdateForm = new PasswordUpdateForm();
		model.put("passwordUpdateForm", passwordUpdateForm);
		if (request.getSession().getAttribute("securityQuestionList") == null) {
			securityQuestionList = resumeManagementService
					.retrieveAllSecurityQuestions();
			model.put("securityQuestionList", securityQuestionList);
		}
		return "updatePassword";
	}

	@RequestMapping("/updatePassword.html")
	public String submit(@Valid PasswordUpdateForm passwordUpdateForm,
			BindingResult result, Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		updateCredientialValidator.validate(passwordUpdateForm, result);
		log.info(String
				.format("Education Information was submitted with the following errors [%s]",
						passwordUpdateForm));
		if (result.hasErrors()) {
			log.info(String
					.format("Education Information Form was submitted with [%s] Errors",
							result.getErrorCount()));
			return "updatePassword";
		}

		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		}

		User provisionedUser = ldapProvisionService.getUser(userInfo
				.getUserName());
		log.info(String.format(
				"The LDAP Provisioned User details found [%s] [%s] [%s]",
				provisionedUser.getFirstName(), provisionedUser.getLastName(),
				provisionedUser.getUserName()));
		ldapProvisionService.delete(provisionedUser);
		log.info(String
				.format("Updating the Password for the Provisioned User from [%s] to [%s]",
						provisionedUser.getPassword(),
						passwordUpdateForm.getNewPassword()));
		provisionedUser.setPassword(passwordUpdateForm.getNewPassword());
		ldapProvisionService.save(provisionedUser);

		UserSecurityQuestionVO userSecurityQuestionVO = resumeManagementService
				.retrieveUserSecurityQuestionByUserId(userId);

		if (userSecurityQuestionVO == null) {
			userSecurityQuestionVO = new UserSecurityQuestionVO();
		}

		userSecurityQuestionVO.setUserId(userId);
		userSecurityQuestionVO.setSecurityQuestionAnswer(passwordUpdateForm
				.getAnswer());
		userSecurityQuestionVO.setSecurityQuestionId(passwordUpdateForm
				.getSecurityQuestionId());
		resumeManagementService
				.saveUserSecurityQuestion(userSecurityQuestionVO);
		resumeManagementService.updateUserStatus(userId, UserStatus.ACTIVE);		
		return "passwordChangedNotice";
		//return "redirect:/action/login.html";

	}
}
