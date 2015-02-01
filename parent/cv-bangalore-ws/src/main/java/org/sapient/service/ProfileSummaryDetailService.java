package org.sapient.service;

import java.util.List;

import org.sapient.service.beans.ProfileSummaryInfoVO;

public interface ProfileSummaryDetailService {
	
	Long saveProfileSummaryDetail(ProfileSummaryInfoVO profileSummaryInfoVO);

	List<ProfileSummaryInfoVO> retrieveProfileSummaryDetailByUserId(Long userId);
}
