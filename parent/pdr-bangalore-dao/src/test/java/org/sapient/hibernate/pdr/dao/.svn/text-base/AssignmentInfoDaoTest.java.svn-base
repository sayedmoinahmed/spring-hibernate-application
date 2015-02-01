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
import org.sapient.hibernate.pdr.entity.AssignmentInfoEntity;
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
public class AssignmentInfoDaoTest {
	@Autowired
	@Qualifier("assignmentInfoDao")
	private AssignmentInfoDao assignmentInfoDao;

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
	public void testSaveAssignmentInfo() {
		AssignmentInfoEntity assignmentInfoEntity = new AssignmentInfoEntity();
		assignmentInfoEntity.setCareerStage("Associate");
		assignmentInfoEntity.setCm("");
		assignmentInfoEntity.setCmBu("");
		assignmentInfoEntity.setCmId("");
		assignmentInfoEntity.setCmTitle("");
		assignmentInfoEntity.setLastPromotionDate("");
		assignmentInfoEntity.setOracleId(new Long(45688));
		assignmentInfoEntity.setRelocationFlag("Y");
		assignmentInfoEntity.setStaiFlag("");
		assignmentInfoEntity.setStatus("Active");
		assignmentInfoEntity.setSupervisor("shalabh");
		assignmentInfoEntity.setSupervisorId("35685");
		assignmentInfoEntity.setTimeSinceLastPromotion("");
		assignmentInfoEntity.setTitleName("Developer");
		assignmentInfoDao.saveAssignmentInfo(assignmentInfoEntity);
	}

	@Test
	public void testLoadAssignmentInfoByOracleId() {
		List<AssignmentInfoEntity> results = assignmentInfoDao
				.loadAssignmentInfoByOracleId(new Long(1));
		assertNotNull(results);
	}

}
