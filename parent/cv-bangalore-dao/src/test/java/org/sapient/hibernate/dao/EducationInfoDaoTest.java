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
import org.sapient.commons.types.CourseName;
import org.sapient.commons.types.CourseType;
import org.sapient.hibernate.entity.EducationInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author komar
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-resources.xml",
		"/applicationContext-dao.xml" })
public class EducationInfoDaoTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Autowired
	private EducationInfoDao educationInfoDao;

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
	public void testGetEducationInfoById() {
		EducationInfoEntity entity = educationInfoDao
				.getEducationInfoById(new Long(1));
		assertNotNull(entity);
	}

	@Test
	public void testSaveEducationInfo() {
		EducationInfoEntity educationInfoEntity = new EducationInfoEntity();
		educationInfoEntity.setCourseType(CourseType.POSTGRADUATION);
		educationInfoEntity.setCourseName(CourseName.BSC);
		educationInfoEntity.setSpecialization("Computer Application");
		educationInfoEntity.setUniversity("UP Technical University");
		educationInfoEntity.setYearofJoining(Calendar.getInstance());
		educationInfoEntity.setYearOfPassing(Calendar.getInstance());
		educationInfoEntity.setAggregate(85.0);
		educationInfoEntity.setCreatedBy(new Long(1));
		educationInfoEntity.setCreatedDate(Calendar.getInstance());
		educationInfoEntity.setUpdatedBy(new Long(1));
		educationInfoEntity.setUpdatedDate(Calendar.getInstance());
		educationInfoDao.saveEducationInfo(educationInfoEntity);
	}
}
