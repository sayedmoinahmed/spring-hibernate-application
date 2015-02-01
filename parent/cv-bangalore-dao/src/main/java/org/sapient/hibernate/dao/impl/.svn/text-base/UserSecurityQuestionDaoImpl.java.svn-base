/**
 * 
 */
package org.sapient.hibernate.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sapient.hibernate.dao.UserSecurityQuestionDao;
import org.sapient.hibernate.entity.UserSecurityQuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author psiva2
 * 
 */
@Repository("userSecurityQuestionDao")
public class UserSecurityQuestionDaoImpl extends HibernateDaoSupport implements
		UserSecurityQuestionDao {

	@Autowired
	public UserSecurityQuestionDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.hibernate.dao.UserSecurityQuestionDao#saveUserSecurityQuestion
	 * (org.sapient.hibernate.entity.UserSecurityQuestionEntity)
	 */
	@Override
	public void saveUserSecurityQuestion(
			UserSecurityQuestionEntity userSecurityQuestionEntity) {
		getHibernateTemplate().saveOrUpdate(userSecurityQuestionEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.hibernate.dao.UserSecurityQuestionDao#getUserSecurityQuestionById
	 * (java.lang.Long)
	 */
	@Override
	public UserSecurityQuestionEntity getUserSecurityQuestionById(Long id) {
		return (UserSecurityQuestionEntity) getHibernateTemplate().get(
				UserSecurityQuestionEntity.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sapient.hibernate.dao.UserSecurityQuestionDao#
	 * getUserSecurityQuestionByUserId(java.lang.Long)
	 */
	@Override
	public UserSecurityQuestionEntity getUserSecurityQuestionByUserId(
			final Long userId) {
		return (UserSecurityQuestionEntity) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from UserSecurityQuestionEntity u "
										+ " where u.userId = :paramUserId");
						query.setLong("paramUserId", userId);
						return query.uniqueResult();
					}
				});
	}

}
