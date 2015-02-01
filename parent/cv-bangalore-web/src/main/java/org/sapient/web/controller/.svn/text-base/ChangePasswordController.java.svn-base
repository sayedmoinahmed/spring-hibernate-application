/**
 * 
 */
package org.sapient.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.ldap.domain.User;
import org.sapient.ldap.service.LdapProvisionService;
import org.sapient.service.client.PersonalInfoVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.service.client.SecurityQuestionVO;
import org.sapient.service.client.UserInfoVO;
import org.sapient.service.client.UserSecurityQuestionVO;
import org.sapient.web.controller.validator.ChangePasswordValidator;
import org.sapient.web.form.ChangePasswordForm;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author brout
 * 
 */
@Controller
public class ChangePasswordController {

	private static final Log log = LogFactory
			.getLog(ChangePasswordController.class);

	@Resource
	@Qualifier("ldapProvisionService")
	private LdapProvisionService ldapProvisionService;

	@Autowired
	@Qualifier("changePasswordValidator")
	private ChangePasswordValidator changePasswordValidator;

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	PersonalInfoVO personalInfoVO;

	@RequestMapping("/changePassword.html")
	public String renderChangePasswordPage(HttpServletRequest req,
			HttpServletResponse res, Map<String, Object> model) {
		log.info("Entering ChangePasswordController::renderChangePasswordPage()...");
		List<SecurityQuestionVO> securityQuestionList = null;
		HttpSession httpSession = req.getSession();
		UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
		if (userInfo != null) {
			UserInfoVO userInfoVO = resumeManagementService
					.retrieveUserInfoByLoginName(userInfo.getUserName());

			personalInfoVO = userInfoVO.getPersonalDetails();

			UserSecurityQuestionVO userSecurityQuestionVO = resumeManagementService
					.retrieveUserSecurityQuestionByUserId(personalInfoVO
							.getId());
			ChangePasswordForm changePasswordForm = new ChangePasswordForm();
			changePasswordForm.setUserId(userSecurityQuestionVO.getUserId());
			changePasswordForm.setLoginId(personalInfoVO.getLoginId());
			changePasswordForm.setSecurityQuestion(userSecurityQuestionVO
					.getDescription());
			changePasswordForm.setOriginalAnswer(userSecurityQuestionVO
					.getSecurityQuestionAnswer());
			model.put("changePasswordForm", changePasswordForm);
			return "changePassword";
		} else {
			return "invalidSession";
		}

	}

	@RequestMapping("/submitChangePassword.html")
	public String submitChangePassword(
			@Valid ChangePasswordForm changePasswordForm, BindingResult result,
			Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		UserInfo userInfo = null;
		userInfo = (UserInfo) request.getSession().getAttribute("userInfo");

		if (userInfo != null) {
			log.info("Entering ChangePasswordController::submitsubmitChangePassword()...");
			changePasswordValidator.validate(changePasswordForm, result);

			if (result.hasErrors()) {
				model.put("changePasswordForm", changePasswordForm);
				return "changePassword";
			}

			User user = ldapProvisionService.getUser(changePasswordForm
					.getLoginId());
			ldapProvisionService.delete(user);
			user.setPassword(changePasswordForm.getNewPassword());
			ldapProvisionService.save(user);
			return "changePasswordSuccess";
		} else {
			return "invalidSession";
		}
	}
}
