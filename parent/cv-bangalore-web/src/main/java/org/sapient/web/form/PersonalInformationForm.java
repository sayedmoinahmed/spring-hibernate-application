package org.sapient.web.form;

import java.io.Serializable;

import org.sapient.service.client.EmploymentType;
import org.sapient.web.form.util.GregorianCalendarFields;

public class PersonalInformationForm implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 6561591738194857722L;

	private Long id;
	private Long oracleId;
	private String loginId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String fatherName;
	private GregorianCalendarFields dateOfBirth;
	private GregorianCalendarFields dateOfJoining;
	private EmploymentType personType;
	private String designation;
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
	 * @return the dateOfBirth
	 */
	public GregorianCalendarFields getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(GregorianCalendarFields dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the dateOfJoining
	 */
	public GregorianCalendarFields getDateOfJoining() {
		return dateOfJoining;
	}
	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(GregorianCalendarFields dateOfJoining) {
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
	    
	    retValue = "PersonalInformationForm ( "
	        + super.toString() + TAB
	        + "id = " + this.id + TAB
	        + "oracleId = " + this.oracleId + TAB
	        + "loginId = " + this.loginId + TAB
	        + "firstName = " + this.firstName + TAB
	        + "middleName = " + this.middleName + TAB
	        + "lastName = " + this.lastName + TAB
	        + "fatherName = " + this.fatherName + TAB
	        + "dateOfBirth = " + this.dateOfBirth + TAB
	        + "dateOfJoining = " + this.dateOfJoining + TAB
	        + "personType = " + this.personType + TAB
	        + "designation = " + this.designation + TAB
	        + " )";
	
	    return retValue;
	}
}