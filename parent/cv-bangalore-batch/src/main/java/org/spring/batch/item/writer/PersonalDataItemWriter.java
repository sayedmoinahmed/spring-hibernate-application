package org.spring.batch.item.writer;

import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sapient.batch.factory.EntityFactory;
import org.sapient.commons.types.EmploymentType;
import org.sapient.commons.types.UserStatus;
import org.sapient.email.Sender;
import org.sapient.hibernate.dao.AllocationInfoDao;
import org.sapient.hibernate.dao.AssignmentInfoDao;
import org.sapient.hibernate.dao.OrganizationInfoDao;
import org.sapient.hibernate.dao.PersonalDataInfoDao;
import org.sapient.hibernate.dao.PersonalInfoDao;
import org.sapient.hibernate.dao.RecognitionTypeDao;
import org.sapient.hibernate.entity.AllocationInfoEntity;
import org.sapient.hibernate.entity.AssignmentInfoEntity;
import org.sapient.hibernate.entity.ContactInfoEntity;
import org.sapient.hibernate.entity.OrganizationInfoEntity;
import org.sapient.hibernate.entity.PersonalDataInfoEntity;
import org.sapient.hibernate.entity.PersonalInfoEntity;
import org.sapient.ldap.domain.User;
import org.sapient.ldap.security.RandomPasswordGenerator;
import org.sapient.ldap.service.LdapProvisionService;
import org.spring.batch.domain.PersonalData;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;

/**
 * @author psiva2
 * 
 */
public class PersonalDataItemWriter implements ItemWriter<PersonalData> {

	private static final String DEFAULT_PASSWORD = "password";

	private static final Log LOG = LogFactory
			.getLog(PersonalDataItemWriter.class);

	@Autowired
	@Qualifier("personalDataInfoDao")
	private PersonalDataInfoDao personalDataInfoDao;

	@Autowired
	@Qualifier("allocationInfoDao")
	private AllocationInfoDao allocationInfoDao ;
	
	@Autowired
	private AssignmentInfoDao assignmentInfoDao;
	
	@Autowired
	@Qualifier("recognitionTypeDao")
	private RecognitionTypeDao recognitionTypeDao;
	
	@Autowired
	private OrganizationInfoDao organizationInfoDao;
	
	@Autowired
	@Qualifier("personalInfoDao")
	private PersonalInfoDao personalInfoDao;
	
	
	@Autowired
	private Sender sender;

