/**
 * 
 */
package org.sapient.hibernate.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.sapient.hibernate.dao.SecurityQuestionDao;
import org.sapient.hibernate.entity.SecurityQuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author psiva2
 * 
 */
@Repository("securityQuestionDao")
public class SecurityQuestionDaoImpl extends HibernateDaoSupport implements
		SecurityQuestionDao {

	@Autowired
	public SecurityQuestionDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.hibernate.dao.SecurityQuestionDao#getAllSecurityQuestions()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SecurityQuestionEntity> getAllSecurityQuestions() {
		return getHibernateTemplate().loadAll(SecurityQuestionEntity.class);
	}

}
