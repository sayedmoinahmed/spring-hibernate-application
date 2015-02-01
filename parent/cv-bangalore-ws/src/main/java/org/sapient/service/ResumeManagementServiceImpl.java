package org.sapient.service;

import java.util.List;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@WebService(name = "ResumeManagementService", targetNamespace = "http://sapient.org/ResumeManagementService")
@Service("resumeManagementService")
public class ResumeManagementServiceImpl implements ResumeManagementService {

	@Autowired
	@Qualifier("searchEmployeeDetailService")
	private SearchEmployeeDetailService searchEmployeeDetailService;

	@Autowired
	@Qualifier("userDetailService")
	private UserDetailService userDetailService;

	@Autowired
	@Qualifier("contactDetailService")
	private ContactDetailService contactDetailService;

	@Autowired
	@Qualifier("educationDetailService")
	private EducationDetailService educationDetailService;

	@Autowired
	@Qualifier("employmentDetailService")
	private EmploymentDetailService employmentDetailService;

	@Autowired
	@Qualifier("profileSummaryDetailService")
	private ProfileSummaryDetailService profileSummaryDetailService;

	@Autowired
	@Qualifier("projectDetailService")
	private ProjectDetailService projectDetailService;

	@Autowired
	@Qualifier("recognitionDetailService")
	private RecognitionDetailService recognitionDetailService;

	@Autowired
	@Qualifier("skillsDetailService")
	private SkillsDetailService skillsDetailService;

	@Autowired
	@Qualifier("addressDetailService")
	private AddressDetailService addressDetailService;

	@Autowired
	@Qualifier("securityQuestionService")
	private SecurityQuestionService securityQuestionService;

	@Autowired
	@Qualifier("userSecurityQuestionService")
	private UserSecurityQuestionService userSecurityQuestionService;

	public UserInfoVO retrieveUserDetailByLoginName(String loginName) {
		return userDetailService.retrieveUserDetailByLoginName(loginName);
	}

	public List<ContactInfoVO> retrieveContactDetailByUserId(Long userId) {
		return contactDetailService.retrieveContactDetailByUserId(userId);
	}

	public Long saveContactDetail(ContactInfoVO contactInfoVO) {
		return contactDetailService.saveContactDetail(contactInfoVO);
	}

	public List<EducationInfoVO> retrieveEducationDetailByUserId(Long userId) {
		return educationDetailService.retrieveEducationDetailByUserId(userId);
	}

	public Long saveEducationDetail(EducationInfoVO educationInfoVO) {
		return educationDetailService.saveEducationDetail(educationInfoVO);
	}

	// Implementation of Employment
	public List<EmploymentInfoVO> retrieveEmploymentDetailByUserId(Long userId) {
		return employmentDetailService.retrieveEmploymentDetailByUserId(userId);
	}

	public Long saveEmploymentDetail(EmploymentInfoVO employmentInfoVO) {
		return employmentDetailService.saveEmploymentDetail(employmentInfoVO);
	}

	// Implementation of Profile
	public List<ProfileSummaryInfoVO> retrieveProfileSummaryDetailByUserId(
			Long userId) {
		return profileSummaryDetailService
				.retrieveProfileSummaryDetailByUserId(userId);
	}

	public Long saveProfileSummaryDetail(
			ProfileSummaryInfoVO profileSummaryInfoVO) {
		return profileSummaryDetailService
				.saveProfileSummaryDetail(profileSummaryInfoVO);
	}

	public List<ProjectInfoVO> retrieveProjectDetailByUserId(Long userId) {
		return projectDetailService.retrieveProjectDetailByUserId(userId);
	}

	public Long saveProjectDetails(ProjectInfoVO projectInfoVO) {
		return projectDetailService.saveProjectDetails(projectInfoVO);
	}

	public List<RecognitionInfoVO> retrieveRecognitionDetailByUserId(Long userId) {
		return recognitionDetailService
				.retrieveRecognitionDetailByUserId(userId);
	}

	public Long saveRecognitionDetails(RecognitionInfoVO recognitionInfoVO) {
		return recognitionDetailService
				.saveRecognitionDetails(recognitionInfoVO);
	}

	public List<SkillsInfoVO> retrieveSkillsDetailByUserId(Long userId) {
		return skillsDetailService.retrieveSkillsDetailByUserId(userId);
	}

	public Long saveSkillsDetail(SkillsInfoVO SkillsInfoVO) {
		return skillsDetailService.saveSkillsDetail(SkillsInfoVO);
	}

	public Long saveAddressDetail(AddressInfoVO addressInfo) {
		return addressDetailService.saveAddressDetail(addressInfo);
	}

	public Long savePersonalDetail(PersonalInfoVO personalInfo) {
		return userDetailService.savePersonalDetail(personalInfo);
	}

