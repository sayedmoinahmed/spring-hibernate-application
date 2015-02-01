package org.sapient.service.beans;

import java.io.Serializable;

/**
 * @author psiva2
 * 
 */
public class UserSecurityQuestionVO implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 2049331904896077874L;

	private Long id;
	private Long userId;
	private Long securityQuestionId;
	private String securityQuestionAnswer;
	private String description;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}