package org.sapient.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.DozerBeanMapper;
import org.sapient.hibernate.dao.ContactInfoDao;
import org.sapient.hibernate.dao.UserInfoDao;
import org.sapient.hibernate.entity.AddressInfoEntity;
import org.sapient.hibernate.entity.ContactInfoEntity;
import org.sapient.service.beans.AddressInfoVO;
import org.sapient.service.beans.ContactInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("contactDetailService")
public class ContactDetailServiceImpl implements ContactDetailService {

	private static final Log LOG = LogFactory
			.getLog(ContactDetailServiceImpl.class);

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	@Qualifier("contactInfoDao")
	private ContactInfoDao contactInfoDao;

	@Autowired
	@Qualifier("userInfoDao")
	private UserInfoDao userInfoDao;

	@Transactional
	public Long saveContactDetail(ContactInfoVO contactInfoVO) {
		ContactInfoEntity contactInfoEntity = dozerBeanMapper.map(
				contactInfoVO, ContactInfoEntity.class);
		if (contactInfoVO.getContactInfoId() == null) {
			contactInfoEntity.setCreatedBy(contactInfoVO.getUserId());
			contactInfoEntity.setCreatedDate(Calendar.getInstance());
		} else {
			contactInfoEntity.setId(contactInfoVO.getContactInfoId());
			contactInfoEntity.setUpdatedBy(contactInfoVO.getUserId());
			contactInfoEntity.setUpdatedDate(Calendar.getInstance());
		}
		contactInfoDao.saveContactInfo(contactInfoEntity);
		LOG.info(String.format(
				"Contact Information was saved with the Id [%s]",
				contactInfoEntity.getId()));
		userInfoDao.addContactDetail(contactInfoVO.getUserId(),
				contactInfoEntity);
		return contactInfoEntity.getId();
	}

	public List<ContactInfoVO> retrieveContactDetailByUserId(Long userId) {
		Set<ContactInfoEntity> results = userInfoDao
				.getContactDetailsByUserId(userId);
		List<ContactInfoVO> contactDetails = null;
		if (results != null && results.size() > 0) {
			contactDetails = new ArrayList<ContactInfoVO>();
			for (ContactInfoEntity contactInfoEntity : results) {
				ContactInfoVO contactInfoVO = dozerBeanMapper.map(
						contactInfoEntity, ContactInfoVO.class);
				Set<AddressInfoVO> addressDetails = new HashSet<AddressInfoVO>();
				for (AddressInfoEntity addressInfoEntity : contactInfoEntity
						.getAddressDetails()) {
					AddressInfoVO addressInfoVO = dozerBeanMapper.map(
							addressInfoEntity, AddressInfoVO.class);
					addressDetails.add(addressInfoVO);
				}
				contactInfoVO.setAddressDetails(addressDetails);
				contactDetails.add(contactInfoVO);
			}
		}
		return contactDetails;
	}

}
