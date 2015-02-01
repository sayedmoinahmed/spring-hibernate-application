package org.sapient.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.RecognitionInfoVO;
import org.sapient.service.client.RecognitionTypeVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.web.form.RecognitionInformationForm;
import org.sapient.web.form.RecognitionSummaryForm;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author pdandir
 * 
 */
@SessionAttributes("recognitionTypes")
@Controller
public class RecognitionSummaryController {

	private static Log log = LogFactory
			.getLog(RecognitionSummaryController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@RequestMapping(value = "/recognitionSummary.html")
	public String renderRecognitionSummary(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		log.info("Entering RecognitionSummaryController::renderRecognitionSummary()...");

		if (request.getSession().getAttribute("recognitionTypes") == null) {
			List<RecognitionTypeVO> recognitionTypes = resumeManagementService
					.retrieveAllRecognitionTypes();
			model.put("recognitionTypes", recognitionTypes);
		}
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		List<RecognitionInfoVO> result = resumeManagementService
				.retrieveRecognitionDetailByUserId(userId);
		List<RecognitionSummaryForm> recognitionSummaryList = null;
		if (result != null && result.size() > 0) {
			recognitionSummaryList = new ArrayList<RecognitionSummaryForm>(
					result.size());
			for (RecognitionInfoVO recognitionInfoVO : result) {
				RecognitionSummaryForm recognitionSummaryForm = new RecognitionSummaryForm();
				recognitionSummaryForm.setRecognitionType(recognitionInfoVO
						.getRecognitionType().getDescription());
				recognitionSummaryForm.setRecognitionInfoId(recognitionInfoVO
						.getRecognitionInfoId());
				recognitionSummaryForm.setItems(recognitionInfoVO.getItems());
				log.info(String.format(
						"Adding the Recognition Information [%s]",
						recognitionSummaryForm));
				recognitionSummaryList.add(recognitionSummaryForm);
			}
			log.info(String
					.format("Added [%s] Recognition Information to the Recognition Summary Page...",
							recognitionSummaryList.size()));
		}
		model.put("recognitionSummaryList", recognitionSummaryList);
		return "recognitionSummary";
	}

	@RequestMapping(value = "/removeRecognitionDetail.html")
	public String removeRecognitionDetail(
			@RequestParam("recognitionInfoId") Long recognitionInfoId,
			Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		log.info("Entering RecognitionSummaryController::removeRecognitionDetail()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		resumeManagementService.removeRecognitionDetail(userId,
				recognitionInfoId);
		return "redirect:/action/recognitionSummary.html";

	}

	@RequestMapping(value = "/retrieveRecognitionInformationById.html")
	public String retrieveRecognitionInformationById(
			@RequestParam("recognitionInfoId") Long recognitionInfoId,
			Map<String, Object> model, HttpServletRequest request) {
		log.info("Entering RecognitionSummaryController::retrieveRecognitionInformationById()...");
		log.info(String.format("The Recognition id submitted is [%s]",
				recognitionInfoId));
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		RecognitionInfoVO recognitionInfoVO = resumeManagementService
				.retrieveRecognitionDetailById(recognitionInfoId);
		if (recognitionInfoVO != null) {
			RecognitionInformationForm recognitionInformationForm = new RecognitionInformationForm();
			recognitionInformationForm.setItems(recognitionInfoVO.getItems());
			recognitionInformationForm.setRecognitionInfoId(recognitionInfoVO
					.getRecognitionInfoId());
			recognitionInformationForm.setRecognitionTypeId(recognitionInfoVO
					.getRecognitionType().getRecognitionTypeId());
			log.info(String.format("Adding the Recognition Information [%s]",
					recognitionInformationForm));
			model.put("recognitionInformationForm", recognitionInformationForm);
		}
		return "recognitionInformation";
	}

}
