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
import org.sapient.hibernate.entity.RecognitionInfoEntity;
import org.sapient.hibernate.entity.RecognitionTypeEntity;
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
public class RecognitionInfoDaoTest {

	@Autowired
	private RecognitionInfoDao recognitionInfoDao;

	@Autowired
	private RecognitionTypeDao recognitionTypeDao;

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
	public void testGetAllRecognitionTypes() {
		List<RecognitionTypeEntity> results = recognitionTypeDao
				.getAllRecognitions();
		assertNotNull(results);
	}

	@Test
	public void testLoadRecognitionInfoById() {
		RecognitionInfoEntity entity = recognitionInfoDao
				.getRecognitionInfoById(new Long(1));
		assertNotNull(entity);
	}

	@Test
	public void testSaveRecognitionInfo() {
		RecognitionInfoEntity recognitionInfoEntity = new RecognitionInfoEntity();
		recognitionInfoEntity.setCreatedBy(2l);
		recognitionInfoEntity.setCreatedDate(Calendar.getInstance());
		recognitionInfoEntity.setRecognitionTypeId(new Long(2));
		recognitionInfoEntity.setItems("Zest for Excellence");
		recognitionInfoDao.saveRecognitionInfo(recognitionInfoEntity);
	}
}
