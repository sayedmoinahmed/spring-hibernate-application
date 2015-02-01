package org.sapient.hibernate.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sapient.hibernate.entity.ContactInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author pdandi
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-resources.xml",
		"/applicationContext-dao.xml" })
public class ContactInfoDaoTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Autowired
	private ContactInfoDao contactInfoDao;

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
	public void testsaveContactInfo() {
		ContactInfoEntity contactInfoEntity = new ContactInfoEntity();
		contactInfoEntity.setCreatedBy(new Long(1));
		contactInfoEntity.setCreatedDate(Calendar.getInstance());
		contactInfoEntity.setUpdatedBy(new Long(1));
		contactInfoEntity.setUpdatedDate(Calendar.getInstance());
		contactInfoEntity.setPrimaryEmail("pdandi@sapient.com");
		contactInfoEntity.setSecondaryEmail("pdandi@gmail.com");
		contactInfoEntity.setMobileNumber("9999988888");
		contactInfoEntity.setOfficeNumber("08041047000");
		contactInfoEntity.setExtension("54565");
		contactInfoEntity.setEmergency(true);
		contactInfoDao.saveContactInfo(contactInfoEntity);
	}

	@Test
	public void testGetContactInfoById() {
		ContactInfoEntity entity = contactInfoDao
				.getContactInfoById(new Long(1));
		assertNotNull(entity);
	}
}
