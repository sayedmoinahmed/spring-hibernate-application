/**
 * 
 */
package org.sapient.hibernate.entity;
import java.io.Serializable;
import java.util.Calendar;

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
@Table(name = "assignment_info")
public class AssignmentInfoEntity {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -5458424343399467096L;

	@Id
	@Column(name = "oracle_id")
	private Long oracleId;

	@Column(name = "status", nullable = false, insertable = true, updatable = true)
	private String status;

	@Column(name = "stai_flag", nullable = false, insertable = true, updatable = true)
	private Character staiFlag;

	@Column(name = "title_name", nullable = false, insertable = true, updatable = true)
	private String titleName;

	@Column(name = "career_stage", nullable = false, insertable = true, updatable = true)
	private String careerStage;

	@Column(name = "last_promotion_date", nullable = true, insertable = true, updatable = true)
	private Calendar lastPromotionDate;

	@Column(name = "time_since_last_promotion", nullable = true, insertable = true, updatable = true)
	private Float timeSinceLastPromotion;

	@Column(name = "cm_id", nullable = true, insertable = true, updatable = true)
	private Long cmId;

	@Column(name = "cm", nullable = true, insertable = true, updatable = true)
	private String cm;

	@Column(name = "cm_bu", nullable = true, insertable = true, updatable = true)
	private String cmBu;

	@Column(name = "cm_title", nullable = true, insertable = true, updatable = true)
	private String cmTitle;

	@Column(name = "supervisor_id", nullable = true, insertable = true, updatable = true)
	private Long supervisorId;

	@Column(name = "supervisor", nullable = true, insertable = true, updatable = true)
	private String supervisor;

	@Column(name = "relocation_flag", nullable = true, insertable = true, updatable = true)
	private Character relocationFlag;

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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the staiFlag
	 */
	public Character getStaiFlag() {
		return staiFlag;
	}

	/**
	 * @param staiFlag
	 *            the staiFlag to set
	 */
	public void setStaiFlag(Character staiFlag) {
		this.staiFlag = staiFlag;
	}

	/**
	 * @return the titleName
	 */
	public String getTitleName() {
		return titleName;
	}

	/**
	 * @param titleName
	 *            the titleName to set
	 */
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	/**
	 * @return the careerStage
	 */
	public String getCareerStage() {
		return careerStage;
	}

	/**
	 * @param careerStage
	 *            the careerStage to set
	 */
	public void setCareerStage(String careerStage) {
		this.careerStage = careerStage;
	}

	/**
	 * @return the lastPromotionDate
	 */
	public Calendar getLastPromotionDate() {
		return lastPromotionDate;
	}

	/**
	 * @param lastPromotionDate
	 *            the lastPromotionDate to set
	 */
	public void setLastPromotionDate(Calendar lastPromotionDate) {
		this.lastPromotionDate = lastPromotionDate;
	}

	/**
	 * @return the timeSinceLastPromotion
	 */
	public Float getTimeSinceLastPromotion() {
		return timeSinceLastPromotion;
	}

	/**
	 * @param timeSinceLastPromotion
	 *            the timeSinceLastPromotion to set
	 */
	public void setTimeSinceLastPromotion(Float timeSinceLastPromotion) {
		this.timeSinceLastPromotion = timeSinceLastPromotion;
	}

	/**
	 * @return the cmId
	 */
	public Long getCmId() {
		return cmId;
	}

	/**
	 * @param cmId
	 *            the cmId to set
	 */
	public void setCmId(Long cmId) {
		this.cmId = cmId;
	}

	/**
	 * @return the cm
	 */
	public String getCm() {
		return cm;
	}

	/**
	 * @param cm
	 *            the cm to set
	 */
	public void setCm(String cm) {
		this.cm = cm;
	}

	/**
	 * @return the cmBu
	 */
	public String getCmBu() {
		return cmBu;
	}

	/**
	 * @param cmBu
	 *            the cmBu to set
	 */
	public void setCmBu(String cmBu) {
		this.cmBu = cmBu;
	}

	/**
	 * @return the cmTitle
	 */
	public String getCmTitle() {
		return cmTitle;
	}

	/**
	 * @param cmTitle
	 *            the cmTitle to set
	 */
	public void setCmTitle(String cmTitle) {
		this.cmTitle = cmTitle;
	}

	/**
	 * @return the supervisorId
	 */
	public Long getSupervisorId() {
		return supervisorId;
	}

	/**
	 * @param supervisorId
	 *            the supervisorId to set
	 */
	public void setSupervisorId(Long supervisorId) {
		this.supervisorId = supervisorId;
	}

	/**
	 * @return the supervisor
	 */
	public String getSupervisor() {
		return supervisor;
	}

	/**
	 * @param supervisor
	 *            the supervisor to set
	 */
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	/**
	 * @return the relocationFlag
	 */
	public Character getRelocationFlag() {
		return relocationFlag;
	}

	/**
	 * @param relocationFlag
	 *            the relocationFlag to set
	 */
	public void setRelocationFlag(Character relocationFlag) {
		this.relocationFlag = relocationFlag;
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

		retValue = "AssignmentInfoEntity ( " + super.toString() + TAB
				+ "oracleId = " + this.oracleId + TAB + "status = "
				+ this.status + TAB + "staiFlag = " + this.staiFlag + TAB
				+ "titleName = " + this.titleName + TAB + "careerStage = "
				+ this.careerStage + TAB + "lastPromotionDate = "
				+ this.lastPromotionDate + TAB + "timeSinceLastPromotion = "
				+ this.timeSinceLastPromotion + TAB + "cmId = " + this.cmId
				+ TAB + "cm = " + this.cm + TAB + "cmBu = " + this.cmBu + TAB
				+ "cmTitle = " + this.cmTitle + TAB + "supervisorId = "
				+ this.supervisorId + TAB + "supervisor = " + this.supervisor
				+ TAB + "relocationFlag = " + this.relocationFlag + TAB + " )";

		return retValue;
	}

}
