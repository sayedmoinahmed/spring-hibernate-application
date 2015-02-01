/**
 * 
 */
package org.sapient.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.sapient.commons.types.ProficiencyLevelType;

/**
 * @author psiva2
 * 
 */
@Entity
@Table(name = "skills_info")
public class SkillsInfoEntity extends AbstractAuditEntity {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -1935103734764820746L;

	@Column(name = "skill_type_id", nullable = false, insertable = true, updatable = true)
	private Long skillTypeId;

	@ManyToOne
	@JoinColumn(name = "skill_type_id", nullable = false, insertable = false, updatable = false)
	private SkillsTypeEntity skillsType;

	@Column(name = "skill_items", nullable = false, length = 512, insertable = true, updatable = true)
	private String items;

	@Enumerated(EnumType.STRING)
	@Column(name = "proficiency_level", nullable = false, insertable = true, updatable = true)
	private ProficiencyLevelType proficienyLevel;


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
	 * @return the skillsType
	 */
	public SkillsTypeEntity getSkillsType() {
		return skillsType;
	}

	/**
	 * @param skillsType the skillsType to set
	 */
	public void setSkillsType(SkillsTypeEntity skillsType) {
		this.skillsType = skillsType;
	}

	/**
	 * @return the items
	 */
	public String getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(String items) {
		this.items = items;
	}

	/**
	 * @return the proficienyLevel
	 */
	public ProficiencyLevelType getProficienyLevel() {
		return proficienyLevel;
	}

	/**
	 * @param proficienyLevel the proficienyLevel to set
	 */
	public void setProficienyLevel(ProficiencyLevelType proficienyLevel) {
		this.proficienyLevel = proficienyLevel;
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
	    
	    retValue = "SkillsInfoEntity ( "
	        + super.toString() + TAB
	        + "skillTypeId = " + this.skillTypeId + TAB
	        + "skillsType = " + this.skillsType + TAB
	        + "items = " + this.items + TAB
	        + "proficienyLevel = " + this.proficienyLevel + TAB
	        + " )";
	
	    return retValue;
	}
}