package org.sapient.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.AddressInfoVO;
import org.sapient.service.client.AddressType;
import org.sapient.service.client.CourseName;
import org.sapient.service.client.CourseType;
import org.sapient.service.client.EducationInfoVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.web.controller.validator.EducationValidator;
import org.sapient.web.form.EducationInformationForm;
import org.sapient.web.form.util.Address;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author pdandi
 * 
 */
@SessionAttributes("courseTypeList,courseNameList")
@Controller
public class ManageEducationController {
	private static Log log = LogFactory.getLog(ManageEducationController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@Autowired
	@Qualifier("educationValidator")
	private EducationValidator educationValidator;

	@RequestMapping(value = "/addNewEducation.html")
	public String renderAddNewEducation(HttpServletRequest request,
			Map<String, Object> model) {
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		if (request.getSession().getAttribute("courseTypeList") == null) {
			List<CourseType> courseTypeList = new ArrayList<CourseType>();
			courseTypeList.add(CourseType.SECONDARY);
			courseTypeList.add(CourseType.HIGHERSECONDARY);
			courseTypeList.add(CourseType.GRADUATION);
			courseTypeList.add(CourseType.POSTGRADUATION);
			courseTypeList.add(CourseType.DIPLOMA);
			courseTypeList.add(CourseType.PHD);
			courseTypeList.add(CourseType.OTHERS);
			model.put("courseTypeList", courseTypeList);
		}
		
		if (request.getSession().getAttribute("courseNameList") == null) {
			List<CourseName> courseNameList = new ArrayList<CourseName>();
			courseNameList.add(CourseName.BE);
			courseNameList.add(CourseName.BTECH);
			courseNameList.add(CourseName.BSC);
			courseNameList.add(CourseName.BCA);
			courseNameList.add(CourseName.MBA);
			courseNameList.add(CourseName.MTECH);
			courseNameList.add(CourseName.OTHERS);
			model.put("courseNameList", courseNameList);
		}
		
		log.info("Entering ManageEducationController::renderAddNewEducation()...");
		EducationInformationForm educationInformationForm = new EducationInformationForm();
		model.put("educationInformationForm", educationInformationForm);
		return "educationInformation";
	}

	@RequestMapping(value = "/submitEducationInformation.html")
	public String submitEducationInformation(
			@Valid EducationInformationForm educationInformationForm,
			BindingResult result, Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {

		log.info("Entering ManageEducationController::processEducationInformation()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}

		educationValidator.validate(educationInformationForm, result);
		log.info(String
				.format("Education Information was submitted with the following errors [%s]",
						educationInformationForm));
		if (result.hasErrors()) {
			log.info(String
					.format("Education Information Form was submitted with [%s] Errors",
							result.getErrorCount()));
			return "educationInformation";
		}

		if (educationInformationForm.getEducationInfoId() != null) {
			log.info(String
					.format("Updating the Education Information for the Education Info Id [%s]",
							educationInformationForm.getEducationInfoId()));
		}
		EducationInfoVO educationInfoVO = new EducationInfoVO();
		educationInfoVO.setEducationInfoId(educationInformationForm
				.getEducationInfoId());
		educationInfoVO.setCourseType(educationInformationForm
				.getSelectedCourseType());
		educationInfoVO.setCourseName(educationInformationForm.getSelectedCourseName());
		/*educationInfoVO.setCourseName(educationInformationForm.getCourseName());*/
		educationInfoVO.setSpecialization(educationInformationForm
				.getSpecialization());
		educationInfoVO.setInstitution(educationInformationForm
				.getInstitution());
		educationInfoVO.setUniversity(educationInformationForm.getUniversity());

		XMLGregorianCalendar educationYear = null;
		try {
			educationYear = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(
							educationInformationForm.getYearOfJoining()
									.getYear(),
							educationInformationForm.getYearOfJoining()
									.getMonth(),
							educationInformationForm.getYearOfJoining()
									.getDay(), 0, 0, 0, 0, 0);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		educationInfoVO.setYearOfJoining(educationYear);
		try {
			educationYear = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(
							educationInformationForm.getYearOfPassing()
									.getYear(),
							educationInformationForm.getYearOfPassing()
									.getMonth(),
							educationInformationForm.getYearOfPassing()
									.getDay(), 0, 0, 0, 0, 0);
		} catch (DatatypeConfigurationException e) {
			log.error("Invalid Year of Joining / Year of Passing...");
		}
		educationInfoVO.setYearOfPassing(educationYear);
		educationInfoVO.setAggregate(Double.valueOf(educationInformationForm
				.getAggregate()));
		if (educationInformationForm.getUserId() == null) {
			educationInformationForm.setUserId(userId);
		}
		educationInfoVO.setUserId(educationInformationForm.getUserId());
		Long educationInfoId = resumeManagementService
				.saveEducationDetail(educationInfoVO);
		Address educationAddress = educationInformationForm
				.getEducationAddress();
		if (educationAddress != null) {
			AddressInfoVO addressInfoVO = new AddressInfoVO();
			addressInfoVO.setAddressInfoId(educationAddress.getAddressInfoId());
			addressInfoVO.setAddressType(AddressType.EDUCATION);
			addressInfoVO.setCity(educationAddress.getCity());
			addressInfoVO.setEducationInfoId(educationInfoId);
			addressInfoVO.setUserId(userId);
			Long addressInfoId = resumeManagementService
					.saveAddressDetail(addressInfoVO);
			log.info(String.format(
					"The Address Information was saved with the Id [%s]",
					addressInfoId));
		}

		return "redirect:/action/educationSummary.html";
	}
}