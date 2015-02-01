/**
 * 
 */
package org.sapient.hibernate.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sapient.hibernate.entity.PersonalDataInfoEntity;
import org.sapient.hibernate.entity.SearchResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author komar
 * 
 *         Updated By @author spash1
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-resources.xml",
		"/applicationContext-dao.xml" })
public class SearchEmployeeDaoTest {

	private static final Log LOG = LogFactory
			.getLog(SearchEmployeeDaoTest.class);

	@Autowired
	SearchEmployeeDao searchEmployeeDao;

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
	public void testLoadEmployeeSearchBySkill() {

		List<SearchResultEntity> results = searchEmployeeDao
				.loadEmployeeSearchBySkill(new Long(83331),"Pooja","","Associate", "",
						 "",
						 "",
						 "",
						 "",
						 "",
						 "",
						 "",
						 "",
						 "",
						 "",
						 "",
						 "",
						 ""
						 
						
				);
		System.out.println("USERSize: " + results.size());

		assertNotNull(results);
	}

}
