package org.sapient.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author psiva2
 * 
 */
@Entity
@Table(name = "user_security_question")
public class UserSecurityQuestionEntity extends AbstractAuditEntity {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 5259570909013516818L;

	@Column(name = "user_id", nullable = false, insertable = true, updatable = true)
	private Long userId;

	@Column(name = "security_question_id", nullable = false, insertable = true, updatable = true)
	private Long securityQuestionId;

	@Column(name = "security_question_answer", nullable = false, insertable = true, updatable = true)
	private String securityQuestionAnswer;

	@OneToOne(targetEntity = UserInfoEntity.class)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private UserInfoEntity userInfoEntity;

	@OneToOne(targetEntity = SecurityQuestionEntity.class)
	@JoinColumn(name = "security_question_id", insertable = false, updatable = false)
	private SecurityQuestionEntity securityQuestionEntity;

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the securityQuestionId
	 */
	public Long getSecurityQuestionId() {
		return securityQuestionId;
	}

	/**
	 * @param securityQuestionId the securityQuestionId to set
	 */
	public void setSecurityQuestionId(Long securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}

	/**
	 * @return the securityQuestionAnswer
	 */
	public String getSecurityQuestionAnswer() {
		return securityQuestionAnswer;
	}

	/**
	 * @param securityQuestionAnswer the securityQuestionAnswer to set
	 */
	public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
		this.securityQuestionAnswer = securityQuestionAnswer;
	}

	/**
	 * @return the userInfoEntity
	 */
	public UserInfoEntity getUserInfoEntity() {
		return userInfoEntity;
	}

	/**
	 * @param userInfoEntity the userInfoEntity to set
	 */
	public void setUserInfoEntity(UserInfoEntity userInfoEntity) {
		this.userInfoEntity = userInfoEntity;
	}

	/**
	 * @return the securityQuestionEntity
	 */
	public SecurityQuestionEntity getSecurityQuestionEntity() {
		return securityQuestionEntity;
	}

	/**
	 * @param securityQuestionEntity the securityQuestionEntity to set
	 */
	public void setSecurityQuestionEntity(
			SecurityQuestionEntity securityQuestionEntity) {
		this.securityQuestionEntity = securityQuestionEntity;
	}
}