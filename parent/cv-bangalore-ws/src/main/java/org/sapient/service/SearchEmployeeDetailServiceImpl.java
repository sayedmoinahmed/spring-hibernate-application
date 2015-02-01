/**
 * 
 */
package org.sapient.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.DozerBeanMapper;
import org.sapient.hibernate.entity.PersonalDataInfoEntity;
import org.sapient.hibernate.entity.SearchResultEntity;
import org.sapient.service.beans.PersonalInfoVO;
import org.sapient.service.beans.SearchResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.sapient.hibernate.dao.SearchEmployeeDao;


/**
 * @author komar
 * 
 * Updated by @author spash1
 * 
 */
@Service("searchEmployeeDetailService")
public class SearchEmployeeDetailServiceImpl implements
		SearchEmployeeDetailService {

	private static final Log LOG = LogFactory
			.getLog(SearchEmployeeDetailServiceImpl.class);

	@Autowired
	@Qualifier("searchEmployeeDao")
	private SearchEmployeeDao searchEmployeeDao;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	public List<SearchResultVO> retrieveEmployeeSearch(Long oracleId , String firstName, String lastName,String designation,String skill,
			String revenueGroup, String teamName,
			String businessFocus, String bu, String division, String homeOff,
			String currOff, String company, String personType,
			String homeRegion, String currentRegion, String primaryCapability,
			String domain
	
	) {

		List<SearchResultEntity> results = searchEmployeeDao
				.loadEmployeeSearchBySkill(oracleId , firstName,lastName,designation, skill ,
						revenueGroup,
						teamName,
						businessFocus,
						bu,
						division,
						homeOff,
						currOff,
						company,
						personType,
						homeRegion,
						currentRegion,
						primaryCapability,
						domain
				);

		List<SearchResultVO> searchDetails = null;
		if (results != null && results.size() > 0) {
			searchDetails = new ArrayList<SearchResultVO>();
			for (SearchResultEntity entity : results) {
				SearchResultVO searchResultVO = dozerBeanMapper.map(entity,
						SearchResultVO.class);
				searchDetails.add(searchResultVO);
			}
		}
		return searchDetails;

		// return results;
	}

	

}

