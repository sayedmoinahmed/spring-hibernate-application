package org.sapient.web.form;

import java.io.Serializable;

import org.sapient.service.client.EmploymentType;
import org.sapient.web.form.util.Address;
import org.sapient.web.form.util.GregorianCalendarFields;

public class EmploymentInformationForm implements Serializable {

	private static final long serialVersionUID = -7156917275843726350L;

	private Long employmentInfoId;
	private Long userId;
	private String employerName;
	private EmploymentType employmentType;
	private GregorianCalendarFields dateOfJoining;
	private GregorianCalendarFields dateOfRelieving;
	private String designation;
	private String supervisorName;
	private Address employmentAddress;
	private Boolean currentEmployer = false;

	/**
	 * @return the employmentInfoId
	 */
	public Long getEmploymentInfoId() {
		return employmentInfoId;
	}

	/**
	 * @param employmentInfoId
	 *            the employmentInfoId to set
	 */
	public void setEmploymentInfoId(Long employmentInfoId) {
		this.employmentInfoId = employmentInfoId;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the employerName
	 */
	public String getEmployerName() {
		return employerName;
	}

	/**
	 * @param employerName
	 *            the employerName to set
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
	 * @param employmentType
	 *            the employmentType to set
	 */
	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}

	/**
	 * @return the dateOfJoining
	 */
	public GregorianCalendarFields getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining
	 *            the dateOfJoining to set
	 */
	public void setDateOfJoining(GregorianCalendarFields dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * @return the dateOfRelieving
	 */
	public GregorianCalendarFields getDateOfRelieving() {
		return dateOfRelieving;
	}

	/**
	 * @param dateOfRelieving
	 *            the dateOfRelieving to set
	 */
	public void setDateOfRelieving(GregorianCalendarFields dateOfRelieving) {
		this.dateOfRelieving = dateOfRelieving;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation
	 *            the designation to set
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
	 * @param supervisorName
	 *            the supervisorName to set
	 */
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	/**
	 * @return the employmentAddress
	 */
	public Address getEmploymentAddress() {
		return employmentAddress;
	}

	/**
	 * @param employmentAddress
	 *            the employmentAddress to set
	 */
	public void setEmploymentAddress(Address employmentAddress) {
		this.employmentAddress = employmentAddress;
	}

	/**
	 * @return the currentEmployer
	 */
	public Boolean getCurrentEmployer() {
		return currentEmployer;
	}

	/**
	 * @param currentEmployer
	 *            the currentEmployer to set
	 */
	public void setCurrentEmployer(Boolean currentEmployer) {
		this.currentEmployer = currentEmployer;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	public String toString() {
		final String TAB = "    ";

		String retValue = "";

		retValue = "EmploymentInformationForm ( " + super.toString() + TAB
				+ "employmentInfoId = " + this.employmentInfoId + TAB
				+ "userId = " + this.userId + TAB + "employerName = "
				+ this.employerName + TAB + "employmentType = "
				+ this.employmentType + TAB + "dateOfJoining = "
				+ this.dateOfJoining + TAB + "dateOfRelieving = "
				+ this.dateOfRelieving + TAB + "designation = "
				+ this.designation + TAB + "supervisorName = "
				+ this.supervisorName + TAB + "employmentAddress = "
				+ this.employmentAddress + TAB + "currentEmployee = "
				+ this.currentEmployer + TAB + " )";

		return retValue;
	}

}