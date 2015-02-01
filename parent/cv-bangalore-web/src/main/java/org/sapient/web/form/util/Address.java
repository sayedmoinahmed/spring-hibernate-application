package org.sapient.web.form.util;

import java.io.Serializable;


/**
 * @author spash1
 *
 */
public class Address implements Serializable {
	
	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 6658295734287193305L;
	private Long addressInfoId;
	private String streetAddress;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	/**
	 * @return the addressInfoId
	 */
	public Long getAddressInfoId() {
		return addressInfoId;
	}
	/**
	 * @param addressInfoId the addressInfoId to set
	 */
	public void setAddressInfoId(Long addressInfoId) {
		this.addressInfoId = addressInfoId;
	}
	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}
	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
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
	    
	    retValue = "Address ( "
	        + super.toString() + TAB
	        + "addressInfoId = " + this.addressInfoId + TAB
	        + "streetAddress = " + this.streetAddress + TAB
	        + "addressLine2 = " + this.addressLine2 + TAB
	        + "city = " + this.city + TAB
	        + "state = " + this.state + TAB
	        + "zipCode = " + this.zipCode + TAB
	        + "country = " + this.country + TAB
	        + " )";
	
	    return retValue;
	}
}