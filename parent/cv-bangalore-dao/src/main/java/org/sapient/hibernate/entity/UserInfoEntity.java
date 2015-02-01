package org.sapient.hibernate.entity;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.sapient.commons.types.EmploymentType;
import org.sapient.commons.types.UserStatus;

/**
 * @author psiva2
 * @version 1.0
 */
@Entity
@Table(name = "user_info")
public class UserInfoEntity extends AbstractAuditEntity {

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -6074315399764741773L;

	@Column(name = "oracle_id", nullable = false, insertable = true, updatable = false)
	private Long oracleId;

	@Column(name = "first_name", nullable = false, length = 64, insertable = true, updatable = true)
	private String firstName;

	@Column(name = "middle_name", nullable = true, length = 64, insertable = true, updatable = true)
	private String middleName;

	@Column(name = "last_name", nullable = false, length = 64, insertable = true, updatable = true)
	private String lastName;

	@Column(name = "father_name", nullable = false, length = 64, insertable = true, updatable = true)
	private String fatherName;

	@Column(name = "login_id", nullable = false, length = 16, insertable = true, updatable = false)
	private String loginId;

	@Column(name = "date_of_birth", nullable = false, insertable = true, updatable = true)
	private Calendar dateOfBirth;

	@Column(name = "date_of_joining", nullable = false, insertable = true, updatable = true)
	private Calendar dateOfJoining;

	@Enumerated(EnumType.STRING)
	@Column(name = "person_type", nullable = false, insertable = true, updatable = true)
	private EmploymentType personType;

	@Column(name = "designation", nullable = false, length = 128, insertable = true, updatable = true)
	private String designation;
	
	@Column(name = "supervisor_id", nullable = true, insertable = true, updatable = true)
	private Long supervisorId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "user_status", nullable = true, insertable = true, updatable = true)
	private UserStatus userStatus;
	
	@Column(name = "email_address", nullable = true, insertable = true, updatable = true)
	private String emailAddress;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_contact", joinColumns = { @JoinColumn(name = "user_info_id") }, inverseJoinColumns = { @JoinColumn(name = "contact_info_id") })
	private Set<ContactInfoEntity> contactDetails;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_education", joinColumns = { @JoinColumn(name = "user_info_id") }, inverseJoinColumns = { @JoinColumn(name = "education_info_id") })
	private Set<EducationInfoEntity> educationDetails;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_employment", joinColumns = { @JoinColumn(name = "user_info_id") }, inverseJoinColumns = { @JoinColumn(name = "employment_info_id") })
	private Set<EmploymentInfoEntity> employmentDetails;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_project", joinColumns = { @JoinColumn(name = "user_info_id") }, inverseJoinColumns = { @JoinColumn(name = "project_info_id") })
	private Set<ProjectInfoEntity> projectDetails;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_skills", joinColumns = { @JoinColumn(name = "user_info_id") }, inverseJoinColumns = { @JoinColumn(name = "skills_info_id") })
	private Set<SkillsInfoEntity> skillSets;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_profile", joinColumns = { @JoinColumn(name = "user_info_id") }, inverseJoinColumns = { @JoinColumn(name = "profile_summary_info_id") })
	private Set<ProfileSummaryInfoEntity> profileSummaryDetails;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_recognition", joinColumns = { @JoinColumn(name = "user_info_id") }, inverseJoinColumns = { @JoinColumn(name = "recognition_info_id") })
	private Set<RecognitionInfoEntity> recognitionDetails;

	/**
	 * @return the oracleId
	 */
	public Long getOracleId() {
		return oracleId;
	}

	/**
	 * @param oracleId the oracleId to set
	 */
	public void setOracleId(Long oracleId) {
		this.oracleId = oracleId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the dateOfJoining
	 */
	public Calendar getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(Calendar dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * @return the personType
	 */
	public EmploymentType getPersonType() {
		return personType;
	}

	/**
	 * @param personType the personType to set
	 */
	public void setPersonType(EmploymentType personType) {
		this.personType = personType;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the supervisorId
	 */
	public Long getSupervisorId() {
		return supervisorId;
	}

	/**
	 * @param supervisorId the supervisorId to set
	 */
	public void setSupervisorId(Long supervisorId) {
		this.supervisorId = supervisorId;
	}

	/**
	 * @return the userStatus
	 */
	public UserStatus getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the contactDetails
	 */
	public Set<ContactInfoEntity> getContactDetails() {
		return contactDetails;
	}

	/**
	 * @param contactDetails the contactDetails to set
	 */
	public void setContactDetails(Set<ContactInfoEntity> contactDetails) {
		this.contactDetails = contactDetails;
	}

	/**
	 * @return the educationDetails
	 */
	public Set<EducationInfoEntity> getEducationDetails() {
		return educationDetails;
	}

	/**
	 * @param educationDetails the educationDetails to set
	 */
	public void setEducationDetails(Set<EducationInfoEntity> educationDetails) {
		this.educationDetails = educationDetails;
	}

	/**
	 * @return the employmentDetails
	 */
	public Set<EmploymentInfoEntity> getEmploymentDetails() {
		return employmentDetails;
	}

	/**
	 * @param employmentDetails the employmentDetails to set
	 */
	public void setEmploymentDetails(Set<EmploymentInfoEntity> employmentDetails) {
		this.employmentDetails = employmentDetails;
	}

	/**
	 * @return the projectDetails
	 */
	public Set<ProjectInfoEntity> getProjectDetails() {
		return projectDetails;
	}

	/**
	 * @param projectDetails the projectDetails to set
	 */
	public void setProjectDetails(Set<ProjectInfoEntity> projectDetails) {
		this.projectDetails = projectDetails;
	}

	/**
	 * @return the skillSets
	 */
	public Set<SkillsInfoEntity> getSkillSets() {
		return skillSets;
	}

	/**
	 * @param skillSets the skillSets to set
	 */
	public void setSkillSets(Set<SkillsInfoEntity> skillSets) {
		this.skillSets = skillSets;
	}

	/**
	 * @return the profileSummaryDetails
	 */
	public Set<ProfileSummaryInfoEntity> getProfileSummaryDetails() {
		return profileSummaryDetails;
	}

	/**
	 * @param profileSummaryDetails the profileSummaryDetails to set
	 */
	public void setProfileSummaryDetails(
			Set<ProfileSummaryInfoEntity> profileSummaryDetails) {
		this.profileSummaryDetails = profileSummaryDetails;
	}

	/**
	 * @return the recognitionDetails
	 */
	public Set<RecognitionInfoEntity> getRecognitionDetails() {
		return recognitionDetails;
	}

	/**
	 * @param recognitionDetails the recognitionDetails to set
	 */
	public void setRecognitionDetails(Set<RecognitionInfoEntity> recognitionDetails) {
		this.recognitionDetails = recognitionDetails;
	}
}