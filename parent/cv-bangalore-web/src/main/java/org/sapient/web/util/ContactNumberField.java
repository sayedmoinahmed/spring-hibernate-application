package org.sapient.web.util;



/**
 * @author spash1
 *
 */
public class ContactNumberField 
{
	
	private String countryCode = null;
	private String areaCode = null;
	private String phoneNumber = null;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAreaCode() {
		return areaCode;
	}


	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ContactNumberField(String contactNumber) {
		this.setCountryCode(contactNumber.substring(0,3));
		this.setAreaCode(contactNumber.substring(3,6));
		this.setPhoneNumber(contactNumber.substring(6,9));
	}

}
