/**
 * 
 */
package org.sapient.web.controller.validator;

import org.sapient.web.form.SkillInformationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * @author komar
 * 
 */
@Component("skillInformationValidator")
public class SkillInformationValidator {
	public boolean supports(Class<?> clazz) {
		return SkillInformationValidator.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		SkillInformationForm skillInformationForm = (SkillInformationForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "items",
				"NotEmpty.skillInformationForm.items",
				"Skill name must not be empty.");
		String items = skillInformationForm.getItems();
		if (errors.getFieldErrorCount("items") <= 0) {
			if (items.length() < 1)
				errors.rejectValue("items",
						"lengthOfItems.skillInformationForm.items",
						"Skill name must be at least 1 characters long.");
			else if (items.length() > 100)
				errors.rejectValue("items",
						"lengthOfItems.skillInformationForm.items",
						"Skill name must not exceed 100 characters.");
		}

	}
}
