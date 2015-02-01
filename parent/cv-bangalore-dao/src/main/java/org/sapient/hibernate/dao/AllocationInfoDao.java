/**
 * 
 */
package org.sapient.hibernate.dao;

import java.util.List;

import org.sapient.hibernate.entity.AllocationInfoEntity;



/**
 * @author komar
 * 
 */
public interface AllocationInfoDao {

	void saveAllocationInfo(AllocationInfoEntity allocationInfoEntity);

	List<AllocationInfoEntity> loadAllocationInfoByOracleId(Long id);

}
