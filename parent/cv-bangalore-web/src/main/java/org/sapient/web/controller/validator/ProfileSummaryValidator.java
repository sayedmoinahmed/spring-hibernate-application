package org.sapient.web.controller.validator;

import org.sapient.web.form.ProfileSummaryForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("profileSummaryValidator")
public class ProfileSummaryValidator {

	public boolean supports(Class<?> clazz) {
		return ProfileSummaryValidator.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ProfileSummaryForm profileSummaryForm = (ProfileSummaryForm) target;
		ValidationUtils
				.rejectIfEmptyOrWhitespace(errors, "title",
						"NotEmpty.profileSummaryForm.title",
						"Title must not be empty.");
		String title = profileSummaryForm.getTitle();
		if (errors.getFieldErrorCount("title") <= 0) {
			if (title.length() < 50)
				errors.rejectValue("title",
						"lengthOfTitle.profileSummaryForm.title",
						"Title must be at least 50 characters long.");
			else if (title.length() > 200)
				errors.rejectValue("title",
						"lengthOfTitle.profileSummaryForm.title",
						"Title must not exceed 200 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"NotEmpty.profileSummaryForm.description",
				"Description must not be empty.");
		String description = profileSummaryForm.getDescription();
		if (errors.getFieldErrorCount("description") <= 0) {
			if (description.length() < 100)
				errors.rejectValue("description",
						"lengthOfDescription.profileSummaryForm.description",
						"Description must be at least 100 characters long.");
			else if (description.length() > 500)
				errors.rejectValue("description",
						"lengthOfDescription.profileSummaryForm.description",
						"Description must not exceed 500 characters.");
		}

	}
}
