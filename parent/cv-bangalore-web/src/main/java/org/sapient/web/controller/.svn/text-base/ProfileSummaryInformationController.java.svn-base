package org.sapient.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.ProfileSummaryInfoVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.web.controller.validator.ProfileSummaryValidator;
import org.sapient.web.form.ProfileSummaryForm;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profileSummaryInformation.html")
public class ProfileSummaryInformationController {
	private static Log log = LogFactory
			.getLog(ProfileSummaryInformationController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@Autowired
	@Qualifier("profileSummaryValidator")
	private ProfileSummaryValidator profileSummaryValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String renderProfileSummary(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		List<ProfileSummaryInfoVO> results = resumeManagementService
				.retrieveProfileSummaryDetailByUserId(userId);
		ProfileSummaryForm profileSummaryForm = new ProfileSummaryForm();
		if (results != null && results.size() > 0) {
			log.info(String
					.format("Number of Profile Summary retrieved for the User [%s] is [%s]",
							new Long(1), results.size()));
			for (ProfileSummaryInfoVO profileSummaryInfo : results) {
				profileSummaryForm.setTitle(profileSummaryInfo.getTitle());
				profileSummaryForm.setDescription(profileSummaryInfo
						.getDescription());
				profileSummaryForm.setId(profileSummaryInfo
						.getProfileSummaryId());
				log.info(String
						.format("Rendering the ProfileSummaryForm with the following details [%s]",
								profileSummaryForm));
			}
		}

		model.put("profileSummaryForm", profileSummaryForm);
		return "profileSummaryInformation";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processProfileSummaryInformation(
			@Valid ProfileSummaryForm profileSummaryForm, BindingResult result,
			Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		log.info("Entering ProfileSummaryInformationController::processProfileSummaryInformation()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		profileSummaryValidator.validate(profileSummaryForm, result);
		log.info(String
				.format("Profile Summary Information was submitted with the following errors [%s]",
						profileSummaryForm));
		if (result.hasErrors()) {
			log.info(String.format(
					"Personal Information Form was submitted with [%s] Errors",
					result.getErrorCount()));
			return "profileSummaryInformation";
		}
		ProfileSummaryInfoVO profileSummaryInfoVO = new ProfileSummaryInfoVO();
		profileSummaryInfoVO.setTitle(profileSummaryForm.getTitle());
		profileSummaryInfoVO
				.setDescription(profileSummaryForm.getDescription());
		profileSummaryInfoVO.setProfileSummaryId(profileSummaryForm.getId());
		profileSummaryInfoVO.setUserId(userId);
		resumeManagementService.saveProfileSummaryDetail(profileSummaryInfoVO);
		model.put("profileSummaryForm", profileSummaryForm);
		return "redirect:/action/skillSummary.html";
	}
}
