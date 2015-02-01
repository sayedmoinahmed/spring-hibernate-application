package org.spring.batch.domain;

import java.io.Serializable;
import java.util.Calendar;

public class PersonalData implements Serializable{

	/** Generated SerialVersionUID */
	private static final long serialVersionUID = -1856387783436605758L;
	
	private Calendar fullDate;
	private Long oracleId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String personType;
	private String titleName;
	private Long supervisorId;
	private String supervisorName;
	private String fatherName;
	private Calendar dateofBirth;
	private String loginName;
	private Calendar startDate;
	private Calendar termDate;
	private String email;
	private String div;
	private String bu;
	private String hrmsTeam;
	private String organization;
	private String homeOff;
	private String currOff;
	private String company;
	private Long costCenterCode;
	private String costCenterName;
	private String homeRegion;
	private String currentRegion;
	private String businessFocus;
	private String primaryCapability;
	private String capacityType;
	private String utilizationTarget;
	private String revenueTarget;
	private String profitTarget;
	private Character loaRetrunFlag;
	private String category; 
	private String status;
	private Character staiFlag;
	private String careerStage; 
	private Calendar lastPromotionDate;
	private Float timeSinceLastPromotion;
	private Long cmId;
	private String cm;
	private String cmBu;
	private String cmTitle;
	private Character relocationFlag;
	private String gender;
	private String maritalStatus;
	private String nationality;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String city;
	private String county;
	private String state;
	private String postalCode;
	private String country;
	private String homePhone;
	private Calendar lastCompetencyUpdate;
	private String domain;
	private String pid;
	private String projectName;
	private String clientName;
	private String teamName;
	private String primaryProjectCapability;
	private String revenueSubCategory;
	private String allocStartDate;
	private String allocEndDate;
	private String commitment;
	private String revenueGroup;
	
	
	/**
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}
	/**
	 * @param county the county to set
	 */
	public void setCounty(String county) {
		this.county = county;
	}
	/**
	 * @return the oracleId
	 */
	public Long getOracleId() {
		return oracleId;
	}
	/**
	 * @return the termDate
	 */
	public Calendar getTermDate() {
		return termDate;
	}
	/**
	 * @param termDate the termDate to set
	 */
	public void setTermDate(Calendar termDate) {
		this.termDate = termDate;
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
	 * @return the personType
	 */
	public String getPersonType() {
		return personType;
	}
	/**
	 * @param personType the personType to set
	 */
	public void setPersonType(String personType) {
		this.personType = personType;
	}
	/**
	 * @return the titleName
	 */
	public String getTitleName() {
		return titleName;
	}
	/**
	 * @param titleName the titleName to set
	 */
	public void setTitleName(String titleName) {
		this.titleName = titleName;
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
	 * @return the supervisorName
	 */
	public String getSupervisorName() {
		return supervisorName;
	}
	/**
	 * @param supervisorName the supervisorName to set
	 */
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
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
	 * @return the dateofBirth
	 */
	public Calendar getDateofBirth() {
		return dateofBirth;
	}
	/**
	 * @param dateofBirth the dateofBirth to set
	 */
	public void setDateofBirth(Calendar dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * @return the startDate
	 */
	public Calendar getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getFullDate() {
		return fullDate;
	}
	public void setFullDate(Calendar fullDate) {
		this.fullDate = fullDate;
	}
	public String getDiv() {
		return div;
	}
	public void setDiv(String div) {
		this.div = div;
	}
	public String getBu() {
		return bu;
	}
	public void setBu(String bu) {
		this.bu = bu;
	}
	public String getHrmsTeam() {
		return hrmsTeam;
	}
	public void setHrmsTeam(String hrmsTeam) {
		this.hrmsTeam = hrmsTeam;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getHomeOff() {
		return homeOff;
	}
	public void setHomeOff(String homeOff) {
		this.homeOff = homeOff;
	}
	public String getCurrOff() {
		return currOff;
	}
	public void setCurrOff(String currOff) {
		this.currOff = currOff;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getCostCenterName() {
		return costCenterName;
	}
	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}
	public String getHomeRegion() {
		return homeRegion;
	}
	public void setHomeRegion(String homeRegion) {
		this.homeRegion = homeRegion;
	}
	public String getCurrentRegion() {
		return currentRegion;
	}
	public void setCurrentRegion(String currentRegion) {
		this.currentRegion = currentRegion;
	}
	public String getBusinessFocus() {
		return businessFocus;
	}
	public void setBusinessFocus(String businessFocus) {
		this.businessFocus = businessFocus;
	}
	public String getPrimaryCapability() {
		return primaryCapability;
	}
	public void setPrimaryCapability(String primaryCapability) {
		this.primaryCapability = primaryCapability;
	}
	public String getCapacityType() {
		return capacityType;
	}
	public void setCapacityType(String capacityType) {
		this.capacityType = capacityType;
	}
	public String getUtilizationTarget() {
		return utilizationTarget;
	}
	public void setUtilizationTarget(String utilizationTarget) {
		this.utilizationTarget = utilizationTarget;
	}
	
	public String getProfitTarget() {
		return profitTarget;
	}
	public void setProfitTarget(String profitTarget) {
		this.profitTarget = profitTarget;
	}
	public Character getLoaRetrunFlag() {
		return loaRetrunFlag;
	}
	public void setLoaRetrunFlag(Character loaRetrunFlag) {
		this.loaRetrunFlag = loaRetrunFlag;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Character getStaiFlag() {
		return staiFlag;
	}
	public void setStaiFlag(Character staiFlag) {
		this.staiFlag = staiFlag;
	}
	public String getCareerStage() {
		return careerStage;
	}
	public void setCareerStage(String careerStage) {
		this.careerStage = careerStage;
	}
	public Calendar getLastPromotionDate() {
		return lastPromotionDate;
	}
	public void setLastPromotionDate(Calendar lastPromotionDate) {
		this.lastPromotionDate = lastPromotionDate;
	}
	public Float getTimeSinceLastPromotion() {
		return timeSinceLastPromotion;
	}
	public void setTimeSinceLastPromotion(Float timeSinceLastPromotion) {
		this.timeSinceLastPromotion = timeSinceLastPromotion;
	}
	public Long getCmId() {
		return cmId;
	}
	public void setCmId(Long cmId) {
		this.cmId = cmId;
	}
	public String getCm() {
		return cm;
	}
	public void setCm(String cm) {
		this.cm = cm;
	}
	public String getCmBu() {
		return cmBu;
	}
	public void setCmBu(String cmBu) {
		this.cmBu = cmBu;
	}
	public String getCmTitle() {
		return cmTitle;
	}
	public void setCmTitle(String cmTitle) {
		this.cmTitle = cmTitle;
	}
	public Character getRelocationFlag() {
		return relocationFlag;
	}
	public void setRelocationFlag(Character relocationFlag) {
		this.relocationFlag = relocationFlag;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public Calendar getLastCompetencyUpdate() {
		return lastCompetencyUpdate;
	}
	public void setLastCompetencyUpdate(Calendar lastCompetencyUpdate) {
		this.lastCompetencyUpdate = lastCompetencyUpdate;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getPrimaryProjectCapability() {
		return primaryProjectCapability;
	}
	public void setPrimaryProjectCapability(String primaryProjectCapability) {
		this.primaryProjectCapability = primaryProjectCapability;
	}
	public String getRevenueSubCategory() {
		return revenueSubCategory;
	}
	public void setRevenueSubCategory(String revenueSubCategory) {
		this.revenueSubCategory = revenueSubCategory;
	}
	public String getAllocStartDate() {
		return allocStartDate;
	}
	public void setAllocStartDate(String allocStartDate) {
		/*Date d = allocStartDate.toGregorianCalendar().getTime();
		String allocationStartDate  = new SimpleDateFormat("dd-MMM-yyyy").format(d);
		*/this.allocStartDate = allocStartDate;
	}
	public String getAllocEndDate() {
		return allocEndDate;
	}
	public void setAllocEndDate(String allocEndDate) {
		/*Date d = allocEndDate.toGregorianCalendar().getTime();
		String allocationEndDate  = new SimpleDateFormat("dd-MMM-yyyy").format(d);
		*/this.allocStartDate = allocEndDate;
	}
	public String getCommitment() {
		return commitment;
	}
	public void setCommitment(String commitment) {
		this.commitment = commitment;
	}
	public String getRevenueGroup() {
		return revenueGroup;
	}
	public void setRevenueGroup(String revenueGroup) {
		this.revenueGroup = revenueGroup;
	}
	public Long getCostCenterCode() {
		return costCenterCode;
	}
	/**
	 * @param costCenterCode the costCenterCode to set
	 */
	public void setCostCenterCode(Long costCenterCode) {
		this.costCenterCode = costCenterCode;
	}
	/**
	 * @return the revenueTarget
	 */
	public String getRevenueTarget() {
		return revenueTarget;
	}
	/**
	 * @param revenueTarget the revenueTarget to set
	 */
	public void setRevenueTarget(String revenueTarget) {
		this.revenueTarget = revenueTarget;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonalData [fullDate=" + fullDate + ", oracleId=" + oracleId
				+ ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", personType=" + personType
				+ ", titleName=" + titleName + ", supervisorId=" + supervisorId
				+ ", supervisorName=" + supervisorName + ", fatherName="
				+ fatherName + ", dateofBirth=" + dateofBirth + ", loginName="
				+ loginName + ", startDate=" + startDate + ", termDate="
				+ termDate + ", email=" + email + ", div=" + div + ", bu=" + bu
				+ ", hrmsTeam=" + hrmsTeam + ", organization=" + organization
				+ ", homeOff=" + homeOff + ", currOff=" + currOff
				+ ", company=" + company + ", costCenterCode=" + costCenterCode
				+ ", costCenterName=" + costCenterName + ", homeRegion="
				+ homeRegion + ", currentRegion=" + currentRegion
				+ ", businessFocus=" + businessFocus + ", primaryCapability="
				+ primaryCapability + ", capacityType=" + capacityType
				+ ", utilizationTarget=" + utilizationTarget
				+ ", revenueTarget=" + revenueTarget + ", profitTarget="
				+ profitTarget + ", loaRetrunFlag=" + loaRetrunFlag
				+ ", category=" + category + ", status=" + status
				+ ", staiFlag=" + staiFlag + ", careerStage=" + careerStage
				+ ", lastPromotionDate=" + lastPromotionDate
				+ ", timeSinceLastPromotion=" + timeSinceLastPromotion
				+ ", cmId=" + cmId + ", cm=" + cm + ", cmBu=" + cmBu
				+ ", cmTitle=" + cmTitle + ", relocationFlag=" + relocationFlag
				+ ", gender=" + gender + ", maritalStatus=" + maritalStatus
				+ ", nationality=" + nationality + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2
				+ ", addressLine3=" + addressLine3 + ", city=" + city
				+ ", country=" + country + ", state=" + state + ", postalCode="
				+ postalCode + ", homePhone=" + homePhone
				+ ", lastCompetencyUpdate=" + lastCompetencyUpdate
				+ ", domain=" + domain + ", pid=" + pid + ", projectName="
				+ projectName + ", clientName=" + clientName + ", teamName="
				+ teamName + ", primaryProjectCapability="
				+ primaryProjectCapability + ", revenueSubCategory="
				+ revenueSubCategory + ", allocStartDate=" + allocStartDate
				+ ", allocEndDate=" + allocEndDate + ", commitment="
				+ commitment + ", revenueGroup=" + revenueGroup + "]";
	}
	
}