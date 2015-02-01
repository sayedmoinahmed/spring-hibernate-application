/**
 * 
 */
package org.sapient.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.ProjectInfoVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.web.form.ProjectInformationForm;
import org.sapient.web.form.ProjectSummaryForm;
import org.sapient.web.form.util.GregorianCalendarFields;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author brout
 * 
 */
@Controller
public class ProjectInformationController {
	private static Log log = LogFactory
			.getLog(ProjectInformationController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@RequestMapping(value = "/projectSummary.html")
	public String renderProjectSummary(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		log.info("Entering ProjectInformationController::renderProjectSummary()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		List<ProjectInfoVO> result = resumeManagementService
				.retrieveProjectDetailByUserId(userId);
		List<ProjectSummaryForm> projectSummaryList = null;
		if (result != null && result.size() > 0) {
			projectSummaryList = new ArrayList<ProjectSummaryForm>(
					result.size());
			for (ProjectInfoVO projectInfoVO : result) {
				ProjectSummaryForm projectSummaryForm = new ProjectSummaryForm();

				projectSummaryForm.setProjectInfoId(projectInfoVO
						.getProjectInfoId());
				projectSummaryForm.setTitle(projectInfoVO.getTitle());
				projectSummaryForm.setDescription(projectInfoVO
						.getDescription());
				projectSummaryForm.setClient(projectInfoVO.getClient());
				projectSummaryForm.setStartDate(new GregorianCalendarFields(
						projectInfoVO.getStartDate()));

				projectSummaryForm.setEndDate(new GregorianCalendarFields(
						projectInfoVO.getEndDate()));
				projectSummaryForm.setResponsibilities(projectInfoVO
						.getResponsibilities());
				projectSummaryForm.setRole(projectInfoVO.getRole());
				projectSummaryForm.setSize(projectInfoVO.getSize());
				projectSummaryForm.setTechnologies(projectInfoVO
						.getTechnologies());

				log.info(String.format("Adding the Project Information [%s]",
						projectSummaryForm));
				projectSummaryList.add(projectSummaryForm);
			}
			log.info(String
					.format("Added [%s] Project Information to the project Summary Page...",
							projectSummaryList.size()));
		}
		model.put("projectSummaryList", projectSummaryList);
		return "projectSummaryInformation";
	}

	@RequestMapping(value = "/removeProjectDetail.html")
	public String removeProjectDetail(@RequestParam("projectInfoId") Long projectInfoId,
			Map<String, Object> model,HttpServletRequest request, HttpServletResponse response) {
		log.info("Entering ProjectInformationController::removeProjectDetail()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		resumeManagementService.removeProjectDetail(userId, projectInfoId);
		return "redirect:/action/projectSummary.html";
	}

	@RequestMapping(value = "/retrieveProjectInformationById.html")
	public String retrieveProjectInformationById(
			@RequestParam("projectInfoId") Long projectInfoId,
			Map<String, Object> model, HttpServletRequest request) {
		log.info("Entering ProjectInformationyController::retrieveProjectInformationById()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		log.info(String.format("The Project Name submitted is [%s]",
				projectInfoId));
		ProjectInfoVO projectInfoVO = resumeManagementService
				.retrieveProjectInformationById(projectInfoId);
		if (projectInfoVO != null) {
			ProjectInformationForm projectInformationForm = new ProjectInformationForm();
			projectInformationForm.setProjectInfoId(projectInfoVO
					.getProjectInfoId());
			projectInformationForm.setTitle(projectInfoVO.getTitle());
			projectInformationForm.setDescription(projectInfoVO
					.getDescription());
			projectInformationForm.setStartDate(new GregorianCalendarFields(
					projectInfoVO.getStartDate()));
			projectInformationForm.setEndDate(new GregorianCalendarFields(
					projectInfoVO.getEndDate()));
			projectInformationForm.setClient(projectInfoVO.getClient());
			projectInformationForm.setSize(String.valueOf(projectInfoVO
					.getSize()));
			projectInformationForm.setRole(projectInfoVO.getRole());
			projectInformationForm.setResponsibilities(projectInfoVO
					.getResponsibilities());
			projectInformationForm.setTechnologies(projectInfoVO
					.getTechnologies());
			projectInformationForm.setUserId(projectInfoVO.getUserId());
			log.info(String.format("Adding the Project Information [%s]",
					projectInformationForm));
			model.put("projectInformationForm", projectInformationForm);
		}
		return "projectInformation";
	}
}
