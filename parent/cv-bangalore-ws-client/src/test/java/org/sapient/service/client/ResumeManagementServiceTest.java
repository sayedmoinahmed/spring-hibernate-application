package org.sapient.service.client;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author psiva2
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:applicationContext-ws-client.xml",
		"classpath:applicationContext-ws-client-resources.xml" })
public class ResumeManagementServiceTest {

	@Resource
	@Qualifier("resumeManagementService")
	ResumeManagementService resumeManagementService;

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
	public void testRetrieveUserInfoByLoginName() {
		List results = resumeManagementService
				.retrieveEmployeeSearch(83356L,"kirti","omar","Associate","spring","","","","","","","","","","","","","");
		assertNotNull(results);
	}

}
