/**
 * 
 */
package org.sapient.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.DozerBeanMapper;
import org.sapient.hibernate.dao.RecognitionInfoDao;
import org.sapient.hibernate.dao.RecognitionTypeDao;
import org.sapient.hibernate.dao.UserInfoDao;
import org.sapient.hibernate.entity.RecognitionInfoEntity;
import org.sapient.hibernate.entity.RecognitionTypeEntity;
import org.sapient.hibernate.entity.SkillsInfoEntity;
import org.sapient.hibernate.entity.SkillsTypeEntity;
import org.sapient.service.beans.RecognitionInfoVO;
import org.sapient.service.beans.RecognitionTypeVO;
import org.sapient.service.beans.SkillsInfoVO;
import org.sapient.service.beans.SkillsTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author brout
 * 
 */
@Service("recognitionDetailService")
public class RecognitionDetailServiceImpl implements RecognitionDetailService {

	private static final Log LOG = LogFactory
			.getLog(RecognitionDetailServiceImpl.class);

	@Autowired
	@Qualifier("recognitionInfoDao")
	private RecognitionInfoDao recognitionInfoDao;

	@Autowired
	@Qualifier("recognitionTypeDao")
	private RecognitionTypeDao recognitionTypeDao;

	@Autowired
	@Qualifier("userInfoDao")
	private UserInfoDao userInfoDao;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.service.ProjectDetailService#saveProjectDetails(org.sapient
	 * .service.beans.ProjectInfoVO)
	 */
	@Transactional
	public Long saveRecognitionDetails(RecognitionInfoVO recognitionInfoVO) {
		RecognitionInfoEntity recognitionInfoEntity = dozerBeanMapper.map(
				recognitionInfoVO, RecognitionInfoEntity.class);
		LOG.info(String.format(
				"Saving the RecognitionInfoEntity with the Values [%s]",
				recognitionInfoEntity));
		RecognitionTypeEntity recognitionTypeEntity = dozerBeanMapper.map(
				recognitionInfoVO.getRecognitionType(),
				RecognitionTypeEntity.class);
		recognitionInfoEntity.setRecognitionTypeId(recognitionTypeEntity
				.getId());
		if (recognitionInfoVO.getRecognitionInfoId() == null) {
			recognitionInfoEntity.setCreatedBy(recognitionInfoVO.getUserId());
			recognitionInfoEntity.setCreatedDate(Calendar.getInstance());
		} else {
			recognitionInfoEntity.setUpdatedBy(recognitionInfoVO.getUserId());
			recognitionInfoEntity.setUpdatedDate(Calendar.getInstance());
		}
		recognitionInfoDao.saveRecognitionInfo(recognitionInfoEntity);

		if (LOG.isDebugEnabled()) {
			LOG.debug(String.format(
					"The RecognitionInfoEntity is saved with the Id [%s]",
					recognitionInfoEntity.getId()));
		}

		userInfoDao.addRecognitionDetail(recognitionInfoVO.getUserId(),
				recognitionInfoEntity);
		return recognitionInfoEntity.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.service.ProjectDetailService#retrieveProjectInfoByUserId(
	 * java.lang.Long)
	 */
	public List<RecognitionInfoVO> retrieveRecognitionDetailByUserId(Long userId) {
		Set<RecognitionInfoEntity> results = userInfoDao
				.getRecognitionDetailsByUserId(userId);
		List<RecognitionInfoVO> recognitionDetails = null;
		if (results != null && results.size() > 0) {
			recognitionDetails = new ArrayList<RecognitionInfoVO>();
			for (RecognitionInfoEntity entity : results) {
				RecognitionInfoVO recognitionInfoVO = dozerBeanMapper.map(
						entity, RecognitionInfoVO.class);
				if (entity.getRecognitionType() != null) {
					RecognitionTypeVO recognitionTypeVO = dozerBeanMapper.map(
							entity.getRecognitionType(),
							RecognitionTypeVO.class);
					recognitionInfoVO.setRecognitionType(recognitionTypeVO);
				}
				recognitionDetails.add(recognitionInfoVO);
			}
		}
		return recognitionDetails;
	}

	@Override
	public RecognitionInfoVO retrieveRecognitionDetailById(Long id) {
		RecognitionInfoEntity entity = recognitionInfoDao
				.getRecognitionInfoById(id);
		RecognitionInfoVO recognitionInfoVO = dozerBeanMapper.map(entity,
				RecognitionInfoVO.class);
		if (entity.getRecognitionType() != null) {
			RecognitionTypeVO recognitionTypeVO = dozerBeanMapper.map(
					entity.getRecognitionType(), RecognitionTypeVO.class);
			recognitionInfoVO.setRecognitionType(recognitionTypeVO);
		}
		return recognitionInfoVO;
	}

	public List<RecognitionTypeVO> retrieveAllRecognitions() {
		List<RecognitionTypeEntity> entities = recognitionTypeDao
				.getAllRecognitions();
		List<RecognitionTypeVO> results = new ArrayList<RecognitionTypeVO>();
		for (RecognitionTypeEntity entity : entities) {
			RecognitionTypeVO recognitionTypeVO = dozerBeanMapper.map(entity,
					RecognitionTypeVO.class);
			results.add(recognitionTypeVO);
		}
		return results;
	}
	public void removeRecognitionDetail(Long userId, Long recognitionInfoId){
		userInfoDao.removeRecognitionDetail(userId, recognitionInfoId);
	}

}
