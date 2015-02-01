/**
 * 
 */
package org.sapient.web.form;

import java.io.Serializable;

/**
 * @author psiva2
 *
 */
public class EmploymentSummaryForm implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 2930108090491214593L;

	private Long employmentInfoId;
	private String employerName;
	private String designation;
	private String employmentType;
	private String dateOfJoining;
	private String dateOfRelieving;
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
	 * @return the employmentType
	 */
	public String getEmploymentType() {
		return employmentType;
	}
	/**
	 * @param employmentType the employmentType to set
	 */
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
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
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	/**
	 * @return the dateOfRelieving
	 */
	public String getDateOfRelieving() {
		return dateOfRelieving;
	}
	/**
	 * @param dateOfRelieving the dateOfRelieving to set
	 */
	public void setDateOfRelieving(String dateOfRelieving) {
		this.dateOfRelieving = dateOfRelieving;
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
	    
	    retValue = "EmploymentSummaryForm ( "
	        + super.toString() + TAB
	        + "employmentInfoId = " + this.employmentInfoId + TAB
	        + "employerName = " + this.employerName + TAB
	        + "designation = " + this.designation + TAB
	        + "employmentType = " + this.employmentType + TAB
	        + "dateOfJoining = " + this.dateOfJoining + TAB
	        + "dateOfRelieving = " + this.dateOfRelieving + TAB
	        + " )";
	
	    return retValue;
	}
}