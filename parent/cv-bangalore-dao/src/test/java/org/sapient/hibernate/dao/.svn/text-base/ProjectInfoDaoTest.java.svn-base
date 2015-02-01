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
import org.sapient.hibernate.entity.ProjectInfoEntity;
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
public class ProjectInfoDaoTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Autowired
	@Qualifier("projectInfoDao")
	private ProjectInfoDao projectInfoDao;

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
	public void testLoadProjectInfoById() {
		ProjectInfoEntity entity = projectInfoDao
				.getProjectInfoById(new Long(1));
		assertNotNull(entity);
	}

	@Test
	public void testSaveProjectInfo() {
		ProjectInfoEntity projectInfoEntity = new ProjectInfoEntity();
		projectInfoEntity.setTitle("MetLife");
		projectInfoEntity.setDescription("eUnderwriting");
		projectInfoEntity.setStartDate(Calendar.getInstance());
		projectInfoEntity.setEndDate(Calendar.getInstance());
		projectInfoEntity.setClient("METLIFE");
		projectInfoEntity.setSize(12);
		projectInfoEntity.setRole("Software Engineer");
		projectInfoEntity.setResponsibilities("Developement");
		projectInfoEntity.setTechnologies("Java, J2EE, Struts, Hibernate, Spring");
		projectInfoEntity.setCreatedBy(1l);
		projectInfoEntity.setCreatedDate(Calendar.getInstance());
		projectInfoEntity.setUpdatedBy(1l);
		projectInfoEntity.setUpdatedDate(Calendar.getInstance());
		projectInfoDao.saveProjectInfo(projectInfoEntity);
	}

}
