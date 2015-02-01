package org.sapient.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.sapient.commons.types.UserStatus;
import org.sapient.service.beans.AddressInfoVO;
import org.sapient.service.beans.ContactInfoVO;
import org.sapient.service.beans.EducationInfoVO;
import org.sapient.service.beans.EmploymentInfoVO;
import org.sapient.service.beans.PersonalInfoVO;
import org.sapient.service.beans.ProfileSummaryInfoVO;
import org.sapient.service.beans.ProjectInfoVO;
import org.sapient.service.beans.RecognitionInfoVO;
import org.sapient.service.beans.SearchResultVO;
import org.sapient.service.beans.RecognitionTypeVO;
import org.sapient.service.beans.SecurityQuestionVO;
import org.sapient.service.beans.SkillsInfoVO;
import org.sapient.service.beans.SkillsTypeVO;
import org.sapient.service.beans.UserInfoVO;
import org.sapient.service.beans.UserSecurityQuestionVO;

@WebService
public interface ResumeManagementService {

	@WebMethod(operationName = "retrieveEmployeeSearch")
	List<SearchResultVO> retrieveEmployeeSearch(
			@WebParam(name = "oracleId") Long oracleId,
			@WebParam(name = "firstName") String firstName,
			@WebParam(name = "lastName") String lastName,
			@WebParam(name = "designation") String designation,
			@WebParam(name = "skill") String skill,			
			@WebParam(name = "revenueGroup") String revenueGroup,
			@WebParam(name = "teamName") String teamName,
			@WebParam(name = "businessFocus") String businessFocus,
			@WebParam(name = "bu") String bu,
			@WebParam(name = "division") String division,
			@WebParam(name = "homeOff") String homeOff,
			@WebParam(name = "currOff") String currOff,
			@WebParam(name = "company") String company,
			@WebParam(name = "personType") String personType,
			@WebParam(name = "homeRegion") String homeRegion,
			@WebParam(name = "currentRegion") String currentRegion,
			@WebParam(name = "primaryCapability") String primaryCapability,
			@WebParam(name = "domain") String domain
			
			);

	@WebMethod(operationName = "retrieveUserInfoByLoginName")
	UserInfoVO retrieveUserDetailByLoginName(
			@WebParam(name = "loginName") String loginName);

	@WebMethod(operationName = "savePersonalDetail")
	Long savePersonalDetail(
			@WebParam(name = "personalDetail") PersonalInfoVO personalInfo);

	@WebMethod(operationName = "saveAddressDetail")
	Long saveAddressDetail(
			@WebParam(name = "addressDetail") AddressInfoVO addressInfo);

	@WebMethod(operationName = "retrieveContactDetailByUserId")
	List<ContactInfoVO> retrieveContactDetailByUserId(
			@WebParam(name = "userId") Long userId);

	@WebMethod(operationName = "saveContactDetail")
	Long saveContactDetail(
			@WebParam(name = "contactDetail") ContactInfoVO contactInfoVO);

	@WebMethod(operationName = "retrieveEducationDetailByUserId")
	List<EducationInfoVO> retrieveEducationDetailByUserId(
			@WebParam(name = "userId") Long userId);

	@WebMethod(operationName = "saveEducationDetail")
	Long saveEducationDetail(
			@WebParam(name = "educationDetail") EducationInfoVO educationInfoVO);

	@WebMethod(operationName = "retrieveEmploymentDetailByUserId")
	List<EmploymentInfoVO> retrieveEmploymentDetailByUserId(
			@WebParam(name = "userId") Long userId);

	@WebMethod(operationName = "saveEmploymentDetail")
	Long saveEmploymentDetail(
			@WebParam(name = "employmentDetail") EmploymentInfoVO employmentInfoVO);

	@WebMethod(operationName = "retrieveProfileSummaryDetailByUserId")
	List<ProfileSummaryInfoVO> retrieveProfileSummaryDetailByUserId(
			@WebParam(name = "userId") Long userId);

	@WebMethod(operationName = "saveProfileSummaryDetail")
	Long saveProfileSummaryDetail(
			@WebParam(name = "profileSummaryDetail") ProfileSummaryInfoVO profileSummaryInfoVO);

	@WebMethod(operationName = "retrieveProjectDetailByUserId")
	List<ProjectInfoVO> retrieveProjectDetailByUserId(
			@WebParam(name = "userId") Long userId);

