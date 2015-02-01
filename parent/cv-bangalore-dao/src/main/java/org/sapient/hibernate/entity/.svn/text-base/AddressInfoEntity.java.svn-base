/**
 * 
 */
package org.sapient.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.sapient.commons.types.AddressType;

/**
 * @author psiva2
 * @version 1.0
 */
@Entity
@Table(name = "address_info")
public class AddressInfoEntity extends AbstractAuditEntity {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -3890306819890744864L;

	@Column(name = "address_line1", length = 128, nullable = true, insertable = true, updatable = true)
	private String addressLine1;

	@Column(name = "address_line2", length = 128, nullable = true, insertable = true, updatable = true)
	private String addressLine2;

	@Column(name = "address_line3", length = 128, nullable = true, insertable = true, updatable = true)
	private String addressLine3;

	@Column(name = "city", nullable = false, length = 64, insertable = true, updatable = true)
	private String city;

	@Column(name = "state", nullable = true, length = 64, insertable = true, updatable = true)
	private String state;

	@Column(name = "zip_code", nullable = true, length = 64, insertable = true, updatable = true)
	private String zipCode;

	@Column(name = "country", nullable = true, length = 64, insertable = true, updatable = true)
	private String country;

	@Enumerated(EnumType.STRING)
	@Column(name = "address_type", nullable = false, length = 64, insertable = true, updatable = true)
	private AddressType addressType;

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
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
	 * @return the addressLine3
	 */
	public String getAddressLine3() {
		return addressLine3;
	}

	/**
	 * @param addressLine3 the addressLine3 to set
	 */
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
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
	 * @return the addressType
	 */
	public AddressType getAddressType() {
		return addressType;
	}

	/**
	 * @param addressType the addressType to set
	 */
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
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
	    
	    retValue = "AddressInfoEntity ( "
	        + super.toString() + TAB
	        + "addressLine1 = " + this.addressLine1 + TAB
	        + "addressLine2 = " + this.addressLine2 + TAB
	        + "addressLine3 = " + this.addressLine3 + TAB
	        + "city = " + this.city + TAB
	        + "state = " + this.state + TAB
	        + "zipCode = " + this.zipCode + TAB
	        + "country = " + this.country + TAB
	        + "addressType = " + this.addressType + TAB
	        + " )";
	
	    return retValue;
	}

	
}