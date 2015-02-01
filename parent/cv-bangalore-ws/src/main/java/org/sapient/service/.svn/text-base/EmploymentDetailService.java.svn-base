package org.sapient.service;

import java.util.List;

import org.sapient.service.beans.EmploymentInfoVO;

public interface EmploymentDetailService {

	Long saveEmploymentDetail(EmploymentInfoVO addressInfo);

	List<EmploymentInfoVO> retrieveEmploymentDetailByUserId(Long userId);

	EmploymentInfoVO retrieveEmploymentInformationById(Long employmentInfoId);

	void removeEmploymentDetail(Long userId, Long employmentInfoId);

	Boolean isCurrentEmployerExists(Long userId);
	
	EmploymentInfoVO getCurrentEmploymentDetail(Long userId);
}
