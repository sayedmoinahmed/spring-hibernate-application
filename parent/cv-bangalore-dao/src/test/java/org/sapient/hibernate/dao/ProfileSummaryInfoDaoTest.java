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
import org.sapient.hibernate.entity.ProfileSummaryInfoEntity;
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
public class ProfileSummaryInfoDaoTest {

	@Autowired
	ProfileSummaryInfoDao profileSummaryInfoDao;

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

	@Test
	public void testLoadProfileSummaryInfoById() {
		ProfileSummaryInfoEntity entity = profileSummaryInfoDao
				.getProfileSummaryInfoById(new Long(1));
		assertNotNull(entity);
	}

	@Test
	public void testSaveProfileSummaryInfo() {
		ProfileSummaryInfoEntity profileSummaryInfoEntity = new ProfileSummaryInfoEntity();
		profileSummaryInfoEntity.setCreatedBy(1l);
		profileSummaryInfoEntity.setCreatedDate(Calendar.getInstance());
		profileSummaryInfoEntity.setTitle("Associate Technology L1");
		profileSummaryInfoEntity
				.setDescription("Bangalore office, Sapient Nitro");
		profileSummaryInfoDao.saveProfileSummaryInfo(profileSummaryInfoEntity);

	}
}
