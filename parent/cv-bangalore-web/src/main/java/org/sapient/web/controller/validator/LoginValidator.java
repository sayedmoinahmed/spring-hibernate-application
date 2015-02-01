package org.sapient.web.controller.validator;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.ldap.service.LdapProvisionService;
import org.sapient.web.form.LoginForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("loginValidator")
public class LoginValidator {

	private static final Log log = LogFactory.getLog(LoginValidator.class);

	@Resource
	@Qualifier("ldapProvisionService")
	private LdapProvisionService ldapProvisionService;

	public boolean supports(Class<?> clazz) {
		return LoginValidator.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		LoginForm loginForm = (LoginForm) target;
		log.info(String.format("Processing the UserInformationForm [%s] ",
				loginForm));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"NotEmpty.loginForm.userName", "Please enter login id.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"NotEmpty.loginForm.password", "Please enter password.");
		if (errors.getFieldErrorCount("userName") <= 0 && errors.getFieldErrorCount("password") <= 0) {
		boolean isValidUser = ldapProvisionService.authenticate(
				loginForm.getUserName(), loginForm.getPassword());
		if (!isValidUser) {
			errors.rejectValue("password", "Invalid.loginForm.password",
					"Login id or password is incorrect.");
		}
		}
	}
}
