package org.sapient.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.AddressInfoVO;
import org.sapient.service.client.EducationInfoVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.web.form.EducationInformationForm;
import org.sapient.web.form.EducationSummaryForm;
import org.sapient.web.form.util.Address;
import org.sapient.web.form.util.GregorianCalendarFields;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author pdandi
 * 
 */
@Controller
public class EducationSummaryController {
	private static Log log = LogFactory
			.getLog(EmploymentSummaryController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@RequestMapping(value = "/educationSummary.html")
	public String renderEducationSummary(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		log.info("Entering EducationSummaryController::renderEducationSummary()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		List<EducationInfoVO> result = resumeManagementService
				.retrieveEducationDetailByUserId(userId);
		List<EducationSummaryForm> educationSummaryList = null;
		if (result != null && result.size() > 0) {
			educationSummaryList = new ArrayList<EducationSummaryForm>(
					result.size());
			for (EducationInfoVO educationInfoVO : result) {
				EducationSummaryForm educationSummaryForm = new EducationSummaryForm();
				educationSummaryForm.setEducationInfoId(educationInfoVO
						.getEducationInfoId());
				educationSummaryForm.setSelectedCourseType(educationInfoVO
						.getCourseType());
				educationSummaryForm.setSelectedCourseName(educationInfoVO.getCourseName());
				/*educationSummaryForm.setCourseName(educationInfoVO
						.getCourseName());*/
				educationSummaryForm.setSpecialization(educationInfoVO
						.getSpecialization());
				educationSummaryForm.setUniversity(educationInfoVO
						.getUniversity());
				log.info(String.format("Adding the Education Information [%s]",
						educationSummaryForm));
				educationSummaryList.add(educationSummaryForm);
			}
			log.info(String
					.format("Added [%s] Education Information to the Education Summary Page...",
							educationSummaryList.size()));
		}
		model.put("educationSummaryList", educationSummaryList);
		return "educationSummary";
	}
	
	@RequestMapping(value = "/removeEducationDetail.html")
	public String removeEducationDetail(@RequestParam("educationInfoId") Long educationInfoId,
			Map<String, Object> model,HttpServletRequest request, HttpServletResponse response) {
		log.info("Entering EducationSummaryController::removeEducationDetail()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		resumeManagementService.removeEducationDetail(userId, educationInfoId);
	     return "redirect:/action/educationSummary.html";
	}

	@RequestMapping(value = "/retrieveEducationInformationById.html")
	public String retrieveEducationInformationById(
			@RequestParam("educationInfoId") Long educationInfoId,
			Map<String, Object> model) {
		log.info("Entering EducationSummaryController::retrieveEducationInformationById()...");
		log.info(String.format("The Course id submitted is [%s]",
				educationInfoId));
		EducationInfoVO educationInfoVO = resumeManagementService
				.retrieveEducationInformationById(educationInfoId);
		if (educationInfoVO != null) {
			EducationInformationForm educationInformationForm = new EducationInformationForm();
			educationInformationForm.setEducationInfoId(educationInfoVO
					.getEducationInfoId());
			educationInformationForm.setSelectedCourseType(educationInfoVO
					.getCourseType());
			educationInformationForm.setSelectedCourseName(educationInfoVO.getCourseName());
			/*educationInformationForm.setCourseName(educationInfoVO
					.getCourseName());*/
			educationInformationForm.setSpecialization(educationInfoVO
					.getSpecialization());
			educationInformationForm.setInstitution(educationInfoVO
					.getInstitution());
			educationInformationForm.setUniversity(educationInfoVO
					.getUniversity());
			educationInformationForm
					.setYearOfJoining(new GregorianCalendarFields(
							educationInfoVO.getYearOfJoining()));
			educationInformationForm
					.setYearOfPassing(new GregorianCalendarFields(
							educationInfoVO.getYearOfPassing()));
			educationInformationForm.setAggregate(String
					.valueOf(educationInfoVO.getAggregate()));
			Address educationAddress = new Address();
			if (educationInfoVO.getAddressDetails() != null) {
				for (AddressInfoVO addressInfoVO : educationInfoVO
						.getAddressDetails()) {
					educationAddress.setAddressInfoId(addressInfoVO
							.getAddressInfoId());
					educationAddress.setCity(addressInfoVO.getCity());
				}
			}
			educationInformationForm.setEducationAddress(educationAddress);
			log.info(String.format("Adding the Education Information [%s]",
					educationInformationForm));
			model.put("educationInformationForm", educationInformationForm);
		}
		return "educationInformation";
	}
}
