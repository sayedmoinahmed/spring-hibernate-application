package org.sapient.hibernate.dao;

import org.sapient.hibernate.entity.SkillsInfoEntity;

public interface SkillsInfoDao {

	void saveSkillsInfo(SkillsInfoEntity skillsInfoEntity);

	SkillsInfoEntity getSkillsInfoById(Long id);
}
