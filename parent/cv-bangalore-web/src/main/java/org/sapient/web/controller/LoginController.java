package org.sapient.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.ldap.service.LdapProvisionService;
import org.sapient.service.client.ContactInfoVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.service.client.UserInfoVO;
import org.sapient.service.client.UserStatus;
import org.sapient.web.controller.validator.LoginValidator;
import org.sapient.web.form.LoginForm;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/login.html")
@SessionAttributes({ "userInfo", "isAdmin" })
public class LoginController {

	private static final Log log = LogFactory.getLog(LoginController.class);

	@Resource
	@Qualifier("ldapProvisionService")
	private LdapProvisionService ldapProvisionService;

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@Autowired
	@Qualifier("loginValidator")
	private LoginValidator loginValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String renderLogin(Map<String, Object> model) {
		log.info("Entering LoginController::renderLogin()...");
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitLogin(@Valid LoginForm loginForm, BindingResult result,
			Map<String, Object> model) {
		log.info("Entering LoginController::submitLogin()...");
		loginValidator.validate(loginForm, result);
		log.info(String.format(
				"LoginForm was submitted with the following values [%s]",
				loginForm));
		if (result.hasErrors()) {
			log.info(String.format("LoginForm was submitted with [%s] Errors",
					result.getErrorCount()));
			return "login";
		}
		boolean isFirstTimeUser = false;
		UserInfoVO userInfoVO = resumeManagementService
				.retrieveUserInfoByLoginName(loginForm.getUserName());
		if (userInfoVO != null && userInfoVO.getPersonalDetails() != null) {
			UserInfo userInfo = new UserInfo();
			userInfo.setFirstName(userInfoVO.getPersonalDetails()
					.getFirstName());
			userInfo.setLastName(userInfoVO.getPersonalDetails().getLastName());
			for (ContactInfoVO contactInfoVO : userInfoVO.getContactDetails()) {
				if (contactInfoVO.getPrimaryEmail() != null) {
					userInfo.setEmailAddress(contactInfoVO.getPrimaryEmail());
				}
			}
			userInfo.setOracleId(userInfoVO.getPersonalDetails().getOracleId());
			userInfo.setUserName(userInfoVO.getPersonalDetails().getLoginId());
			userInfo.setUserId(userInfoVO.getPersonalDetails().getId());
			String designation = userInfoVO.getPersonalDetails()
					.getDesignation();
			Boolean isAdmin = false;
			if (designation.contains("People")
					|| designation.contains("staffing")) {
				isAdmin = true;
			}
			if (userInfoVO.getPersonalDetails().getUserStatus() == UserStatus.NEW) {
				isFirstTimeUser = true;
			}
			model.put("userInfo", userInfo);
		} else {
			return "accessDenied";
		}
		if (isFirstTimeUser) {
			return "redirect:/action/showUpdatePassword.html";
		} else {
			return "redirect:/action/home.html";
		}
	}
}
