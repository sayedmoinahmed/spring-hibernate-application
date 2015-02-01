/**
 * 
 */
package org.sapient.hibernate.dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.sapient.hibernate.dao.SearchEmployeeDao;
import org.sapient.hibernate.entity.PersonalDataInfoEntity;
import org.sapient.hibernate.entity.SearchResultEntity;
import org.sapient.hibernate.entity.SkillsInfoEntity;
import org.sapient.hibernate.entity.UserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author komar
 * 
 *         Updated by @author spash1
 * 
 */
@Repository("searchEmployeeDao")
public class SearchEmployeeDaoImpl extends HibernateDaoSupport implements
		SearchEmployeeDao {

	@Autowired
	public SearchEmployeeDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public List<SearchResultEntity> loadEmployeeSearchBySkill(
			final Long oracleId ,final String firstName,final String lastName,final String designation, final String skill,
			final String revenueGroup
			,final String teamName
			,final String businessFocus
			,final String bu
			,final String division
			,final String homeOff
			,final String currOff
			,final String company
			,final String personType
			,final String homeRegion
			,final String currentRegion
			,final String primaryCapability
			,final String domain
	
	) {

		return (List<SearchResultEntity>) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
							
						String skillParam = "%" + skill + "%";
						String designationParam = "%" + designation + "%";
						String firstNameParam ="%" +firstName +"%";
						String lastNameParam ="%" +lastName +"%";
						String oracleIdParam =null;
						if(oracleId!= null){
						 oracleIdParam ="%"+oracleId+"%";
						}else{
							oracleIdParam ="%";
						}
						
						
						 String revenueGroupParam = "%" + revenueGroup + "%";
						 String teamNameParam = "%" + teamName + "%";
						 String businessFocusParam = "%" + businessFocus + "%";
						 String buParam = "%" + bu + "%";
						 String divisionParam = "%" + division + "%";
						 String homeOffParam = "%" + homeOff + "%";
						 String currOffParam = "%" + currOff + "%";
						 String companyParam = "%" + company + "%";
						 String personTypeParam = "%" + personType + "%";
						 String homeRegionParam = "%" + homeRegion + "%";
						 String currentRegionParam = "%" + currentRegion + "%";
						 String primaryCapabilityParam = "%" + primaryCapability + "%";
						 String domainParam = "%" + domain + "%";
						
						Query q = session.getNamedQuery("doSearch").setString(
								"skillItems", skillParam);
						q.setString("designation", designationParam);
						q.setString("firstName", firstNameParam);
						q.setString("lastName", lastNameParam);
						q.setString("oracleId", oracleIdParam);
						
						
						q.setString("revenueGroup", revenueGroupParam);
						q.setString("teamName", teamNameParam);
						q.setString("businessFocus", businessFocusParam);
						q.setString("bu", buParam);
						q.setString("division", divisionParam);
						q.setString("homeOff", homeOffParam);
						q.setString("currOff", currOffParam);
						q.setString("company", companyParam);
						q.setString("personType", personTypeParam);
						q.setString("homeRegion", homeRegionParam);	
						q.setString("currentRegion", currentRegionParam);
						q.setString("primaryCapability", primaryCapabilityParam);
						q.setString("domain", domainParam);
						

						List<SearchResultEntity> l = q.list();
						ListIterator i = l.listIterator();

						while (i.hasNext()) {
							SearchResultEntity searchResultEntity = (SearchResultEntity) i
									.next();

							System.out.println("Values are:"
									+ searchResultEntity.getFirstName()
									+ searchResultEntity.getDesignation()
									+ searchResultEntity.getLoginId());

						}

						return l;
					}
				});
	}

}
