/**
 * 
 */
package org.sapient.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.DozerBeanMapper;
import org.sapient.hibernate.dao.SecurityQuestionDao;
import org.sapient.hibernate.entity.SecurityQuestionEntity;
import org.sapient.service.beans.SecurityQuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author psiva2
 * 
 */
@Service("securityQuestionService")
public class SecurityQuestionServiceImpl implements SecurityQuestionService {

	private static final Log LOG = LogFactory
			.getLog(SecurityQuestionServiceImpl.class);

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	private SecurityQuestionDao securityQuestionDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sapient.service.SecurityQuestionService#retrieveAllSecurityQuestions
	 * ()
	 */
	@Override
	public List<SecurityQuestionVO> retrieveAllSecurityQuestions() {
		List<SecurityQuestionEntity> entities = securityQuestionDao
				.getAllSecurityQuestions();
		List<SecurityQuestionVO> results = new ArrayList<SecurityQuestionVO>();
		for (SecurityQuestionEntity entity : entities) {
			SecurityQuestionVO securityQuestionVO = dozerBeanMapper.map(entity,
					SecurityQuestionVO.class);
			results.add(securityQuestionVO);
		}
		return results;
	}

}