	@Resource
	@Qualifier("ldapProvisionService")
	private LdapProvisionService ldapProvisionService;
	
	
	public void write(List<? extends PersonalData> results) throws Exception {
		PersonalDataItemWriter personalDataItemWriter = new PersonalDataItemWriter();
		recognitionTypeDao.getAllRecognitions();
		for (PersonalData personalData : results) {
			PersonalDataInfoEntity entity = new PersonalDataInfoEntity();
			ContactInfoEntity contactInfoEntity = new ContactInfoEntity();

			entity.setOracleId(personalData.getOracleId());
			entity.setFirstName(personalData.getFirstName());
			entity.setMiddleName(personalData.getMiddleName());
			entity.setLastName(personalData.getLastName());
			if (personalData.getPersonType().equals("Contractor"))
				entity.setPersonType(EmploymentType.CONTRACT);
			else
				entity.setPersonType(EmploymentType.PERMANENT);
			entity.setFatherName(personalData.getFatherName());
			entity.setDateOfBirth(personalData.getDateofBirth());
			entity.setLoginId(personalData.getLoginName());
			entity.setDateOfJoining(personalData.getStartDate());
			entity.setCreatedBy(new Long(1));
			entity.setCreatedDate(Calendar.getInstance());
			entity.setDesignation(personalData.getTitleName());
			try {
				entity.setSupervisorId(new Long(personalData.getSupervisorId()));
			} catch (Exception ex) {
				LOG.error("The Exception occured is " + ex.getStackTrace());
			}
			entity.setEmailAddress(personalData.getEmail());
			if (personalData.getTermDate() != null)
				entity.setUserStatus(UserStatus.DELETED);
			else if (!(personalDataInfoDao.exists(entity))
					|| personalDataInfoDao
							.getPersonalDataInfoByOracleId(
									personalData.getOracleId()).getUserStatus()
							.equals(UserStatus.NEW))
				entity.setUserStatus(UserStatus.NEW);
			else if (personalDataInfoDao
					.getPersonalDataInfoByOracleId(personalData.getOracleId())
					.getUserStatus().equals(UserStatus.ACTIVE))
				entity.setUserStatus(UserStatus.ACTIVE);
			
			EntityFactory entityFactory = new EntityFactory();
			
			try{
			PersonalInfoEntity personalInfoEntity = (PersonalInfoEntity) entityFactory.getEntity(personalData, "personalInfoEntity");
			personalInfoDao.savePersonalInfo(personalInfoEntity);
			}
			catch(Exception e)
			{
				LOG.debug(personalData.getLoginName());
				LOG.error("error occurend in personalInfoDao is"+e.getMessage());
			}
			
			try{
			AllocationInfoEntity allocationInfoEntity = (AllocationInfoEntity) entityFactory.getEntity(personalData,"allocationInfoEntity");
			allocationInfoDao.saveAllocationInfo(allocationInfoEntity);
			}
			catch(Exception e)
			{
				LOG.debug(personalData.getLoginName());
				LOG.error("error occurend in allocationInfoDao is"+e.getMessage());
			}
			
			try{
			AssignmentInfoEntity assignmentInfoEntity = (AssignmentInfoEntity)entityFactory.getEntity(personalData, "assignmentInfoEntity");
			assignmentInfoDao.saveAssignmentInfo(assignmentInfoEntity);
			}
			catch(Exception e)
			{
				LOG.debug(personalData.getLoginName());
				LOG.error("error occurend in assignmentInfoDao is"+e.getMessage());
			}
			
			try{
			OrganizationInfoEntity organizationInfoEntity = (OrganizationInfoEntity) entityFactory.getEntity(personalData, "organizationInfoEntity");
			organizationInfoDao.saveOrganizationInfo(organizationInfoEntity);
			}
			catch(Exception e)
			{
				LOG.debug(personalData.getLoginName());
				LOG.error("error occurend in organizationInfoDao is"+e.getMessage());
			}
			
			boolean isUpdate = personalDataInfoDao.save(entity);
			
			if(entity.getUserStatus().equals(UserStatus.DELETED))
			{
				User deleteUser = ldapProvisionService.getUser(entity.getLoginId());
				if(deleteUser!=null)
				ldapProvisionService.delete(deleteUser);
			}
			
			User existedUser = ldapProvisionService.getUser(personalData.getLoginName());
			
			if (existedUser==null && !entity.getUserStatus().equals(UserStatus.DELETED)){
				String password = RandomPasswordGenerator.generatePassword();

				Properties props = new Properties();
				props.put("firstName", personalData.getFirstName());
				props.put("lastName", personalData.getLastName());
				props.put("randomPassword", password);
				SimpleMailMessage msg = new SimpleMailMessage();
				msg.setTo(personalData.getEmail());
				msg.setFrom("npolicharla@sapient.com");
				msg.setSubject("Generated password for ");
				sender.sendWelcomeEmail(msg, props);

				User user = new User();
				user.setFirstName(personalData.getFirstName());
				user.setLastName(personalData.getLastName());
				user.setUserName(personalData.getLoginName());
				user.setEmail(personalData.getEmail());
				user.setPassword(password);
				try {
					ldapProvisionService.save(user);
				} catch (Exception e) {
					LOG.error("The Exception occured is " + e.getStackTrace());
				}
				LOG.info("user details in LDAP"
						+ ldapProvisionService.getUser(personalData
								.getLoginName()) + "Random Password "
						+ password);
			}

		}
	}
}
