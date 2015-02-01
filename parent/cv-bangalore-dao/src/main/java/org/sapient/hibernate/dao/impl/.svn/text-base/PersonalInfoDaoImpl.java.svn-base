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
import org.sapient.hibernate.dao.PersonalInfoDao;
import org.sapient.hibernate.entity.PersonalDataInfoEntity;
import org.sapient.hibernate.entity.PersonalInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author komar
 * 
 */
@Repository("personalInfoDao")
public class PersonalInfoDaoImpl extends HibernateDaoSupport implements
		PersonalInfoDao {
	
	private static final Log LOG = LogFactory
	.getLog(PersonalInfoDaoImpl.class);

	@Autowired
	public PersonalInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void savePersonalInfo(PersonalInfoEntity personalInfoEntity) {
		boolean isUpdate = true;
		if (!exists(personalInfoEntity)) {
			isUpdate = false;
			try {
				LOG.error(String.format(
						"Invalid JobExecution, ID [%s] not found",
						personalInfoEntity.getOracleId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		getHibernateTemplate().saveOrUpdate(personalInfoEntity);
	}
	
	public boolean exists(final PersonalInfoEntity personalInfoEntity) {
		PersonalInfoEntity entity = (PersonalInfoEntity) getHibernateTemplate()
				.get(PersonalInfoEntity.class,
						personalInfoEntity.getOracleId());
		if (entity != null) {
			getSession().flush();
			getHibernateTemplate().evict(entity);
		}
		return (entity != null);
	}

	@SuppressWarnings("unchecked")
	public List<PersonalInfoEntity> loadPersonalInfoByOracleId(final Long id) {
		return (List<PersonalInfoEntity>) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {

						Criteria crit = session
								.createCriteria(PersonalInfoEntity.class);

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
