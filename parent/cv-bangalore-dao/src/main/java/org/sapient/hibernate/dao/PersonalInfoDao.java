/**
 * 
 */
package org.sapient.hibernate.dao;
import java.util.List;

import org.sapient.hibernate.entity.PersonalInfoEntity;



/**
 * @author komar
 * 
 */
public interface PersonalInfoDao {

	void savePersonalInfo(PersonalInfoEntity personalInfoEntity);

	List<PersonalInfoEntity> loadPersonalInfoByOracleId(Long id);
}
