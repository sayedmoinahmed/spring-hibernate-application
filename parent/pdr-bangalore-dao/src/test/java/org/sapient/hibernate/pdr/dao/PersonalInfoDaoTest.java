/**
 * 
 */
package org.sapient.hibernate.pdr.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sapient.hibernate.pdr.entity.PersonalInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author komar
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-resources.xml",
		"/applicationContext-dao.xml" })
public class PersonalInfoDaoTest {

	@Autowired
	@Qualifier("personalInfoDao")
	private PersonalInfoDao personalInfoDao;

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSavePersonalInfo() {
		PersonalInfoEntity personalInfoEntity = new PersonalInfoEntity();
		personalInfoEntity.setAddressLine1("");
		personalInfoEntity.setAddressLine2("");
		personalInfoEntity.setAddressLine3("");
		personalInfoEntity.setCity("");
		personalInfoEntity.setCountry("");
		personalInfoEntity.setCounty("");
		personalInfoEntity.setDateOfBirth("");
		personalInfoEntity.setEmailAddress("");
		personalInfoEntity.setFatherName("");
		personalInfoEntity.setGender("");
		personalInfoEntity.setHomePhone("");
		personalInfoEntity.setLastCompetencyUpdate("");
		personalInfoEntity.setLoginId("");
		personalInfoEntity.setMaritalStatus("");
		personalInfoEntity.setNationality("");
		personalInfoEntity.setOracleId(new Long(63457));
		personalInfoEntity.setPostalCode("");
		personalInfoEntity.setState("");
		personalInfoDao.savePersonalInfo(personalInfoEntity);
	}

	@Test
	public void testLoadPersonalInfoByOracleId() {
		List<PersonalInfoEntity> results = personalInfoDao
				.loadPersonalInfoByOracleId(new Long(32462));
		assertNotNull(results);
	}

}
