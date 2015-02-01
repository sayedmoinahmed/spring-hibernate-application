package org.sapient.hibernate.dao.impl;

import org.hibernate.SessionFactory;
import org.sapient.hibernate.dao.EmploymentInfoDao;
import org.sapient.hibernate.entity.AddressInfoEntity;
import org.sapient.hibernate.entity.EmploymentInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("employmentInfoDao")
public class EmploymentInfoDaoImpl extends HibernateDaoSupport implements
		EmploymentInfoDao {

	@Autowired
	public EmploymentInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void saveEmploymentInfo(EmploymentInfoEntity employmentInfoEntity) {
		getHibernateTemplate().saveOrUpdate(employmentInfoEntity);
	}

	public EmploymentInfoEntity getEmploymentInfoById(Long id) {
		return (EmploymentInfoEntity) getHibernateTemplate().get(
				EmploymentInfoEntity.class, id);
	}

	@Override
	public Boolean addEmploymentAddress(Long employmentInfoId,
			AddressInfoEntity addressInfoEntity) {
		return getEmploymentInfoById(employmentInfoId).getAddressDetails().add(
				addressInfoEntity);
	}

}
