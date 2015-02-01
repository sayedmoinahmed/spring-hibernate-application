package org.sapient.hibernate.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sapient.commons.types.EmploymentType;
import org.sapient.commons.types.UserStatus;
import org.sapient.hibernate.entity.ContactInfoEntity;
import org.sapient.hibernate.entity.EducationInfoEntity;
import org.sapient.hibernate.entity.EmploymentInfoEntity;
import org.sapient.hibernate.entity.ProjectInfoEntity;
import org.sapient.hibernate.entity.RecognitionInfoEntity;
import org.sapient.hibernate.entity.SkillsInfoEntity;
import org.sapient.hibernate.entity.UserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-resources.xml",
		"/applicationContext-dao.xml" })
public class UserInfoDaoTest {

	private static final Log LOG = LogFactory.getLog(UserInfoDaoTest.class);

	@Autowired
	@Qualifier("userInfoDao")
	private UserInfoDao userInfoDao;

	@Autowired
	@Qualifier("educationInfoDao")
	private EducationInfoDao educationInfoDao;

	@Autowired
	@Qualifier("skillsInfoDao")
	private SkillsInfoDao skillsInfoDao;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUpdateUserStatus() {
		userInfoDao.updateUserStatus(new Long(1), UserStatus.DELETED);
	}

	@Test
	public void testRemoveEducationDetail() {
		userInfoDao.removeEducationDetail(new Long(1), new Long(2));
	}

	@Test
	public void testRemoveProjectDetail() {
		userInfoDao.removeProjectDetail(new Long(1), new Long(1));
	}

	@Test
	public void testRemoveSkillsDetail() {
		userInfoDao.removeSkillSet(new Long(1), new Long(1));
	}

	@Test
	public void testRemoveEmploymentDetail() {
		userInfoDao.removeEmploymentDetail(new Long(1), new Long(1));
	}

	@Test
	public void testRemoveRecognitionDetail() {
		userInfoDao.removeRecognitionDetail(new Long(1), new Long(1));
	}

	@Test
	public void testSaveUserInfo() {
		UserInfoEntity entity = new UserInfoEntity();
		entity.setCreatedBy(new Long(1));
		entity.setCreatedDate(Calendar.getInstance());
		entity.setDateOfBirth(Calendar.getInstance());
		entity.setDateOfJoining(Calendar.getInstance());
		entity.setDesignation("Associate Technology L2");
		entity.setFatherName("Shenbagamoorthy");
		entity.setFirstName("Hariharan");
		entity.setLastName("Shenbagamoorthy");
		entity.setLoginId("hshenbag");
		entity.setMiddleName(null);
		entity.setOracleId(new Long(85342));
		entity.setPersonType(EmploymentType.PERMANENT);
		userInfoDao.saveUserInfo(entity);
		assertNotNull(entity.getId());
	}

	@Test
	public void testGetUserInfoById() {
		UserInfoEntity entity = userInfoDao.getUserInfoById(new Long(1));
		assertNotNull(entity);
	}

	@Test
	public void testGetUserInfoBySupervisorId() {
		List<UserInfoEntity> set = userInfoDao
				.getUserInfoBySupervisorId(new Long(83574));
		assertNotNull(set);
	}

	@Test
	public void testGetUserInfoByLoginId() {
		UserInfoEntity entity = userInfoDao.getUserInfoByLoginId("psiva2");
		assertNotNull(entity);
	}

	@Test
	public void testGetEducationDetailsByUserId() {
		Set<EducationInfoEntity> educationDetails = userInfoDao
				.getEducationDetailsByUserId(new Long(1));
		for (EducationInfoEntity entity : educationDetails) {
			LOG.info(String.format("The EducationInfoEntity retrieved is [%s]",
					entity));
		}
		assertNotNull(educationDetails);
	}

	@Test
	public void testGetEmploymentDetailsByUserId() {
		Set<EmploymentInfoEntity> employmentDetails = userInfoDao
				.getEmploymentDetailsByUserId(new Long(1));
		assertNotNull(employmentDetails);
	}

	@Test
	public void testGetProjectDetailsByUserId() {
		Set<ProjectInfoEntity> projectDetails = userInfoDao
				.getProjectDetailsByUserId(new Long(1));
		assertNotNull(projectDetails);
	}

	@Test
	public void testGetProfileSummaryDetailsByUserId() {
		Set<ProjectInfoEntity> projectDetails = userInfoDao
				.getProjectDetailsByUserId(new Long(1));
		assertNotNull(projectDetails);
	}

	@Test
	public void testGetSkillSetsByUserId() {
		Set<SkillsInfoEntity> skillSets = userInfoDao
				.getSkillSetsByUserId(new Long(1));
		assertNotNull(skillSets);
	}

	@Test
	public void testGetRecognitionDetailsByUserId() {
		Set<RecognitionInfoEntity> recognitionDetails = userInfoDao
				.getRecognitionDetailsByUserId(new Long(1));
		assertNotNull(recognitionDetails);
	}

	@Test
	public void testGetContactDetailsByUserId() {
		Set<ContactInfoEntity> contactDetails = userInfoDao
				.getContactDetailsByUserId(new Long(1));
		assertNotNull(contactDetails);
	}

	@Test
	public void testAddEducationDetail() {
		EducationInfoEntity entity = educationInfoDao
				.getEducationInfoById(new Long(1));
		entity.setAggregate(100.0);
		educationInfoDao.saveEducationInfo(entity);
		userInfoDao.addEducationDetail(new Long(1), entity);
		Set<EducationInfoEntity> results = userInfoDao
				.getEducationDetailsByUserId(new Long(1));
		LOG.info(String.format(
				"The Number of Education Details retrieved is [%s]",
				results.size()));
		for (EducationInfoEntity educationInfoEntity : results) {
			LOG.info(String.format(
					"The Education Course [%s] with Aggregate [%s]",
					educationInfoEntity.getCourseName(),
					educationInfoEntity.getAggregate()));
		}
		assertNotNull(results);
	}

}