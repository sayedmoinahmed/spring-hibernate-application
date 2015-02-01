package org.sapient.web.controller.validator;

import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.EmploymentInfoVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.web.form.EmploymentInformationForm;
import org.sapient.web.form.util.GregorianCalendarFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("employmentInformationValidator")
public class EmploymentInformationValidator {

	private static final Log log = LogFactory
			.getLog(EmploymentInformationValidator.class);

	@Autowired
	@Qualifier("dateValidator")
	private DateValidator dateValidator;

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	public boolean supports(Class<?> clazz) {
		return EmploymentInformationValidator.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		EmploymentInformationForm employmentInformationForm = (EmploymentInformationForm) target;
		log.info(String
				.format("Validating the Employment Information Form with the values [%s]",
						employmentInformationForm));

		/**
		 * employerName validation
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employerName",
				"NotEmpty.employmentInformationForm.employerName",
				"Employer name must not be empty.");
		String employerName = employmentInformationForm.getEmployerName();
		log.info("employerName Validation");
		if (errors.getFieldErrorCount("employerName") <= 0) {
			if (employerName.length() > 50)
				errors.rejectValue(
						"employerName",
						"lengthOfEmployerName.employmentInformationForm.employerName",
						"Employer name must not exceed 50 characters.");
		}
		if (errors.getFieldErrorCount("employerName") <= 0) {
			if (!employerName.matches("^[a-zA-Z0-9,.&^ \\s]*$")) {
				log.info("alphabatic validation in employer name");
				errors.rejectValue(
						"employerName",
						"NotNumberEmployerName.employmentInformationForm.employerName",
						"Employer name must not contain numbers & special character.");

			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employmentType",
				"NotEmpty.employmentInformationForm.employmentType",
				"Employment type must not be empty.");

		GregorianCalendarFields dateOfJoining = employmentInformationForm
				.getDateOfJoining();
		log.info(String.format("The date of Joining Obtained is [%s]",
				dateOfJoining));
		if (dateOfJoining.getYear() == null || dateOfJoining.getMonth() == null
				|| dateOfJoining.getDay() == null) {
			errors.rejectValue("dateOfJoining",
					"NotEmpty.employmentInformationForm.dateOfJoining",
					"Date of joining must not be empty.");
		} else {
			log.info(String.format("Validating the date of Joining [%s]",
					dateOfJoining));
			boolean isValidDate = dateValidator.validate(
					dateOfJoining.getYear(), dateOfJoining.getMonth(),
					dateOfJoining.getDay());
			if (!isValidDate) {
				errors.rejectValue("dateOfJoining",
						"InvalidDate.employmentInformationForm.dateOfJoining",
						"Invalid date of joining.");
			}
		}
		if (errors.getFieldErrorCount("dateOfJoining") <= 0) {
			log.info(String.format("Validating for future dates [%s]",
					dateOfJoining));
			boolean isFutureDate = dateValidator.isFutureDate(
					dateOfJoining.getYear(), dateOfJoining.getMonth(),
					dateOfJoining.getDay());
			if (isFutureDate) {
				errors.rejectValue("dateOfJoining",
						"dateFormat.employmentInformationForm.dateOfJoining",
						"Invalid date of joining.");
			}
		}

		if (employmentInformationForm.getCurrentEmployer() == false) {
			GregorianCalendarFields dateOfRelieving = employmentInformationForm
					.getDateOfRelieving();
			log.info(String.format("The date of Relieving Obtained is [%s]",
					dateOfRelieving));
			if (dateOfRelieving != null) {
				if (dateOfRelieving.getYear() == null
						|| dateOfRelieving.getMonth() == null
						|| dateOfRelieving.getDay() == null) {
					errors.rejectValue(
							"dateOfRelieving",
							"NotEmpty.employmentInformationForm.dateOfRelieving",
							"Date of relieving must not be empty.");
				} else {
					log.info(String.format(
							"Validating the date of Relieving [%s]",
							dateOfRelieving));
					boolean isValidDate = dateValidator.validate(
							dateOfRelieving.getYear(),
							dateOfRelieving.getMonth(),
							dateOfRelieving.getDay());
					if (!isValidDate) {
						errors.rejectValue(
								"dateOfRelieving",
								"InvalidDate.employmentInformationForm.dateOfRelieving",
								"Invalid date of relieving.");
					}
				}
				if (errors.getFieldErrorCount("dateOfRelieving") <= 0) {
					log.info(String.format("Validating for future dates [%s]",
							dateOfRelieving));
					boolean isFutureDate = dateValidator.isFutureDate(
							dateOfRelieving.getYear(),
							dateOfRelieving.getMonth(),
							dateOfRelieving.getDay());
					if (isFutureDate) {
						errors.rejectValue(
								"dateOfRelieving",
								"dateFormat.employmentInformationForm.dateOfRelieving",
								"Invalid date of relieving.");
					}
				}

				if (errors.getFieldErrorCount("dateOfRelieving") <= 0
						&& errors.getFieldErrorCount("dateOfJoining") <= 0) {
					if (dateOfJoining.getDay() >= dateOfRelieving.getDay()
							&& dateOfJoining.getMonth() >= dateOfRelieving
									.getMonth()
							&& dateOfJoining.getYear() >= dateOfRelieving
									.getYear()) {
						errors.rejectValue(
								"dateOfRelieving",
								"dateFormat.employmentInformationForm.dateOfRelieving",
								"Date of relieving must be greater than date of joining.");
					} else if (dateOfJoining.getMonth() > dateOfRelieving
							.getMonth()
							&& dateOfJoining.getYear() >= dateOfRelieving
									.getYear()) {
						errors.rejectValue(
								"dateOfRelieving",
								"dateFormat.employmentInformationForm.dateOfRelieving",
								"Date of relieving must be greater than date of joining.");

					} else if (dateOfJoining.getYear() > dateOfRelieving
							.getYear()) {
						errors.rejectValue(
								"dateOfRelieving",
								"dateFormat.employmentInformationForm.dateOfRelieving",
								"Date of relieving must be greater than date of joining.");
					}
				}
			} else {
				errors.rejectValue("dateOfRelieving",
						"dateFormat.employmentInformationForm.dateOfRelieving",
						"Date of relieving must not be empty.");
			}
		} else {
			log.info(String
					.format("Validating if there are more than one current employers for the userId [%s]",
							employmentInformationForm.getUserId()));
			Boolean isCurrentEmployerFound = resumeManagementService
					.isCurrentEmployerExists(employmentInformationForm
							.getUserId());
			if (isCurrentEmployerFound) {
				EmploymentInfoVO employmentInfoVO = resumeManagementService
						.getCurrentEmploymentDetail(employmentInformationForm
								.getUserId());
				log.info("The Current Employer Id retrieved is "
						+ employmentInfoVO.getEmploymentInfoId());
				log.info("The Current Employer Id for Editing is "
						+ employmentInformationForm.getEmploymentInfoId());
				if (employmentInfoVO.getEmploymentInfoId().equals(
						employmentInformationForm.getEmploymentInfoId())) {
					log.info("Editing the details of Current Employment is Allowed...");
				} else {
					errors.rejectValue(
							"dateOfRelieving",
							"moreThanOneCurrentEmployer.employmentInformationForm.dateOfRelieving",
							"Can not add more than 1 current employer.");
				}
			}

		}
		/**
		 * designation validation
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designation",
				"NotEmpty.employmentInformationForm.designation",
				"Designation must not be empty.");
		String designation = employmentInformationForm.getDesignation();
		log.info("designation Validation");
		if (errors.getFieldErrorCount("designation") <= 0) {
			if (designation.length() > 50)
				errors.rejectValue(
						"designation",
						"lengthOfDesignation.employmentInformationForm.designation",
						"Designation must not exceed 50 characters.");
		}
		if (errors.getFieldErrorCount("designation") <= 0) {
			if (!designation.matches("^[a-zA-Z0-9,. \\s]*$")) {
				log.info("alphabatic validation in designation");
				errors.rejectValue(
						"designation",
						"NotNumberDesignation.employmentInformationForm.designation",
						"Designation must not contain special character.");

			}
		}

		/**
		 * supervisorName validation
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "supervisorName",
				"NotEmpty.employmentInformationForm.supervisorName",
				"Supervisor name must not be empty.");
		String supervisorName = employmentInformationForm.getSupervisorName();
		log.info("supervisorName Validation");
		if (errors.getFieldErrorCount("supervisorName") <= 0) {
			if (supervisorName.length() > 50)
				errors.rejectValue(
						"supervisorName",
						"lengthOfsupervisorName.employmentInformationForm.supervisorName",
						"Supervisor name must not exceed 50 characters.");
		}
		if (errors.getFieldErrorCount("supervisorName") <= 0) {
			if (!supervisorName.matches("^[a-zA-Z \\s]*$")) {
				log.info("alphabatic validation in supervisorName");
				errors.rejectValue(
						"supervisorName",
						"NotNumbersupervisorName.employmentInformationForm.supervisorName",
						"Supervisor name must not contain numbers & special character.");

			}
		}

		/**
		 * Address validation
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"employmentAddress.city",
				"NotEmpty.employmentInformationForm.employmentAddress.city",
				"Employment address must not be empty.");
		String employmentAddress = employmentInformationForm
				.getEmploymentAddress().getCity();
		if (errors.getFieldErrorCount("employmentAddress.city") <= 0) {
			if (employmentAddress.length() > 50)
				errors.rejectValue(
						"employmentAddress.city",
						"lengthOfEmploymentAddress.employmentInformationForm.employmentAddress.city",
						"City must not exceed 50 characters.");
		}
		if (errors.getFieldErrorCount("employmentAddress.city") <= 0) {
			if (!employmentAddress.matches("^[a-zA-Z \\s]*$")) {
				log.info("alphabatic validation in city");
				errors.rejectValue(
						"employmentAddress.city",
						"NotNumberEmploymentAddress.employmentInformationForm.employmentAddress.city",
						"City must not contain numbers & special character.");

			}
		}

		if (errors.getFieldErrorCount("employmentAddress.city") <= 0) {
			ValidationUtils
					.rejectIfEmptyOrWhitespace(
							errors,
							"employmentAddress.state",
							"NotEmpty.employmentInformationForm.employmentAddress.state",
							"Employment address must not be empty.");
			employmentAddress = employmentInformationForm
					.getEmploymentAddress().getState();
			if (errors.getFieldErrorCount("employmentAddress.state") <= 0) {
				if (employmentAddress.length() > 50)
					errors.rejectValue(
							"employmentAddress.state",
							"lengthOfEmploymentAddress.employmentInformationForm.employmentAddress.state",
							"State must not exceed 50 characters.");
			}
			if (errors.getFieldErrorCount("employmentAddress.state") <= 0) {
				if (!employmentAddress.matches("^[a-zA-Z \\s]*$")) {
					log.info("alphabatic validation in state");
					errors.rejectValue(
							"employmentAddress.state",
							"NotNumberEmploymentAddress.employmentInformationForm.employmentAddress.state",
							"State must not contain numbers & special character.");

				}
			}

			if (errors.getFieldErrorCount("employmentAddress.state") <= 0) {
				/**
				 * Zip code validation
				 */
				String zip = employmentInformationForm.getEmploymentAddress()
						.getZipCode();
				log.info("Zip Code Validation");
				if (!(Pattern.matches("^\\d{5}?$", zip)
						|| (Pattern.matches("^\\d{6}?$", zip)) || (zip
						.equals("")))) {
					errors.rejectValue(
							"employmentAddress.zipCode",
							"zipCode.employmentInformationForm.employmentAddress.zipCode",
							"Invalid zip code value.");
				}

				if (errors.getFieldErrorCount("employmentAddress.zipCode") <= 0) {
					ValidationUtils
							.rejectIfEmptyOrWhitespace(
									errors,
									"employmentAddress.country",
									"NotEmpty.employmentInformationForm.employmentAddress.country",
									"Employment address must not be empty.");
					employmentAddress = employmentInformationForm
							.getEmploymentAddress().getCountry();
					if (errors.getFieldErrorCount("employmentAddress.country") <= 0) {
						if (employmentAddress.length() > 50)
							errors.rejectValue(
									"employmentAddress.country",
									"lengthOfEmploymentAddress.employmentInformationForm.employmentAddress.country",
									"Country must not exceed 50 characters.");
					}
					if (errors.getFieldErrorCount("employmentAddress.country") <= 0) {
						if (!employmentAddress.matches("^[a-zA-Z \\s]*$")) {
							log.info("alphabatic validation in country");
							errors.rejectValue(
									"employmentAddress.country",
									"NotNumberEmploymentAddress.employmentInformationForm.employmentAddress.country",
									"Country must not contain numbers & special character.");
						}
					}
				}
			}
		}
	}
}
