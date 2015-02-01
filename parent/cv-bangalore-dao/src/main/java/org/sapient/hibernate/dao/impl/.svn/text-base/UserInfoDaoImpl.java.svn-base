package org.sapient.hibernate.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sapient.commons.types.UserStatus;
import org.sapient.hibernate.dao.UserInfoDao;
import org.sapient.hibernate.entity.ContactInfoEntity;
import org.sapient.hibernate.entity.EducationInfoEntity;
import org.sapient.hibernate.entity.EmploymentInfoEntity;
import org.sapient.hibernate.entity.ProfileSummaryInfoEntity;
import org.sapient.hibernate.entity.ProjectInfoEntity;
import org.sapient.hibernate.entity.RecognitionInfoEntity;
import org.sapient.hibernate.entity.SkillsInfoEntity;
import org.sapient.hibernate.entity.UserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("userInfoDao")
public class UserInfoDaoImpl extends HibernateDaoSupport implements UserInfoDao {

	private static final Log LOG = LogFactory.getLog(UserInfoDaoImpl.class);

	@Autowired
	public UserInfoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void saveUserInfo(UserInfoEntity userInfoEntity) {
		getHibernateTemplate().saveOrUpdate(userInfoEntity);
	}

	public UserInfoEntity getUserInfoById(final Long id) {
		return (UserInfoEntity) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from UserInfoEntity u "
										+ "left join fetch u.contactDetails "
										+ "left join fetch u.educationDetails "
										+ "left join fetch u.employmentDetails "
										+ "left join fetch u.projectDetails "
										+ "left join fetch u.skillSets "
										+ "left join fetch u.profileSummaryDetails "
										+ "left join fetch u.recognitionDetails "
										+ " where u.id = :paramId");
						query.setLong("paramId", id);
						return query.uniqueResult();
					}
				});
	}

	public UserInfoEntity getUserInfoByLoginId(final String loginId) {
		return (UserInfoEntity) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from UserInfoEntity u "
										+ " where u.loginId = :paramLoginId");
						query.setString("paramLoginId", loginId);
						return query.uniqueResult();
					}
				});
	}

	public Set<EducationInfoEntity> getEducationDetailsByUserId(final Long id) {
		UserInfoEntity result = (UserInfoEntity) getHibernateTemplate()
				.execute(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from UserInfoEntity u "
										+ "left join fetch u.educationDetails "
										+ " where u.id = :paramId");
						query.setLong("paramId", id);
						return query.uniqueResult();
					}
				});
		if (result != null)
			return result.getEducationDetails();

		return null;
	}

	public Set<EmploymentInfoEntity> getEmploymentDetailsByUserId(final Long id) {
		UserInfoEntity result = (UserInfoEntity) getHibernateTemplate()
				.execute(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from UserInfoEntity u "
										+ "left join fetch u.employmentDetails "
										+ " where u.id = :paramId");
						query.setLong("paramId", id);
						return query.uniqueResult();
					}
				});
		if (result != null)
			return result.getEmploymentDetails();

		return null;
	}

	public Set<ProjectInfoEntity> getProjectDetailsByUserId(final Long id) {
		UserInfoEntity result = (UserInfoEntity) getHibernateTemplate()
				.execute(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from UserInfoEntity u "
										+ "left join fetch u.projectDetails "
										+ " where u.id = :paramId");
						query.setLong("paramId", id);
						return query.uniqueResult();
					}
				});
		if (result != null)
			return result.getProjectDetails();

		return null;
	}

	public Set<ProfileSummaryInfoEntity> getProfileSummaryDetailsByUserId(
			final Long id) {
		UserInfoEntity result = (UserInfoEntity) getHibernateTemplate()
				.execute(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from UserInfoEntity u "
										+ "left join fetch u.profileSummaryDetails "
										+ " where u.id = :paramId");
						query.setLong("paramId", id);
						return query.uniqueResult();
					}
				});
		if (result != null)
			return result.getProfileSummaryDetails();

		return null;
	}

	public Set<SkillsInfoEntity> getSkillSetsByUserId(final Long id) {
		UserInfoEntity result = (UserInfoEntity) getHibernateTemplate()
				.execute(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from UserInfoEntity u "
										+ "left join fetch u.skillSets "
										+ " where u.id = :paramId");
						query.setLong("paramId", id);
						return query.uniqueResult();
					}
				});
		if (result != null)
			return result.getSkillSets();

		return null;
	}

	public Set<RecognitionInfoEntity> getRecognitionDetailsByUserId(
			final Long id) {
		UserInfoEntity result = (UserInfoEntity) getHibernateTemplate()
				.execute(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from UserInfoEntity u "
										+ "left join fetch u.recognitionDetails "
										+ " where u.id = :paramId");
						query.setLong("paramId", id);
						return query.uniqueResult();
					}
				});
		if (result != null)
			return result.getRecognitionDetails();

		return null;
	}

	public Set<ContactInfoEntity> getContactDetailsByUserId(final Long id) {
		UserInfoEntity result = (UserInfoEntity) getHibernateTemplate()
				.execute(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from UserInfoEntity u "
										+ "left join fetch u.contactDetails "
										+ " where u.id = :paramId");
						query.setLong("paramId", id);
						return query.uniqueResult();
					}
				});
		if (result != null)
			return result.getContactDetails();

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.hibernate.dao.UserInfoDao#addEducationDetail(java.lang.Long,
	 * org.sapient.hibernate.entity.EducationInfoEntity)
	 */
	public Boolean addEducationDetail(Long userId,
			EducationInfoEntity educationInfoEntity) {
		return getUserInfoById(userId).getEducationDetails().add(
				educationInfoEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.hibernate.dao.UserInfoDao#addEmploymentDetail(java.lang.Long,
	 * org.sapient.hibernate.entity.EmploymentInfoEntity)
	 */
	public Boolean addEmploymentDetail(Long userId,
			EmploymentInfoEntity employmentInfoEntity) {
		return getUserInfoById(userId).getEmploymentDetails().add(
				employmentInfoEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.hibernate.dao.UserInfoDao#addProjectDetail(java.lang.Long,
	 * org.sapient.hibernate.entity.ProjectInfoEntity)
	 */
	public Boolean addProjectDetail(Long userId,
			ProjectInfoEntity projectInfoEntity) {
		return getUserInfoById(userId).getProjectDetails().add(
				projectInfoEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.hibernate.dao.UserInfoDao#addProfileSummaryDetail(java.lang
	 * .Long, org.sapient.hibernate.entity.ProfileSummaryInfoEntity)
	 */
	public Boolean addProfileSummaryDetail(Long userId,
			ProfileSummaryInfoEntity profileSummaryInfoEntity) {
		return getUserInfoById(userId).getProfileSummaryDetails().add(
				profileSummaryInfoEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sapient.hibernate.dao.UserInfoDao#addSkillSet(java.lang.Long,
	 * org.sapient.hibernate.entity.SkillsInfoEntity)
	 */
	public Boolean addSkillSet(Long userId, SkillsInfoEntity skillsInfoEntity) {
		return getUserInfoById(userId).getSkillSets().add(skillsInfoEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.hibernate.dao.UserInfoDao#addRecognitionDetail(java.lang.
	 * Long, org.sapient.hibernate.entity.RecognitionInfoEntity)
	 */
	public Boolean addRecognitionDetail(Long userId,
			RecognitionInfoEntity recognitionInfoEntity) {
		return getUserInfoById(userId).getRecognitionDetails().add(
				recognitionInfoEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.hibernate.dao.UserInfoDao#addContactDetail(java.lang.Long,
	 * org.sapient.hibernate.entity.ContactInfoEntity)
	 */
	public Boolean addContactDetail(Long userId,
			ContactInfoEntity contactInfoEntity) {
		return getUserInfoById(userId).getContactDetails().add(
				contactInfoEntity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfoEntity> getUserInfoBySupervisorId(
			final Long supervisorId) {

		List<UserInfoEntity> result = (List<UserInfoEntity>) getHibernateTemplate()
				.execute(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String queryStr = "from UserInfoEntity WHERE supervisorId = :paramSupervisorId";
						Query query = session.createQuery(queryStr);
						query.setLong("paramSupervisorId", supervisorId);
						return query.list();
					}
				});
		if (result != null) {
			return result;
		}
		return null;
	}

	@Override
	public void removeEducationDetail(Long userId, Long educationInfoId) {
		UserInfoEntity userInfoEntity = getUserInfoById(userId);
		Set<EducationInfoEntity> educationDetails = userInfoEntity
				.getEducationDetails();
		EducationInfoEntity entityToDelete = null;
		for (EducationInfoEntity educationInfoEntity : educationDetails) {

			if (educationInfoEntity.getId().equals(educationInfoId)) {
				LOG.info(String.format("Marking the Entity to delete [%s] ",
						educationInfoEntity.getId()));
				entityToDelete = educationInfoEntity;
			}
		}
		educationDetails.remove(entityToDelete);
		userInfoEntity.setEducationDetails(educationDetails);
		saveUserInfo(userInfoEntity);
		getHibernateTemplate().delete(entityToDelete);
	}

	@Override
	public void removeEmploymentDetail(Long userId, Long employmentInfoId) {
		UserInfoEntity userInfoEntity = getUserInfoById(userId);
		Set<EmploymentInfoEntity> employmentDetails = userInfoEntity
				.getEmploymentDetails();
		EmploymentInfoEntity entityToDelete = null;
		for (EmploymentInfoEntity employmentInfoEntity : employmentDetails) {

			if (employmentInfoEntity.getId().equals(employmentInfoId)) {
				LOG.info(String.format("Marking the Entity to delete [%s] ",
						employmentInfoEntity.getId()));
				entityToDelete = employmentInfoEntity;
			}
		}
		employmentDetails.remove(entityToDelete);
		userInfoEntity.setEmploymentDetails(employmentDetails);
		saveUserInfo(userInfoEntity);
		getHibernateTemplate().delete(entityToDelete);

	}

	@Override
	public void removeProjectDetail(Long userId, Long projectInfoId) {
		UserInfoEntity userInfoEntity = getUserInfoById(userId);
		Set<ProjectInfoEntity> projectDetails = userInfoEntity
				.getProjectDetails();
		ProjectInfoEntity entityToDelete = null;
		for (ProjectInfoEntity projectInfoEntity : projectDetails) {

			if (projectInfoEntity.getId().equals(projectInfoId)) {
				LOG.info(String.format("Marking the Entity to delete [%s] ",
						projectInfoEntity.getId()));
				entityToDelete = projectInfoEntity;
			}
		}
		projectDetails.remove(entityToDelete);
		userInfoEntity.setProjectDetails(projectDetails);
		saveUserInfo(userInfoEntity);
		getHibernateTemplate().delete(entityToDelete);

	}

	@Override
	public void removeSkillSet(Long userId, Long skillsInfoId) {
		UserInfoEntity userInfoEntity = getUserInfoById(userId);
		Set<SkillsInfoEntity> skillsDetails = userInfoEntity.getSkillSets();
		SkillsInfoEntity entityToDelete = null;
		for (SkillsInfoEntity skillsInfoEntity : skillsDetails) {

			if (skillsInfoEntity.getId().equals(skillsInfoId)) {
				LOG.info(String.format("Marking the Entity to delete [%s] ",
						skillsInfoEntity.getId()));
				entityToDelete = skillsInfoEntity;
			}
		}
		skillsDetails.remove(entityToDelete);
		userInfoEntity.setSkillSets(skillsDetails);
		saveUserInfo(userInfoEntity);
		getHibernateTemplate().delete(entityToDelete);

	}

	@Override
	public void removeRecognitionDetail(Long userId, Long recognitionInfoId) {
		UserInfoEntity userInfoEntity = getUserInfoById(userId);
		Set<RecognitionInfoEntity> recognitionDetails = userInfoEntity
				.getRecognitionDetails();
		RecognitionInfoEntity entityToDelete = null;
		for (RecognitionInfoEntity recognitionInfoEntity : recognitionDetails) {

			if (recognitionInfoEntity.getId().equals(recognitionInfoId)) {
				LOG.info(String.format("Marking the Entity to delete [%s] ",
						recognitionInfoEntity.getId()));
				entityToDelete = recognitionInfoEntity;
			}
		}
		recognitionDetails.remove(entityToDelete);
		userInfoEntity.setRecognitionDetails(recognitionDetails);
		saveUserInfo(userInfoEntity);
		getHibernateTemplate().delete(entityToDelete);

	}

	@Override
	public UserInfoEntity getUserInfoByOracleId(final Long oracleId) {
		UserInfoEntity result = (UserInfoEntity) getHibernateTemplate()
				.execute(new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session
								.createQuery("from UserInfoEntity u "
										+ " where u.oracleId = :paramId");
						query.setLong("paramId", oracleId);
						return query.uniqueResult();
					}
				});
		if (result != null)
			return result;

		return null;
	}

	@Override
	public void updateUserStatus(Long userId, UserStatus userStatus) {
		UserInfoEntity entity = getUserInfoById(userId);
		LOG.info(String.format(
				"The Current User Status for the userId [%s] is [%s]", userId,
				entity.getUserStatus()));
		entity.setUserStatus(userStatus);
		LOG.info(String.format("Updating the user status to [%s]", userStatus));
		getHibernateTemplate().saveOrUpdate(entity);
	}

}