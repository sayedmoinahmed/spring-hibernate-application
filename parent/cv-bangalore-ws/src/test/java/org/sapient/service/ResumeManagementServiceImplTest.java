package org.sapient.service;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sapient.commons.types.AddressType;
import org.sapient.commons.types.CourseName;
import org.sapient.commons.types.CourseType;
import org.sapient.commons.types.ProficiencyLevelType;
import org.sapient.service.beans.AddressInfoVO;
import org.sapient.service.beans.ContactInfoVO;
import org.sapient.service.beans.EducationInfoVO;
import org.sapient.service.beans.EmploymentInfoVO;
import org.sapient.service.beans.ProfileSummaryInfoVO;
import org.sapient.service.beans.ProjectInfoVO;
import org.sapient.service.beans.RecognitionInfoVO;
import org.sapient.service.beans.RecognitionTypeVO;
import org.sapient.service.beans.SearchResultVO;
import org.sapient.service.beans.SecurityQuestionVO;
import org.sapient.service.beans.SkillsInfoVO;
import org.sapient.service.beans.SkillsTypeVO;
import org.sapient.service.beans.UserInfoVO;
import org.sapient.service.beans.UserSecurityQuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author smoin
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-resources.xml",
		"/applicationContext-ws.xml" })
public class ResumeManagementServiceImplTest {

	private static final Log LOG = LogFactory
			.getLog(ResumeManagementServiceImplTest.class);

	@Autowired
	@Qualifier("resumeManagementService")
	private ResumeManagementService resumeManagementService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		LOG.info("Started Logging in web services");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllRecognitionTypes() {
		List<RecognitionTypeVO> results = resumeManagementService
				.retrieveAllRecognitionTypes();
		assertNotNull(results);
	}

	@Test
	public void testGetAllSkillTypes() {
		List<SkillsTypeVO> results = resumeManagementService
				.retrieveAllSkillTypes();
		assertNotNull(results);
	}

	@Test
	public void testSaveUserSecurityQuestion() {
		UserSecurityQuestionVO userSecurityQuestionVO = new UserSecurityQuestionVO();
		userSecurityQuestionVO.setId(new Long(1));
		userSecurityQuestionVO.setSecurityQuestionId(new Long(2));
		userSecurityQuestionVO.setSecurityQuestionAnswer("Angelina Jolie");
		userSecurityQuestionVO.setUserId(new Long(1));
		resumeManagementService
				.saveUserSecurityQuestion(userSecurityQuestionVO);
	}

	@Test
	public void testGetUserSecurityQuestionByUserId() {
		UserSecurityQuestionVO result = resumeManagementService
				.retrieveUserSecurityQuestionByUserId(new Long(1));
		assertNotNull(result);
	}

	@Test
	public void testRetrieveAllSecurityQuestion() {
		List<SecurityQuestionVO> results = resumeManagementService
				.retrieveAllSecurityQuestions();
		assertNotNull(results);
	}

	@Test
	public void testSaveEducationDetails() {
		
		AddressInfoVO addressInfo = new AddressInfoVO();
		addressInfo.setAddressType(AddressType.EDUCATION);
		addressInfo.setCity("Kolkata");
		addressInfo.setEducationInfoId(new Long(1));
		addressInfo.setUserId(new Long(1));
		Long addressId = resumeManagementService.saveAddressDetail(addressInfo);
		System.out.println("addressId: " + addressId);
	}

	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#retrieveUserDetailByLoginName(java.lang.String)}
	 * .
	 */
	@Test
	public void testRetrieveUserDetailByLoginName() {
		UserInfoVO results = resumeManagementService
				.retrieveUserDetailByLoginName("psiva2");
		assertNotNull(results);
	}

	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#retrieveSkillsDetailByUserId(java.lang.Long)}
	 * .
	 */
	@Test
	public void testRetrieveSkillsDetailByUserId() {
		List<SkillsInfoVO> result = resumeManagementService
				.retrieveSkillsDetailByUserId(new Long(1));
		assertNotNull(result);
	}

	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#retrieveRecognitionDetailByUserId(java.lang.Long)}
	 * .
	 */
	@Test
	public void testRetrieveRecognitionDetailByUserId() {
		List<RecognitionInfoVO> result = resumeManagementService
				.retrieveRecognitionDetailByUserId(new Long(1));
		assertNotNull(result);
	}

	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#retrieveProjectDetailByUserId(java.lang.Long)}
	 * .
	 */
	@Test
	public void testRetrieveProjectDetailByUserId() {
		List<ProjectInfoVO> result = resumeManagementService
				.retrieveProjectDetailByUserId(new Long(1));
		assertNotNull(result);
	}

	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#retrieveProfileSummaryDetailByUserId(java.lang.Long)}
	 * .
	 */
	@Test
	public void testRetrieveProfileSummaryDetailByUserId() {
		List<ProfileSummaryInfoVO> result = resumeManagementService
				.retrieveProfileSummaryDetailByUserId(new Long(1));
		assertNotNull(result);
	}

	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#retrieveEmploymentDetailByUserId(java.lang.Long)}
	 * .
	 */
	@Test
	public void testRetrieveEmploymentDetailByUserId() {
		List<EmploymentInfoVO> result = resumeManagementService
				.retrieveEmploymentDetailByUserId(new Long(1));
		assertNotNull(result);
	}

	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#retrieveEducationDetailByUserId(java.lang.Long)}
	 * .
	 */
	@Test
	public void testRetrieveEducationDetailByUserId() {
		List<EducationInfoVO> result = resumeManagementService
				.retrieveEducationDetailByUserId(new Long(1));
		assertNotNull(result);
	}

	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#retrieveContactDetailByUserId(java.lang.Long)}
	 * .
	 */
	@Test
	public void testRetrieveContactDetailByUserId() {
		List<ContactInfoVO> result = resumeManagementService
				.retrieveContactDetailByUserId(new Long(1));
		assertNotNull(result);

	}

