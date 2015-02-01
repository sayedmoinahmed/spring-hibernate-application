package org.sapient.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.AddressInfoVO;
import org.sapient.service.client.AddressType;
import org.sapient.service.client.ContactInfoVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.web.controller.validator.ContactInformationValidator;
import org.sapient.web.form.ContactInformationForm;
import org.sapient.web.form.util.Address;
import org.sapient.web.form.util.ContactNumberField;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author spash1
 * 
 *         Controller to retrieve,submit contact information
 * 
 */
@Controller
@RequestMapping("/contactInformation")
public class ContactInformationController {

	private static Log log = LogFactory
			.getLog(ContactInformationController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@Autowired
	@Qualifier("contactInformationValidator")
	private ContactInformationValidator contactInformationValidator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView renderContactDetails(HttpServletRequest request,
			HttpServletResponse response) {
		String message = "Contact Information";

		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return new ModelAndView("invalidSession");
		}
		List<ContactInfoVO> results = resumeManagementService
				.retrieveContactDetailByUserId(userId);

		ContactInformationForm contactInformationForm = new ContactInformationForm();
		Address address2 = null;

		if (results != null && results.size() > 0) {
			log.info(String.format(
					"contact information retrieved for the User [%s] is [%s]",
					userId, results.size()));

			for (ContactInfoVO contactInfoVO : results) {

				List<AddressInfoVO> addresses = contactInfoVO
						.getAddressDetails();

				for (AddressInfoVO address : addresses) {
					if (address.getAddressType().equals(AddressType.PERMANENT)) {
						address2 = new Address();
						address2.setStreetAddress(address.getAddressLine1());
						address2.setAddressLine2(address.getAddressLine2());
						address2.setCity(address.getCity());
						address2.setState(address.getState());
						address2.setCountry(address.getCountry());
						address2.setZipCode(address.getZipCode());
						contactInformationForm.setPermanentAddress(address2);

					} else if (address.getAddressType().equals(
							AddressType.CURRENT)) {
						address2 = new Address();
						address2.setStreetAddress(address.getAddressLine1());
						address2.setAddressLine2(address.getAddressLine2());
						address2.setCity(address.getCity());
						address2.setState(address.getState());
						address2.setCountry(address.getCountry());
						address2.setZipCode(address.getZipCode());
						contactInformationForm.setCurrentAddress(address2);
					}
				}

				contactInformationForm.setPrimaryEmail(contactInfoVO
						.getPrimaryEmail());
				contactInformationForm.setSecondaryEmail(contactInfoVO
						.getSecondaryEmail());
				contactInformationForm.setMobileNumber(new ContactNumberField(
						contactInfoVO.getMobileNumber()));
				contactInformationForm.setOfficeNumber(new ContactNumberField(
						"9999667777"));
				contactInformationForm.setExtension(contactInfoVO
						.getExtension());
				contactInformationForm
						.setEmergency(contactInfoVO.isEmergency());

				log.info(String
						.format("Rendering the contactInformationForm with the following details [%s]",
								contactInformationForm));
			}
		}
		log.info(String.format("Adding the contact information [%s]", message));
		return new ModelAndView("contactInformation", "contactInformationForm",
				contactInformationForm);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitContactInformationForm(
			@Valid ContactInformationForm contactInformationForm,
			BindingResult result, Map<String, Object> model) {

		log.info("Inside submitContactInformationForm method --"
				+ contactInformationForm.getPrimaryEmail());

		contactInformationValidator.validate(contactInformationForm, result);
		log.info(String
				.format("Contact Information was submitted with the following errors [%s]",
						contactInformationForm));
		if (result.hasErrors()) {
			log.info(String.format(
					"Contact Information Form was submitted with [%s] Errors",
					result.getErrorCount()));
			return "contactInformation";
		}

		contactInformationForm = (ContactInformationForm) model
				.get(contactInformationForm);

		ContactInfoVO contactInfoVO = new ContactInfoVO();
		contactInfoVO.setPrimaryEmail(contactInformationForm.getPrimaryEmail());
		contactInfoVO.setSecondaryEmail(contactInformationForm
				.getSecondaryEmail());
		log.info("value of mobile number -"
				+ contactInformationForm.getMobileNumber().getCountryCode()
				+ contactInformationForm.getMobileNumber().getAreaCode()
				+ contactInformationForm.getMobileNumber().getPhoneNumber());
		contactInfoVO.setMobileNumber(contactInformationForm.getMobileNumber()
				.getCountryCode()
				+ contactInformationForm.getMobileNumber().getAreaCode()
				+ contactInformationForm.getMobileNumber().getPhoneNumber());
		log.info("value of mobile number - "
				+ contactInformationForm.getOfficeNumber().getCountryCode()
				+ contactInformationForm.getOfficeNumber().getAreaCode()
				+ contactInformationForm.getOfficeNumber().getPhoneNumber());
		contactInfoVO.setOfficeNumber(contactInformationForm.getOfficeNumber()
				.getCountryCode()
				+ contactInformationForm.getOfficeNumber().getAreaCode()
				+ contactInformationForm.getOfficeNumber().getPhoneNumber());
		contactInfoVO.setExtension(contactInformationForm.getExtension());
		contactInfoVO.setEmergency(contactInformationForm.isEmergency());
		resumeManagementService.saveContactDetail(contactInfoVO);
		model.put("contactInformationForm", contactInformationForm);
		return "submitSuccess";
	}

}
