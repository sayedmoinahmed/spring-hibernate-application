/**
 * 
 */
package org.sapient.web.form.util;

import java.io.Serializable;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author brout
 * 
 */
public class GregorianCalendarFields implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -2205201808071794029L;
	private Integer year;
	private Integer month;
	private Integer day;

	public GregorianCalendarFields(){
		
	}
	public GregorianCalendarFields(XMLGregorianCalendar instance) {
		this.year = instance.getYear();
		this.month = instance.getMonth();
		this.day = instance.getDay();
	}
	/**
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	/**
	 * @return the month
	 */
	public Integer getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}
	/**
	 * @return the day
	 */
	public Integer getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(Integer day) {
		this.day = day;
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
	    
	    retValue = "GregorianCalendarFields ( "
	        + super.toString() + TAB
	        + "year = " + this.year + TAB
	        + "month = " + this.month + TAB
	        + "day = " + this.day + TAB
	        + " )";
	
	    return retValue;
	}
}