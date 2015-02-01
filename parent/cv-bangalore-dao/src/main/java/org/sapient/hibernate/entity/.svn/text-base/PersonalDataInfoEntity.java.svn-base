package org.sapient.hibernate.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.sapient.commons.types.EmploymentType;
import org.sapient.commons.types.UserStatus;

/**
 * @author psiva2
 * 
 */
@Entity
@Table(name = "personal_data_info")
public class PersonalDataInfoEntity implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 7276169736660460669L;

	@Id
	@Column(name = "oracle_id", nullable = false, insertable = true, updatable = false)
	private Long oracleId;

	@Column(name = "first_name", nullable = false, length = 64, insertable = true, updatable = true)
	private String firstName;

	@Column(name = "middle_name", nullable = true, length = 64, insertable = true, updatable = true)
	private String middleName;

	@Column(name = "last_name", nullable = false, length = 64, insertable = true, updatable = true)
	private String lastName;

	@Column(name = "father_name", nullable = false, length = 64, insertable = true, updatable = true)
	private String fatherName;

	@Column(name = "login_id", nullable = true, length = 16,  insertable = true, updatable = false)
	private String loginId;

	@Column(name = "date_of_birth", nullable = true, insertable = true, updatable = true)
	private Calendar dateOfBirth;

	@Column(name = "date_of_joining", nullable = false, insertable = true, updatable = true)
	private Calendar dateOfJoining;

	@Enumerated(EnumType.STRING)
	@Column(name = "person_type", nullable = false, insertable = true, updatable = true)
	private EmploymentType personType;

	@Column(name = "designation", nullable = false, length = 128, insertable = true, updatable = true)
	private String designation;

	@Column(name = "created_by", nullable = false, insertable = true, updatable = false)
	private Long createdBy;

	@Column(name = "created_date", nullable = false, insertable = true, updatable = false)
	private Calendar createdDate;

	@Column(name = "updated_by", nullable = true, insertable = true, updatable = true)
	private Long updatedBy;

	@Column(name = "updated_date", nullable = true, insertable = true, updatable = true)
	private Calendar updatedDate;

	@Column(name = "supervisor_id", nullable = true, insertable = true, updatable = true)
	private Long supervisorId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "user_status", nullable = true, insertable = true, updatable = true)
	private UserStatus userStatus;
	
	@Column(name = "email_address", nullable = true, insertable = true, updatable = true)
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
	 * @return the createdBy
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Calendar getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedBy
	 */
	public Long getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedDate
	 */
	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the supervisorId
	 */
	public Long getSupervisorId() {
		return supervisorId;
	}

	/**
	 * @param supervisorId the supervisorId to set
	 */
	public void setSupervisorId(Long supervisorId) {
		this.supervisorId = supervisorId;
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
	    
	    retValue = "PersonalDataInfoEntity ( "
	        + super.toString() + TAB
	        + "oracleId = " + this.oracleId + TAB
	        + "firstName = " + this.firstName + TAB
	        + "middleName = " + this.middleName + TAB
	        + "lastName = " + this.lastName + TAB
	        + "fatherName = " + this.fatherName + TAB
	        + "loginId = " + this.loginId + TAB
	        + "dateOfBirth = " + this.dateOfBirth + TAB
	        + "dateOfJoining = " + this.dateOfJoining + TAB
	        + "personType = " + this.personType + TAB
	        + "designation = " + this.designation + TAB
	        + "createdBy = " + this.createdBy + TAB
	        + "createdDate = " + this.createdDate + TAB
	        + "updatedBy = " + this.updatedBy + TAB
	        + "updatedDate = " + this.updatedDate + TAB
	        + "supervisorId = " + this.supervisorId + TAB
	        + "userStatus = " + this.userStatus + TAB
	        + "emailAddress = " + this.emailAddress + TAB
	        + " )";
	
	    return retValue;
	}
}