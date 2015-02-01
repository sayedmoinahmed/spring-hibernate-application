package org.sapient.service.beans;

import java.io.Serializable;

public class RecognitionInfoVO implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 6992680327951068376L;
	
	private Long userId;
	private Long recognitionInfoId;
	private RecognitionTypeVO recognitionType;
	private String items;
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
	 * @return the recognitionType
	 */
	public RecognitionTypeVO getRecognitionType() {
		return recognitionType;
	}
	/**
	 * @param recognitionType the recognitionType to set
	 */
	public void setRecognitionType(RecognitionTypeVO recognitionType) {
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
	    
	    retValue = "RecognitionInfoVO ( "
	        + super.toString() + TAB
	        + "userId = " + this.userId + TAB
	        + "recognitionInfoId = " + this.recognitionInfoId + TAB
	        + "recognitionType = " + this.recognitionType + TAB
	        + "items = " + this.items + TAB
	        + " )";
	
	    return retValue;
	}
}