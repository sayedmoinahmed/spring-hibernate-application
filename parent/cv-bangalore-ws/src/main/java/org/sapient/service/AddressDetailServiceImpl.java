/**
 * 
 */
package org.sapient.service;

import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.DozerBeanMapper;
import org.sapient.commons.types.AddressType;
import org.sapient.hibernate.dao.AddressInfoDao;
import org.sapient.hibernate.dao.ContactInfoDao;
import org.sapient.hibernate.dao.EducationInfoDao;
import org.sapient.hibernate.dao.EmploymentInfoDao;
import org.sapient.hibernate.entity.AddressInfoEntity;
import org.sapient.service.beans.AddressInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author psiva2
 * 
 */
@Service("addressDetailService")
public class AddressDetailServiceImpl implements AddressDetailService {

	private static final Log LOG = LogFactory
			.getLog(AddressDetailServiceImpl.class);

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	@Qualifier("addressInfoDao")
	private AddressInfoDao addressInfoDao;

	@Autowired
	@Qualifier("employmentInfoDao")
	private EmploymentInfoDao employmentInfoDao;

	@Autowired
	@Qualifier("contactInfoDao")
	private ContactInfoDao contactInfoDao;

	@Autowired
	@Qualifier("educationInfoDao")
	private EducationInfoDao educationInfoDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.service.AddressDetailService#saveAddressDetail(org.sapient
	 * .service.beans.AddressInfoVO)
	 */
	@Transactional
	public Long saveAddressDetail(AddressInfoVO addressInfoVO) {
		AddressInfoEntity addressInfoEntity = dozerBeanMapper.map(
				addressInfoVO, AddressInfoEntity.class);
		if (addressInfoVO.getAddressInfoId() == null) {
			addressInfoEntity.setCreatedBy(addressInfoVO.getUserId());
			addressInfoEntity.setCreatedDate(Calendar.getInstance());
		} else {
			addressInfoEntity.setId(addressInfoVO.getAddressInfoId());
			addressInfoEntity.setUpdatedBy(addressInfoVO.getUserId());
			addressInfoEntity.setUpdatedDate(Calendar.getInstance());
		}
		addressInfoDao.saveAddressInfo(addressInfoEntity);
		if (LOG.isDebugEnabled()) {
			LOG.debug(String.format(
					"Address Information was saved with the Id [%s]",
					addressInfoEntity.getId()));
		}

		if (addressInfoEntity.getAddressType() == AddressType.EMPLOYMENT) {
			employmentInfoDao.addEmploymentAddress(
					addressInfoVO.getEmploymentInfoId(), addressInfoEntity);
		} else if (addressInfoEntity.getAddressType() == AddressType.EDUCATION) {
			educationInfoDao.addEducationAddress(
					addressInfoVO.getEducationInfoId(), addressInfoEntity);
		} else {
			contactInfoDao.addContactAddress(addressInfoVO.getContactInfoId(),
					addressInfoEntity);
		}
		return addressInfoEntity.getId();
	}
}
