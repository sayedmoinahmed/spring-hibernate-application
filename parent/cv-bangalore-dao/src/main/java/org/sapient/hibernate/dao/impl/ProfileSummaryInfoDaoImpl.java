package org.sapient.hibernate.dao.impl;

import org.hibernate.SessionFactory;
import org.sapient.hibernate.dao.ProfileSummaryInfoDao;
import org.sapient.hibernate.entity.ProfileSummaryInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("profileSummaryInfoDao")
public class ProfileSummaryInfoDaoImpl extends HibernateDaoSupport implements
		ProfileSummaryInfoDao {

	@Autowired
	public ProfileSummaryInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void saveProfileSummaryInfo(
			ProfileSummaryInfoEntity profileSummaryInfoEntity) {
		getHibernateTemplate().saveOrUpdate(profileSummaryInfoEntity);
	}

	public ProfileSummaryInfoEntity getProfileSummaryInfoById(Long id) {
		return (ProfileSummaryInfoEntity) getHibernateTemplate().get(
				ProfileSummaryInfoEntity.class, id);
	}

}
