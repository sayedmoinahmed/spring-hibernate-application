package org.sapient.web.form;

public class PasswordUpdateForm {

	private String password;
	private String newPassword;
	private Long securityQuestionId;
	private String securityQuestion;
	private String answer;
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}
	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
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
	 * @return the securityQuestion
	 */
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	/**
	 * @param securityQuestion the securityQuestion to set
	 */
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
