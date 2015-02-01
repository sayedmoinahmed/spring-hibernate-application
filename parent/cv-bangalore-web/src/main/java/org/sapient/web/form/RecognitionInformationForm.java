package org.sapient.web.form;

import java.io.Serializable;

/**
 * @author pdandi
 * 
 */
public class RecognitionInformationForm implements Serializable{

	/**
	 * Generated SerialVersionUID
	 */
	private static final long serialVersionUID = -817280760082225895L;
	private Long recognitionInfoId;
	private Long recognitionTypeId;
	private String recognitionType;
	private String items;
	/**
	 * @return the recognitionInfoId
	 */
	public Long getRecognitionInfoId() {
		return recognitionInfoId;
	}
	/**
	 * @param recognitionInfoId the recognitionInfoId to set
	 */
	public void setRecognitionInfoId(Long recognitionInfoId) {
		this.recognitionInfoId = recognitionInfoId;
	}
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
	public String getRecognitionType() {
		return recognitionType;
	}
	/**
	 * @param recognitionType the recognitionType to set
	 */
	public void setRecognitionType(String recognitionType) {
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
	    
	    retValue = "RecognitionInformationForm ( "
	        + super.toString() + TAB
	        + "recognitionInfoId = " + this.recognitionInfoId + TAB
	        + "recognitionTypeId = " + this.recognitionTypeId + TAB
	        + "recognitionType = " + this.recognitionType + TAB
	        + "items = " + this.items + TAB
	        + " )";
	
	    return retValue;
	}
}
