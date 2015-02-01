package org.sapient.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.DozerBeanMapper;
import org.sapient.hibernate.dao.ProjectInfoDao;
import org.sapient.hibernate.dao.UserInfoDao;
import org.sapient.hibernate.entity.ProjectInfoEntity;
import org.sapient.service.beans.ProjectInfoVO;
import org.sapient.service.beans.comparator.ProjectComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author psiva2
 * 
 */
@Service("projectDetailService")
public class ProjectDetailServiceImpl implements ProjectDetailService {

	private static final Log LOG = LogFactory
			.getLog(ProjectDetailServiceImpl.class);

	@Autowired
	@Qualifier("projectInfoDao")
	private ProjectInfoDao projectInfoDao;

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
	public Long saveProjectDetails(ProjectInfoVO projectInfoVO) {
		ProjectInfoEntity projectInfoEntity = dozerBeanMapper.map(
				projectInfoVO, ProjectInfoEntity.class);
		LOG.info(String.format(
				"Saving the ProjectInfoEntity with the Values [%s]",
				projectInfoEntity));
		if (projectInfoVO.getProjectInfoId() == null) {
			projectInfoEntity.setCreatedBy(projectInfoVO.getUserId());
			projectInfoEntity.setCreatedDate(Calendar.getInstance());
		} else {
			projectInfoEntity.setId(projectInfoVO.getProjectInfoId());
			projectInfoEntity.setUpdatedBy(projectInfoVO.getUserId());
			projectInfoEntity.setUpdatedDate(Calendar.getInstance());
		}
		projectInfoDao.saveProjectInfo(projectInfoEntity);

		if (LOG.isDebugEnabled()) {
			LOG.debug(String.format(
					"The ProjectInfoEntity is saved with the Id [%s]",
					projectInfoEntity.getId()));
		}
		userInfoDao.addProjectDetail(projectInfoVO.getUserId(),
				projectInfoEntity);
		return projectInfoEntity.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.service.ProjectDetailService#retrieveProjectInfoByUserId(
	 * java.lang.Long)
	 */
	public List<ProjectInfoVO> retrieveProjectDetailByUserId(Long userId) {
		Set<ProjectInfoEntity> results = userInfoDao
				.getProjectDetailsByUserId(userId);
		List<ProjectInfoVO> projectDetails = null;
		if (results != null && results.size() > 0) {
			projectDetails = new ArrayList<ProjectInfoVO>();
			for (ProjectInfoEntity entity : results) {
				ProjectInfoVO projectInfoVO = dozerBeanMapper.map(entity,
						ProjectInfoVO.class);
				projectDetails.add(projectInfoVO);
			}
			 Collections.sort(projectDetails, new ProjectComparator());
		}
		return projectDetails;
	}

	public ProjectInfoVO retrieveProjectDetailById(Long projectInfoId) {
		ProjectInfoEntity entity = projectInfoDao
				.getProjectInfoById(projectInfoId);
		ProjectInfoVO projectInfoVO = dozerBeanMapper.map(entity,
				ProjectInfoVO.class);
		return projectInfoVO;
	}

	public void removeProjectDetail(Long userId, Long projectInfoId) {
		userInfoDao.removeProjectDetail(userId, projectInfoId);
	}

}