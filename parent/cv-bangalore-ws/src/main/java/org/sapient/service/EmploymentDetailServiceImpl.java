package org.sapient.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.DozerBeanMapper;
import org.sapient.hibernate.dao.EmploymentInfoDao;
import org.sapient.hibernate.dao.UserInfoDao;
import org.sapient.hibernate.entity.AddressInfoEntity;
import org.sapient.hibernate.entity.EmploymentInfoEntity;
import org.sapient.service.beans.AddressInfoVO;
import org.sapient.service.beans.EmploymentInfoVO;
import org.sapient.service.beans.comparator.EmploymentComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employmentDetailService")
public class EmploymentDetailServiceImpl implements EmploymentDetailService {

	private static final Log LOG = LogFactory
			.getLog(EducationDetailServiceImpl.class);

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	/*
	 * This is required to persist the employment Information on employment_info
	 * table
	 */
	@Autowired
	@Qualifier("employmentInfoDao")
	private EmploymentInfoDao employmentInfoDao;

	/*
	 * This is required to persist the User Education Information on
	 * user_education table
	 */
	@Autowired
	@Qualifier("userInfoDao")
	private UserInfoDao userInfoDao;

	@Transactional
	public Long saveEmploymentDetail(EmploymentInfoVO employmentInfoVO) {
		EmploymentInfoEntity employmentInfoEntity = dozerBeanMapper.map(
				employmentInfoVO, EmploymentInfoEntity.class);
		LOG.info(String.format(
				"Saving the EmploymentInfoEntity with the Values [%s]",
				employmentInfoEntity));
		if (employmentInfoVO.getEmploymentInfoId() == null) {
			employmentInfoEntity.setCreatedBy(employmentInfoVO.getUserId());
			employmentInfoEntity.setCreatedDate(Calendar.getInstance());
		} else {
			employmentInfoEntity.setId(employmentInfoVO.getEmploymentInfoId());
			employmentInfoEntity.setUpdatedBy(employmentInfoVO.getUserId());
			employmentInfoEntity.setCreatedDate(Calendar.getInstance());
		}

		employmentInfoDao.saveEmploymentInfo(employmentInfoEntity);

		if (LOG.isDebugEnabled()) {
			LOG.debug(String.format(
					"The EmploymentInfoEntity is saved with the Id [%s]",
					employmentInfoEntity.getId()));
		}
		userInfoDao.addEmploymentDetail(employmentInfoVO.getUserId(),
				employmentInfoEntity);
		return employmentInfoEntity.getId();
	}

	public List<EmploymentInfoVO> retrieveEmploymentDetailByUserId(Long userId) {
		Set<EmploymentInfoEntity> results = userInfoDao
				.getEmploymentDetailsByUserId(userId);
		List<EmploymentInfoVO> employmentDetails = null;
		if (results != null && results.size() > 0) {
			employmentDetails = new ArrayList<EmploymentInfoVO>();
			for (EmploymentInfoEntity employmentInfoEntity : results) {
				EmploymentInfoVO educationInfo = dozerBeanMapper.map(
						employmentInfoEntity, EmploymentInfoVO.class);
				Set<AddressInfoVO> addressDetails = new HashSet<AddressInfoVO>();
				for (AddressInfoEntity addressInfoEntity : employmentInfoEntity
						.getAddressDetails()) {
					AddressInfoVO addressInfoVO = dozerBeanMapper.map(
							addressInfoEntity, AddressInfoVO.class);
					addressDetails.add(addressInfoVO);
				}
				educationInfo.setAddressDetails(addressDetails);
				employmentDetails.add(educationInfo);
			}
			Collections.sort(employmentDetails, new EmploymentComparator());
		}
		return employmentDetails;
	}

	public EmploymentInfoVO retrieveEmploymentInformationById(
			Long employmentInfoId) {
		EmploymentInfoEntity entity = employmentInfoDao
				.getEmploymentInfoById(employmentInfoId);
		EmploymentInfoVO employmentInfo = dozerBeanMapper.map(entity,
				EmploymentInfoVO.class);
		Set<AddressInfoVO> addressDetails = new HashSet<AddressInfoVO>();
		for (AddressInfoEntity addressInfoEntity : entity.getAddressDetails()) {
			AddressInfoVO addressInfoVO = dozerBeanMapper.map(
					addressInfoEntity, AddressInfoVO.class);
			addressDetails.add(addressInfoVO);
		}
		employmentInfo.setAddressDetails(addressDetails);
		return employmentInfo;
	}

	public void removeEmploymentDetail(Long userId, Long employmentInfoId) {
		userInfoDao.removeEmploymentDetail(userId, employmentInfoId);
	}

	@Override
	public Boolean isCurrentEmployerExists(Long userId) {
		Set<EmploymentInfoEntity> results = userInfoDao
				.getEmploymentDetailsByUserId(userId);
		Boolean foundCurrentEmployer = false;

		for (EmploymentInfoEntity entity : results) {
			if (entity.getDateOfRelieving() == null) {
				foundCurrentEmployer = true;
				break;
			}
			continue;
		}
		return foundCurrentEmployer;
	}

	@Override
	public EmploymentInfoVO getCurrentEmploymentDetail(Long userId) {
		Set<EmploymentInfoEntity> results = userInfoDao
				.getEmploymentDetailsByUserId(userId);
		EmploymentInfoVO employmentInfo = null;
		for (EmploymentInfoEntity entity : results) {
			if (entity.getDateOfRelieving() == null) {
				employmentInfo = dozerBeanMapper.map(entity,
						EmploymentInfoVO.class);
				Set<AddressInfoVO> addressDetails = new HashSet<AddressInfoVO>();
				for (AddressInfoEntity addressInfoEntity : entity
						.getAddressDetails()) {
					AddressInfoVO addressInfoVO = dozerBeanMapper.map(
							addressInfoEntity, AddressInfoVO.class);
					addressDetails.add(addressInfoVO);
				}
				employmentInfo.setAddressDetails(addressDetails);
				break;
			}
			continue;
		}
		return employmentInfo;
	}
}