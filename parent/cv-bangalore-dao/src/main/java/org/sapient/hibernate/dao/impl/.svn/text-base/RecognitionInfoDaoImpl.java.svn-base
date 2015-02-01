package org.sapient.hibernate.dao.impl;

import org.hibernate.SessionFactory;
import org.sapient.hibernate.entity.RecognitionInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("recognitionInfoDao")
public class RecognitionInfoDaoImpl extends HibernateDaoSupport implements
		org.sapient.hibernate.dao.RecognitionInfoDao {

	@Autowired
	public RecognitionInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void saveRecognitionInfo(RecognitionInfoEntity recognitionInfoEntity) {
		getHibernateTemplate().saveOrUpdate(recognitionInfoEntity);
	}

	public RecognitionInfoEntity getRecognitionInfoById(Long id) {
		return (RecognitionInfoEntity) getHibernateTemplate().get(
				RecognitionInfoEntity.class, id);
	}

}
