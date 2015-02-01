/**
 * 
 */
package org.sapient.web.controller.validator;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.ldap.service.LdapProvisionService;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.service.client.UserSecurityQuestionVO;
import org.sapient.web.form.ChangePasswordForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * @author brout
 * 
 */
@Component("changePasswordValidator")
public class ChangePasswordValidator {
	private static Log log = LogFactory.getLog(ChangePasswordValidator.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@Resource
	@Qualifier("ldapProvisionService")
	private LdapProvisionService ldapProvisionService;

	public boolean supports(Class<?> clazz) {
		return ChangePasswordValidator.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		log.info("inside changePasswordValidator:validate");
		ChangePasswordForm changePasswordForm = (ChangePasswordForm) target;

		/* Validating the Current Password */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPassword",
				"NotEmpty.changePasswordForm.currentPassword",
				"Current password must not be empty.");

		/* Authenticating the user with Login Credentials */
		if (errors.getFieldErrorCount("currentPassword") <= 0) {
			Boolean isAuthenticated = ldapProvisionService.authenticate(
					changePasswordForm.getLoginId(),
					changePasswordForm.getCurrentPassword());

			if (!isAuthenticated) {
				errors.rejectValue("currentPassword",
						"Invalid.changePasswordForm.currentPassword",
						"Your password did not match our records.");
			}
		}

		/* Validating the New Password */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword",
				"NotEmpty.changePasswordForm.newPassword",
				"New password must not be empty.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
				"NotEmpty.changePasswordForm.confirmPassword",
				"Confirm new password must not be empty.");

		String newPassword = changePasswordForm.getNewPassword();
		if (errors.getFieldErrorCount("newPassword") <= 0) {
			if (!newPassword
					.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*?-_=',.+]).{8,20})")) {
				errors.rejectValue(
						"newPassword",
						"Invalid.changePasswordForm.newPassword",
						"New password must contain a number, a special symbol, a lowercase & uppercase character and must be between 8 to 20 character long.");
			}
		}

		if (errors.getFieldErrorCount("newPassword") <= 0) {
			if (changePasswordForm.getCurrentPassword().equals(
					changePasswordForm.getNewPassword())) {
				errors.rejectValue("newPassword",
						"Invalid.changePasswordForm.confirmPassword",
						"The new password should not be same as the current password.");
			}
		}

		if (errors.getFieldErrorCount("newPassword") <= 0) {
			if (!changePasswordForm.getNewPassword().equals(
					changePasswordForm.getConfirmPassword())) {
				errors.rejectValue("confirmPassword",
						"Invalid.changePasswordForm.confirmPassword",
						"The new password and the confirm new password did not match.");
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "securityAnswer",
				"NotEmpty.changePasswordForm.securityAnswer",
				"Security answer must not be empty.");

		if (errors.getFieldErrorCount("securityAnswer") <= 0) {
			if (!changePasswordForm.getOriginalAnswer().equals(
					changePasswordForm.getSecurityAnswer())) {
				errors.rejectValue("securityAnswer",
						"Invalid.changePasswordForm.securityAnswer",
						"The answer to the security question did not match our records.");
			}
		}

	}
}
