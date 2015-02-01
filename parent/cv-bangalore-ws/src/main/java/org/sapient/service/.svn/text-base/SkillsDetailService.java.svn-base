/**
 * 
 */
package org.sapient.service;

import java.util.List;

import org.sapient.service.beans.SkillsInfoVO;
import org.sapient.service.beans.SkillsTypeVO;

/**
 * @author brout
 * 
 */
public interface SkillsDetailService {

	Long saveSkillsDetail(SkillsInfoVO SkillsInfoVO);

	List<SkillsInfoVO> retrieveSkillsDetailByUserId(Long userId);
	
	SkillsInfoVO retrieveSkillsDetailById(Long id);

	List<SkillsTypeVO> retrieveAllSkillTypes();
	
	void removeSkillSet(Long userId, Long skillsInfoId);
}
