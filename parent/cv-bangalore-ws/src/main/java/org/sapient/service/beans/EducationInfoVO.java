package org.sapient.service.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import org.sapient.commons.types.CourseName;
import org.sapient.commons.types.CourseType;

public class EducationInfoVO implements Serializable {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -2142264065000605586L;

	private Long userId;
	private Long educationInfoId;
	private CourseType courseType;
	private CourseName courseName;
	private String institution;
	private String specialization;
	private String university;
	private Calendar yearOfJoining;
	private Calendar yearOfPassing;
	private Double aggregate;
	private Set<AddressInfoVO> addressDetails;
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
	 * @return the courseType
	 */
	public CourseType getCourseType() {
		return courseType;
	}
	/**
	 * @param courseType the courseType to set
	 */
	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}
	/**
	 * @return the courseName
	 */
	public CourseName getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(CourseName courseName) {
		this.courseName = courseName;
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
	public Calendar getYearOfJoining() {
		return yearOfJoining;
	}
	/**
	 * @param yearOfJoining the yearOfJoining to set
	 */
	public void setYearOfJoining(Calendar yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	/**
	 * @return the yearOfPassing
	 */
	public Calendar getYearOfPassing() {
		return yearOfPassing;
	}
	/**
	 * @param yearOfPassing the yearOfPassing to set
	 */
	public void setYearOfPassing(Calendar yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}
	/**
	 * @return the aggregate
	 */
	public Double getAggregate() {
		return aggregate;
	}
	/**
	 * @param aggregate the aggregate to set
	 */
	public void setAggregate(Double aggregate) {
		this.aggregate = aggregate;
	}
	/**
	 * @return the addressDetails
	 */
	public Set<AddressInfoVO> getAddressDetails() {
		return addressDetails;
	}
	/**
	 * @param addressDetails the addressDetails to set
	 */
	public void setAddressDetails(Set<AddressInfoVO> addressDetails) {
		this.addressDetails = addressDetails;
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
	    
	    retValue = "EducationInfoVO ( "
	        + super.toString() + TAB
	        + "userId = " + this.userId + TAB
	        + "educationInfoId = " + this.educationInfoId + TAB
	        + "courseType = " + this.courseType + TAB
	        + "courseName = " + this.courseName + TAB
	        + "institution = " + this.institution + TAB
	        + "specialization = " + this.specialization + TAB
	        + "university = " + this.university + TAB
	        + "yearOfJoining = " + this.yearOfJoining + TAB
	        + "yearOfPassing = " + this.yearOfPassing + TAB
	        + "aggregate = " + this.aggregate + TAB
	        + "addressDetails = " + this.addressDetails + TAB
	        + " )";
	
	    return retValue;
	}
}