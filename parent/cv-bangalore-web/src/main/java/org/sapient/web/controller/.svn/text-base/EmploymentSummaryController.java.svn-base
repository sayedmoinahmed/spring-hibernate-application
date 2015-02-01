package org.sapient.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.AddressInfoVO;
import org.sapient.service.client.EmploymentInfoVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.web.form.EmploymentInformationForm;
import org.sapient.web.form.EmploymentSummaryForm;
import org.sapient.web.form.util.Address;
import org.sapient.web.form.util.GregorianCalendarFields;
import org.sapient.web.model.UserInfo;
import org.sapient.web.util.DateFormatUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmploymentSummaryController {

	private static Log log = LogFactory
			.getLog(EmploymentSummaryController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@RequestMapping(value = "/employmentSummary.html")
	public String renderEmploymentSummary(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		log.info("Entering EmploymentSummaryController::renderEmploymentSummary()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		List<EmploymentInfoVO> result = resumeManagementService
				.retrieveEmploymentDetailByUserId(userId);
		List<EmploymentSummaryForm> employmentSummaryList = null;
		if (result != null && result.size() > 0) {
			employmentSummaryList = new ArrayList<EmploymentSummaryForm>(
					result.size());
			for (EmploymentInfoVO employmentInfoVO : result) {
				EmploymentSummaryForm employmentSummaryForm = new EmploymentSummaryForm();
				employmentSummaryForm.setEmploymentInfoId(employmentInfoVO
						.getEmploymentInfoId());
				employmentSummaryForm.setEmployerName(employmentInfoVO
						.getEmployerName());
				employmentSummaryForm.setEmploymentType(employmentInfoVO
						.getEmploymentType().toString());
				employmentSummaryForm.setDesignation(employmentInfoVO
						.getDesignation());
				XMLGregorianCalendar dateOfJoining = employmentInfoVO
						.getDateOfJoining();
				if (employmentInfoVO.getDateOfRelieving() != null) {
					XMLGregorianCalendar dateOfRelieving = employmentInfoVO
							.getDateOfRelieving();
					employmentSummaryForm.setDateOfRelieving(DateFormatUtil
							.formatEmploymentDate(dateOfRelieving
									.toGregorianCalendar().getTime()));
				} else {
					employmentSummaryForm.setDateOfRelieving(null);
				}
				employmentSummaryForm.setDateOfJoining(DateFormatUtil
						.formatEmploymentDate(dateOfJoining
								.toGregorianCalendar().getTime()));
				log.info(String.format(
						"Adding the Employment Information [%s]",
						employmentSummaryForm));
				employmentSummaryList.add(employmentSummaryForm);
			}
			log.info(String
					.format("Added [%s] Employment Information to the Employment Summary Page...",
							employmentSummaryList.size()));
		}
		model.put("employmentSummaryList", employmentSummaryList);
		return "employmentSummary";
	}

	@RequestMapping(value = "/removeEmploymentDetail.html")
	public String removeEmploymentDetail(
			@RequestParam("employmentInfoId") Long employmentInfoId,
			Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		log.info("Entering EmploymentSummaryController::removeEmploymentDetail()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		resumeManagementService
				.removeEmploymentDetail(userId, employmentInfoId);
		return "redirect:/action/employmentSummary.html";

	}

	@RequestMapping(value = "/retrieveEmploymentInformationById.html")
	public String retrieveEmploymentInformationById(
			@RequestParam("employmentInfoId") Long employmentInfoId,
			Map<String, Object> model, HttpServletRequest request) {
		log.info("Entering EmploymentSummaryController::retrieveEmploymentInformationById()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		log.info(String.format("The Employer Name submitted is [%s]",
				employmentInfoId));
		EmploymentInfoVO employmentInfoVO = resumeManagementService
				.retrieveEmploymentInformationById(employmentInfoId);
		if (employmentInfoVO != null) {
			EmploymentInformationForm employmentInformationForm = new EmploymentInformationForm();
			employmentInformationForm.setEmploymentInfoId(employmentInfoVO
					.getEmploymentInfoId());
			employmentInformationForm
					.setDateOfJoining(new GregorianCalendarFields(
							employmentInfoVO.getDateOfJoining()));
			if (employmentInfoVO.getDateOfRelieving() != null) {
				employmentInformationForm.setCurrentEmployer(false);
				employmentInformationForm
						.setDateOfRelieving(new GregorianCalendarFields(
								employmentInfoVO.getDateOfRelieving()));
			} else {
				employmentInformationForm.setCurrentEmployer(true);
			}
			employmentInformationForm.setDesignation(employmentInfoVO
					.getDesignation());
			employmentInformationForm.setEmployerName(employmentInfoVO
					.getEmployerName());
			employmentInformationForm.setEmploymentType(employmentInfoVO
					.getEmploymentType());
			employmentInformationForm.setSupervisorName(employmentInfoVO
					.getSupervisorName());
			employmentInformationForm.setUserId(userId);
			Address employmentAddress = new Address();
			if (employmentInfoVO.getAddressDetails() != null) {
				for (AddressInfoVO addressInfoVO : employmentInfoVO
						.getAddressDetails()) {
					employmentAddress.setAddressInfoId(addressInfoVO
							.getAddressInfoId());
					employmentAddress.setStreetAddress(addressInfoVO
							.getAddressLine1());
					employmentAddress.setAddressLine2(addressInfoVO
							.getAddressLine2());
					employmentAddress.setCity(addressInfoVO.getCity());
					employmentAddress.setCountry(addressInfoVO.getCountry());
					employmentAddress.setState(addressInfoVO.getState());
					employmentAddress.setZipCode(addressInfoVO.getZipCode());
				}
			}
			employmentInformationForm.setEmploymentAddress(employmentAddress);
			log.info(String.format("Adding the Employment Information [%s]",
					employmentInformationForm));
			model.put("employmentInformationForm", employmentInformationForm);
		}
		return "employmentInformation";
	}
}
