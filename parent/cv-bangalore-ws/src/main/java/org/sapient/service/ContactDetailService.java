package org.sapient.service;

import java.util.List;

import org.sapient.service.beans.ContactInfoVO;

public interface ContactDetailService {

	Long saveContactDetail(ContactInfoVO contactInfoVO);

	List<ContactInfoVO> retrieveContactDetailByUserId(Long userId);
}
