/**
 * 
 */
package org.spring.batch.domain.mapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.domain.PersonalData;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * @author psiva2
 * 
 */
public class PersonalDataFieldSetMapper implements FieldSetMapper<PersonalData> {
	private static final Log LOG = LogFactory
			.getLog(PersonalDataFieldSetMapper.class);

	StringToCalender calender = new StringToCalender();

	public PersonalData mapFieldSet(FieldSet fieldSet) throws BindException {

		if (fieldSet == null) {
			return null;
		}

		PersonalData personalData = new PersonalData();
		personalData.setOracleId(fieldSet.readLong("ORACLE_ID"));
		personalData.setFirstName(fieldSet.readString("FIRST_NAME"));
		personalData.setMiddleName(fieldSet.readString("MIDDLE_NAME"));
		personalData.setLastName(fieldSet.readString("LAST_NAME"));
		personalData.setPersonType(fieldSet.readString("PERSONTYPE"));
		personalData.setTitleName(fieldSet.readString("TITLE_NAME"));
		try {
			personalData.setSupervisorId(fieldSet.readLong("SUPERVISOR_ID"));
		} catch (NumberFormatException e) {
			personalData.setSupervisorId(null);
		}
		personalData.setSupervisorName(fieldSet.readString("SUPERVISOR"));
		personalData.setFatherName(fieldSet.readString("FATHER_NAME"));
		if(fieldSet.readString("DOB").equals(""))
			personalData.setDateofBirth(null);
		else
		personalData.setDateofBirth(calender.getCalendar(fieldSet
				.readString("DOB")));
		if(fieldSet.readString("NT_LOGIN").equals(""))
			personalData.setLoginName("");
		else
		personalData.setLoginName(fieldSet.readString("NT_LOGIN"));
		personalData.setStartDate(calender.getCalendar(fieldSet
				.readString("STARTDATE")));
		String termDate = fieldSet.readRawString("TERMDATE").trim();
		System.out.println("termDate" + termDate);
		Boolean isAvailable = fieldSet.readBoolean("TERMDATE"); 
		if(fieldSet.readString("TERMDATE").equals(""))
			personalData.setTermDate(null);
		else
		personalData.setTermDate(calender.getCalendar(fieldSet
					.readString("TERMDATE")));
		personalData.setEmail(fieldSet.readString("EMAIL_ADDRESS"));
		personalData.setDiv(fieldSet.readString("DIV"));
		personalData.setBu(fieldSet.readString("BU"));
		personalData.setHrmsTeam(fieldSet.readString("HRMS_TEAM"));
		personalData.setOrganization(fieldSet.readString("ORGANIZATION"));
		personalData.setHomeOff(fieldSet.readString("HOME_OFF"));
		personalData.setCurrOff(fieldSet.readString("CURR_OFF"));
		personalData.setCompany(fieldSet.readString("COMPANY"));
		if(fieldSet.readString("COST_CENTER_CODE").equals(""))
			personalData.setCostCenterCode(null);
		else
		personalData.setCostCenterCode(Long.parseLong(fieldSet.readString("COST_CENTER_CODE")));
		personalData.setCostCenterName(fieldSet.readString("COST_CENTER_NAME"));
		personalData.setHomeRegion(fieldSet.readString("HOME_REGION"));
		personalData.setCurrentRegion(fieldSet.readString("CURRENT_REGION"));
		personalData.setBusinessFocus(fieldSet.readString("BUSINESS_FOCUS"));
		personalData.setPrimaryCapability(fieldSet.readString("PRIMARY_CAPABILITY"));
		personalData.setCapacityType(fieldSet.readString("CAPACITY_TYPE"));
		personalData.setUtilizationTarget(fieldSet.readString("UTILIZATION_TARGET"));
		personalData.setRevenueTarget(fieldSet.readString("REVENUE_TARGET"));
		personalData.setProfitTarget(fieldSet.readString("PROFIT_TARGET"));
		if(fieldSet.readString("LOA_RETURN_FLAG").equals(""))
			personalData.setLoaRetrunFlag(' ');
		else
		personalData.setLoaRetrunFlag(fieldSet.readChar("LOA_RETURN_FLAG"));
		personalData.setCategory(fieldSet.readString("CATEGORY"));
		personalData.setStatus(fieldSet.readString("STATUS"));
		if(fieldSet.readString("STAI_FLAG").equals(""))
			personalData.setStaiFlag(' ');
		else
		personalData.setStaiFlag(fieldSet.readChar("STAI_FLAG"));
		personalData.setCareerStage(fieldSet.readString("CAREER_STAGE"));
		if(fieldSet.readString("LAST_PROMOTION_DATE").equals(""))
			personalData.setLastPromotionDate(null);
		else
		personalData.setLastPromotionDate(calender.getCalendar(fieldSet.readString("LAST_PROMOTION_DATE")));
		if(fieldSet.readString("TIME_SINCE_LAST_PROMOTION").equals(""))
			personalData.setTimeSinceLastPromotion(null);
		else
		personalData.setTimeSinceLastPromotion(fieldSet.readFloat("TIME_SINCE_LAST_PROMOTION"));
		if(fieldSet.readString("CM_ID").equals(""))
			personalData.setCmId(null);
		else
		personalData.setCmId(fieldSet.readLong("CM_ID"));
		
		if(fieldSet.readString("CM")==null)
			personalData.setCm(null);
		else
		personalData.setCm(fieldSet.readString("CM"));
		
		if(fieldSet.readString("CM_BU")==null)
			personalData.setCmBu(null);
		else
		personalData.setCmBu(fieldSet.readString("CM_BU"));
		
		if(fieldSet.readString("CM_TITLE")==null)
			personalData.setCmTitle(null);
		else
		personalData.setCmTitle(fieldSet.readString("CM_TITLE"));
		if(fieldSet.readString("RELOCATION_FLAG").equals(""))
			personalData.setRelocationFlag(' ');
		else
		personalData.setRelocationFlag(fieldSet.readChar("RELOCATION_FLAG"));
		personalData.setGender(fieldSet.readString("GENDER"));
		personalData.setMaritalStatus(fieldSet.readString("MARITAL_STATUS"));
		personalData.setNationality(fieldSet.readString("NATIONALITY"));
		personalData.setAddressLine1(fieldSet.readString("ADDRESS_LINE1"));
		personalData.setAddressLine2(fieldSet.readString("ADDRESS_LINE2"));
		personalData.setAddressLine3(fieldSet.readString("ADDRESS_LINE3"));
		personalData.setCity(fieldSet.readString("CITY"));
		personalData.setCounty(fieldSet.readString("COUNTY"));
		personalData.setState(fieldSet.readString("STATE"));
		personalData.setPostalCode(fieldSet.readString("POSTAL_CODE"));
		personalData.setCountry(fieldSet.readString("COUNTRY"));
		personalData.setHomePhone(fieldSet.readString("HOME_PHONE"));
		if(fieldSet.readString("LAST_COMPETENCY_UPDATE").equals(""))
			personalData.setLastCompetencyUpdate(null);
		else
		personalData.setLastCompetencyUpdate(calender.getCalendar(fieldSet.readString("LAST_COMPETENCY_UPDATE")));
		personalData.setDomain(fieldSet.readString("DOMAIN"));
		if(fieldSet.readString("PID")==null)
			personalData.setPid(null);
		else
		personalData.setPid(fieldSet.readString("PID"));
		personalData.setProjectName(fieldSet.readString("PROJECT_NAME"));
		personalData.setClientName(fieldSet.readString("CLIENT_NAME"));
		personalData.setTeamName(fieldSet.readString("TEAM_NAME"));
		personalData.setPrimaryProjectCapability(fieldSet.readString("PRIMARY_PROJECT_CAPABILITY"));
		personalData.setRevenueSubCategory(fieldSet.readString("REVENUE_SUBCATEGORY"));
		personalData.setAllocStartDate(fieldSet.readString("ALLOC_START_DATE"));
		personalData.setAllocEndDate(fieldSet.readString("ALLOC_END_DATE"));
		personalData.setCommitment(fieldSet.readString("COMMITMENT"));
		if(fieldSet.readString("REVENUE_GROUP").equals(""))
			personalData.setRevenueGroup(null);
		else
		personalData.setRevenueGroup(fieldSet.readString("REVENUE_GROUP"));
		return personalData;

	}

}
