/**
 * 
 */
package org.sapient.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author psiva2
 * @version 1.0
 */
@Entity
@Table(name = "profile_summary_info")
public class ProfileSummaryInfoEntity extends AbstractAuditEntity {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 2818491189436247114L;

	@Column(name = "title", nullable = false, length = 256, insertable = true, updatable = true)
	private String title;

	@Column(name = "description", nullable = false, length = 512, insertable = true, updatable = true)
	private String description;

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
	    
	    retValue = "ProfileSummaryInfoEntity ( "
	        + super.toString() + TAB
	        + "title = " + this.title + TAB
	        + "description = " + this.description + TAB
	        + " )";
	
	    return retValue;
	}
}