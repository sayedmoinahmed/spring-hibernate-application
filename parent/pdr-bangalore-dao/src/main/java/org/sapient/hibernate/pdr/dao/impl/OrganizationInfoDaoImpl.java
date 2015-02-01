/**
 * 
 */
package org.sapient.hibernate.pdr.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sapient.hibernate.pdr.dao.OrganizationInfoDao;
import org.sapient.hibernate.pdr.entity.OrganizationInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author komar
 * 
 */
@Repository("organizationInfoDao")
public class OrganizationInfoDaoImpl extends HibernateDaoSupport implements
		OrganizationInfoDao {

	@Autowired
	public OrganizationInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void saveOrganizationInfo(
			OrganizationInfoEntity organizationInfoEntity) {
		getHibernateTemplate().save(organizationInfoEntity);
	}

	@SuppressWarnings("unchecked")
	public List<OrganizationInfoEntity> loadOrganizationInfoByOracleId(
			final Long id) {
		return (List<OrganizationInfoEntity>) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from OrganizationInfoEntity where oracleId = :paramId");
						query.setLong("paramId", id);
						return query.list();
					}
				});
	}

}
