package org.sapient.web.controller.validator;

import org.sapient.web.form.RecognitionInformationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * @author pdandi
 * 
 */
@Component("recognitionValidator")
public class RecognitionValidator {
	public boolean supports(Class<?> clazz) {
		return RecognitionValidator.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		RecognitionInformationForm recognitionInformationForm = (RecognitionInformationForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "items",
				"NotEmpty.recognitionInformationForm.items",
				"Description must not be empty.");
		String items = recognitionInformationForm.getItems();
		if (errors.getFieldErrorCount("items") <= 0) {
			if (items.length() < 1)
				errors.rejectValue("items",
						"lengthOfItems.recognitionInformationForm.items",
						"Description must be at least 1 characters long.");
			else if (items.length() > 100)
				errors.rejectValue("items",
						"lengthOfItems.recognitionInformationForm.items",
						"Description must not exceed 100 characters.");
		}

	}
}
