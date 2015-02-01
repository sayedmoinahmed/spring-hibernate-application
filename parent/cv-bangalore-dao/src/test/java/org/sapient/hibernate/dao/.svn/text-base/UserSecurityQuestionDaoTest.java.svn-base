package org.sapient.hibernate.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sapient.hibernate.entity.SecurityQuestionEntity;
import org.sapient.hibernate.entity.UserSecurityQuestionEntity;
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
public class UserSecurityQuestionDaoTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Autowired
	private UserSecurityQuestionDao userSecurityQuestionDao;

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
	public void testGetUserSecurityQuestionById() {
		UserSecurityQuestionEntity results = userSecurityQuestionDao
				.getUserSecurityQuestionById(new Long(1));
		assertNotNull(results);
	}

	@Test
	public void testGetUserSecurityQuestionByUserId() {
		UserSecurityQuestionEntity results = userSecurityQuestionDao
				.getUserSecurityQuestionByUserId(new Long(1));
		assertNotNull(results);
	}
}