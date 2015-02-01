package org.sapient.web.controller.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.routines.DoubleValidator;
import org.sapient.service.client.CourseName;
import org.sapient.service.client.CourseType;
import org.sapient.web.form.EducationInformationForm;
import org.sapient.web.form.util.GregorianCalendarFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * @author pdandi
 * 
 */
@Component("educationValidator")
public class EducationValidator {

	private static final Log log = LogFactory.getLog(EducationValidator.class);

	@Autowired
	@Qualifier("dateValidator")
	private DateValidator dateValidator;

	public boolean supports(Class<?> clazz) {
		return EducationValidator.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		EducationInformationForm educationInformationForm = (EducationInformationForm) target;

		log.info(String
				.format("Validating the Education Information Form with the values [%s]",
						educationInformationForm));

		/**
		 * courseType validation
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "selectedCourseType",
				"NotEmpty.educationInformationForm.selectedCourseType",
				"Course type must not be empty.");
		CourseType courseType = educationInformationForm
				.getSelectedCourseType();
		if (errors.getFieldErrorCount("selectedCourseType") <= 0) {
			if (courseType.toString() != "SECONDARY"
					&& courseType.toString() != "HIGHERSECONDARY"
					&& courseType.toString() != "GRADUATION"
					&& courseType.toString() != "POSTGRADUATION"
					&& courseType.toString() != "DIPLOMA"
					&& courseType.toString() != "PHD"
					&& courseType.toString() != "OTHERS") {
				errors.rejectValue(
						"selectedCourseType",
						"SelectionOfpersonType.educationInformationForm.selectedCourseType",
						"Please select course type.");
			}
		}

		/**
		 * courseName validation
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "selectedCourseName",
				"NotEmpty.educationInformationForm.selectedCourseName",
				"Course name must not be empty.");
		CourseName courseName = educationInformationForm.getSelectedCourseName();
		if (errors.getFieldErrorCount("selectedCourseName") <= 0) {
			if (courseName.toString() != "BE"
					&& courseName.toString() != "BTECH"
					&& courseName.toString() != "BSC"
					&& courseName.toString() != "MBA"
					&& courseName.toString() != "MTECH"
					&& courseName.toString() != "BCA"
					&& courseName.toString() != "OTHERS") {
				errors.rejectValue(
						"selectedCourseName",
						"SelectionOfpersonType.educationInformationForm.selectedCourseName",
						"Please select course name.");
			}
		}

		/**
		 * specialization validation
		 */
		String specialization = educationInformationForm.getSpecialization();
		if (!specialization.matches("^[a-zA-Z\\&,\\.\\s]*$")) {
			log.info("specialization alphabatic validation");
			errors.rejectValue(
					"specialization",
					"NumberNotAllowedSpecialization.educationInformationForm.specialization",
					"Specialization must not contain numbers or special characters.");

		}

		if (errors.getFieldErrorCount("specialization") <= 0) {
			if (specialization.length() > 125)
				errors.rejectValue(
						"specialization",
						"lengthOfSpecialization.educationInformationForm.specialization",
						"Specialization must not exceed 125 characters.");

		}
		/**
		 * institutionName validation
		 */
		String institutionName = educationInformationForm.getInstitution();
		if (!institutionName.matches("^[a-zA-Z\\&,\\.\\s]*$")) {
			log.info("institutionName alphabatic validation");
			errors.rejectValue(
					"institution",
					"NumberNotAllowedInstitution.educationInformationForm.institution",
					"Institution name must not contain numbers or special characters.");

		}
		if (errors.getFieldErrorCount("institution") <= 0) {
			if (institutionName.length() > 125)
				errors.rejectValue(
						"institution",
						"lengthOfInstitution.educationInformationForm.institution",
						"Institution name must not exceed 125 characters.");
		}

		/**
		 * university validation
		 */
		String university = educationInformationForm.getUniversity();
		if (!university.matches("^[a-zA-Z\\&,\\.\\s]*$")) {
			log.info("university alphabatic validation");
			errors.rejectValue(
					"university",
					"NumberNotAllowedInstitution.educationInformationForm.university",
					"Board/University name must not contain numbers or special characters.");

		}

		if (errors.getFieldErrorCount("university") <= 0) {
			if (university.length() > 125)
				errors.rejectValue(
						"university",
						"lengthOfUniversity.educationInformationForm.university",
						"Board/University must not exceed 125 characters.");
		}
		/**
		 * Joining Date validation
		 */
		GregorianCalendarFields yearOfJoining = educationInformationForm
				.getYearOfJoining();
		log.info(String.format("The year of Joining Obtained is [%s]",
				yearOfJoining));
		if (yearOfJoining.getYear() == null || yearOfJoining.getMonth() == null
				|| yearOfJoining.getDay() == null) {
			errors.rejectValue("yearOfJoining",
					"NotEmpty.educationInformationForm.yearOfJoining",
					"Date of joining must not be empty.");
		} else {
			log.info(String.format("Validating the year of Joining [%s]",
					yearOfJoining));
			boolean isValidJoiningDate = dateValidator.validate(
					yearOfJoining.getYear(), yearOfJoining.getMonth(),
					yearOfJoining.getDay());
			if (!isValidJoiningDate) {
				errors.rejectValue("yearOfJoining",
						"dateFormat.educationInformationForm.yearOfJoining",
						"Invalid date of joining.");
			}
		}
		if (errors.getFieldErrorCount("yearOfJoining") <= 0) {
			log.info(String.format("Validating for future dates [%s]",
					yearOfJoining));
			boolean isFutureDate = dateValidator.isFutureDate(
					yearOfJoining.getYear(), yearOfJoining.getMonth(),
					yearOfJoining.getDay());
			if (isFutureDate) {
				errors.rejectValue("yearOfJoining",
						"dateFormat.educationInformationForm.yearOfJoining",
						"Invalid date of joining.");
			}
		}

		/**
		 * Passing Date validation
		 */
		GregorianCalendarFields yearOfPassing = educationInformationForm
				.getYearOfPassing();
		log.info(String.format("The year of Passing Obtained is [%s]",
				yearOfPassing));
		if (yearOfPassing.getYear() == null || yearOfPassing.getMonth() == null
				|| yearOfPassing.getDay() == null) {
			errors.rejectValue("yearOfPassing",
					"NotEmpty.educationInformationForm.yearOfPassing",
					"Date of passing date must not be empty.");
		} else {
			log.info(String.format("Validating the year of Passing [%s]",
					yearOfPassing));
			boolean isValidPassingDate = dateValidator.validate(
					yearOfPassing.getYear(), yearOfPassing.getMonth(),
					yearOfPassing.getDay());
			if (!isValidPassingDate) {
				errors.rejectValue("yearOfPassing",
						"dateFormat.educationInformationForm.yearOfPassing",
						"Invalid date of passing.");
			}
		}
		if (errors.getFieldErrorCount("yearOfPassing") <= 0) {
			log.info(String.format("Validating for future dates [%s]",
					yearOfPassing));
			boolean isFutureDate = dateValidator.isFutureDate(
					yearOfPassing.getYear(), yearOfPassing.getMonth(),
					yearOfPassing.getDay());
			if (isFutureDate) {
				errors.rejectValue("yearOfPassing",
						"dateFormat.educationInformationForm.yearOfPassing",
						"Invalid date of passing.");
			}
		}

		if (errors.getFieldErrorCount("yearOfPassing") <= 0
				&& errors.getFieldErrorCount("yearOfJoining") <= 0) {
			if (yearOfJoining.getDay() >= yearOfPassing.getDay()
					&& yearOfJoining.getMonth() >= yearOfPassing.getMonth()
					&& yearOfJoining.getYear() >= yearOfPassing.getYear()) {
				errors.rejectValue("yearOfPassing",
						"dateFormat.educationInformationForm.yearOfPassing",
						"Date of passing must be greater than date of joining.");
			} else if (yearOfJoining.getMonth() > yearOfPassing.getMonth()
					&& yearOfJoining.getYear() >= yearOfPassing.getYear()) {
				errors.rejectValue("yearOfPassing",
						"dateFormat.educationInformationForm.yearOfPassing",
						"Date of passing must be greater than date of joining.");

			} else if (yearOfJoining.getYear() > yearOfPassing.getYear()) {
				errors.rejectValue("yearOfPassing",
						"dateFormat.educationInformationForm.yearOfPassing",
						"Date of passing must be greater than date of joining.");
			}
		}

		/**
		 * aggregate validation
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aggregate",
				"NotEmpty.educationInformationForm.aggregate",
				"Aggregate/Percentage must not be empty.");
		Double aggregateValue = DoubleValidator.getInstance().validate(
				educationInformationForm.getAggregate());
		if (errors.getFieldErrorCount("aggregate") <= 0) {
			if (aggregateValue == null) {
				errors.rejectValue("aggregate",
						"lengthOfSize.educationInformationForm.aggregate",
						"Invalid aggregate/percentage value.");
			}
		}
		if (errors.getFieldErrorCount("aggregate") <= 0) {
			if (!educationInformationForm.getAggregate().matches("^[0-9.]*$")) {
				errors.rejectValue("aggregate",
						"lengthOfSize.educationInformationForm.aggregate",
						"Invalid aggregate/percentage value.");
			}
		}
		if (errors.getFieldErrorCount("aggregate") <= 0) {
			if (aggregateValue <= 0) {
				errors.rejectValue("aggregate",
						"lengthOfAggregate.educationInformationForm.aggregate",
						"Aggregate/Percentage must not be zero or negative value.");
			} else if (aggregateValue > 100) {
				errors.rejectValue("aggregate",
						"lengthOfAggregate.educationInformationForm.aggregate",
						"Aggregate/Percentage must not exceed 100.");
			}
		}

		/**
		 * city validation
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"educationAddress.city",
				"NotEmpty.educationInformationForm.educationAddress.city",
				"City must not be empty.");
		String educationAddress = educationInformationForm
				.getEducationAddress().getCity();
		if (errors.getFieldErrorCount("educationAddress.city") <= 0) {
			if (educationAddress.length() > 50)
				errors.rejectValue(
						"educationAddress.city",
						"lengthOfEducationAddress.educationInformationForm.educationAddress.city",
						"City must not exceed 50 characters.");
		}
		if (errors.getFieldErrorCount("educationAddress.city") <= 0) {
			if (!educationAddress.matches("^[a-zA-Z,\\s]*$")) {
				log.info("alphabatic validation");
				errors.rejectValue(
						"educationAddress.city",
						"NotNumberEducationAddress.educationInformationForm.educationAddress.city",
						"City must not contain numbers & special character.");

			}
		}

	}
}
