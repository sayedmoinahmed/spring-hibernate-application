package org.sapient.web.form;

import java.io.Serializable;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.sapient.web.form.util.Address;
import org.sapient.web.form.util.ContactNumberField;






/**
 * @author spash1
 * 
 * ContactInformationForm to display the fields in ContactInformation page
 *
 */
public class ContactInformationForm implements Serializable {
	
	
	/**
	 * Generated SerialVersionUID
	 */
	private static final long serialVersionUID = 8476676100564124099L;
	
	
	private Address permanentAddress;
	
	@NotEmpty
	private Address currentAddress;
	
	@NotEmpty
	private String primaryEmail;
	
	@NotEmpty
	private String secondaryEmail;
	
	@NotEmpty
	@Size(min=8,max=10)
	private ContactNumberField mobileNumber;
	
	@NotEmpty
	@Size(min=8,max=10)
	private ContactNumberField officeNumber;
	
	@NotEmpty
	@Size(min=4,max=4)
	private String extension;
	
	private boolean emergency;

	/**
	 * @return the permanentAddress
	 */
	public Address getPermanentAddress() {
		return permanentAddress;
	}

	/**
	 * @param permanentAddress the permanentAddress to set
	 */
	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	/**
	 * @return the currentAddress
	 */
	public Address getCurrentAddress() {
		return currentAddress;
	}

	/**
	 * @param currentAddress the currentAddress to set
	 */
	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}

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
	public ContactNumberField getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(ContactNumberField mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the officeNumber
	 */
	public ContactNumberField getOfficeNumber() {
		return officeNumber;
	}

	/**
	 * @param officeNumber the officeNumber to set
	 */
	public void setOfficeNumber(ContactNumberField officeNumber) {
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
}
