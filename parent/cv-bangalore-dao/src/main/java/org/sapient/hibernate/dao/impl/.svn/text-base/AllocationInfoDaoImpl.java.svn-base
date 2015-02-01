/**
 * 
 */
package org.sapient.hibernate.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.sapient.hibernate.dao.AllocationInfoDao;
import org.sapient.hibernate.entity.AllocationInfoEntity;
import org.sapient.hibernate.entity.PersonalDataInfoEntity;
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
	private static final Log LOG = LogFactory
	.getLog(AllocationInfoDaoImpl.class);
	
	@Autowired
	public AllocationInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void saveAllocationInfo(AllocationInfoEntity allocationInfoEntity) {

		boolean isUpdate = true;
		if (!exists(allocationInfoEntity)) {
			isUpdate = false;
			try {
				LOG.error(String.format(
						"Invalid JobExecution, ID [%s] not found",
						allocationInfoEntity.getOracleId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		getHibernateTemplate().saveOrUpdate(allocationInfoEntity);
	}
	public boolean exists(final AllocationInfoEntity allocationInfoEntity) {
		AllocationInfoEntity entity = (AllocationInfoEntity) getHibernateTemplate()
				.get(AllocationInfoEntity.class,
						allocationInfoEntity.getOracleId());
		if (entity != null) {
			getSession().flush();
			getHibernateTemplate().evict(entity);
		}
		return (entity != null);
	}
	@SuppressWarnings("unchecked")
	public List<AllocationInfoEntity> loadAllocationInfoByOracleId(final Long id) {
		return (List<AllocationInfoEntity>) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {

						Criteria crit = session
								.createCriteria(AllocationInfoEntity.class);

						// crit.add(Restrictions.like("designation", "%" +
						// designation +"%"));

						Criterion rhs = Restrictions.like("oracleId", id);
						crit.add(rhs);
						List searchedItems = crit.list();
						return searchedItems;
					}
				});
	}

}
