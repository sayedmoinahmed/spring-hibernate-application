package org.sapient.service;

import java.util.List;

import org.sapient.commons.types.UserStatus;
import org.sapient.service.beans.PersonalInfoVO;
import org.sapient.service.beans.UserInfoVO;

public interface UserDetailService {

	UserInfoVO retrieveUserDetailByLoginName(String loginName);

	Long savePersonalDetail(PersonalInfoVO personalInfoVO);

	List<PersonalInfoVO> retrieveUserDetailBySupervisorId(Long supervisorId);

	String retriveSupervisorNameByID(Long oracleId);

	void updateUserStatus(Long userId, UserStatus userStatus);
}
