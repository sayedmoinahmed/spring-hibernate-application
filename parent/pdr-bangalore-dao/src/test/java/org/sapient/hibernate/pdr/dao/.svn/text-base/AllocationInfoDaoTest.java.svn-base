/**
 * 
 */
package org.sapient.hibernate.pdr.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sapient.hibernate.pdr.entity.AllocationInfoEntity;
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
public class AllocationInfoDaoTest {

	/**
	 * @throws java.lang.Exception
	 */

	@Autowired
	@Qualifier("allocationInfoDao")
	private AllocationInfoDao allocationInfoDao;

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
	public void testSaveAllocationInfo() {
		AllocationInfoEntity allocationInfoEntity = new AllocationInfoEntity();
		allocationInfoEntity.setAllocationEndDate("4 jan 2011");
		allocationInfoEntity.setAllocationStartDate("1 mar 2011");
		allocationInfoEntity.setClientName("SAA");
		allocationInfoEntity.setCommitment("100%");
		allocationInfoEntity.setDomain("Technology");
		allocationInfoEntity.setOracleId(new Long(454535));
		allocationInfoEntity.setPrimaryProjectCapability("Other Technology");
		allocationInfoEntity.setProjectId("62760");
		allocationInfoEntity.setProjectName("Singapore");
		allocationInfoEntity.setRevenueGroup("Tech&BC");
		allocationInfoEntity.setRevenueSubCategory("revenueSubCategory");
		allocationInfoEntity.setTeamName("SAA");
		allocationInfoDao.saveAllocationInfo(allocationInfoEntity);
	}

	@Test
	public void testLoadAllocationInfoByOracleId() {
		List<AllocationInfoEntity> results = allocationInfoDao
				.loadAllocationInfoByOracleId(new Long(454535));
		assertNotNull(results);
	}

}
