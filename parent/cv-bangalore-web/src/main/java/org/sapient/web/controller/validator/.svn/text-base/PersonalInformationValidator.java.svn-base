package org.sapient.web.controller.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.sapient.service.client.EmploymentType;
import org.sapient.web.form.PersonalInformationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("personalInformationValidator")
public class PersonalInformationValidator implements Validator {

	@Autowired
	@Qualifier("dateValidator")
	private DateValidator dateValidator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	public boolean supports(Class<?> clazz) {
		return PersonalInformationValidator.class.isAssignableFrom(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	public void validate(Object target, Errors errors) {
		PersonalInformationForm personalInformationForm = (PersonalInformationForm) target;
		System.out.println("Validate");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oracleId",
				"NotEmptyOrWhitespace.personalInformationForm.oracleId",
				"OracleId must not be Empty.");
		Long oracleId = personalInformationForm.getOracleId();
		if (errors.getFieldErrorCount("oracleId") <= 0) {
			if (oracleId.toString() == null) {
				errors.rejectValue(
						"oracleId",
						"NotEmptyOrWhitespace.personalInformationForm.oracleId",
						"Oracle id must not be empty.");

			} else if (oracleId.toString().length() > 6) {
				errors.rejectValue("oracleId",
						"lengthOfOracleId.personalInformationForm.oracleId",
						"Oracle id can not be more than 6 characters.");
			} else {
				Pattern p = Pattern.compile("([0-9]*)");
				Matcher m = p.matcher(oracleId.toString());
				boolean condition = m.matches(); // TRUE
				if (condition == false) {
					errors.rejectValue(
							"oracleId",
							"lengthOfOracleId.personalInformationForm.oracleId",
							"Oracle id can not contain alphabets.");
				}
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginId",
				"NotEmptyOrWhitespace.personalInformationForm.loginId",
				"LoginId must not be Empty.");
		String loginId = personalInformationForm.getLoginId();
		if (errors.getFieldErrorCount("loginId") <= 0) {
			if (loginId.length() == 0) {
				errors.rejectValue("loginId",
						"lengthOfLoginId.personalInformationForm.loginId",
						"Login id must not be empty.");
			}
			else if(loginId.length()>16){
				errors.rejectValue("loginId",
						"lengthOfLoginId.personalInformationForm.loginId",
						"Login id must be less than 16 characters.");
			}
		}

		ValidationUtils.rejectIfEmpty(errors, "firstName",
				"NotEmptyOrWhitespace.personalInformationForm.firstName",
				"FirstName must not be Empty.");
		String firstName = personalInformationForm.getFirstName();
		if (errors.getFieldErrorCount("firstName") <= 0) {
			if (firstName.length() < 0) {
				errors.rejectValue("firstName",
						"lengthOfFirstName.personalInformationForm.firstName",
						"First name must not be less than 0 characters.");
			} else if (firstName.length() > 64) {
				errors.rejectValue("firstName",
						"lengthOfFirstName.personalInformationForm.firstName",
						"First name must not be greater than 50 characters.");
			}
		}

		ValidationUtils.rejectIfEmpty(errors, "middleName",
				"NotEmpty.personalInformationForm.middleName",
				"Middle name must not be empty.");
		String middleName = personalInformationForm.getMiddleName();
		if (errors.getFieldErrorCount("middleName") <= 0) {
			if (middleName.length() < 0) {
				errors.rejectValue(
						"middleName",
						"lengthOfMiddleName.personalInformationForm.middleName",
						"Middle name must not be empty.");
			} else if (middleName.length() > 64) {
				errors.rejectValue(
						"middleName",
						"lengthOfMiddleName.personalInformationForm.middleName",
						"Middle name must not be greater than 50 characters.");
			}
		}

		ValidationUtils.rejectIfEmpty(errors, "lastName",
				"NotEmpty.personalInformationForm.lastName",
				"Last name must not be empty.");
		String lastName = personalInformationForm.getLastName();
		if (errors.getFieldErrorCount("lastName") <= 0) {
			if (lastName.length() < 0) {
				errors.rejectValue("lastName",
						"lengthOfLastName.personalInformationForm.lastName",
						"Last name must not be empty.");
			} else if (lastName.length() > 64) {
				errors.rejectValue("lastName",
						"lengthOfLastName.personalInformationForm.lastName",
						"Last name must not be greater than 50 characters.");
			}
		}

		ValidationUtils.rejectIfEmpty(errors, "fatherName",
				"NotEmpty.personalInformationForm.fatherName",
				"Father name must not be empty.");
		String fatherName = personalInformationForm.getFatherName();
		if (errors.getFieldErrorCount("fatherName") <= 0) {
			if (fatherName.length() < 0) {
				errors.rejectValue(
						"fatherName",
						"lengthOffatherName.personalInformationForm.fatherName",
						"Father name must not be empty.");
			} else if (fatherName.length() > 64) {
				errors.rejectValue(
						"fatherName",
						"lengthOffatherName.personalInformationForm.fatherName",
						"Father name must not be greater than 50 characters.");
			}
		}

		ValidationUtils.rejectIfEmpty(errors, "dateOfBirth",
				"NotEmpty.personalInformationForm.dateOfBirth",
				"Date of birth must not be empty.");
		boolean isDateOfBirth = dateValidator.validate(personalInformationForm
				.getDateOfBirth().getYear(), personalInformationForm
				.getDateOfBirth().getMonth(), personalInformationForm
				.getDateOfBirth().getDay());
		if (!isDateOfBirth) {
			errors.rejectValue("dateOfBirth",
					"dateFormat.personalInformationForm.dateOfBirth",
					"Invalid date Of birth");
		}
		
		ValidationUtils.rejectIfEmpty(errors, "dateOfJoining",
				"NotEmpty.personalInformationForm.dateOfJoining",
				"Date of joining must not be empty.");
		boolean isDateOfJoining = dateValidator.validate(
				personalInformationForm.getDateOfJoining().getYear(),
				personalInformationForm.getDateOfJoining().getMonth(),
				personalInformationForm.getDateOfJoining().getDay());
		if (!isDateOfJoining) {
			errors.rejectValue("dateOfJoining",
					"dateFormat.personalInformationForm.dateOfJoining",
					"Invalid date Of joining");
		}
		if (errors.getFieldErrorCount("dateOfBirth") <= 0 && errors.getFieldErrorCount("dateOfJoining")<=0) {
			if (personalInformationForm.getDateOfBirth().getYear() >= personalInformationForm
					.getDateOfJoining().getYear()
					&& personalInformationForm.getDateOfBirth().getMonth() >= personalInformationForm
							.getDateOfJoining().getMonth()
					&& personalInformationForm.getDateOfBirth().getDay() >= personalInformationForm
							.getDateOfJoining().getDay()) {
						errors.rejectValue("dateOfJoining",
						"dateFormat.personalInformationForm.dateOfJoining",
						"Date of joining must be greater than date of birth.");
			}
		}

		ValidationUtils.rejectIfEmpty(errors, "personType",
				"NotEmpty.personalInformationForm.personType",
				"Person type must not be empty.");
		EmploymentType personType = personalInformationForm.getPersonType();
		if (errors.getFieldErrorCount("personType") <= 0) {
			if (personType.toString() != "PERMANENT"
					&& personType.toString() != "CONTRACT"
					&& personType.toString() != "TRAINEE") {
				errors.rejectValue(
						"personType",
						"SelectionOfpersonType.personalInformationForm.personType",
						"Please select employment type.");
			}
		}

		ValidationUtils.rejectIfEmpty(errors, "designation",
				"NotEmpty.personalInformationForm.designation",
				"Designation must not be empty.");
		String designation = personalInformationForm.getDesignation();
		if (errors.getFieldErrorCount("designation") <= 0) {
			if (designation.length() < 0) {
				errors.rejectValue(
						"designation",
						"lengthOfDesignation.personalInformationForm.designation",
						"Designation must not be empty.");
			} else if (designation.length() > 128) {
				errors.rejectValue(
						"designation",
						"lengthOfDesignation.personalInformationForm.designation",
						"Designation must not be greater than 120 characters.");
			}
		}

	}
}
