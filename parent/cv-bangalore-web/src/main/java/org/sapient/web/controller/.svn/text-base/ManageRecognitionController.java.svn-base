package org.sapient.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.RecognitionInfoVO;
import org.sapient.service.client.RecognitionTypeVO;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.web.controller.validator.RecognitionValidator;
import org.sapient.web.form.RecognitionInformationForm;
import org.sapient.web.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pdandi
 * 
 */
@Controller
public class ManageRecognitionController {

	private static Log log = LogFactory
			.getLog(ManageRecognitionController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@Autowired
	@Qualifier("recognitionValidator")
	private RecognitionValidator recognitionValidator;

	@RequestMapping(value = "/addNewRecognition.html")
	public String renderAddNewRecognition(HttpServletRequest request,
			Map<String, Object> model) {
		log.info("Entering ManageRecognitionController::renderAddNewRecognition()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}
		RecognitionInformationForm recognitionInformationForm = new RecognitionInformationForm();
		model.put("recognitionInformationForm", recognitionInformationForm);
		return "recognitionInformation";
	}

	@RequestMapping(value = "/submitRecognitionInformation.html")
	public String submitRecognitionInformation(
			@Valid RecognitionInformationForm recognitionInformationForm,
			BindingResult result, Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		log.info("Entering ManageRecognitionController::submitRecognitionInformation()...");
		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}

		recognitionValidator.validate(recognitionInformationForm, result);
		log.info(String
				.format("Recognition Information was submitted with the following errors [%s]",
						recognitionInformationForm));
		if (result.hasErrors()) {
			log.info(String
					.format("Recognition Information Form was submitted with [%s] Errors",
							result.getErrorCount()));
			return "recognitionInformation";
		}
		if (recognitionInformationForm.getRecognitionInfoId() != null) {
			log.info(String
					.format("Updating the Recognition Information for the Recognition Info Id [%s]",
							recognitionInformationForm.getRecognitionInfoId()));
		}
		RecognitionInfoVO recognitionInfoVO = new RecognitionInfoVO();
		recognitionInfoVO.setRecognitionInfoId(recognitionInformationForm
				.getRecognitionInfoId());
		recognitionInfoVO.setItems(recognitionInformationForm.getItems());

		RecognitionTypeVO recognitionTypeVO = new RecognitionTypeVO();
		recognitionTypeVO.setRecognitionTypeId(recognitionInformationForm
				.getRecognitionTypeId());
		recognitionInfoVO.setRecognitionType(recognitionTypeVO);
		recognitionInfoVO.setUserId(userId);

		resumeManagementService.saveRecognitionDetails(recognitionInfoVO);
		model.put("recognitionInformationForm", recognitionInformationForm);
		return "redirect:/action/recognitionSummary.html";
	}

}
