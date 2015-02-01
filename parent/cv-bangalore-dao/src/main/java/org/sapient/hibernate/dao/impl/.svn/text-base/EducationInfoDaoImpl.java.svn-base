package org.sapient.hibernate.dao.impl;

import org.hibernate.SessionFactory;
import org.sapient.hibernate.dao.EducationInfoDao;
import org.sapient.hibernate.entity.AddressInfoEntity;
import org.sapient.hibernate.entity.EducationInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("educationInfoDao")
public class EducationInfoDaoImpl extends HibernateDaoSupport implements
		EducationInfoDao {
	@Autowired
	public EducationInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void saveEducationInfo(EducationInfoEntity educationInfoEntity) {
		getHibernateTemplate().saveOrUpdate(educationInfoEntity);
	}

	public EducationInfoEntity getEducationInfoById(Long id) {
		return (EducationInfoEntity) getHibernateTemplate().get(
				EducationInfoEntity.class, id);
	}

	public Boolean addEducationAddress(Long educationInfoId,
			AddressInfoEntity addressInfoEntity) {
		return getEducationInfoById(educationInfoId).getAddressDetails().add(
				addressInfoEntity);
	}

}
