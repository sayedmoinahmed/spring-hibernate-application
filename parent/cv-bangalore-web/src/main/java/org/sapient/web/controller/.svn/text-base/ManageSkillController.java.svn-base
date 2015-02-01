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
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.ProficiencyLevelType;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.service.client.SkillsInfoVO;
import org.sapient.service.client.SkillsTypeVO;
import org.sapient.web.controller.validator.SkillInformationValidator;
import org.sapient.web.form.SkillInformationForm;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author komar
 * 
 */
@Controller
public class ManageSkillController {

	private static Log log = LogFactory.getLog(ManageEducationController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@Autowired
	@Qualifier("skillInformationValidator")
	private SkillInformationValidator skillInformationValidator;

	List<ProficiencyLevelType> proficiencyLevelTypeList = new ArrayList<ProficiencyLevelType>();

	@RequestMapping(value = "/addNewSkill.html")
	public String renderAddNewSkill(HttpServletRequest request,
			Map<String, Object> model) {
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		log.info("Entering ManageSkillController::renderAddNewSkill()...");
		SkillInformationForm skillInformationForm = new SkillInformationForm();
		model.put("skillInformationForm", skillInformationForm);
		return "skillInformation";
	}

	@RequestMapping(value = "/submitSkillInformation.html")
	public String submitSkillInformation(
			@Valid SkillInformationForm skillInformationForm,
			BindingResult result, Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		log.info("Entering ManageSkillController::submitSkillInformation()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		skillInformationValidator.validate(skillInformationForm, result);
		log.info(String
				.format("Skill Information was submitted with the following errors [%s]",
						skillInformationForm));
		if (result.hasErrors()) {
			log.info(String.format(
					"Skill Information Form was submitted with [%s] Errors",
					result.getErrorCount()));
			return "skillInformation";
		}
		if (skillInformationForm.getSkillInfoId() != null) {
			log.info(String
					.format("Updating the Skill Information for the Skill Info Id [%s]",
							skillInformationForm.getSkillInfoId()));
		}
		SkillsInfoVO skillsInfoVO = new SkillsInfoVO();
		skillsInfoVO.setItems(skillInformationForm.getItems());
		skillsInfoVO.setProficienyLevel(skillInformationForm
				.getProficienyLevelType());
		skillsInfoVO.setSkillsInfoId(skillInformationForm.getSkillInfoId());
		SkillsTypeVO skillsType = new SkillsTypeVO();
		skillsType.setSkillTypeId(skillInformationForm.getSkillTypeId());
		skillsInfoVO.setSkillsType(skillsType);
		skillsInfoVO.setUserId(userId);

		resumeManagementService.saveSkillsDetail(skillsInfoVO);
		model.put("skillInformationForm", skillInformationForm);
		return "redirect:/action/skillSummary.html";
	}

}
