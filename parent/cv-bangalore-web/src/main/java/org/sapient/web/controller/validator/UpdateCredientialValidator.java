package org.sapient.web.controller.validator;

import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.web.form.EmploymentInformationForm;
import org.sapient.web.form.PasswordUpdateForm;
import org.sapient.web.form.util.GregorianCalendarFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("updateCredientialValidator")
public class UpdateCredientialValidator {

	// static final String regex1 = "^\\d{5}?$";
	// static final String regex2 = "^\\d{6}?$";

	private static final Log log = LogFactory
			.getLog(UpdateCredientialValidator.class);

	@Autowired
	@Qualifier("dateValidator")
	private DateValidator dateValidator;

	public boolean supports(Class<?> clazz) {
		return UpdateCredientialValidator.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		PasswordUpdateForm passwordUpdateForm = (PasswordUpdateForm) target;
		log.info(String
				.format("Validating the Employment Information Form with the values [%s]",
						passwordUpdateForm));
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"NotEmpty.passwordUpdateForm.password",
				"Password must not be empty.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword",
				"NotEmpty.passwordUpdateForm.newPassword",
				"New password must not be empty.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer",
				"NotEmpty.passwordUpdateForm.answer",
				"Answer must not be empty.");

		/**
		 * Password validation
		 */

		String password = passwordUpdateForm.getPassword();
		/*
		 * if (password.length() > 10) errors.rejectValue("password",
		 * "Password must not exceed 10 characters.");
		 */
		if (errors.getFieldErrorCount("password") <= 0) {
			if (!password
					.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*?-_=',.+]).{8,20})")) {
				log.info("password validation");
				errors.rejectValue(
						"password",
						"passwordValidation.passwordUpdateForm.password",
						"Password must contain a number, a special symbol, a lowercase & uppercase character and must be between 8 to 20 character long.");

			}

		}
		if ((errors.getFieldErrorCount("newPassword") <= 0)
				&& (errors.getFieldErrorCount("password") <= 0)) {
			String newpassword = passwordUpdateForm.getNewPassword();
			boolean b = true;
			if (password.equals(newpassword))
				b = false;
			else
				errors.rejectValue("newPassword", "Both should be same",
						"The new password and confirm new password should match");
		}

	}
}
