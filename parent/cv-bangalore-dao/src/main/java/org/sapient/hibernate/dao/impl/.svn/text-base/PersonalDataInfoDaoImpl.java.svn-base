/**
 * 
 */
package org.sapient.hibernate.dao.impl;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sapient.hibernate.dao.PersonalDataInfoDao;
import org.sapient.hibernate.entity.PersonalDataInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author psiva2
 * 
 */
@Repository("personalDataInfoDao")
public class PersonalDataInfoDaoImpl extends HibernateDaoSupport implements
		PersonalDataInfoDao {

	private static final Log LOG = LogFactory
			.getLog(PersonalDataInfoDaoImpl.class);

	@Autowired
	public PersonalDataInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public boolean save(final PersonalDataInfoEntity personalDataInfoEntity) {
		boolean isUpdate = true;
		if (!exists(personalDataInfoEntity)) {
			isUpdate = false;
			try {
				LOG.error(String.format(
						"Invalid JobExecution, ID [%s] not found",
						personalDataInfoEntity.getOracleId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		getHibernateTemplate().saveOrUpdate(personalDataInfoEntity);
		return isUpdate;
	}

	public boolean exists(final PersonalDataInfoEntity personalDataInfoEntity) {
		PersonalDataInfoEntity entity = (PersonalDataInfoEntity) getHibernateTemplate()
				.get(PersonalDataInfoEntity.class,
						personalDataInfoEntity.getOracleId());
		if (entity != null) {
			getSession().flush();
			getHibernateTemplate().evict(entity);
		}
		return (entity != null);
	}

	@Override
	public PersonalDataInfoEntity getPersonalDataInfoByOracleId(
			final Long oracleId) {
		return (PersonalDataInfoEntity) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from PersonalDataInfoEntity p "
										+ " where p.oracleId = :paramOracleId");
						query.setLong("paramOracleId", oracleId);
						return query.uniqueResult();
					}
				});
	}
}