package org.sapient.hibernate.dao.impl;

import org.hibernate.SessionFactory;
import org.sapient.hibernate.dao.ProjectInfoDao;
import org.sapient.hibernate.entity.ProjectInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("projectInfoDao")
public class ProjectInfoDaoImpl extends HibernateDaoSupport implements
		ProjectInfoDao {

	@Autowired
	public ProjectInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void saveProjectInfo(ProjectInfoEntity projectInfoEntity) {
		getHibernateTemplate().saveOrUpdate(projectInfoEntity);
	}

	public ProjectInfoEntity getProjectInfoById(Long id) {
		return (ProjectInfoEntity) getHibernateTemplate().get(
				ProjectInfoEntity.class, id);
	}

}
