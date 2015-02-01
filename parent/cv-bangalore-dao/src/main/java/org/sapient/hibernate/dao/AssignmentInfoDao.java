/**
 * 
 */
package org.sapient.hibernate.dao;
import java.util.List;

import org.sapient.hibernate.entity.AssignmentInfoEntity;

 

/**
 * @author komar
 * 
 */
public interface AssignmentInfoDao {

	void saveAssignmentInfo(AssignmentInfoEntity assignmentInfoEntity);

	List<AssignmentInfoEntity> loadAssignmentInfoByOracleId(Long id);
}
