package org.sapient.hibernate.entity;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.sapient.commons.types.CourseName;
import org.sapient.commons.types.CourseType;

@Entity
@Table(name = "education_info")
public class EducationInfoEntity extends AbstractAuditEntity {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = 5926263489124840310L;

	@Enumerated(EnumType.STRING)
	@Column(name = "course_type", nullable = false, length = 128, insertable = true, updatable = true)
	private CourseType courseType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "course_name", nullable = false, length = 128, insertable = true, updatable = true)
	private CourseName courseName;

	@Column(name = "course_specialization", nullable = true, length = 128, insertable = true, updatable = true)
	private String specialization;

	@Column(name = "institution", nullable = true, length = 128, insertable = true, updatable = true)
	private String institution;
	
	@Column(name = "course_university", nullable = true, length = 128, insertable = true, updatable = true)
	private String university;

	@Column(name = "year_of_joining", nullable = false, insertable = true, updatable = true)
	private Calendar yearofJoining;

	@Column(name = "year_of_completion", nullable = false, insertable = true, updatable = true)
	private Calendar yearOfPassing;

	@Column(name = "aggregate", nullable = false, insertable = true, updatable = true)
	private Double aggregate;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "education_address", joinColumns = { @JoinColumn(name = "education_info_id") }, inverseJoinColumns = { @JoinColumn(name = "address_info_id") })
	private Set<AddressInfoEntity> addressDetails;

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
	 * @return the yearofJoining
	 */
	public Calendar getYearofJoining() {
		return yearofJoining;
	}

	/**
	 * @param yearofJoining the yearofJoining to set
	 */
	public void setYearofJoining(Calendar yearofJoining) {
		this.yearofJoining = yearofJoining;
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
	public Set<AddressInfoEntity> getAddressDetails() {
		return addressDetails;
	}

	/**
	 * @param addressDetails the addressDetails to set
	 */
	public void setAddressDetails(Set<AddressInfoEntity> addressDetails) {
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
	    
	    retValue = "EducationInfoEntity ( "
	        + super.toString() + TAB
	        + "courseType = " + this.courseType + TAB
	        + "courseName = " + this.courseName + TAB
	        + "specialization = " + this.specialization + TAB
	        + "institution = " + this.institution + TAB
	        + "university = " + this.university + TAB
	        + "yearofJoining = " + this.yearofJoining + TAB
	        + "yearOfPassing = " + this.yearOfPassing + TAB
	        + "aggregate = " + this.aggregate + TAB
	        + "addressDetails = " + this.addressDetails + TAB
	        + " )";
	
	    return retValue;
	}
}