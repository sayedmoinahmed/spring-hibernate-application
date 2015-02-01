/**
 * 
 */
package org.sapient.hibernate.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sapient.commons.types.EmploymentType;
import org.sapient.hibernate.entity.EmploymentInfoEntity;
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
public class EmploymentInfoDaoTest {

	private static final Calendar CALENDAR_INSTANCE = Calendar.getInstance();

	@Autowired
	EmploymentInfoDao employmentInfoDao;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.sapient.hibernate.dao.impl.EmploymentInfoDaoImpl#saveEmploymentInfo(org.sapient.hibernate.entity.EmploymentInfoEntity)}
	 * .
	 */
	@Test
	public void testSaveEmploymentInfo() {
		EmploymentInfoEntity employmentInfoEntity = new EmploymentInfoEntity();
		employmentInfoEntity.setCreatedBy(new Long(1));
		employmentInfoEntity.setCreatedDate(CALENDAR_INSTANCE);
		employmentInfoEntity.setEmployerName("Sapient");
		employmentInfoEntity.setEmploymentType(EmploymentType.PERMANENT);
		employmentInfoEntity.setDateOfJoining(CALENDAR_INSTANCE);
		employmentInfoEntity.setDateOfRelieving(CALENDAR_INSTANCE);
		employmentInfoEntity.setDesignation("Associate Technology L1");
		employmentInfoEntity.setSupervisorName("Shalabh Bhatnagar");
		employmentInfoDao.saveEmploymentInfo(employmentInfoEntity);
	}

	/**
	 * Test method for
	 * {@link org.sapient.hibernate.dao.impl.EmploymentInfoDaoImpl#loadEmploymentInfoById(java.lang.Long)}
	 * .
	 */
	@Test
	public void testLoadEmploymentInfoById() {
		EmploymentInfoEntity entity = employmentInfoDao
				.getEmploymentInfoById(new Long(1));
		assertNotNull(entity);
	}

}
