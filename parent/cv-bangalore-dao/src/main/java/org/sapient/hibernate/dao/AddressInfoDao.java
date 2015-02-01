package org.sapient.hibernate.dao;

import org.sapient.hibernate.entity.AddressInfoEntity;

public interface AddressInfoDao {

	void saveAddressInfo(AddressInfoEntity addressInfoEntity);

	AddressInfoEntity getAddressInfoById(final Long id);
}
