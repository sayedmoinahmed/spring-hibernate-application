/**
 * 
 */
package org.sapient.hibernate.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sapient.commons.types.ProficiencyLevelType;
import org.sapient.hibernate.entity.SkillsInfoEntity;
import org.sapient.hibernate.entity.SkillsTypeEntity;
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
public class SkillsInfoDaoTest {

	@Autowired
	private SkillsInfoDao skillsInfoDao;

	@Autowired
	private SkillsTypeDao skillsTypeDao;

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
	public void testGetAllSkillTypes() {
		List<SkillsTypeEntity> results = skillsTypeDao.getAllSkillTypes();
		assertNotNull(results);
	}

	@Test
	public void testSaveSkillsInfo() {
		SkillsInfoEntity skillsInfoEntity = new SkillsInfoEntity();
		skillsInfoEntity.setSkillTypeId(new Long(1));
		skillsInfoEntity.setItems("Java");
		skillsInfoEntity.setCreatedBy(new Long(1));
		skillsInfoEntity.setCreatedDate(Calendar.getInstance());
		skillsInfoEntity.setProficienyLevel(ProficiencyLevelType.BEGINNER);
		skillsInfoDao.saveSkillsInfo(skillsInfoEntity);

	}

	@Test
	public void testLoadSkillsInfoById() {
		SkillsInfoEntity entity = skillsInfoDao.getSkillsInfoById(new Long(1));
		assertNotNull(entity);

	}
}
