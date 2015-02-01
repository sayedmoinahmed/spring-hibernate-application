package org.sapient.web.form;

import java.io.Serializable;

public class ProfileSummaryForm implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -9133201069949292978L;
	private Long id;
	private String title;
	private String description;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	    
	    retValue = "ProfileSummaryForm ( "
	        + super.toString() + TAB
	        + "id = " + this.id + TAB
	        + "title = " + this.title + TAB
	        + "description = " + this.description + TAB
	        + " )";
	
	    return retValue;
	}
	
	
}