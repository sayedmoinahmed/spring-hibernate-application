/**
 * 
 */
package org.sapient.hibernate.dao;

import java.util.List;
import java.util.Set;

import org.sapient.commons.types.UserStatus;
import org.sapient.hibernate.entity.ContactInfoEntity;
import org.sapient.hibernate.entity.EducationInfoEntity;
import org.sapient.hibernate.entity.EmploymentInfoEntity;
import org.sapient.hibernate.entity.ProfileSummaryInfoEntity;
import org.sapient.hibernate.entity.ProjectInfoEntity;
import org.sapient.hibernate.entity.RecognitionInfoEntity;
import org.sapient.hibernate.entity.SkillsInfoEntity;
import org.sapient.hibernate.entity.UserInfoEntity;

public interface UserInfoDao {

	void saveUserInfo(final UserInfoEntity userInfoEntity);

	UserInfoEntity getUserInfoById(final Long id);

	UserInfoEntity getUserInfoByLoginId(final String loginId);

	List<UserInfoEntity> getUserInfoBySupervisorId(final Long supervisorId);

	Set<EducationInfoEntity> getEducationDetailsByUserId(final Long id);

	Set<EmploymentInfoEntity> getEmploymentDetailsByUserId(final Long id);

	Set<ProjectInfoEntity> getProjectDetailsByUserId(final Long id);

	Set<ProfileSummaryInfoEntity> getProfileSummaryDetailsByUserId(final Long id);

	Set<SkillsInfoEntity> getSkillSetsByUserId(final Long id);

	Set<RecognitionInfoEntity> getRecognitionDetailsByUserId(final Long id);

	Set<ContactInfoEntity> getContactDetailsByUserId(final Long id);

	Boolean addEducationDetail(Long userId,
			EducationInfoEntity educationInfoEntity);

	Boolean addEmploymentDetail(Long userId,
			EmploymentInfoEntity employmentInfoEntity);

	Boolean addProjectDetail(Long userId, ProjectInfoEntity projectInfoEntity);

	Boolean addProfileSummaryDetail(Long userId,
			ProfileSummaryInfoEntity profileSummaryInfoEntity);

	Boolean addSkillSet(Long userId, SkillsInfoEntity skillsInfoEntity);

	Boolean addRecognitionDetail(Long userId,
			RecognitionInfoEntity recognitionInfoEntity);

	Boolean addContactDetail(Long userId, ContactInfoEntity contactInfoEntity);

	void removeEducationDetail(Long userId, Long educationInfoId);

	void removeEmploymentDetail(Long userId, Long employmentInfoId);

	void removeProjectDetail(Long userId, Long projectInfoId);

	void removeSkillSet(Long userId, Long skillsInfoId);

	void removeRecognitionDetail(Long userId, Long recognitionInfoId);

	UserInfoEntity getUserInfoByOracleId(Long oracleId);

	void updateUserStatus(Long userId, UserStatus userStatus);
}
