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
import org.sapient.hibernate.dao.SkillsInfoDao;
import org.sapient.hibernate.dao.SkillsTypeDao;
import org.sapient.hibernate.dao.UserInfoDao;
import org.sapient.hibernate.entity.SkillsInfoEntity;
import org.sapient.hibernate.entity.SkillsTypeEntity;
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
@Service("skillsDetailService")
public class SkillsDetailServiceImpl implements SkillsDetailService {
	private static final Log LOG = LogFactory
			.getLog(SkillsDetailServiceImpl.class);

	@Autowired
	@Qualifier("skillsInfoDao")
	private SkillsInfoDao skillsInfoDao;

	@Autowired
	@Qualifier("skillsTypeDao")
	private SkillsTypeDao skillsTypeDao;

	@Autowired
	@Qualifier("userInfoDao")
	private UserInfoDao userInfoDao;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Transactional
	public Long saveSkillsDetail(SkillsInfoVO skillsInfoVO) {
		SkillsInfoEntity skillsInfoEntity = dozerBeanMapper.map(skillsInfoVO,
				SkillsInfoEntity.class);
		LOG.info(String.format(
				"Saving the SkillsInfoEntity with the Values [%s]",
				skillsInfoEntity));
		SkillsTypeEntity skillsTypeEntity = dozerBeanMapper.map(
				skillsInfoVO.getSkillsType(), SkillsTypeEntity.class);
		skillsInfoEntity.setSkillTypeId(skillsTypeEntity.getId());
		if (skillsInfoVO.getSkillsInfoId() == null) {
			skillsInfoEntity.setCreatedBy(skillsInfoVO.getUserId());
			skillsInfoEntity.setCreatedDate(Calendar.getInstance());
		} else {
			skillsInfoEntity.setUpdatedBy(skillsInfoVO.getUserId());
			skillsInfoEntity.setUpdatedDate(Calendar.getInstance());
		}
		skillsInfoDao.saveSkillsInfo(skillsInfoEntity);

		if (LOG.isDebugEnabled()) {
			LOG.debug(String.format(
					"The SkillsInfoEntity is saved with the Id [%s]",
					skillsInfoEntity.getId()));
		}
		userInfoDao.addSkillSet(skillsInfoVO.getUserId(), skillsInfoEntity);
		return skillsInfoEntity.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sapient.service.SkillsDetailService#retrieveProjectInfoByUserId(
	 * java.lang.Long)
	 */
	public List<SkillsInfoVO> retrieveSkillsDetailByUserId(Long userId) {
		Set<SkillsInfoEntity> results = userInfoDao
				.getSkillSetsByUserId(userId);
		List<SkillsInfoVO> skillsDetails = null;
		if (results != null && results.size() > 0) {
			skillsDetails = new ArrayList<SkillsInfoVO>();
			for (SkillsInfoEntity entity : results) {
				SkillsInfoVO skillsInfoVO = dozerBeanMapper.map(entity,
						SkillsInfoVO.class);
				if (entity.getSkillsType() != null) {
					SkillsTypeVO skillsTypeVO = dozerBeanMapper.map(
							entity.getSkillsType(), SkillsTypeVO.class);
					skillsInfoVO.setSkillsType(skillsTypeVO);
				}
				skillsDetails.add(skillsInfoVO);
			}
		}
		return skillsDetails;
	}

	public SkillsInfoVO retrieveSkillsDetailById(Long id) {
		SkillsInfoEntity entity = skillsInfoDao.getSkillsInfoById(id);
		SkillsInfoVO skillsInfoVO = dozerBeanMapper.map(entity,
				SkillsInfoVO.class);
		if (entity.getSkillsType() != null) {
			SkillsTypeVO skillsTypeVO = dozerBeanMapper.map(
					entity.getSkillsType(), SkillsTypeVO.class);
			skillsInfoVO.setSkillsType(skillsTypeVO);
		}
		return skillsInfoVO;
	}

	public List<SkillsTypeVO> retrieveAllSkillTypes() {
		List<SkillsTypeEntity> entities = skillsTypeDao.getAllSkillTypes();
		List<SkillsTypeVO> results = new ArrayList<SkillsTypeVO>();
		for (SkillsTypeEntity entity : entities) {
			SkillsTypeVO skillsTypeVO = dozerBeanMapper.map(entity,
					SkillsTypeVO.class);
			results.add(skillsTypeVO);
		}
		return results;
	}

	public void removeSkillSet(Long userId, Long skillsInfoId) {
		userInfoDao.removeSkillSet(userId, skillsInfoId);
	}
}