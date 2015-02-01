/**
 * 
 */
package org.sapient.hibernate.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author psiva2
 * 
 */
@Entity
@Table(name = "project_info")
public class ProjectInfoEntity extends AbstractAuditEntity {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 980392632406905000L;

	@Column(name = "project_title", nullable = false, length = 128, insertable = true, updatable = true)
	private String title;

	@Column(name = "project_description", nullable = false, length = 1024, insertable = true, updatable = true)
	private String description;

	@Column(name = "project_start_date", nullable = false, insertable = true, updatable = true)
	private Calendar startDate;

	@Column(name = "project_end_date", nullable = true, insertable = true, updatable = true)
	private Calendar endDate;

	@Column(name = "project_client", nullable = true, length = 128, insertable = true, updatable = true)
	private String client;

	@Column(name = "project_team_size", nullable = false, insertable = true, updatable = true)
	private Integer size;

	@Column(name = "project_role", nullable = false, length = 512, insertable = true, updatable = true)
	private String role;

	@Column(name = "project_responsibilities", nullable = true, length = 1024, insertable = true, updatable = true)
	private String responsibilities;

	@Column(name = "key_technologies", nullable = false, length = 1024, insertable = true, updatable = true)
	private String technologies;

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
	 * @return the startDate
	 */
	public Calendar getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Calendar getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the responsibilities
	 */
	public String getResponsibilities() {
		return responsibilities;
	}

	/**
	 * @param responsibilities the responsibilities to set
	 */
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	/**
	 * @return the technologies
	 */
	public String getTechnologies() {
		return technologies;
	}

	/**
	 * @param technologies the technologies to set
	 */
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
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
	    
	    retValue = "ProjectInfoEntity ( "
	        + super.toString() + TAB
	        + "title = " + this.title + TAB
	        + "description = " + this.description + TAB
	        + "startDate = " + this.startDate + TAB
	        + "endDate = " + this.endDate + TAB
	        + "client = " + this.client + TAB
	        + "size = " + this.size + TAB
	        + "role = " + this.role + TAB
	        + "responsibilities = " + this.responsibilities + TAB
	        + "technologies = " + this.technologies + TAB
	        + " )";
	
	    return retValue;
	}
}