	public EmploymentInfoVO retrieveEmploymentInformationById(
			Long employmentInfoId) {
		return employmentDetailService
				.retrieveEmploymentInformationById(employmentInfoId);
	}

	public EducationInfoVO retrieveEducationInformationById(Long educationInfoId) {
		return educationDetailService
				.retrieveEducationInformationById(educationInfoId);
	}

	public ProjectInfoVO retrieveProjectInformationById(Long projectInfoId) {
		return projectDetailService.retrieveProjectDetailById(projectInfoId);
	}

	public SkillsInfoVO retrieveSkillsDetailById(Long id) {
		return skillsDetailService.retrieveSkillsDetailById(id);
	}

	public RecognitionInfoVO retrieveRecognitionDetailById(Long id) {
		return recognitionDetailService.retrieveRecognitionDetailById(id);
	}

	public List<SearchResultVO> retrieveEmployeeSearch(Long oracleId ,String firstName,String lastName,String designation,
			String skill,String revenueGroup, String teamName,
			String businessFocus, String bu, String division, String homeOff,
			String currOff, String company, String personType,
			String homeRegion, String currentRegion, String primaryCapability,
			String domain) {
		return searchEmployeeDetailService.retrieveEmployeeSearch(oracleId ,firstName,lastName, designation,
				skill,
				revenueGroup,
				teamName,
				businessFocus,
				bu,
				division,
				homeOff,
				currOff,
				company,
				personType,
				homeRegion,
				currentRegion,
				primaryCapability,
				domain
				
		);
	}

	public List<PersonalInfoVO> retrieveUserDetailBySupervisorId(
			Long supervisorId) {
		return userDetailService.retrieveUserDetailBySupervisorId(supervisorId);
	}

	public String retriveSupervisorNameByID(Long oracleId) {
		return userDetailService.retriveSupervisorNameByID(oracleId);
	}

	@Override
	public List<SecurityQuestionVO> retrieveAllSecurityQuestions() {
		return securityQuestionService.retrieveAllSecurityQuestions();
	}

	@Override
	public UserSecurityQuestionVO retrieveUserSecurityQuestionByUserId(
			Long userId) {
		return userSecurityQuestionService
				.retrieveUserSecurityQuestionByUserId(userId);
	}

	@Override
	public Long saveUserSecurityQuestion(
			UserSecurityQuestionVO userSecurityQuestionVO) {
		return userSecurityQuestionService
				.saveUserSecurityQuestion(userSecurityQuestionVO);
	}

	@Override
	public List<RecognitionTypeVO> retrieveAllRecognitionTypes() {
		return recognitionDetailService.retrieveAllRecognitions();
	}

	@Override
	public List<SkillsTypeVO> retrieveAllSkillTypes() {
		return skillsDetailService.retrieveAllSkillTypes();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.service.ResumeManagementService#removeEducationDetail(java
	 * .lang.Long, java.lang.Long)
	 */
	@Override
	public void removeEducationDetail(Long userId, Long educationInfoId) {
		educationDetailService.removeEducationDetail(userId, educationInfoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.service.ResumeManagementService#removeEmploymentDetail(java
	 * .lang.Long, java.lang.Long)
	 */
	@Override
	public void removeEmploymentDetail(Long userId, Long employmentInfoId) {
		employmentDetailService
				.removeEmploymentDetail(userId, employmentInfoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.service.ResumeManagementService#removeProjectDetail(java.
	 * lang.Long, java.lang.Long)
	 */
	@Override
	public void removeProjectDetail(Long userId, Long projectInfoId) {
		projectDetailService.removeProjectDetail(userId, projectInfoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.service.ResumeManagementService#removeSkillSet(java.lang.
	 * Long, java.lang.Long)
	 */
	@Override
	public void removeSkillSet(Long userId, Long skillsInfoId) {
		skillsDetailService.removeSkillSet(userId, skillsInfoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.service.ResumeManagementService#removeRecognitionDetail(java
	 * .lang.Long, java.lang.Long)
	 */
	@Override
	public void removeRecognitionDetail(Long userId, Long recognitionInfoId) {
		recognitionDetailService.removeRecognitionDetail(userId,
				recognitionInfoId);

	}

	@Override
	public UserSecurityQuestionVO retrieveUserSecurityQuestionById(Long id) {
		return userSecurityQuestionService
				.retrieveUserSecurityQuestionByUserId(id);
	}

	@Override
	public void updateUserStatus(Long userId, UserStatus userStatus) {
		userDetailService.updateUserStatus(userId, userStatus);
	}

	@Override
	public Boolean isCurrentEmployerExists(Long userId) {
		return employmentDetailService.isCurrentEmployerExists(userId);
	}

	@Override
	public EmploymentInfoVO getCurrentEmploymentDetail(Long userId) {
		return employmentDetailService.getCurrentEmploymentDetail(userId);
	}
}