package org.sapient.hibernate.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sapient.hibernate.entity.PersonalDataInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-resources.xml",
		"/applicationContext-dao.xml" })
public class PersonalDataInfoDaoTest {

	@Autowired
	@Qualifier("personalDataInfoDao")
	PersonalDataInfoDao personalDataInfoDao;

	@Test
	@Ignore
	public void testGetPersonalDataInfoByOracleId() {
		PersonalDataInfoEntity entity = personalDataInfoDao
				.getPersonalDataInfoByOracleId(new Long(22616));
		assertNotNull(entity);
	}
}
