/**
 * 
 */
package org.sapient.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 * @author komar
 * 
 *Updated by @author spash1
 * 
 */
@Entity
@Table(name = "search_result")
@NamedNativeQuery(name = "doSearch", query = "SELECT DISTINCT u.oracle_id as oracleId,u.id as id,u.login_id as loginId,u.first_name as firstName,u.last_name as lastName ,u.designation as designation "
		+ "FROM user_info u,skills_info s,user_skills us "
		+ "WHERE (s.id= us.skills_info_id AND us.user_info_id =u.id AND (s.skill_items like :skillItems) "
		+ "AND (u.designation like :designation) AND (u.first_name like :firstName) AND (u.last_name like :lastName) AND (u.oracle_id like :oracleId)" 
		+ " AND u.oracle_id  in(SELECT DISTINCT a.oracle_id from allocation_info a , organization_info o ,personal_data_info p where ((a.revenue_group like :revenueGroup) AND (a.team_name LIKE :teamName) AND (o.business_focus LIKE :businessFocus) AND (o.bu LIKE :bu) AND (o.division LIKE :division) AND (o.home_off LIKE :homeOff)  AND  (o.curr_off LIKE :currOff) AND  (o.company LIKE :company) AND (p.person_type LIKE :personType) AND (o.home_region LIKE :homeRegion)	 AND (o.current_region LIKE :currentRegion) AND (o.primary_capability LIKE :primaryCapability) AND (a.domain LIKE :domain ) AND (o.oracle_id= a.oracle_id AND p.oracle_id =o.oracle_id))))", resultClass = SearchResultEntity.class)
public class SearchResultEntity {

	@Id
	private Long id;
	private Long oracleId;

	private String loginId;

	private String firstName;

	private String designation;
	
	private String lastName;
	

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId
	 *            the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation
	 *            the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the oracleId
	 */
	public Long getOracleId() {
		return oracleId;
	}

	/**
	 * @param oracleId
	 *            the oracleId to set
	 */
	public void setOracleId(Long oracleId) {
		this.oracleId = oracleId;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
