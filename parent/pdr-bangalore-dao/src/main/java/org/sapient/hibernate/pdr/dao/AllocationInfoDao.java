/**
 * 
 */
package org.sapient.hibernate.pdr.dao;

import java.util.List;

import org.sapient.hibernate.pdr.entity.AllocationInfoEntity;

/**
 * @author komar
 * 
 */
public interface AllocationInfoDao {

	void saveAllocationInfo(AllocationInfoEntity allocationInfoEntity);

	List<AllocationInfoEntity> loadAllocationInfoByOracleId(Long id);

}
