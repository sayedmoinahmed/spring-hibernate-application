/**
 * 
 */
package org.sapient.web.form;

import java.io.Serializable;

import org.sapient.web.form.util.GregorianCalendarFields;

/**
 * @author brout
 * 
 */
public class ProjectInformationForm implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -7156917275843726349L;
	private Long projectInfoId;
	private Long userId;
	private String title;
	private String description;
	private GregorianCalendarFields startDate;
	private GregorianCalendarFields endDate;
	private String client;
	private String size;
	private String role;
	private String responsibilities;
	private String technologies;

	/**
	 * @return the projectInfoId
	 */
	public Long getProjectInfoId() {
		return projectInfoId;
	}

	/**
	 * @param projectInfoId
	 *            the projectInfoId to set
	 */
	public void setProjectInfoId(Long projectInfoId) {
		this.projectInfoId = projectInfoId;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
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
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the startDate
	 */
	public GregorianCalendarFields getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(GregorianCalendarFields startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public GregorianCalendarFields getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(GregorianCalendarFields endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
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
	 * @param responsibilities
	 *            the responsibilities to set
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
	 * @param technologies
	 *            the technologies to set
	 */
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}

}