package org.sapient.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.DozerBeanMapper;
import org.sapient.hibernate.dao.EducationInfoDao;
import org.sapient.hibernate.dao.UserInfoDao;
import org.sapient.hibernate.entity.EducationInfoEntity;
import org.sapient.service.beans.EducationInfoVO;
import org.sapient.service.beans.comparator.EducationComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("educationDetailService")
public class EducationDetailServiceImpl implements EducationDetailService {

	private static final Log LOG = LogFactory
			.getLog(EducationDetailServiceImpl.class);

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	/*
	 * This is required to persist the Education Information on education_info
	 * table
	 */
	@Autowired
	@Qualifier("educationInfoDao")
	private EducationInfoDao educationInfoDao;

	/*
	 * This is required to persist the User Education Information on
	 * user_education table
	 */
	@Autowired
	@Qualifier("userInfoDao")
	private UserInfoDao userInfoDao;

	@Transactional
	public Long saveEducationDetail(EducationInfoVO educationInfoVO) {
		EducationInfoEntity educationInfoEntity = dozerBeanMapper.map(
				educationInfoVO, EducationInfoEntity.class);
		LOG.info(String.format(
				"Saving the EducationInfoEntity with the Values [%s]",
				educationInfoEntity));
		if (educationInfoVO.getEducationInfoId() == null) {
			educationInfoEntity.setCreatedBy(educationInfoVO.getUserId());
			educationInfoEntity.setCreatedDate(Calendar.getInstance());
		} else {
			educationInfoEntity.setId(educationInfoVO.getEducationInfoId());
			educationInfoEntity.setUpdatedBy(educationInfoVO.getUserId());
			educationInfoEntity.setUpdatedDate(Calendar.getInstance());
		}

		educationInfoDao.saveEducationInfo(educationInfoEntity);

		if (LOG.isDebugEnabled()) {
			LOG.debug(String.format(
					"The EducationInfoEntity is saved with the Id [%s]",
					educationInfoEntity.getId()));
		}
		userInfoDao.addEducationDetail(educationInfoVO.getUserId(),
				educationInfoEntity);
		return educationInfoEntity.getId();
	}

	public List<EducationInfoVO> retrieveEducationDetailByUserId(Long userId) {
		Set<EducationInfoEntity> results = userInfoDao
				.getEducationDetailsByUserId(userId);
		List<EducationInfoVO> educationDetails = null;
		if (results != null && results.size() > 0) {
			educationDetails = new ArrayList<EducationInfoVO>();
			for (EducationInfoEntity entity : results) {
				EducationInfoVO educationInfo = dozerBeanMapper.map(entity,
						EducationInfoVO.class);
				educationDetails.add(educationInfo);
			}
			 Collections.sort(educationDetails, new EducationComparator());
		}
		
		return educationDetails;
	}

	public EducationInfoVO retrieveEducationInformationById(Long educationInfoId) {
		EducationInfoEntity entity = educationInfoDao
				.getEducationInfoById(educationInfoId);
		EducationInfoVO educationInfo = dozerBeanMapper.map(entity,
				EducationInfoVO.class);
		return educationInfo;
	}

	public void removeEducationDetail(Long userId, Long educationInfoId) {
		userInfoDao.removeEducationDetail(userId, educationInfoId);
	}

}