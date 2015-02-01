package org.sapient.batch.factory;


import org.sapient.hibernate.entity.AllocationInfoEntity;
import org.sapient.hibernate.entity.AssignmentInfoEntity;
import org.sapient.hibernate.entity.OrganizationInfoEntity;
import org.sapient.hibernate.entity.PersonalInfoEntity;
import org.spring.batch.domain.PersonalData;

public class EntityFactory {
	
	public Object getEntity(PersonalData personalData , String entityType)
	{
		Object entityObject = null;
		if(entityType.equals("allocationInfoEntity"))
		{
			AllocationInfoEntity allocationInfoEntity = new AllocationInfoEntity();
			allocationInfoEntity.setOracleId(personalData.getOracleId());
			allocationInfoEntity.setDomain(personalData.getDomain());
			allocationInfoEntity.setProjectId(personalData.getPid());
			allocationInfoEntity.setProjectName(personalData.getProjectName());
			allocationInfoEntity.setClientName(personalData.getClientName());
			allocationInfoEntity.setTeamName(personalData.getTeamName());
			allocationInfoEntity.setPrimaryProjectCapability(personalData.getPrimaryProjectCapability());
			allocationInfoEntity.setRevenueSubCategory(personalData.getRevenueSubCategory());
			allocationInfoEntity.setAllocationStartDate(personalData.getAllocStartDate());
			allocationInfoEntity.setAllocationEndDate(personalData.getAllocEndDate());
			allocationInfoEntity.setCommitment(personalData.getCommitment());
			allocationInfoEntity.setRevenueGroup(personalData.getRevenueGroup());
			entityObject = allocationInfoEntity;
			
		}else
		if(entityType.equals("assignmentInfoEntity"))
		{
			AssignmentInfoEntity assignmentInfoEntity = new AssignmentInfoEntity();
			assignmentInfoEntity.setOracleId(personalData.getOracleId());
			assignmentInfoEntity.setStatus(personalData.getStatus());
			assignmentInfoEntity.setStaiFlag(personalData.getStaiFlag());
			assignmentInfoEntity.setTitleName(personalData.getTitleName());
			assignmentInfoEntity.setCareerStage(personalData.getCareerStage());
			assignmentInfoEntity.setLastPromotionDate(personalData.getLastPromotionDate());
			assignmentInfoEntity.setTimeSinceLastPromotion(personalData.getTimeSinceLastPromotion());
			assignmentInfoEntity.setCmId(personalData.getCmId());
			assignmentInfoEntity.setCm(personalData.getCm());
			assignmentInfoEntity.setCmBu(personalData.getCmBu());
			assignmentInfoEntity.setCmTitle(personalData.getCmTitle());
			assignmentInfoEntity.setSupervisorId(personalData.getSupervisorId());
			assignmentInfoEntity.setSupervisor(personalData.getSupervisorName());
			assignmentInfoEntity.setRelocationFlag(personalData.getRelocationFlag());
			
			entityObject = assignmentInfoEntity;
			
		}else
		if(entityType.equals("organizationInfoEntity"))
		{
			OrganizationInfoEntity organizationInfoEntity = new OrganizationInfoEntity();
			organizationInfoEntity.setOracleId(personalData.getOracleId());
			organizationInfoEntity.setFirstName(personalData.getFirstName());
			organizationInfoEntity.setMiddleName(personalData.getMiddleName());
			organizationInfoEntity.setLastName(personalData.getLastName());
			organizationInfoEntity.setDivision(personalData.getDiv());
			organizationInfoEntity.setBusinessUnit(personalData.getBu());
			organizationInfoEntity.setHrmsTeam(personalData.getHrmsTeam());
			organizationInfoEntity.setOrganization(personalData.getOrganization());
			organizationInfoEntity.setHomeOffice(personalData.getHomeOff());
			organizationInfoEntity.setCurrentOffice(personalData.getCurrOff());
			organizationInfoEntity.setCompany(personalData.getCompany());
			organizationInfoEntity.setCostCenterCode(personalData.getCostCenterCode());
			organizationInfoEntity.setCostCenterName(personalData.getCostCenterName());
			organizationInfoEntity.setPersonType(personalData.getPersonType());
			organizationInfoEntity.setStartDate(personalData.getStartDate());
			organizationInfoEntity.setTerminationDate(personalData.getTermDate());
			organizationInfoEntity.setHomeRegion(personalData.getHomeRegion());
			organizationInfoEntity.setCurrentRegion(personalData.getCurrentRegion());
			organizationInfoEntity.setBusinessFocus(personalData.getBusinessFocus());
			organizationInfoEntity.setPrimaryCapability(personalData.getPrimaryCapability());
			organizationInfoEntity.setCapacityType(personalData.getCapacityType());
			organizationInfoEntity.setUtilizationTarget(personalData.getUtilizationTarget());
			organizationInfoEntity.setRevenueTarget(personalData.getRevenueTarget());
			organizationInfoEntity.setProfitTarget(personalData.getProfitTarget());
			organizationInfoEntity.setLoaReturnflag(personalData.getLoaRetrunFlag());
			organizationInfoEntity.setCategory(personalData.getCategory());	
			entityObject = organizationInfoEntity;
		}else
		if(entityType.equals("personalInfoEntity"))
		{
			PersonalInfoEntity personalInfoEntity = new PersonalInfoEntity();
			personalInfoEntity.setOracleId(personalData.getOracleId());
			personalInfoEntity.setFatherName(personalData.getFatherName());
			personalInfoEntity.setGender(personalData.getGender());
			personalInfoEntity.setMaritalStatus(personalData.getMaritalStatus());
			personalInfoEntity.setNationality(personalData.getNationality());
			personalInfoEntity.setDateOfBirth(personalData.getDateofBirth());
			personalInfoEntity.setAddressLine1(personalData.getAddressLine1());
			personalInfoEntity.setAddressLine2(personalData.getAddressLine2());
			personalInfoEntity.setAddressLine3(personalData.getAddressLine3());
			personalInfoEntity.setCity(personalData.getCity());
			personalInfoEntity.setCounty(personalData.getCounty());
			personalInfoEntity.setState(personalData.getState());
			personalInfoEntity.setPostalCode(personalData.getPostalCode());
			personalInfoEntity.setCountry(personalData.getCountry());
			personalInfoEntity.setHomePhone(personalData.getHomePhone());
			personalInfoEntity.setLoginId(personalData.getLoginName());
			personalInfoEntity.setEmailAddress(personalData.getEmail());
			personalInfoEntity.setLastCompetencyUpdate(personalData.getLastCompetencyUpdate());
			entityObject = personalInfoEntity;
		}
		return entityObject;
	}

}