	// Save
	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#saveSkillsDetail(org.sapient.service.beans.SkillsInfoVO)}
	 * .
	 */
	@Test
	public void testSaveSkillsDetail() {
		SkillsInfoVO skillsInfoVO = new SkillsInfoVO();
		skillsInfoVO.setItems("Java, J2EE, Spring, Hibernate");
		SkillsTypeVO skillsType = new SkillsTypeVO();
		skillsType.setSkillTypeId(new Long(1));
		skillsInfoVO.setSkillsType(skillsType);
		skillsInfoVO.setUserId(new Long(1));
		skillsInfoVO.setProficienyLevel(ProficiencyLevelType.BEGINNER);
		Long result = resumeManagementService.saveSkillsDetail(skillsInfoVO);
		assertNotNull(result);
	}

	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#saveRecognitionDetails(org.sapient.service.beans.RecognitionInfoVO)}
	 * .
	 */
	@Test
	public void testSaveRecognitionDetails() {
		RecognitionInfoVO recognitionInfoVO = new RecognitionInfoVO();
		recognitionInfoVO.setItems("1");
		RecognitionTypeVO recognitionTypeVO = new RecognitionTypeVO();
		recognitionTypeVO.setDescription("This is Decsription");
		recognitionTypeVO.setRecognitionTypeId(new Long(1));
		recognitionInfoVO.setRecognitionType(recognitionTypeVO);
		recognitionInfoVO.setUserId(new Long(1));
		Long result = resumeManagementService
				.saveRecognitionDetails(recognitionInfoVO);
		assertNotNull(result);
	}

	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#saveProjectDetails(org.sapient.service.beans.ProjectInfoVO)}
	 * .
	 */
	@Test
	public void testSaveProjectDetails() {
		ProjectInfoVO projectInfoVO = new ProjectInfoVO();
		projectInfoVO.setClient("Vodafone");
		projectInfoVO.setDescription("This is Desc. for Voda");
		projectInfoVO.setEndDate(Calendar.getInstance());
		projectInfoVO.setResponsibilities("Developer");
		projectInfoVO.setRole("Java");
		projectInfoVO.setSize(new Integer(5));
		projectInfoVO.setStartDate(Calendar.getInstance());
		projectInfoVO.setTechnologies("java,j2ee");
		projectInfoVO.setTitle("Voda");
		projectInfoVO.setUserId(new Long(1));
		Long result = resumeManagementService.saveProjectDetails(projectInfoVO);
		assertNotNull(result);
	}

	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#saveProfileSummaryDetail(org.sapient.service.beans.ProfileSummaryInfoVO)}
	 * .
	 */
	@Test
	public void testSaveProfileSummaryDetail() {
		ProfileSummaryInfoVO profileSummaryInfoVO = new ProfileSummaryInfoVO();
		profileSummaryInfoVO.setDescription("This is Role");
		profileSummaryInfoVO.setTitle("Role");
		profileSummaryInfoVO.setUserId(new Long(1));
		Long result = resumeManagementService
				.saveProfileSummaryDetail(profileSummaryInfoVO);
		assertNotNull(result);
	}

	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#saveEmploymentDetail(org.sapient.service.beans.EmploymentInfoVO)}
	 * .
	 */

