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
import org.sapient.service.client.ProficiencyLevelType;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.service.client.SkillsInfoVO;
import org.sapient.service.client.SkillsTypeVO;
import org.sapient.web.form.SkillInformationForm;
import org.sapient.web.form.SkillSummaryForm;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author komar
 * 
 */
@SessionAttributes({ "proficiencyLevelTypeList", "skillTypeList" })
@Controller
public class SkillSummaryController {

	private static Log log = LogFactory.getLog(SkillSummaryController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@RequestMapping(value = "/skillSummary.html")
	public String renderSkillSummary(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		log.info("Entering SkillSummaryController::renderSkillSummary()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		log.info("Adding the SkillTypeList to the Session...");
		if (request.getSession().getAttribute("skillTypeList") == null) {
			List<SkillsTypeVO> skillTypeList = resumeManagementService
					.retrieveAllSkillTypes();
			request.getSession().setAttribute("skillTypeList", skillTypeList);
		}

		log.info("Adding the Proficiency Level Type List to the Session...");
		if (request.getSession().getAttribute("proficiencyLevelTypeList") == null) {
			List<ProficiencyLevelType> proficiencyLevelTypeList = new ArrayList<ProficiencyLevelType>();
			proficiencyLevelTypeList.add(ProficiencyLevelType.BEGINNER);
			proficiencyLevelTypeList.add(ProficiencyLevelType.INTERMEDIATE);
			proficiencyLevelTypeList.add(ProficiencyLevelType.PROFICIENT);
			proficiencyLevelTypeList.add(ProficiencyLevelType.EXPERT);
			model.put("proficiencyLevelTypeList", proficiencyLevelTypeList);
			request.getSession().setAttribute("proficiencyLevelTypeList",
					proficiencyLevelTypeList);
		}
		List<SkillsInfoVO> result = resumeManagementService
				.retrieveSkillsDetailByUserId(userId);
		List<SkillSummaryForm> skillSummaryList = null;
		if (result != null && result.size() > 0) {
			skillSummaryList = new ArrayList<SkillSummaryForm>(result.size());
			for (SkillsInfoVO skillsInfoVO : result) {
				SkillSummaryForm skillSummaryForm = new SkillSummaryForm();
				skillSummaryForm.setSkillType(skillsInfoVO.getSkillsType()
						.getDescription());
				skillSummaryForm.setSkillInfoId(skillsInfoVO.getSkillsInfoId());
				skillSummaryForm.setItems(skillsInfoVO.getItems());
				skillSummaryForm.setProficienyLevel(skillsInfoVO
						.getProficienyLevel());
				log.info(String.format("Adding the Skill Information [%s]",
						skillSummaryForm));
				skillSummaryList.add(skillSummaryForm);
			}
			log.info(String
					.format("Added [%s] Skill Information to the Skill Summary Page...",
							skillSummaryList.size()));
		}
		model.put("skillSummaryList", skillSummaryList);
		return "skillSummary";
	}
	@RequestMapping(value = "/removeSkillSet.html")
	public String removeSkillSet(@RequestParam("skillInfoId") Long skillInfoId,
			Map<String, Object> model,HttpServletRequest request, HttpServletResponse response) {
		log.info("Entering SkillSummaryController::renderSkillSummary()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		resumeManagementService.removeSkillSet(userId, skillInfoId);
		 return "redirect:/action/skillSummary.html";
		
	}

	@RequestMapping(value = "/retrieveSkillInformationById.html")
	public String retrieveSkillInformationById(
			@RequestParam("skillInfoId") Long skillInfoId,
			Map<String, Object> model) {
		log.info("Entering SkillSummaryController::retrieveSkillInformationById()...");
		log.info(String.format("The Skill id submitted is [%s]", skillInfoId));
		SkillsInfoVO skillsInfoVO = resumeManagementService
				.retrieveSkillsDetailById(skillInfoId);
		if (skillsInfoVO != null) {
			SkillInformationForm skillInformationForm = new SkillInformationForm();
			skillInformationForm.setItems(skillsInfoVO.getItems());
			skillInformationForm.setProficienyLevelType(skillsInfoVO
					.getProficienyLevel());
			skillInformationForm.setSkillInfoId(skillsInfoVO.getSkillsInfoId());
			skillInformationForm.setSkillTypeId(skillsInfoVO.getSkillsType()
					.getSkillTypeId());
			log.info(String.format("Adding the Skill Information [%s]",
					skillInformationForm));
			model.put("skillInformationForm", skillInformationForm);
		}
		return "skillInformation";
	}

}
