package org.sapient.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "security_question")
public class SecurityQuestionEntity extends AbstractAuditEntity {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -2859174731653214278L;

	@Column(name = "security_question", nullable = false, updatable = true, insertable = true)
	private String securityQuestion;

	/**
	 * @return the securityQuestion
	 */
	public String getSecurityQuestion() {
		return securityQuestion;
	}

	/**
	 * @param securityQuestion
	 *            the securityQuestion to set
	 */
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
}