/**
 * 
 */
package org.sapient.service;

import java.util.Calendar;

import org.dozer.DozerBeanMapper;
import org.sapient.hibernate.dao.UserSecurityQuestionDao;
import org.sapient.hibernate.entity.UserSecurityQuestionEntity;
import org.sapient.service.beans.UserSecurityQuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author psiva2
 * 
 */
@Service("userSecurityQuestionService")
public class UserSecurityQuestionServiceImpl implements
		UserSecurityQuestionService {

	@Autowired
	private UserSecurityQuestionDao userSecurityQuestionDao;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.service.UserSecurityQuestionService#saveUserSecurityQuestion
	 * (org.sapient.service.beans.UserSecurityQuestionVO)
	 */
	@Override
	public Long saveUserSecurityQuestion(
			UserSecurityQuestionVO userSecurityQuestionVO) {
		UserSecurityQuestionEntity userSecurityQuestionEntity = dozerBeanMapper
				.map(userSecurityQuestionVO, UserSecurityQuestionEntity.class);
		if (userSecurityQuestionEntity.getId() == null) {
			userSecurityQuestionEntity.setCreatedBy(userSecurityQuestionVO
					.getUserId());
			userSecurityQuestionEntity.setCreatedDate(Calendar.getInstance());
		} else {
			userSecurityQuestionEntity.setId(userSecurityQuestionVO.getId());
			userSecurityQuestionEntity.setUpdatedBy(userSecurityQuestionVO
					.getUserId());
			userSecurityQuestionEntity.setUpdatedDate(Calendar.getInstance());
		}

		userSecurityQuestionDao
				.saveUserSecurityQuestion(userSecurityQuestionEntity);
		return userSecurityQuestionEntity.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sapient.service.UserSecurityQuestionService#
	 * retrieveUserSecurityQuestionByUserId(java.lang.Long)
	 */
	@Override
	public UserSecurityQuestionVO retrieveUserSecurityQuestionByUserId(
			Long userId) {
		UserSecurityQuestionEntity userSecurityQuestionEntity = userSecurityQuestionDao
				.getUserSecurityQuestionByUserId(userId);
		UserSecurityQuestionVO userSecurityQuestionVO = null;
		if (userSecurityQuestionEntity != null) {
			userSecurityQuestionVO = dozerBeanMapper.map(
					userSecurityQuestionEntity, UserSecurityQuestionVO.class);
			userSecurityQuestionVO.setDescription(userSecurityQuestionEntity
					.getSecurityQuestionEntity().getSecurityQuestion());
		}
		return userSecurityQuestionVO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sapient.service.UserSecurityQuestionService#
	 * retrieveUserSecurityQuestionById(java.lang.Long)
	 */
	@Override
	public UserSecurityQuestionVO retrieveUserSecurityQuestionById(Long id) {
		UserSecurityQuestionEntity userSecurityQuestionEntity = userSecurityQuestionDao
				.getUserSecurityQuestionById(id);
		UserSecurityQuestionVO userSecurityQuestionVO = dozerBeanMapper.map(
				userSecurityQuestionEntity, UserSecurityQuestionVO.class);
		return userSecurityQuestionVO;
	}
}