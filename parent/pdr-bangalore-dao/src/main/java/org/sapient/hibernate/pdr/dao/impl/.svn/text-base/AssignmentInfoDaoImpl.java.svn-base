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
import org.sapient.hibernate.pdr.dao.AssignmentInfoDao;
import org.sapient.hibernate.pdr.entity.AssignmentInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author komar
 * 
 */
@Repository("assignmentInfoDao")
public class AssignmentInfoDaoImpl extends HibernateDaoSupport implements
		AssignmentInfoDao {

	@Autowired
	public AssignmentInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void saveAssignmentInfo(AssignmentInfoEntity assignmentInfoEntity) {
		getHibernateTemplate().save(assignmentInfoEntity);
	}

	@SuppressWarnings("unchecked")
	public List<AssignmentInfoEntity> loadAssignmentInfoByOracleId(final Long id) {
		return (List<AssignmentInfoEntity>) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from AssignmentInfoEntity where oracleId = :paramId");
						query.setLong("paramId", id);
						return query.list();
					}
				});
	}

}
