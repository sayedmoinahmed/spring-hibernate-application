/**
 * 
 */
package org.sapient.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Prabu Sivakumar
 * 
 */
@Entity
@Table(name = "recognition_info")
public class RecognitionInfoEntity extends AbstractAuditEntity {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 3024741189352536056L;

	@Column(name = "recognition_type_id", nullable = false, insertable = true, updatable = true)
	private Long recognitionTypeId;

	@ManyToOne
	@JoinColumn(name = "recognition_type_id", nullable = false, insertable = false, updatable = false)
	private RecognitionTypeEntity recognitionType;

	@Column(name = "recognition_items", nullable = false, length = 512, insertable = true, updatable = true)
	private String items;

	/**
	 * @return the recognitionTypeId
	 */
	public Long getRecognitionTypeId() {
		return recognitionTypeId;
	}

	/**
	 * @param recognitionTypeId the recognitionTypeId to set
	 */
	public void setRecognitionTypeId(Long recognitionTypeId) {
		this.recognitionTypeId = recognitionTypeId;
	}

	/**
	 * @return the recognitionType
	 */
	public RecognitionTypeEntity getRecognitionType() {
		return recognitionType;
	}

	/**
	 * @param recognitionType the recognitionType to set
	 */
	public void setRecognitionType(RecognitionTypeEntity recognitionType) {
		this.recognitionType = recognitionType;
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
	    
	    retValue = "RecognitionInfoEntity ( "
	        + super.toString() + TAB
	        + "recognitionTypeId = " + this.recognitionTypeId + TAB
	        + "recognitionType = " + this.recognitionType + TAB
	        + "items = " + this.items + TAB
	        + " )";
	
	    return retValue;
	}

}