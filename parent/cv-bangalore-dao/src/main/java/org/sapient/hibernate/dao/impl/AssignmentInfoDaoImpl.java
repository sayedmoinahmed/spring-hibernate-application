/**
 * 
 */
package org.sapient.hibernate.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.sapient.hibernate.dao.AssignmentInfoDao;
import org.sapient.hibernate.entity.AssignmentInfoEntity;
import org.sapient.hibernate.entity.PersonalDataInfoEntity;
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
	private static final Log LOG = LogFactory
	.getLog(AssignmentInfoDaoImpl.class);

	@Autowired
	public AssignmentInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	public void saveAssignmentInfo(AssignmentInfoEntity assignmentInfoEntity) {
		boolean isUpdate = true;
		if (!exists(assignmentInfoEntity)) {
			isUpdate = false;
			try {
				LOG.error(String.format(
						"Invalid JobExecution, ID [%s] not found",
						assignmentInfoEntity.getOracleId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		getHibernateTemplate().saveOrUpdate(assignmentInfoEntity);
		

	}
	public boolean exists(final AssignmentInfoEntity assignmentInfoEntity) {
		AssignmentInfoEntity entity = (AssignmentInfoEntity) getHibernateTemplate()
				.get(AssignmentInfoEntity.class,
						assignmentInfoEntity.getOracleId());
		if (entity != null) {
			getSession().flush();
			getHibernateTemplate().evict(entity);
		}
		return (entity != null);
	}
	@SuppressWarnings("unchecked")
	public List<AssignmentInfoEntity> loadAssignmentInfoByOracleId(final Long id) {
		return (List<AssignmentInfoEntity>) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {

						Criteria crit = session
								.createCriteria(AssignmentInfoEntity.class);

						// crit.add(Restrictions.like("designation", "%" +
						// designation +"%"));

						Criterion rhs = Restrictions.like("oracleId", id);
						crit.add(rhs);
						List searchedItems = crit.list();
						return searchedItems;
					}
				});
	}
}
