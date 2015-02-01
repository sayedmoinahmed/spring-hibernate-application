/**
 * 
 */
package org.sapient.hibernate.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author psiva2
 * @version 1.0
 */
@MappedSuperclass
public class AbstractAuditEntity implements Serializable{

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 8429098138392953701L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "created_by", nullable = false, insertable = true, updatable = false)
	private Long createdBy;
	
	@Column(name = "created_date", nullable = false, insertable = true, updatable = false)
	private Calendar createdDate;
	
	@Column(name = "updated_by", nullable = true, insertable = true, updatable = true)
	private Long updatedBy;
	
	@Column(name = "updated_date", nullable = true, insertable = true, updatable = true)
	private Calendar updatedDate;

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
	 * @return the createdBy
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Calendar getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedBy
	 */
	public Long getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedDate
	 */
	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
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
	    
	    retValue = "AbstractAuditEntity ( "
	        + super.toString() + TAB
	        + "id = " + this.id + TAB
	        + "createdBy = " + this.createdBy + TAB
	        + "createdDate = " + this.createdDate + TAB
	        + "updatedBy = " + this.updatedBy + TAB
	        + "updatedDate = " + this.updatedDate + TAB
	        + " )";
	
	    return retValue;
	}

}