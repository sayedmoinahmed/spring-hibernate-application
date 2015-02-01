/**
 * 
 */
package org.sapient.hibernate.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.sapient.hibernate.dao.OrganizationInfoDao;
import org.sapient.hibernate.entity.OrganizationInfoEntity;
import org.sapient.hibernate.entity.PersonalDataInfoEntity;
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

	private static final Log LOG = LogFactory
	.getLog(PersonalDataInfoDaoImpl.class);
	
	@Autowired
	public OrganizationInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	public void saveOrganizationInfo(
			OrganizationInfoEntity organizationInfoEntity) {
		boolean isUpdate = true;
		if (!exists(organizationInfoEntity)) {
			isUpdate = false;
			try {
				LOG.error(String.format(
						"Invalid JobExecution, ID [%s] not found",
						organizationInfoEntity.getOracleId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		getHibernateTemplate().saveOrUpdate(organizationInfoEntity);

	}
	
	public boolean exists(final OrganizationInfoEntity organizationInfoEntity) {
		OrganizationInfoEntity entity = (OrganizationInfoEntity) getHibernateTemplate()
				.get(OrganizationInfoEntity.class,
						organizationInfoEntity.getOracleId());
		if (entity != null) {
			getSession().flush();
			getHibernateTemplate().evict(entity);
		}
		return (entity != null);
	}
	
	@SuppressWarnings("unchecked")
	public List<OrganizationInfoEntity> loadOrganizationInfoByOracleId(
			final Long id) {
		return (List<OrganizationInfoEntity>) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {

						Criteria crit = session
								.createCriteria(OrganizationInfoEntity.class);

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
