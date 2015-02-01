/**
 * 
 */
package org.sapient.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.DozerBeanMapper;
import org.sapient.commons.types.CourseType;
import org.sapient.commons.types.ResumeStatus;
import org.sapient.commons.types.UserStatus;
import org.sapient.hibernate.dao.UserInfoDao;
import org.sapient.hibernate.entity.UserInfoEntity;
import org.sapient.service.beans.ContactInfoVO;
import org.sapient.service.beans.EducationInfoVO;
import org.sapient.service.beans.EmploymentInfoVO;
import org.sapient.service.beans.PersonalInfoVO;
import org.sapient.service.beans.ProfileSummaryInfoVO;
import org.sapient.service.beans.ProjectInfoVO;
import org.sapient.service.beans.RecognitionInfoVO;
import org.sapient.service.beans.SkillsInfoVO;
import org.sapient.service.beans.UserInfoVO;
import org.sapient.service.beans.comparator.HirarchyComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author psiva2
 * 
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailService {

	private static final Log LOG = LogFactory
			.getLog(UserDetailServiceImpl.class);
	@Autowired
	@Qualifier("userInfoDao")
	private UserInfoDao userInfoDao;

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
	@Qualifier("projectDetailService")
	private ProjectDetailService projectDetailService;

	@Autowired
	@Qualifier("skillsDetailService")
	private SkillsDetailService skillsDetailService;

	@Autowired
	@Qualifier("profileSummaryDetailService")
	private ProfileSummaryDetailService profileSummaryDetailService;

	@Autowired
	@Qualifier("recognitionDetailService")
	private RecognitionDetailService recognitionDetailService;

	@Autowired
	@Qualifier("dozerBeanMapper")
	private DozerBeanMapper dozerBeanMapper;

	public UserInfoVO retrieveUserDetailByLoginName(String loginId) {
		UserInfoVO userInfo = new UserInfoVO();
		PersonalInfoVO personalInfo = new PersonalInfoVO();
		UserInfoEntity entity = userInfoDao.getUserInfoByLoginId(loginId);
		if (entity != null) {
			personalInfo = dozerBeanMapper.map(entity, PersonalInfoVO.class);
			userInfo.setPersonalDetails(personalInfo);

			List<ContactInfoVO> contactDetails = contactDetailService
					.retrieveContactDetailByUserId(entity.getId());
			userInfo.setContactDetails(contactDetails);

			List<EducationInfoVO> educationDetails = educationDetailService
					.retrieveEducationDetailByUserId(entity.getId());
			userInfo.setEducationDetails(educationDetails);

			List<EmploymentInfoVO> employmentDetails = employmentDetailService
					.retrieveEmploymentDetailByUserId(entity.getId());
			userInfo.setEmploymentDetails(employmentDetails);

			List<ProjectInfoVO> projectDetails = projectDetailService
					.retrieveProjectDetailByUserId(entity.getId());
			userInfo.setProjectDetails(projectDetails);

			List<SkillsInfoVO> skillsDetails = skillsDetailService
					.retrieveSkillsDetailByUserId(entity.getId());
			userInfo.setSkillSets(skillsDetails);

			List<ProfileSummaryInfoVO> profileSummaryDetails = profileSummaryDetailService
					.retrieveProfileSummaryDetailByUserId(entity.getId());
			userInfo.setProfileSummaryDetails(profileSummaryDetails);

			List<RecognitionInfoVO> recognitionDetails = recognitionDetailService
					.retrieveRecognitionDetailByUserId(entity.getId());
			userInfo.setRecognitionDetails(recognitionDetails);
			List<String> completionTips = new ArrayList<String>();
			userInfo.setResumeStatus(getResumeCompletionStatus(userInfo,
					completionTips));
			userInfo.setCompletionTips(completionTips);
		}
		return userInfo;
	}

	private String getResumeCompletionStatus(UserInfoVO userInfo,
			List<String> completionTips) {

		if (userInfo.getEducationDetails() != null
				&& userInfo.getEducationDetails().size() > 0) {
			boolean isFound = false;
			for (EducationInfoVO educationInfoVO : userInfo
					.getEducationDetails()) {
				if (educationInfoVO.getCourseType() == CourseType.GRADUATION) {
					isFound = true;
				}
			}
			if (!isFound) {
				completionTips.add("Education Information is Incomplete...");
			}
		} else {
			completionTips.add("Education Information is Incomplete...");
		}

		if (!(userInfo.getEmploymentDetails() != null && userInfo
				.getEmploymentDetails().size() > 0)) {
			completionTips.add("Employment Information is Incomplete...");
		}

		if (!(userInfo.getProjectDetails() != null && userInfo
				.getProjectDetails().size() > 0)) {
			completionTips.add("Project Information is Incomplete...");
		}

		if (!(userInfo.getSkillSets() != null && userInfo.getSkillSets().size() > 0)) {
			completionTips.add("Skill Sets Information is Incomplete...");
		}

		if (!(userInfo.getProfileSummaryDetails() != null && userInfo
				.getProfileSummaryDetails().size() > 0)) {
			completionTips.add("Profile Summary Information is Incomplete...");
		}

		return (completionTips != null && completionTips.size() > 0) ? "Incomplete"
				: "Complete";
	}

	@Transactional
	public Long savePersonalDetail(PersonalInfoVO personalInfoVO) {
		UserInfoEntity userInfoEntity = userInfoDao
				.getUserInfoById(personalInfoVO.getId());
		userInfoEntity = dozerBeanMapper.map(personalInfoVO,
				UserInfoEntity.class);
		if (personalInfoVO.getId() == null) {
			userInfoEntity.setCreatedBy(new Long(1));
			userInfoEntity.setCreatedDate(Calendar.getInstance());
		} else {
			userInfoEntity.setUpdatedBy(new Long(1));
			userInfoEntity.setUpdatedDate(Calendar.getInstance());
		}
		userInfoDao.saveUserInfo(userInfoEntity);
		LOG.info(String.format(
				"The Personal Information is saved with the Id [%s]",
				userInfoEntity.getId()));
		return null;
	}

	public List<PersonalInfoVO> retrieveUserDetailBySupervisorId(
			Long supervisorId) {
		LOG.info(String.format("Retrieving User detail by SupervisorId"));
		List<UserInfoEntity> entities = userInfoDao
				.getUserInfoBySupervisorId(supervisorId);
		List<PersonalInfoVO> results = null;
		if (entities != null && entities.size() > 0) {
			results = new ArrayList<PersonalInfoVO>();
			for (UserInfoEntity entity : entities) {
				PersonalInfoVO personalInfoVO = dozerBeanMapper.map(entity,
						PersonalInfoVO.class);
				results.add(personalInfoVO);
			}
			 Collections.sort(results, new HirarchyComparator());
		}
		return results;
	}

	public String retriveSupervisorNameByID(Long oracleId) {
		UserInfoEntity userInfoEntity = userInfoDao
				.getUserInfoByOracleId(oracleId);
		if (userInfoEntity.getSupervisorId() != null) {
			UserInfoEntity supervisorEntity = userInfoDao
					.getUserInfoByOracleId(userInfoEntity.getSupervisorId());
			if (supervisorEntity != null) {
				String superVisorName = supervisorEntity.getFirstName() + " "
						+ supervisorEntity.getLastName();
				LOG.info("The SuperVisor Information is shown...");
				return superVisorName;
			}
		}
		return null;
	}

	@Override
	public void updateUserStatus(Long userId, UserStatus userStatus) {
		userInfoDao.updateUserStatus(userId, userStatus);
	}
}