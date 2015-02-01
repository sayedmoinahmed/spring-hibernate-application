package org.sapient.hibernate.dao.impl;

import org.hibernate.SessionFactory;
import org.sapient.hibernate.dao.SkillsInfoDao;
import org.sapient.hibernate.entity.SkillsInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("skillsInfoDao")
public class SkillsInfoDaoImpl extends HibernateDaoSupport implements
		SkillsInfoDao {

	@Autowired
	public SkillsInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	public void saveSkillsInfo(SkillsInfoEntity skillsInfoEntity) {
		getHibernateTemplate().saveOrUpdate(skillsInfoEntity);
	}

	public SkillsInfoEntity getSkillsInfoById(Long id) {
		return (SkillsInfoEntity) getHibernateTemplate().get(
				SkillsInfoEntity.class, id);
	}

}
