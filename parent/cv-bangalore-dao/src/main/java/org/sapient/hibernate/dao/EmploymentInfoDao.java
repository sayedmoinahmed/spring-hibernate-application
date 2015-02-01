package org.sapient.hibernate.dao;

import org.sapient.hibernate.entity.AddressInfoEntity;
import org.sapient.hibernate.entity.EmploymentInfoEntity;

public interface EmploymentInfoDao {

	void saveEmploymentInfo(EmploymentInfoEntity employmentInfoEntity);

	EmploymentInfoEntity getEmploymentInfoById(Long id);

	Boolean addEmploymentAddress(Long employmentInfoId,
			AddressInfoEntity addressInfoEntity);
}