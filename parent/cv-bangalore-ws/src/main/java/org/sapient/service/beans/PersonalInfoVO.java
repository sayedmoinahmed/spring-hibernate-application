package org.sapient.service.beans;

import java.io.Serializable;
import java.util.Calendar;

import org.sapient.commons.types.EmploymentType;
import org.sapient.commons.types.UserStatus;

public class PersonalInfoVO implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -6290572155260948915L;
	private Long oracleId;
	private Long id;
	private String loginId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String fatherName;
	private Calendar dateOfBirth;
	private Calendar dateOfJoining;
	private EmploymentType personType;
	private String designation;
	private UserStatus userStatus;
	private String emailAddress;
	/**
	 * @return the oracleId
	 */
	public Long getOracleId() {
		return oracleId;
	}
	/**
	 * @param oracleId the oracleId to set
	 */
	public void setOracleId(Long oracleId) {
		this.oracleId = oracleId;
	}
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
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}
	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}
	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the dateOfJoining
	 */
	public Calendar getDateOfJoining() {
		return dateOfJoining;
	}
	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(Calendar dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	/**
	 * @return the personType
	 */
	public EmploymentType getPersonType() {
		return personType;
	}
	/**
	 * @param personType the personType to set
	 */
	public void setPersonType(EmploymentType personType) {
		this.personType = personType;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the userStatus
	 */
	public UserStatus getUserStatus() {
		return userStatus;
	}
	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";
	    
	    String retValue = "";
	    
	    retValue = "PersonalInfoVO ( "
	        + super.toString() + TAB
	        + "oracleId = " + this.oracleId + TAB
	        + "id = " + this.id + TAB
	        + "loginId = " + this.loginId + TAB
	        + "firstName = " + this.firstName + TAB
	        + "lastName = " + this.lastName + TAB
	        + "middleName = " + this.middleName + TAB
	        + "fatherName = " + this.fatherName + TAB
	        + "dateOfBirth = " + this.dateOfBirth + TAB
	        + "dateOfJoining = " + this.dateOfJoining + TAB
	        + "personType = " + this.personType + TAB
	        + "designation = " + this.designation + TAB
	        + "userStatus = " + this.userStatus + TAB
	        + "emailAddress = " + this.emailAddress + TAB
	        + " )";
	
	    return retValue;
	}
}