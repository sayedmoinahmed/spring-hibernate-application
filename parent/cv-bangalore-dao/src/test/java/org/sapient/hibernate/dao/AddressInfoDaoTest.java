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
import org.sapient.commons.types.AddressType;
import org.sapient.hibernate.entity.AddressInfoEntity;
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
public class AddressInfoDaoTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Autowired
	private AddressInfoDao addressInfoDao;

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
	public void testSaveAddressInfo() {
		AddressInfoEntity addressInfoEntity = new AddressInfoEntity();
		addressInfoEntity.setAddressLine1("Salarpuria Tech Park");
		addressInfoEntity.setAddressLine2("137 White Field Main Road");
		addressInfoEntity.setAddressLine3("Whitefield");
		addressInfoEntity.setAddressType(AddressType.EMPLOYMENT);
		addressInfoEntity.setCity("Bangalore");
		addressInfoEntity.setCountry("India");
		addressInfoEntity.setZipCode("560066");
		addressInfoEntity.setCreatedBy(new Long(2));
		addressInfoEntity.setCreatedDate(Calendar.getInstance());
		addressInfoEntity.setUpdatedBy(new Long(2));
		addressInfoEntity.setUpdatedDate(Calendar.getInstance());
		addressInfoDao.saveAddressInfo(addressInfoEntity);
	}

	@Test
	public void testLoadAddressInfoById() {
		AddressInfoEntity entity = addressInfoDao
				.getAddressInfoById(new Long(1));
		assertNotNull(entity);
	}
}
