package org.sapient.service.beans;

import java.io.Serializable;

public class SkillsTypeVO implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -6930896900159105802L;

	private Long skillTypeId;
	private String description;
	/**
	 * @return the skillTypeId
	 */
	public Long getSkillTypeId() {
		return skillTypeId;
	}
	/**
	 * @param skillTypeId the skillTypeId to set
	 */
	public void setSkillTypeId(Long skillTypeId) {
		this.skillTypeId = skillTypeId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	    
	    retValue = "SkillsTypeVO ( "
	        + super.toString() + TAB
	        + "skillTypeId = " + this.skillTypeId + TAB
	        + "description = " + this.description + TAB
	        + " )";
	
	    return retValue;
	}
}