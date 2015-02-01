/**
 * 
 */
package org.sapient.hibernate.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author psiva2
 * 
 */
@Entity
@Table(name = "contact_info")
public class ContactInfoEntity extends AbstractAuditEntity {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 4548217078477212155L;

	@Column(name = "primary_email", nullable = true, length = 128, insertable = true, updatable = true)
	private String primaryEmail;

	@Column(name = "secondary_email", nullable = true, length = 128, insertable = true, updatable = true)
	private String secondaryEmail;

	@Column(name = "mobile_number", nullable = false, length = 16, insertable = true, updatable = true)
	private String mobileNumber;

	@Column(name = "office_number", nullable = true,  length = 16, insertable = true, updatable = true)
	private String officeNumber;

	@Column(name = "office_extension", nullable = true, length = 8, insertable = true, updatable = true)
	private String extension;

	@Column(name = "is_emergency", nullable = true, insertable = true, updatable = true)
	private boolean emergency;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "contact_address", joinColumns = {@JoinColumn(name = "contact_info_id")}, inverseJoinColumns = {@JoinColumn(name = "address_info_id")})
	private Set<AddressInfoEntity> addressDetails;

	/**
	 * @return the primaryEmail
	 */
	public String getPrimaryEmail() {
		return primaryEmail;
	}

	/**
	 * @param primaryEmail the primaryEmail to set
	 */
	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	/**
	 * @return the secondaryEmail
	 */
	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	/**
	 * @param secondaryEmail the secondaryEmail to set
	 */
	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the officeNumber
	 */
	public String getOfficeNumber() {
		return officeNumber;
	}

	/**
	 * @param officeNumber the officeNumber to set
	 */
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @return the emergency
	 */
	public boolean isEmergency() {
		return emergency;
	}

	/**
	 * @param emergency the emergency to set
	 */
	public void setEmergency(boolean emergency) {
		this.emergency = emergency;
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
	    
	    retValue = "ContactInfoEntity ( "
	        + super.toString() + TAB
	        + "primaryEmail = " + this.primaryEmail + TAB
	        + "secondaryEmail = " + this.secondaryEmail + TAB
	        + "mobileNumber = " + this.mobileNumber + TAB
	        + "officeNumber = " + this.officeNumber + TAB
	        + "extension = " + this.extension + TAB
	        + "emergency = " + this.emergency + TAB
	        + "addressDetails = " + this.addressDetails + TAB
	        + " )";
	
	    return retValue;
	}
}