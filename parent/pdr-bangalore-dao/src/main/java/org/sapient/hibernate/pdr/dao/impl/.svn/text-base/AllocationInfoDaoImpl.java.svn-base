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
import org.sapient.hibernate.pdr.dao.AllocationInfoDao;
import org.sapient.hibernate.pdr.entity.AllocationInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author komar
 * 
 */
@Repository("allocationInfoDao")
public class AllocationInfoDaoImpl extends HibernateDaoSupport implements
		AllocationInfoDao {

	@Autowired
	public AllocationInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void saveAllocationInfo(AllocationInfoEntity allocationInfoEntity) {
		getHibernateTemplate().save(allocationInfoEntity);
	}

	@SuppressWarnings("unchecked")
	public List<AllocationInfoEntity> loadAllocationInfoByOracleId(final Long id) {
		return (List<AllocationInfoEntity>) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from AllocationInfoEntity where oracleId = :paramId");
						query.setLong("paramId", id);
						return query.list();
					}
				});
	}

}
