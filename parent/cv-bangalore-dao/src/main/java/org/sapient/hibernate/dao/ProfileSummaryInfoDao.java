package org.sapient.hibernate.dao;

import org.sapient.hibernate.entity.ProfileSummaryInfoEntity;

public interface ProfileSummaryInfoDao {

	void saveProfileSummaryInfo(
			ProfileSummaryInfoEntity profileSummaryInfoEntity);

	ProfileSummaryInfoEntity getProfileSummaryInfoById(Long id);
}
