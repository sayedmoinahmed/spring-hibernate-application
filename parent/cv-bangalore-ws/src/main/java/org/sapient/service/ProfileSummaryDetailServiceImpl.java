package org.sapient.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.DozerBeanMapper;
import org.sapient.hibernate.dao.ProfileSummaryInfoDao;
import org.sapient.hibernate.dao.UserInfoDao;
import org.sapient.hibernate.entity.ProfileSummaryInfoEntity;
import org.sapient.service.beans.ProfileSummaryInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("profileSummaryDetailService")
public class ProfileSummaryDetailServiceImpl implements
		ProfileSummaryDetailService {

	private static final Log LOG = LogFactory
			.getLog(ProfileSummaryDetailServiceImpl.class);

	@Autowired
	@Qualifier("profileSummaryInfoDao")
	private ProfileSummaryInfoDao profileSummaryInfoDao;

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
	public Long saveProfileSummaryDetail(
			ProfileSummaryInfoVO profileSummaryInfoVO) {
		ProfileSummaryInfoEntity profileSummaryInfoEntity = dozerBeanMapper
				.map(profileSummaryInfoVO, ProfileSummaryInfoEntity.class);
		LOG.info(String.format(
				"Saving the ProfileSummaryInfoEntity with the Values [%s]",
				profileSummaryInfoEntity));
		if (profileSummaryInfoVO.getProfileSummaryId() == null) {
			profileSummaryInfoEntity.setCreatedBy(profileSummaryInfoVO
					.getUserId());
			profileSummaryInfoEntity.setCreatedDate(Calendar.getInstance());
		} else {
			profileSummaryInfoEntity.setId(profileSummaryInfoVO
					.getProfileSummaryId());
			profileSummaryInfoEntity.setUpdatedBy(profileSummaryInfoVO
					.getUserId());
			profileSummaryInfoEntity.setUpdatedDate(Calendar.getInstance());
		}

		profileSummaryInfoDao.saveProfileSummaryInfo(profileSummaryInfoEntity);

		if (LOG.isDebugEnabled()) {
			LOG.debug(String.format(
					"The ProfileSummaryInfoEntity is saved with the Id [%s]",
					profileSummaryInfoEntity.getId()));
		}
		userInfoDao.addProfileSummaryDetail(profileSummaryInfoVO.getUserId(),
				profileSummaryInfoEntity);
		return profileSummaryInfoEntity.getId();
	}

	public List<ProfileSummaryInfoVO> retrieveProfileSummaryDetailByUserId(
			Long userId) {
		Set<ProfileSummaryInfoEntity> results = userInfoDao
				.getProfileSummaryDetailsByUserId(userId);
		List<ProfileSummaryInfoVO> profileSummaryDetails = null;
		if (results != null && results.size() > 0) {
			profileSummaryDetails = new ArrayList<ProfileSummaryInfoVO>();
			for (ProfileSummaryInfoEntity entity : results) {
				ProfileSummaryInfoVO profileInfoVO = dozerBeanMapper.map(
						entity, ProfileSummaryInfoVO.class);
				profileSummaryDetails.add(profileInfoVO);
			}
		}
		return profileSummaryDetails;
	}
}
