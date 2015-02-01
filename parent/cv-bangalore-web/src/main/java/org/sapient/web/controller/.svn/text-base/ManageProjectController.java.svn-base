/**
 * 
 */
package org.sapient.web.controller;

/**
 * @author brout
 *
 */
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.ProjectInfoVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.web.controller.validator.ProjectInformationValidator;
import org.sapient.web.form.ProjectInformationForm;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageProjectController {

	private static final Log log = LogFactory
			.getLog(ManageProjectController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@Autowired
	@Qualifier("projectInformationValidator")
	private ProjectInformationValidator projectInformationValidator;

	@RequestMapping(value = "/addNewProject.html")
	public String renderAddNewProject(HttpServletRequest request,
			Map<String, Object> model) {
		log.info("Entering ManageProjectController::addNewProject()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		ProjectInformationForm projectInformationForm = new ProjectInformationForm();
		model.put("projectInformationForm", projectInformationForm);
		return "projectInformation";
	}

	@RequestMapping(value = "/submitProjectInformation.html")
	public String submitProjectInformation(
			@Valid ProjectInformationForm projectInformationForm,
			BindingResult result, Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		log.info("Entering ManageProjectController::submitProjectInformation()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		projectInformationValidator.validate(projectInformationForm, result);
		if (result.hasErrors()) {
			log.info(String.format(
					"Project Information Form was submitted with [%s] Errors",
					result.getErrorCount()));
			return "projectInformation";
		}
		if (projectInformationForm.getProjectInfoId() != null) {
			log.info(String
					.format("Updating the Employment Information for the Employment Info Id [%s]",
							projectInformationForm.getProjectInfoId()));
		}
		ProjectInfoVO projectInfoVO = new ProjectInfoVO();
		if (projectInformationForm.getProjectInfoId() != null) {
			projectInfoVO.setProjectInfoId(projectInformationForm
					.getProjectInfoId());
		} else {
			projectInfoVO.setProjectInfoId(null);
		}
		projectInfoVO.setTitle(projectInformationForm.getTitle());
		projectInfoVO.setDescription(projectInformationForm.getDescription());

		try {
			projectInfoVO.setStartDate(DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(
							projectInformationForm.getStartDate().getYear(),
							projectInformationForm.getStartDate().getMonth(),
							projectInformationForm.getStartDate().getDay(), 0,
							0, 0, 0, 0));

			projectInfoVO.setEndDate(DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(
							projectInformationForm.getEndDate().getYear(),
							projectInformationForm.getEndDate().getMonth(),
							projectInformationForm.getEndDate().getDay(), 0, 0,
							0, 0, 0));
		} catch (DatatypeConfigurationException e) {
			log.error("Invalid Date of Start / Date of End...");
		}
		projectInfoVO.setClient(projectInformationForm.getClient());
		projectInfoVO
				.setSize(Integer.valueOf(projectInformationForm.getSize()));
		projectInfoVO.setRole(projectInformationForm.getRole());
		projectInfoVO.setResponsibilities(projectInformationForm
				.getResponsibilities());
		projectInfoVO.setTechnologies(projectInformationForm.getTechnologies());
		if (projectInformationForm.getUserId() == null) {
			projectInformationForm.setUserId(userId);
		}
		projectInfoVO.setUserId(projectInformationForm.getUserId());
		resumeManagementService.saveProjectDetails(projectInfoVO);
		return "redirect:/action/projectSummary.html";
	}
}
