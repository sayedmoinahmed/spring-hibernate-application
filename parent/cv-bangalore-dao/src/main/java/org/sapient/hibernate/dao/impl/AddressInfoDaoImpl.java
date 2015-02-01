/**
 * 
 */
package org.sapient.hibernate.dao.impl;

import org.hibernate.SessionFactory;
import org.sapient.hibernate.dao.AddressInfoDao;
import org.sapient.hibernate.entity.AddressInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("addressInfoDao")
public class AddressInfoDaoImpl extends HibernateDaoSupport implements
		AddressInfoDao {

	@Autowired
	public AddressInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void saveAddressInfo(AddressInfoEntity addressInfoEntity) {
		getHibernateTemplate().saveOrUpdate(addressInfoEntity);
	}

	public AddressInfoEntity getAddressInfoById(Long id) {
		return (AddressInfoEntity) getHibernateTemplate().get(
				AddressInfoEntity.class, id);
	}

}
