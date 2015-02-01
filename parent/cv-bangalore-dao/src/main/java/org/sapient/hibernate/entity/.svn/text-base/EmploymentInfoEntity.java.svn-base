package org.sapient.hibernate.entity;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.sapient.commons.types.EmploymentType;

/**
 * @author psiva2
 * @version 1.0
 */
@Entity
@Table(name = "employment_info")
public class EmploymentInfoEntity extends AbstractAuditEntity {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -706244488205278694L;
	
	@Column(name = "employer_name", nullable = false, length = 128, insertable = true, updatable = true)
	private String employerName;

	@Enumerated(EnumType.STRING)
	@Column(name = "employment_type", nullable = false, insertable = true, updatable = true)
	private EmploymentType employmentType;

	@Column(name = "date_of_joining", nullable = false, insertable = true, updatable = true)
	private Calendar dateOfJoining;

	@Column(name = "date_of_relieving", nullable = true, insertable = true, updatable = true)
	private Calendar dateOfRelieving;

	@Column(name = "designation", nullable = false, length = 128, insertable = true, updatable = true)
	private String designation;

	@Column(name = "supervisor_name", nullable = false, length = 128, insertable = true, updatable = true)
	private String supervisorName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "employment_address", joinColumns = {@JoinColumn(name = "employment_info_id")}, inverseJoinColumns = {@JoinColumn(name = "address_info_id")})
	private Set<AddressInfoEntity> addressDetails;

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
	public Set<AddressInfoEntity> getAddressDetails() {
		return addressDetails;
	}

	/**
	 * @param addressDetails the addressDetails to set
	 */
	public void setAddressDetails(Set<AddressInfoEntity> addressDetails) {
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
	    
	    retValue = "EmploymentInfoEntity ( "
	        + super.toString() + TAB
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