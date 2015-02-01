/**
 * 
 */
package org.sapient.web.form;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author psiva2
 * 
 */
public class LoginForm implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 8818783550126299521L;

	private String userName;
	private String password;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}