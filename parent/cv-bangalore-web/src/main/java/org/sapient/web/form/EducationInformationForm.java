package org.sapient.web.form;

import java.io.Serializable;

import org.sapient.service.client.CourseName;
import org.sapient.service.client.CourseType;
import org.sapient.web.form.util.Address;
import org.sapient.web.form.util.GregorianCalendarFields;

public class EducationInformationForm implements Serializable{

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 712292996816839232L;
	
	private Long educationInfoId;
	private Long userId;
	private CourseType selectedCourseType;
	private CourseName selectedCourseName;
	/*private String courseName;*/
	private String specialization;
	private String institution;
	private String university;
	private GregorianCalendarFields yearOfJoining;
	private GregorianCalendarFields yearOfPassing;
	private String aggregate;
	private Address educationAddress;
	/**
	 * @return the educationInfoId
	 */
	public Long getEducationInfoId() {
		return educationInfoId;
	}
	/**
	 * @param educationInfoId the educationInfoId to set
	 */
	public void setEducationInfoId(Long educationInfoId) {
		this.educationInfoId = educationInfoId;
	}
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
	 * @return the selectedCourseType
	 */
	public CourseType getSelectedCourseType() {
		return selectedCourseType;
	}
	/**
	 * @param selectedCourseType the selectedCourseType to set
	 */
	public void setSelectedCourseType(CourseType selectedCourseType) {
		this.selectedCourseType = selectedCourseType;
	}
	
	/**
	 * @return the selectedCourseName
	 */
	public CourseName getSelectedCourseName() {
		return selectedCourseName;
	}
	/**
	 * @param selectedCourseName the selectedCourseName to set
	 */
	public void setSelectedCourseName(CourseName selectedCourseName) {
		this.selectedCourseName = selectedCourseName;
	}
	/**
	 * @return the specialization
	 */
	public String getSpecialization() {
		return specialization;
	}
	/**
	 * @param specialization the specialization to set
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	/**
	 * @return the institution
	 */
	public String getInstitution() {
		return institution;
	}
	/**
	 * @param institution the institution to set
	 */
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	/**
	 * @return the university
	 */
	public String getUniversity() {
		return university;
	}
	/**
	 * @param university the university to set
	 */
	public void setUniversity(String university) {
		this.university = university;
	}
	/**
	 * @return the yearOfJoining
	 */
	public GregorianCalendarFields getYearOfJoining() {
		return yearOfJoining;
	}
	/**
	 * @param yearOfJoining the yearOfJoining to set
	 */
	public void setYearOfJoining(GregorianCalendarFields yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	/**
	 * @return the yearOfPassing
	 */
	public GregorianCalendarFields getYearOfPassing() {
		return yearOfPassing;
	}
	/**
	 * @param yearOfPassing the yearOfPassing to set
	 */
	public void setYearOfPassing(GregorianCalendarFields yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}
	/**
	 * @return the aggregate
	 */
	public String getAggregate() {
		return aggregate;
	}
	/**
	 * @param aggregate the aggregate to set
	 */
	public void setAggregate(String aggregate) {
		this.aggregate = aggregate;
	}
	/**
	 * @return the educationAddress
	 */
	public Address getEducationAddress() {
		return educationAddress;
	}
	/**
	 * @param educationAddress the educationAddress to set
	 */
	public void setEducationAddress(Address educationAddress) {
		this.educationAddress = educationAddress;
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
	    
	    retValue = "EducationInformationForm ( "
	        + super.toString() + TAB
	        + "educationInfoId = " + this.educationInfoId + TAB
	        + "userId = " + this.userId + TAB
	        + "selectedCourseType = " + this.selectedCourseType + TAB
	        + "selectedCourseName = " + this.selectedCourseName + TAB
	        
	        + "specialization = " + this.specialization + TAB
	        + "institution = " + this.institution + TAB
	        + "university = " + this.university + TAB
	        + "yearOfJoining = " + this.yearOfJoining + TAB
	        + "yearOfPassing = " + this.yearOfPassing + TAB
	        + "aggregate = " + this.aggregate + TAB
	        + "educationAddress = " + this.educationAddress + TAB
	        + " )";
	
	    return retValue;
	}
	
}
