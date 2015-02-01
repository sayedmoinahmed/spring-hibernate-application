/**
 * 
 */
package org.sapient.web.controller.validator;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.service.client.UserInfoVO;
import org.sapient.web.form.LoginNameInResetPasswordForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * @author pdandi
 * 
 */
@Component("userLoginNameValidator")
public class UserLoginNameValidator {
	private static Log log = LogFactory.getLog(UserLoginNameValidator.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	public boolean supports(Class<?> clazz) {
		return ResetPasswordValidator.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		log.info("inside UserLoginNameValidator:validate");
		LoginNameInResetPasswordForm loginNameInResetPasswordForm = (LoginNameInResetPasswordForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"NotEmpty.loginNameInResetPasswordForm.userName",
				"Login name must not be empty.");
		String userName = loginNameInResetPasswordForm.getUserName();
		if (errors.getFieldErrorCount("userName") <= 0) {
			UserInfoVO userInfoVO = resumeManagementService
					.retrieveUserInfoByLoginName(userName);
			if (userInfoVO.getPersonalDetails() == null) {
				errors.rejectValue("userName",
						"DataNotExist.loginNameInResetPasswordForm.userName",
						"Login name does not exist.");
			}
		}
	}
}
