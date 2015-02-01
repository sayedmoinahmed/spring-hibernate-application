package org.sapient.hibernate.dao;

import org.sapient.hibernate.entity.PersonalDataInfoEntity;

public interface PersonalDataInfoDao {

	boolean save(PersonalDataInfoEntity personalDataInfoEntity);

	PersonalDataInfoEntity getPersonalDataInfoByOracleId(Long oracleId);
	
	public boolean exists(final PersonalDataInfoEntity personalDataInfoEntity);
}
