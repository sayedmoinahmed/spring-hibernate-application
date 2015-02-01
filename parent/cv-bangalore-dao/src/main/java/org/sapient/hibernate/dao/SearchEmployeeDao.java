/**
 * 
 */
package org.sapient.hibernate.dao;

import java.util.List;

import org.sapient.hibernate.entity.PersonalDataInfoEntity;
import org.sapient.hibernate.entity.SearchResultEntity;
import org.sapient.hibernate.entity.SkillsInfoEntity;
import org.springframework.stereotype.Repository;

/**
 * @author komar
 * 
 *         Updated by @author spash1
 * 
 */
public interface SearchEmployeeDao {

	List<SearchResultEntity> loadEmployeeSearchBySkill(
			final Long oracleId ,final String firstName,final String lastName, final String designation, final String skill,
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
	);
}
