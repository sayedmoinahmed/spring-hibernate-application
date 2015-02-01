/**
 * 
 */
package org.sapient.service.beans;

import java.io.Serializable;

/**
 * @author psiva2
 *
 */
public class SecurityQuestionVO implements Serializable{

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -8856741253277396123L;
	
	private Long questionId;
	private String description;
	/**
	 * @return the questionId
	 */
	public Long getQuestionId() {
		return questionId;
	}
	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
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