	@Test
	public void testSaveEmploymentDetail() {
		EmploymentInfoVO employmentInfoVO = new EmploymentInfoVO();
		employmentInfoVO.setUserId(new Long(1));
		employmentInfoVO.setDateOfJoining(Calendar.getInstance());
		employmentInfoVO.setDateOfRelieving(Calendar.getInstance());
		employmentInfoVO.setDesignation("Senior Manager");
		employmentInfoVO.setEmployerName("sapient");
		employmentInfoVO
				.setEmploymentType(org.sapient.commons.types.EmploymentType.PERMANENT);
		employmentInfoVO.setSupervisorName("Prabu");
		employmentInfoVO.setUserId(new Long(1));
		Long result = resumeManagementService
				.saveEmploymentDetail(employmentInfoVO);
		assertNotNull(result);
	}

	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#saveEducationDetail(org.sapient.service.beans.EducationInfoVO)}
	 * .
	 */
	@Test
	public void testSaveEducationDetail() {
		EducationInfoVO educationInfoVO = new EducationInfoVO();
		educationInfoVO.setAggregate(75.56);
		educationInfoVO.setCourseType(CourseType.POSTGRADUATION);
		educationInfoVO.setCourseName(CourseName.BSC);
		educationInfoVO.setSpecialization("Computer");
		educationInfoVO.setUniversity("Oxford");
		educationInfoVO.setUserId(new Long(1));
		educationInfoVO.setYearOfJoining(Calendar.getInstance());
		educationInfoVO.setYearOfPassing(Calendar.getInstance());
		Long result = resumeManagementService
				.saveEducationDetail(educationInfoVO);
		assertNotNull(result);
	}

	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#saveContactDetail(org.sapient.service.beans.ContactInfoVO)}
	 * .
	 */
	@Test
	public void testSaveContactDetail() {
		ContactInfoVO contactInfoVO = new ContactInfoVO();
		contactInfoVO.setEmergency(true);
		contactInfoVO.setExtension("7195");
		contactInfoVO.setMobileNumber("999999999");
		contactInfoVO.setOfficeNumber("0070456000");
		contactInfoVO.setPrimaryEmail("sam@gmail.com");
		contactInfoVO.setSecondaryEmail("rock@yahoo.com");
		contactInfoVO.setUserId(new Long(1));
		Long result = resumeManagementService.saveContactDetail(contactInfoVO);
		assertNotNull(result);
	}

	/**
	 * Test method for
	 * {@link org.sapient.service.ResumeManagementServiceImpl#saveAddressDetail(org.sapient.service.beans.AddressInfoVO)}
	 * .
	 */
	@Test
	public void testSaveAddressDetail() {
		AddressInfoVO addressInfoVO = new AddressInfoVO();
		addressInfoVO.setAddressLine1("Indra Nagar");
		addressInfoVO.setAddressLine2("kadugudi");
		addressInfoVO.setAddressLine3("hudi");
		addressInfoVO
				.setAddressType(org.sapient.commons.types.AddressType.EMPLOYMENT);
		addressInfoVO.setCity("Banglore");
		addressInfoVO.setContactInfoId(new Long(1));
		addressInfoVO.setCountry("india");
		addressInfoVO.setEmploymentInfoId(new Long(1));
		addressInfoVO.setUserId(new Long(1));
		addressInfoVO.setZipCode("444555");
		Long result = resumeManagementService.saveAddressDetail(addressInfoVO);
		assertNotNull(result);
	}

	@Test
	public void testRetrieveEmploymentInformationById() {
		EmploymentInfoVO result = resumeManagementService
				.retrieveEmploymentInformationById(new Long(1));
		assertNotNull(result);
	}
	
	@Test
	public void testRetrieveEducationInformationById() {
		EducationInfoVO result = resumeManagementService
				.retrieveEducationInformationById(new Long(1));
		assertNotNull(result);
	}
	
	@Test
	public void testRetrieveProjectInformationById() {
		ProjectInfoVO result = resumeManagementService
				.retrieveProjectInformationById(new Long(1));
		assertNotNull(result);
	}
	
	@Test
	public void testRetrieveEmployeeSearch(){
		
		List<SearchResultVO> result= resumeManagementService.retrieveEmployeeSearch(83574L,"Prabu","sivakumar","Senior","java",
				"",
				"",
				"",
				"",
				"",
				"",
				"",
				"",
				"",
				"",
				"",
				"",
				""
				);
		System.out.println("**********Show me the:" + result.size());
		System.out.println("**********Show1 me the:" + result);
		assertNotNull(result);
	}
	
}
