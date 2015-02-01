package org.sapient.web.controller.validator;

import org.apache.commons.validator.EmailValidator;
import org.apache.commons.validator.routines.IntegerValidator;
import org.sapient.web.form.ContactInformationForm;
import org.sapient.web.form.ProfileSummaryForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("contactInformationValidator")
public class ContactInformationValidator {

	public boolean supports(Class<?> clazz) {
		return ContactInformationValidator.class.isAssignableFrom(clazz);
	}

	/**
	 * @param target
	 * @param errors
	 */
	public void validate(Object target, Errors errors) {
		ContactInformationForm contactInformationForm = (ContactInformationForm) target;

		/*
		 * validations for Permanent Address fields
		 */
		
		String streetAddress = contactInformationForm.getPermanentAddress()
				.getStreetAddress();
		if (errors.getFieldErrorCount("permanentAddress.streetAddress") <= 0) {
			if (streetAddress.length() > 120)
				errors.rejectValue(
						"streetAddress",
						"lengthOfStreetAddress.contactInformationForm.permanentAddress.streetAddress",
						"Street address must not exceed 120 characters.");
			else{
				ValidationUtils
				.rejectIfEmptyOrWhitespace(
						errors,
						"permanentAddress.streetAddress",
						"NotEmpty.contactInformationForm.permanentAddress.streetAddress",
						"Street address must not be empty.");
			}

		}

		ValidationUtils
				.rejectIfEmptyOrWhitespace(
						errors,
						"permanentAddress.addressLine2",
						"NotEmpty.contactInformationForm.permanentAddress.addressLine2",
						"Address line2 must not be empty.");
		String addressLine2 = contactInformationForm.getPermanentAddress()
				.getAddressLine2();
		if (errors.getFieldErrorCount("permanentAddress.addressLine2") <= 0) {
			if (addressLine2.length() > 120)
				errors.rejectValue(
						"permanentAddress.addressLine2",
						"lengthOfAddressLine2.contactInformationForm.permanentAddress.addressLine2",
						"Address line2 must not exceed 120 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"permanentAddress.city",
				"NotEmpty.contactInformationForm.permanentAddress.city",
				"City must not be empty.");
		String city = contactInformationForm.getPermanentAddress().getCity();
		if (errors.getFieldErrorCount("permanentAddress.city") <= 0) {
			if (city.length() > 60)
				errors.rejectValue(
						"permanentAddress.city",
						"lengthOfCity.contactInformationForm.permanentAddress.city",
						"City must not exceed 60 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"permanentAddress.state",
				"NotEmpty.contactInformationForm.permanentAddress.state",
				"State must not be empty.");
		String state = contactInformationForm.getPermanentAddress().getState();
		if (errors.getFieldErrorCount("permanentAddress.state") <= 0) {
			if (state.length() > 60)
				errors.rejectValue(
						"permanentAddress.state",
						"lengthOfState.contactInformationForm.permanentAddress.state",
						"State must not exceed 60 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"permanentAddress.zipCode",
				"NotEmpty.contactInformationForm.permanentAddress.zipCode",
				"Zipcode must not be empty.");
		String zipcode = contactInformationForm.getPermanentAddress()
				.getZipCode();
		if (errors.getFieldErrorCount("permanentAddress.zipCode") <= 0) {
			if (zipcode.length() > 60)
				errors.rejectValue(
						"permanentAddress.zipCode",
						"lengthOfZipcode.contactInformationForm.permanentAddress.zipCode",
						"Zipcode must not exceed 60 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"permanentAddress.country",
				"NotEmpty.contactInformationForm.permanentAddress.country",
				"Country must not be empty.");
		String country = contactInformationForm.getPermanentAddress()
				.getCountry();
		if (errors.getFieldErrorCount("permanentAddress.country") <= 0) {
			if (country.length() > 60)
				errors.rejectValue(
						"permanentAddress.country",
						"lengthOfCountry.contactInformationForm.permanentAddress.country",
						"Country must not exceed 60 characters.");
		}

		/**
		 * validations for Current Address fields
		 * */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"currentAddress.streetAddress",
				"NotEmpty.contactInformationForm.currentAddress.streetAddress",
				"Street address must not be empty.");
		String currentStreetAddress = contactInformationForm
				.getCurrentAddress().getStreetAddress();
		if (errors.getFieldErrorCount("currentAddress.streetAddress") <= 0) {
			if (currentStreetAddress.length() > 120)
				errors.rejectValue(
						"streetAddress",
						"lengthOfStreetAddress.contactInformationForm.currentAddress.streetAddress",
						"Street address must not exceed 120 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"currentAddress.addressLine2",
				"NotEmpty.contactInformationForm.currentAddress.addressLine2",
				"Address line2 must not be empty.");
		String currentAddressLine2 = contactInformationForm.getCurrentAddress()
				.getAddressLine2();
		if (errors.getFieldErrorCount("currentAddress.addressLine2") <= 0) {
			if (currentAddressLine2.length() > 120)
				errors.rejectValue(
						"currentAddress.addressLine2",
						"lengthOfAddressLine2.contactInformationForm.currentAddress.addressLine2",
						"Address line2 must not exceed 120 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"currentAddress.city",
				"NotEmpty.contactInformationForm.currentAddress.city",
				"City must not be empty.");
		String currentCity = contactInformationForm.getCurrentAddress()
				.getCity();
		if (errors.getFieldErrorCount("currentAddress.city") <= 0) {
			if (currentCity.length() > 60)
				errors.rejectValue(
						"currentAddress.city",
						"lengthOfCity.contactInformationForm.currentAddress.city",
						"City must not exceed 60 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"currentAddress.state",
				"NotEmpty.contactInformationForm.currentAddress.state",
				"State must not be empty.");
		String currentState = contactInformationForm.getCurrentAddress()
				.getState();
		if (errors.getFieldErrorCount("currentAddress.state") <= 0) {
			if (currentState.length() > 60)
				errors.rejectValue(
						"currentAddress.state",
						"lengthOfState.contactInformationForm.currentAddress.state",
						"State must not exceed 60 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"currentAddress.zipCode",
				"NotEmpty.contactInformationForm.currentAddress.zipCode",
				"Zipcode must not be empty.");
		String currentZipcode = contactInformationForm.getCurrentAddress()
				.getZipCode();
		if (errors.getFieldErrorCount("currentAddress.zipCode") <= 0) {
			if (currentZipcode.length() > 6)
				errors.rejectValue(
						"currentAddress.zipCode",
						"lengthOfZipcode.contactInformationForm.currentAddress.zipcode",
						"Zipcode must not exceed 6 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"currentAddress.country",
				"NotEmpty.contactInformationForm.currentAddress.country",
				"Country must not be empty.");
		String currentCountry = contactInformationForm.getCurrentAddress()
				.getCountry();
		if (errors.getFieldErrorCount("currentAddress.country") <= 0) {
			if (currentCountry.length() > 60)
				errors.rejectValue(
						"currentAddress.country",
						"lengthOfCountry.contactInformationForm.currentAddress.country",
						"Country must not exceed 60 characters.");
		}

		/**
		 * validations for primary Email
		 * */
		boolean isValidEmail = EmailValidator.getInstance().isValid(
				contactInformationForm.getPrimaryEmail());

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "primaryEmail",
				"NotEmpty.contactInformationForm.primaryEmail",
				"Primary email must not be empty.");
		String primaryEmail = contactInformationForm.getPrimaryEmail();
		if (errors.getFieldErrorCount("primaryEmail") <= 0) {
			if (primaryEmail.length() > 30)
				errors.rejectValue(
						"primaryEmail",
						"lengthOfPrimaryEmail.contactInformationForm.primaryEmail",
						"Primary email must not exceed 30 characters.");
			else {
				if (!isValidEmail)
					errors.rejectValue("primaryEmail",
							"NotEmpty.contactInformationForm.primaryEmail",
							"Not a valid email id");

			}
		}

		/**
		 * validations for secondary Email
		 * */

		String secondaryEmail = contactInformationForm.getSecondaryEmail();
		if (errors.getFieldErrorCount("secondaryEmail") <= 0) {
			if (secondaryEmail.length() > 30)
				errors.rejectValue(
						"secondaryEmail",
						"lengthOfSecondaryEmail.contactInformationForm.secondaryEmail",
						"Secondary email must not exceed 30 characters.");
			else {
				if (!isValidEmail)
					errors.rejectValue("secondaryEmail",
							"NotEmpty.contactInformationForm.secondaryEmail",
							"Not a valid email id");
			}
		}

		/**
		 * validations for Mobile Number fields
		 * */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"mobileNumber.countryCode",
				"NotEmpty.contactInformationForm.mobileNumber.countryCode",
				"CountryCode must not be Empty.");
		String countryCode = contactInformationForm.getMobileNumber()
				.getCountryCode();
		if (errors.getFieldErrorCount("mobileNumber.countryCode") <= 0) {
			if (countryCode.length() > 3)
				errors.rejectValue(
						"mobileNumber.countryCode",
						"lengthOfCountryCode.contactInformationForm.mobileNumber.countryCode",
						"CountryCode must not exceed 3 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"mobileNumber.areaCode",
				"NotEmpty.contactInformationForm.mobileNumber.areaCode",
				"AreaCode must not be Empty.");
		String areaCode = contactInformationForm.getMobileNumber()
				.getAreaCode();
		if (errors.getFieldErrorCount("mobileNumber.areaCode") <= 0) {
			if (areaCode.length() > 7)
				errors.rejectValue(
						"mobileNumber.areaCode",
						"lengthOfAreaCode.contactInformationForm.mobileNumber.areaCode",
						"AreaCode must not exceed 7 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"mobileNumber.phoneNumber",
				"NotEmpty.contactInformationForm.mobileNumber.phoneNumber",
				"PhoneNumber must not be Empty.");
		String phoneNumber = contactInformationForm.getMobileNumber()
				.getPhoneNumber();
		if (errors.getFieldErrorCount("mobileNumber.phoneNumber") <= 0) {
			if (phoneNumber.length() > 10)
				errors.rejectValue(
						"mobileNumber.phoneNumber",
						"lengthOfPhoneNumber.contactInformationForm.mobileNumber.phoneNumber",
						"PhoneNumber must not exceed 10 characters.");
		}

		/**
		 * validations for Office Number fields
		 * */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"officeNumber.countryCode",
				"NotEmpty.contactInformationForm.officeNumber.countryCode",
				"CountryCode must not be Empty.");
		String officeNumberCountryCode = contactInformationForm
				.getOfficeNumber().getCountryCode();
		if (errors.getFieldErrorCount("officeNumber.countryCode") <= 0) {
			if (officeNumberCountryCode.length() > 5)
				errors.rejectValue(
						"officeNumber.countryCode",
						"lengthOfCountryCode.contactInformationForm.officeNumber.countryCode",
						"CountryCode must not exceed 5 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"officeNumber.areaCode",
				"NotEmpty.contactInformationForm.officeNumber.areaCode",
				"AreaCode must not be Empty.");
		String officeNumberAreaCode = contactInformationForm.getOfficeNumber()
				.getAreaCode();
		if (errors.getFieldErrorCount("officeNumber.areaCode") <= 0) {
			if (officeNumberAreaCode.length() > 4)
				errors.rejectValue(
						"officeNumber.areaCode",
						"lengthOfAreaCode.contactInformationForm.officeNumber.areaCode",
						"AreaCode must not exceed 4 characters.");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"officeNumber.phoneNumber",
				"NotEmpty.contactInformationForm.officeNumber.phoneNumber",
				"PhoneNumber must not be Empty.");
		String officeNumberPhoneNumber = contactInformationForm
				.getOfficeNumber().getPhoneNumber();
		if (errors.getFieldErrorCount("officeNumber.phoneNumber") <= 0) {
			if (officeNumberPhoneNumber.length() > 10)
				errors.rejectValue(
						"officeNumber.phoneNumber",
						"lengthOfPhoneNumber.contactInformationForm.officeNumber.phoneNumber",
						"PhoneNumber must not exceed 10 characters.");
		}

		/**
		 * validation for extension number
		 * */

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "extension",
				"NotEmpty.contactInformationForm.extension",
				"Extension must not be Empty.");
		String extension = contactInformationForm.getExtension();
		if (errors.getFieldErrorCount("extension") <= 0) {
			if (extension.length() < 50)
				errors.rejectValue("extension",
						"lengthOfExtension.contactInformationForm.extension",
						"Extension must be at least 50 characters long.");
			else if (extension.length() > 200)
				errors.rejectValue("extension",
						"lengthOfExtension.contactInformationForm.extension",
						"Extension must not exceed 200 characters.");
		}

	}

}
