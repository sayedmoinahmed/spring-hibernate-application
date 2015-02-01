/**
 * 
 */
package org.sapient.hibernate.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.sapient.hibernate.dao.RecognitionTypeDao;
import org.sapient.hibernate.entity.RecognitionTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author psiva2
 *
 */
@Repository("recognitionTypeDao")
public class RecognitionTypeDaoImpl extends HibernateDaoSupport implements
		RecognitionTypeDao {

	@Autowired
	public RecognitionTypeDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	/* (non-Javadoc)
	 * @see org.sapient.hibernate.dao.RecognitionTypeDao#retrieveAllRecognitionTypes()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RecognitionTypeEntity> getAllRecognitions() {
		return getHibernateTemplate().loadAll(RecognitionTypeEntity.class);
	}

}
