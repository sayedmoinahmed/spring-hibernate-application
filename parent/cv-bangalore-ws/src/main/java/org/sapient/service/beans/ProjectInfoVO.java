package org.sapient.service.beans;

import java.io.Serializable;
import java.util.Calendar;

public class ProjectInfoVO implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 2471981993883560452L;
	
	private Long userId;
	private Long projectInfoId;
	private String title;
	private String description;
	private Calendar startDate;
	private Calendar endDate;
	private String client;
	private Integer size;
	private String role;
	private String responsibilities;
	private String technologies;
	
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the projectInfoId
	 */
	public Long getProjectInfoId() {
		return projectInfoId;
	}

	/**
	 * @param projectInfoId the projectInfoId to set
	 */
	public void setProjectInfoId(Long projectInfoId) {
		this.projectInfoId = projectInfoId;
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
	    
	    retValue = "ProjectInfoVO ( "
	        + super.toString() + TAB
	        + "userId = " + this.userId + TAB
	        + "projectInfoId = " + this.projectInfoId + TAB
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