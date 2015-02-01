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
import org.sapient.hibernate.pdr.entity.OrganizationInfoEntity;
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
public class OrganizationInfoDaoTest {
	@Autowired
	@Qualifier("organizationInfoDao")
	private OrganizationInfoDao organizationInfoDao;

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
	public void testSaveOrganizationInfo() {
		OrganizationInfoEntity organizationInfoEntity = new OrganizationInfoEntity();
		organizationInfoEntity.setBusinessFocus("Marketing Services");
		organizationInfoEntity.setBusinessUnit("NA");
		organizationInfoEntity.setCapacityType("");
		organizationInfoEntity.setCategory("");
		organizationInfoEntity.setCompany("");
		organizationInfoEntity.setCostCenterCode("");
		organizationInfoEntity.setCostCenterName("");
		organizationInfoEntity.setCurrentOffice("");
		organizationInfoEntity.setCurrentRegion("");
		organizationInfoEntity.setDivision("");
		organizationInfoEntity.setFirstName("");
		organizationInfoEntity.setHomeOffice("");
		organizationInfoEntity.setHomeRegion("");
		organizationInfoEntity.setHrmsTeam("");
		organizationInfoEntity.setLastName("");
		organizationInfoEntity.setLoaReturnflag("");
		organizationInfoEntity.setMiddleName("");
		organizationInfoEntity.setOracleId(new Long(72345));
		organizationInfoEntity.setOrganization("");
		organizationInfoEntity.setPersonType("");
		organizationInfoEntity.setPrimaryCapability("");
		organizationInfoEntity.setProfitTarget("");
		organizationInfoEntity.setRevenueTarget("");
		organizationInfoEntity.setStartDate("");
		organizationInfoEntity.setTerminationDate("");
		organizationInfoEntity.setUtilizationTarget("");
		organizationInfoDao.saveOrganizationInfo(organizationInfoEntity);
	}

	@Test
	public void testLoadOrganizationInfoByOracleId() {
		List<OrganizationInfoEntity> results = organizationInfoDao
				.loadOrganizationInfoByOracleId(new Long(32462));
		assertNotNull(results);
	}

}
