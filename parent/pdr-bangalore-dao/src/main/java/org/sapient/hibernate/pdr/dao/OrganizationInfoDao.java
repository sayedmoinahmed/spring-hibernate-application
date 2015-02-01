/**
 * 
 */
package org.sapient.hibernate.pdr.dao;

import java.util.List;

import org.sapient.hibernate.pdr.entity.OrganizationInfoEntity;

/**
 * @author komar
 * 
 */
public interface OrganizationInfoDao {

	void saveOrganizationInfo(OrganizationInfoEntity organizationInfoEntity);

	List<OrganizationInfoEntity> loadOrganizationInfoByOracleId(Long id);
}
