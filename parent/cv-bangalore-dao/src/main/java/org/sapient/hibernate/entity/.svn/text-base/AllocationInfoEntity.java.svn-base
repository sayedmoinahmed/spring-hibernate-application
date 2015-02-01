/**
 * 
 */
package org.sapient.hibernate.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author komar
 * 
 */
@Entity
@Table(name = "allocation_info")
public class AllocationInfoEntity  {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 4349228785969635612L;

	@Id
	@Column(name = "oracle_id", nullable = false, insertable = true, updatable = false)
	private Long oracleId;

	@Column(name = "domain", nullable = true, insertable = true, updatable = true)
	private String domain;

	@Column(name = "pid", nullable = true, insertable = true, updatable = true)
	private String projectId;

	@Column(name = "project_name", nullable = true, insertable = true, updatable = true)
	private String projectName;

	@Column(name = "client_name", nullable = true, insertable = true, updatable = true)
	private String clientName;

	@Column(name = "team_name", nullable = true, insertable = true, updatable = true)
	private String teamName;

	@Column(name = "primary_project_capability", nullable = true, insertable = true, updatable = true)
	private String primaryProjectCapability;

	@Column(name = "revenue_subcategory", nullable = true, insertable = true, updatable = true)
	private String revenueSubCategory;

	@Column(name = "alloc_start_date", nullable = true, insertable = true, updatable = true)
	private String allocationStartDate;

	@Column(name = "alloc_end_date", nullable = true, insertable = true, updatable = true)
	private String allocationEndDate;

	@Column(name = "commitment", nullable = true, insertable = true, updatable = true)
	private String commitment;

	@Column(name = "revenue_group", nullable = true, insertable = true, updatable = true)
	private String revenueGroup;

	/**
	 * @return the oracleId
	 */
	public Long getOracleId() {
		return oracleId;
	}

	/**
	 * @param oracleId
	 *            the oracleId to set
	 */
	public void setOracleId(Long oracleId) {
		this.oracleId = oracleId;
	}

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain
	 *            the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId
	 *            the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName
	 *            the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName
	 *            the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the primaryProjectCapability
	 */
	public String getPrimaryProjectCapability() {
		return primaryProjectCapability;
	}

	/**
	 * @param primaryProjectCapability
	 *            the primaryProjectCapability to set
	 */
	public void setPrimaryProjectCapability(String primaryProjectCapability) {
		this.primaryProjectCapability = primaryProjectCapability;
	}

	/**
	 * @return the revenueSubCategory
	 */
	public String getRevenueSubCategory() {
		return revenueSubCategory;
	}

	/**
	 * @param revenueSubCategory
	 *            the revenueSubCategory to set
	 */
	public void setRevenueSubCategory(String revenueSubCategory) {
		this.revenueSubCategory = revenueSubCategory;
	}

	/**
	 * @return the allocationStartDate
	 */
	public String getAllocationStartDate() {
		return allocationStartDate;
	}

	/**
	 * @param allocationStartDate
	 *            the allocationStartDate to set
	 */
	public void setAllocationStartDate(String allocationStartDate) {
		this.allocationStartDate = allocationStartDate;
	}

	/**
	 * @return the allocationEndDate
	 */
	public String getAllocationEndDate() {
		return allocationEndDate;
	}

	/**
	 * @param allocationEndDate
	 *            the allocationEndDate to set
	 */
	public void setAllocationEndDate(String allocationEndDate) {
		this.allocationEndDate = allocationEndDate;
	}

	/**
	 * @return the commitment
	 */
	public String getCommitment() {
		return commitment;
	}

	/**
	 * @param commitment
	 *            the commitment to set
	 */
	public void setCommitment(String commitment) {
		this.commitment = commitment;
	}

	/**
	 * @return the revenueGroup
	 */
	public String getRevenueGroup() {
		return revenueGroup;
	}

	/**
	 * @param revenueGroup
	 *            the revenueGroup to set
	 */
	public void setRevenueGroup(String revenueGroup) {
		this.revenueGroup = revenueGroup;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	public String toString() {
		final String TAB = "    ";

		String retValue = "";

		retValue = "AllocationInfoEntity ( " + super.toString() + TAB
				+ "oracleId = " + this.oracleId + TAB + "domain = "
				+ this.domain + TAB + "projectId = " + this.projectId + TAB
				+ "projectName = " + this.projectName + TAB + "clientName = "
				+ this.clientName + TAB + "teamName = " + this.teamName + TAB
				+ "primaryProjectCapability = " + this.primaryProjectCapability
				+ TAB + "revenueSubCategory = " + this.revenueSubCategory + TAB
				+ "allocationStartDate = " + this.allocationStartDate + TAB
				+ "allocationEndDate = " + this.allocationEndDate + TAB
				+ "commitment = " + this.commitment + TAB + "revenueGroup = "
				+ this.revenueGroup + TAB + " )";

		return retValue;
	}

}
