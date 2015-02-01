/**
 * 
 */
package org.sapient.hibernate.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.sapient.hibernate.dao.SkillsTypeDao;
import org.sapient.hibernate.entity.SkillsTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author psiva2
 * 
 */
@Repository("skillsTypeDao")
public class SkillsTypeDaoImpl extends HibernateDaoSupport implements
		SkillsTypeDao {

	@Autowired
	public SkillsTypeDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sapient.hibernate.dao.SkillsTypeDao#retrieveAllSkills()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SkillsTypeEntity> getAllSkillTypes() {
		return getHibernateTemplate().loadAll(SkillsTypeEntity.class);
	}

}
