package org.sapient.web.form;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.sapient.service.client.EmploymentType;

public class AccountCenterForm implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -7806177584025628621L;

	private String firstName;
	private String middleName;
	private String lastName;
	private Long oracleId;
	private String loginName;	
	private String encryptedLoginName;	
	private String resumeStatus;
	private String supervisorName;
	private String loginTimeStamp;	
	private String dateOfJoining;
	private EmploymentType personType;
	private String designation;
	private Boolean isAdmin;
	private Integer size;
	private Boolean isSubordinate;
	
	
	public Boolean getIsSubordinate() {
		return isSubordinate;
	}
	public void setIsSubordinate(Boolean isSubordinate) {
		this.isSubordinate = isSubordinate;
	}
	public Integer getSize()
	{
		return size;
	}
	public void setSize(Integer size)
	{
		this.size = size;
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
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * @return the resumeStatus
	 */
	public String getResumeStatus() {
		return resumeStatus;
	}
	/**
	 * @param resumeStatus the resumeStatus to set
	 */
	public void setResumeStatus(String resumeStatus) {
		this.resumeStatus = resumeStatus;
	}
	/**
	 * @return the supervisorName
	 */
	public String getSupervisorName() {
		return supervisorName;
	}
	/**
	 * @param supervisorName the supervisorName to set
	 */
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	/**
	 * @return the loginTimeStamp
	 */
	public String getLoginTimeStamp() {
		return loginTimeStamp;
	}
	/**
	 * @param loginTimeStamp the loginTimeStamp to set
	 */
	public void setLoginTimeStamp(String loginTimeStamp) {
		this.loginTimeStamp = loginTimeStamp;
	}
	/**
	 * @return the dateOfJoining
	 */
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(XMLGregorianCalendar dateOfJoining) {
		Date d = dateOfJoining.toGregorianCalendar().getTime();
		String joiningDate  = new SimpleDateFormat("dd-MMM-yyyy").format(d);
		this.dateOfJoining = joiningDate;
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
	 * @return the isAdmin
	 */
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	/**
	 * @return the encryptedLoginName
	 */
	public String getEncryptedLoginName() {
		return encryptedLoginName;
	}
	/**
	 * @param encryptedLoginName the encryptedLoginName to set
	 */
	public void setEncryptedLoginName(String encryptedLoginName) {
		this.encryptedLoginName = encryptedLoginName;
	}
	
	
	
	
}