	@WebMethod(operationName = "saveProjectDetails")
	Long saveProjectDetails(
			@WebParam(name = "projectDetails") ProjectInfoVO projectInfoVO);

	@WebMethod(operationName = "retrieveRecognitionDetailByUserId")
	List<RecognitionInfoVO> retrieveRecognitionDetailByUserId(
			@WebParam(name = "userId") Long userId);

	@WebMethod(operationName = "saveRecognitionDetails")
	Long saveRecognitionDetails(
			@WebParam(name = "recognitionDetails") RecognitionInfoVO projectInfoVO);

	@WebMethod(operationName = "retrieveSkillsDetailByUserId")
	List<SkillsInfoVO> retrieveSkillsDetailByUserId(
			@WebParam(name = "userId") Long userId);

	@WebMethod(operationName = "saveSkillsDetail")
	Long saveSkillsDetail(
			@WebParam(name = "skillsDetail") SkillsInfoVO SkillsInfoVO);

	@WebMethod(operationName = "retrieveEmploymentInformationById")
	EmploymentInfoVO retrieveEmploymentInformationById(
			@WebParam(name = "employmentInfoId") Long employmentInfoId);

	@WebMethod(operationName = "retrieveEducationInformationById")
	EducationInfoVO retrieveEducationInformationById(
			@WebParam(name = "educationInfoId") Long educationInfoId);

	@WebMethod(operationName = "retrieveProjectInformationById")
	ProjectInfoVO retrieveProjectInformationById(
			@WebParam(name = "projectInfoId") Long projectInfoId);

	@WebMethod(operationName = "retrieveSkillsDetailById")
	SkillsInfoVO retrieveSkillsDetailById(@WebParam(name = "id") Long id);

	@WebMethod(operationName = "retrieveRecognitionDetailById")
	RecognitionInfoVO retrieveRecognitionDetailById(
			@WebParam(name = "id") Long id);

	@WebMethod(operationName = "retrieveUserDetailBySupervisorId")
	List<PersonalInfoVO> retrieveUserDetailBySupervisorId(
			@WebParam(name = "supervisorId") Long supervisorId);

	@WebMethod(operationName = "retriveSupervisorNameByID")
	String retriveSupervisorNameByID(@WebParam(name = "oracleId") Long oracleId);

	@WebMethod(operationName = "retrieveAllSecurityQuestions")
	List<SecurityQuestionVO> retrieveAllSecurityQuestions();

	@WebMethod(operationName = "retrieveUserSecurityQuestionByUserId")
	UserSecurityQuestionVO retrieveUserSecurityQuestionByUserId(
			@WebParam(name = "userId") Long userId);

	@WebMethod(operationName = "saveUserSecurityQuestion")
	Long saveUserSecurityQuestion(
			@WebParam(name = "userSecurityQuestion") UserSecurityQuestionVO userSecurityQuestionVO);

	@WebMethod(operationName = "retrieveAllRecognitionTypes")
	List<RecognitionTypeVO> retrieveAllRecognitionTypes();

	@WebMethod(operationName = "retrieveAllSkillTypes")
	List<SkillsTypeVO> retrieveAllSkillTypes();

	@WebMethod(operationName = "removeEducationDetail")
	void removeEducationDetail(Long userId, Long educationInfoId);

	@WebMethod(operationName = "removeEmploymentDetail")
	void removeEmploymentDetail(Long userId, Long employmentInfoId);

	@WebMethod(operationName = "removeProjectDetail")
	void removeProjectDetail(Long userId, Long projectInfoId);

	@WebMethod(operationName = "removeSkillSet")
	void removeSkillSet(Long userId, Long skillsInfoId);

	@WebMethod(operationName = "removeRecognitionDetail")
	void removeRecognitionDetail(Long userId, Long recognitionInfoId);

	@WebMethod(operationName = "retrieveUserSecurityQuestionById")
	UserSecurityQuestionVO retrieveUserSecurityQuestionById(
			@WebParam(name = "userId") Long id);

	@WebMethod(operationName = "updateUserStatus")
	void updateUserStatus(Long userId, UserStatus userStatus);

	@WebMethod(operationName = "isCurrentEmployerExists")
	Boolean isCurrentEmployerExists(@WebParam(name = "userId") Long userId);
	
	@WebMethod(operationName = "getCurrentEmploymentDetail")
	EmploymentInfoVO getCurrentEmploymentDetail(Long userId);
}