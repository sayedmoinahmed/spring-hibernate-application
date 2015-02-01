/**
 * 
 */
package org.sapient.web.controller.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.routines.IntegerValidator;
import org.sapient.web.form.ProjectInformationForm;
import org.sapient.web.form.util.GregorianCalendarFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * @author brout
 * 
 */
@Component("projectInformationValidator")
public class ProjectInformationValidator {
	private static final Log log = LogFactory
			.getLog(ProjectInformationValidator.class);

	@Autowired
	@Qualifier("dateValidator")
	private DateValidator dateValidator;

	public boolean supports(Class<?> clazz) {
		return ProjectInformationValidator.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ProjectInformationForm projectInformationForm = (ProjectInformationForm) target;
		/**
		 * title validation
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
				"NotEmpty.projectInformationForm.title",
				"Project title must not be empty.");
		String title = projectInformationForm.getTitle();
		if (errors.getFieldErrorCount("title") <= 0) {
			if (title.length() > 100) {
				errors.rejectValue("title",
						"lengthOfTitle.projectInformationForm.title",
						"Project title must be within 100 characters.");
			} else {
				Pattern p = Pattern.compile("^[a-zA-Z&,.:)(@*# \\s0-9]+$");
				Matcher m = p.matcher(title);
				boolean condition = m.matches();
				if (condition == false) {
					errors.rejectValue("title",
							"title.projectInformationForm.title",
							"Project title must not contains special characters.");
				}
			}
		}

		/**
		 * description validation
		 */

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"NotEmpty.projectInformationForm.description",
				"Project description must not be empty.");
		String description = projectInformationForm.getDescription();
		if (errors.getFieldErrorCount("description") <= 0) {
			if (description.length() > 800)
				errors.rejectValue(
						"description",
						"lengthOfDescription.projectInformationForm.description",
						"Project description must be within 800 characters.");
		}
		/**
		 * client validation
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "client",
				"NotEmpty.projectInformationForm.client",
				"Project client must not be empty.");
		if (projectInformationForm.getClient().length() <= 0) {
			if (projectInformationForm.getClient().length() >= 100)
				errors.rejectValue("client",
						"lengthOfClient.projectInformationForm.client",
						"Project client name must not exceed 100 characters.");
		}
		String client = projectInformationForm.getClient();
		if (errors.getFieldErrorCount("client") <= 0) {
			Pattern p = Pattern.compile("^[a-zA-Z&,.:)(@*# \\s0-9]+$");
			Matcher m = p.matcher(client);
			boolean condition = m.matches();
			if (condition == false) {
				errors.rejectValue("client",
						"client.projectInformationForm.client",
						"Project client name must not contain special characters.");
			}
		}
		/**
		 * size validation
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "size",
				"NotEmpty.projectInformationForm.client",
				"Project team size  must not be empty.");
		Integer teamSize = IntegerValidator.getInstance().validate(
				projectInformationForm.getSize());
		if (errors.getFieldErrorCount("size") <= 0) {
			if (teamSize == null) {
				errors.rejectValue("size",
						"lengthOfSize.projectInformationForm.size",
						"Invalid project team size.");
			}
		}
		String size = projectInformationForm.getSize();
		if (errors.getFieldErrorCount("size") <= 0) {
			if (teamSize < 1) {
				errors.rejectValue("size",
						"lengthOfSize.projectInformationForm.size",
						"Invalid project team size.");
			} else {
				Pattern p = Pattern.compile("^[0-9]+$");
				Matcher m = p.matcher(size);
				boolean condition = m.matches();
				if (condition == false) {
					errors.rejectValue("size",
							"lengthOfSize.projectInformationForm.size",
							"Project team size must not contain white spaces or characters.");
				}
			}
		}

		/**
		 * role validation
		 */

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role",
				"NotEmpty.projectInformationForm.role",
				"Role must not be empty.");
		String role = projectInformationForm.getRole();
		if (errors.getFieldErrorCount("role") <= 0) {
			if (role.length() > 500)
				errors.rejectValue("role",
						"lengthOfRole.projectInformationForm.role",
						"Project role must be within 500 characters.");
			else {
				Pattern p = Pattern.compile("^[a-zA-Z&,. @\\s]+$");
				Matcher m = p.matcher(role);
				boolean condition = m.matches();
				if (condition == false) {
					errors.rejectValue("role",
							"title.projectInformationForm.title",
							"Project role must not contain numbers or special characters.");
				}
			}
		}
		/**
		 * responsibilities validation
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "responsibilities",
				"NotEmpty.projectInformationForm.responsibilities",
				"Business values must not be empty.");
		String responsibilities = projectInformationForm.getResponsibilities();
		if (errors.getFieldErrorCount("responsibilities") <= 0) {
			if (responsibilities.length() > 800)
				errors.rejectValue(
						"responsibilities",
						"lengthOfResponsibilities.projectInformationForm.responsibilities",
						"Business values must not exceed 800 characters.");
			
		}
		/**
		 * technology validation
		 */

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "technologies",
				"NotEmpty.projectInformationForm.technologies",
				"Key technologies must not be empty.");
		String technologies = projectInformationForm.getTechnologies();
		if (errors.getFieldErrorCount("technologies") <= 0) {
			if (technologies.length() > 500)
				errors.rejectValue(
						"technologies",
						"lengthOftechnologies .projectInformationForm.responsibilities",
						"Key technologies  must be within 500 characters.");

		}
		GregorianCalendarFields startDate = projectInformationForm
				.getStartDate();
		log.info(String.format("The startdate Obtained is [%s]", startDate));
		if ((startDate.getYear() == null || startDate.getYear().equals(""))
				|| (startDate.getMonth() == null || startDate.getMonth()
						.equals("")) || startDate.getDay() == null
				|| startDate.getDay().equals("")) {
			errors.rejectValue("startDate",
					"NotEmpty.projectInformationForm.startDate",
					"Invalid project start date.");
		} else {
			log.info(String.format("Validating Start Date [%s]", startDate));
			boolean isValidStartDate = dateValidator.validate(
					startDate.getYear(), startDate.getMonth(),
					startDate.getDay());
			if (!isValidStartDate) {
				errors.rejectValue("startDate",
						"dateFormat.projectformationForm.startDate",
						"Invalid project start date.");
			}
		}

		/**
		 * endDate validation
		 */
		GregorianCalendarFields endDate = projectInformationForm.getEndDate();
		log.info(String.format("The EndDate Obtained is [%s]", endDate));
		if ((endDate.getYear() == null || startDate.getYear().equals("")
				|| endDate.getMonth() == null || startDate.getYear().equals(""))
				|| endDate.getDay() == null || startDate.getYear().equals("")) {
			errors.rejectValue("endDate",
					"NotEmpty.educationInformationForm.yearOfPassing",
					"Invalid project end date.");
		} else {
			log.info(String.format("Validating the End Date [%s]", endDate));
			boolean isValidEndDate = dateValidator.validate(endDate.getYear(),
					endDate.getMonth(), endDate.getDay());
			if (!isValidEndDate) {
				errors.rejectValue("endDate",
						"dateFormat.projectInformationForm.endDate",
						"Invalid project end date.");
			}
		}
		if (errors.getFieldErrorCount("startDate") <= 0) {
			log.info(String.format("Validating for future dates [%s]",
					startDate));
			boolean isFutureDate = dateValidator.isFutureDate(
					startDate.getYear(), startDate.getMonth(),
					startDate.getDay());
			if (isFutureDate) {
				errors.rejectValue("startDate",
						"dateFormat.projectInformationForm.startDate",
						"Invalid project start date.");
			}
		}
		if (errors.getFieldErrorCount("endDate") <= 0) {
			log.info(String.format("Validating for future dates [%s]", endDate));
			boolean isFutureDate = dateValidator.isFutureDate(
					endDate.getYear(), endDate.getMonth(), endDate.getDay());
			if (isFutureDate) {
				errors.rejectValue("endDate",
						"dateFormat.educationInformationForm.yearOfPassing",
						"Invalid project end date.");
			}
		}

		if (errors.getFieldErrorCount("endDate") <= 0
				&& errors.getFieldErrorCount("startDate") <= 0) {
			if (projectInformationForm.getStartDate().getYear() >= projectInformationForm
					.getEndDate().getYear()
					&& projectInformationForm.getStartDate().getMonth() >= projectInformationForm
							.getEndDate().getMonth()
					&& projectInformationForm.getStartDate().getDay() >= projectInformationForm
							.getEndDate().getDay()) {
				errors.rejectValue("endDate",
						"dateFormat.projectInformationForm.endDate",
						"project end date must be greater than project start date.");
			}
		}

	}

}
