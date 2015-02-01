package org.sapient.hibernate.dao.impl;

import org.hibernate.SessionFactory;
import org.sapient.hibernate.dao.ContactInfoDao;
import org.sapient.hibernate.entity.AddressInfoEntity;
import org.sapient.hibernate.entity.ContactInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("contactInfoDao")
public class ContactInfoDaoImpl extends HibernateDaoSupport implements
		ContactInfoDao {

	@Autowired
	public ContactInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void saveContactInfo(ContactInfoEntity contactInfoEntity) {
		getHibernateTemplate().saveOrUpdate(contactInfoEntity);
	}

	public ContactInfoEntity getContactInfoById(Long id) {
		return (ContactInfoEntity) getHibernateTemplate().get(
				ContactInfoEntity.class, id);
	}

	public Boolean addContactAddress(Long contactInfoId,
			AddressInfoEntity addressInfoEntity) {
		return getContactInfoById(contactInfoId).getAddressDetails().add(
				addressInfoEntity);
	}

}
