package org.sapient.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.AddressInfoVO;
import org.sapient.service.client.AddressType;
import org.sapient.service.client.EmploymentInfoVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.web.controller.validator.EmploymentInformationValidator;
import org.sapient.web.form.EmploymentInformationForm;
import org.sapient.web.form.util.Address;
import org.sapient.web.form.util.GregorianCalendarFields;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("userInfo")
@Controller
public class ManageEmploymentController {

	private static final Log log = LogFactory
			.getLog(ManageEmploymentController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@Autowired
	@Qualifier("employmentInformationValidator")
	private EmploymentInformationValidator employmentInformationValidator;

	@RequestMapping(value = "/addNewEmployment.html")
	public String renderAddNewEmployment(HttpServletRequest request,
			Map<String, Object> model) {
		log.info("Entering ManageEmploymentController::addNewEmployment()...");
		Long userId = null;
		EmploymentInformationForm employmentInformationForm = new EmploymentInformationForm();
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		employmentInformationForm.setCurrentEmployer(true);
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		employmentInformationForm.setUserId(userId);
		model.put("employmentInformationForm", employmentInformationForm);
		return "employmentInformation";
	}

	@RequestMapping(value = "/submitEmploymentInformation.html")
	public String submitEmploymentInformation(
			@Valid EmploymentInformationForm employmentInformationForm,
			BindingResult result, Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		log.info("Entering ManageEmploymentController::submitEmploymentInformation()...");
		employmentInformationValidator.validate(employmentInformationForm,
				result);
		if (result.hasErrors()) {
			log.info(String
					.format("Employment Information Form was submitted with [%s] Errors",
							result.getErrorCount()));
			return "employmentInformation";
		}

		if (employmentInformationForm.getEmploymentInfoId() != null) {
			log.info(String
					.format("Updating the Employment Information for the Employment Info Id [%s]",
							employmentInformationForm.getEmploymentInfoId()));
		}
		EmploymentInfoVO employmentInfoVO = new EmploymentInfoVO();
		try {
			employmentInfoVO.setDateOfJoining(DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(
							employmentInformationForm.getDateOfJoining()
									.getYear(),
							employmentInformationForm.getDateOfJoining()
									.getMonth(),
							employmentInformationForm.getDateOfJoining()
									.getDay(), 0, 0, 0, 0, 0));
			GregorianCalendarFields date = employmentInformationForm
					.getDateOfRelieving();
			if (date != null) {
				if (date.getDay() != null) {
					employmentInformationForm.setCurrentEmployer(false);
					employmentInfoVO.setDateOfRelieving(DatatypeFactory
							.newInstance().newXMLGregorianCalendar(
									employmentInformationForm
											.getDateOfRelieving().getYear(),
									employmentInformationForm
											.getDateOfRelieving().getMonth(),
									employmentInformationForm
											.getDateOfRelieving().getDay(), 0,
									0, 0, 0, 0));
				}
			} else {
				employmentInformationForm.setCurrentEmployer(true);
			}
		} catch (DatatypeConfigurationException e) {
			log.error("Invalid Date of Joining / Date of Relieving...");
		}
		employmentInfoVO.setDesignation(employmentInformationForm
				.getDesignation());
		employmentInfoVO.setEmployerName(employmentInformationForm
				.getEmployerName());
		employmentInfoVO.setEmploymentInfoId(employmentInformationForm
				.getEmploymentInfoId());
		employmentInfoVO.setEmploymentType(employmentInformationForm
				.getEmploymentType());
		employmentInfoVO.setSupervisorName(employmentInformationForm
				.getSupervisorName());
		if (employmentInformationForm.getUserId() == null) {
			employmentInformationForm.setUserId(userId);
		}
		employmentInfoVO.setUserId(employmentInformationForm.getUserId());
		Long employmentInfoId = resumeManagementService
				.saveEmploymentDetail(employmentInfoVO);

		Address employmentAddress = employmentInformationForm
				.getEmploymentAddress();
		if (employmentAddress != null) {
			AddressInfoVO addressInfoVO = new AddressInfoVO();
			addressInfoVO
					.setAddressInfoId(employmentAddress.getAddressInfoId());
			addressInfoVO.setAddressLine1(employmentAddress.getStreetAddress());
			addressInfoVO.setAddressLine2(employmentAddress.getAddressLine2());
			addressInfoVO.setAddressType(AddressType.EMPLOYMENT);
			addressInfoVO.setCity(employmentAddress.getCity());
			addressInfoVO.setState(employmentAddress.getState());
			addressInfoVO.setZipCode(employmentAddress.getZipCode());
			addressInfoVO.setCountry(employmentAddress.getCountry());
			addressInfoVO.setEmploymentInfoId(employmentInfoId);
			addressInfoVO.setUserId(userId);
			Long addressInfoId = resumeManagementService
					.saveAddressDetail(addressInfoVO);
			log.info(String.format(
					"The Address Information was saved with the Id [%s] ",
					addressInfoId));
		}
		model.put("employmentInformationForm", employmentInformationForm);
		return "redirect:/action/employmentSummary.html";
	}
}
