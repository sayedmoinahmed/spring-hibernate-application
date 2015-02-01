package org.sapient.service.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import org.sapient.commons.types.EmploymentType;

public class EmploymentInfoVO implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -3074051995259006583L;

	private Long userId;
	private Long employmentInfoId;
	private String employerName;
	private EmploymentType employmentType;
	private Calendar dateOfJoining;
	private Calendar dateOfRelieving;
	private String designation;
	private String supervisorName;
	private Set<AddressInfoVO> addressDetails;
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
	 * @return the employmentInfoId
	 */
	public Long getEmploymentInfoId() {
		return employmentInfoId;
	}
	/**
	 * @param employmentInfoId the employmentInfoId to set
	 */
	public void setEmploymentInfoId(Long employmentInfoId) {
		this.employmentInfoId = employmentInfoId;
	}
	/**
	 * @return the employerName
	 */
	public String getEmployerName() {
		return employerName;
	}
	/**
	 * @param employerName the employerName to set
	 */
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	/**
	 * @return the employmentType
	 */
	public EmploymentType getEmploymentType() {
		return employmentType;
	}
	/**
	 * @param employmentType the employmentType to set
	 */
	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
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
	 * @return the dateOfRelieving
	 */
	public Calendar getDateOfRelieving() {
		return dateOfRelieving;
	}
	/**
	 * @param dateOfRelieving the dateOfRelieving to set
	 */
	public void setDateOfRelieving(Calendar dateOfRelieving) {
		this.dateOfRelieving = dateOfRelieving;
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
	 * @return the addressDetails
	 */
	public Set<AddressInfoVO> getAddressDetails() {
		return addressDetails;
	}
	/**
	 * @param addressDetails the addressDetails to set
	 */
	public void setAddressDetails(Set<AddressInfoVO> addressDetails) {
		this.addressDetails = addressDetails;
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
	    
	    retValue = "EmploymentInfoVO ( "
	        + super.toString() + TAB
	        + "userId = " + this.userId + TAB
	        + "employmentInfoId = " + this.employmentInfoId + TAB
	        + "employerName = " + this.employerName + TAB
	        + "employmentType = " + this.employmentType + TAB
	        + "dateOfJoining = " + this.dateOfJoining + TAB
	        + "dateOfRelieving = " + this.dateOfRelieving + TAB
	        + "designation = " + this.designation + TAB
	        + "supervisorName = " + this.supervisorName + TAB
	        + "addressDetails = " + this.addressDetails + TAB
	        + " )";
	
	    return retValue;
	}
}