/**
 * 
 */
package org.sapient.web.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.service.client.ResumeManagementService;
import org.sapient.service.client.SearchResultVO;
import org.sapient.service.client.UserInfoVO;
import org.sapient.web.form.SearchEmployeeForm;
import org.sapient.web.model.UserInfo;
import org.sapient.web.util.ResumeManagerPDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.DocumentException;

/**
 * @author komar
 * 
 *         Updated by @author spash1
 * 
 */
@Controller
public class SearchEmployeeController {

	private static Log log = LogFactory.getLog(SearchEmployeeController.class);

	@Resource
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	@Autowired
	@Qualifier("resumeManagerPDFGenerator")
	private ResumeManagerPDFGenerator resumeManagerPDFGenerator;

	@RequestMapping(value = "/searchEmployee.html")
	public String renderSearchEmployee(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) {
		log.info("Entering SearchEmployeeController::SearchEmployeeController()...");

		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}

		SearchEmployeeForm searchEmployeeForm = new SearchEmployeeForm();
		model.put("searchEmployeeForm", searchEmployeeForm);

		return "searchEmployee";
	}

	@RequestMapping(value = "/submitSearchCriteria.html")
	public String submitSearchCriteria(
			@Valid SearchEmployeeForm searchEmployeeForm, BindingResult result,
			Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {

		Long userId = null;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (userInfo != null) {
			userId = userInfo.getUserId();
		} else {
			return "invalidSession";
		}

		String fName = searchEmployeeForm.getfName();
		String lName = searchEmployeeForm.getlName();
		Long oracleId = searchEmployeeForm.getOracleId();
		String searchCriteria = searchEmployeeForm.getSearchCriteria();
		String skill = searchEmployeeForm.getSkill();
		String revenueGroup = searchEmployeeForm.getRevenueGroup();
		String teamName = searchEmployeeForm.getTeamName();
		String businessFocus = searchEmployeeForm.getBusinessFocus();
		String bu = searchEmployeeForm.getBu();
		String division = searchEmployeeForm.getDivision();
		String homeOff = searchEmployeeForm.getHomeOff();
		String currOff = searchEmployeeForm.getCurrOff();
		String company = searchEmployeeForm.getCompany();
		String personType = searchEmployeeForm.getPersonType();
		String homeRegion = searchEmployeeForm.getHomeRegion();
		String currentRegion = searchEmployeeForm.getCurrentRegion();
		String primaryCapability = searchEmployeeForm.getPrimaryCapability();
		String domain = searchEmployeeForm.getDomain();

		List<SearchResultVO> searchedEmployeeList = resumeManagementService
				.retrieveEmployeeSearch(oracleId, fName, lName, searchCriteria,
						skill, revenueGroup, teamName, businessFocus, bu,
						division, homeOff, currOff, company, personType,
						homeRegion, currentRegion, primaryCapability, domain);
		model.put("searchedEmployeeList", searchedEmployeeList);
		return "searchEmployee";
	}

	@RequestMapping("/resumeDetail.html")
	public String printResumeDetails(@RequestParam("loginId") String loginId,
			HttpServletRequest request, HttpServletResponse response)
			throws DocumentException, IOException {

		log.info("inside ResumeDetailsController ::" + loginId);

		UserInfoVO userInfoVO = resumeManagementService
				.retrieveUserInfoByLoginName(loginId);
		ByteArrayOutputStream baos = resumeManagerPDFGenerator
				.generatePDF(userInfoVO);
		response.getOutputStream().write(baos.toByteArray());

		return null;
	}

}
