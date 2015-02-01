/**
 * 
 */
package org.sapient.web.controller.validator;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.service.client.UserSecurityQuestionVO;
import org.sapient.web.form.ResetPasswordForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * @author pdandi
 * 
 */
@Component("resetPasswordValidator")
public class ResetPasswordValidator {
	private static Log log = LogFactory.getLog(UserLoginNameValidator.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	public boolean supports(Class<?> clazz) {
		return ResetPasswordValidator.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		log.info("inside ResetPasswordValidator:validate");
		ResetPasswordForm resetPasswordForm = (ResetPasswordForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer",
				"NotEmpty.resetPasswordForm.answer",
				"Security answer must not be empty.");

		if (!errors.hasErrors()) {
			UserSecurityQuestionVO userSecurityQuestionVO = resumeManagementService
					.retrieveUserSecurityQuestionByUserId(resetPasswordForm
							.getUserId());

			if (!userSecurityQuestionVO.getSecurityQuestionAnswer()
					.equalsIgnoreCase(resetPasswordForm.getAnswer())) {
				errors.rejectValue("answer",
						"Invalid.resetPasswordForm.answer",
						"Invalid security answer for the security question.");
			}
		}

	}
}
