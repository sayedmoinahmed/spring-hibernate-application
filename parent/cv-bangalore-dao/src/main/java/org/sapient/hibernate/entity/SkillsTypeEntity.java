package org.sapient.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "skills_type")
public class SkillsTypeEntity extends AbstractAuditEntity {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 6079425629911465275L;

	@Column(name = "skills_description", nullable = false, length = 256, insertable = true, updatable = true)
	private String description;

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
	    
	    retValue = "SkillsTypeEntity ( "
	        + super.toString() + TAB
	        + "description = " + this.description + TAB
	        + " )";
	
	    return retValue;
	}
}