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
import org.sapient.hibernate.pdr.dao.PersonalInfoDao;
import org.sapient.hibernate.pdr.entity.PersonalInfoEntity;
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

	@Autowired
	public PersonalInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void savePersonalInfo(PersonalInfoEntity personalInfoEntity) {
		getHibernateTemplate().save(personalInfoEntity);
	}

	@SuppressWarnings("unchecked")
	public List<PersonalInfoEntity> loadPersonalInfoByOracleId(final Long id) {
		return (List<PersonalInfoEntity>) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from PersonalInfoEntity where oracleId = :paramId");
						query.setLong("paramId", id);
						return query.list();
					}
				});
	}

}
