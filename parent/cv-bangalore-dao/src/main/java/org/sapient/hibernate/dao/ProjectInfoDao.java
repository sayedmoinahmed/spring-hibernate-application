package org.sapient.hibernate.dao;

import org.sapient.hibernate.entity.ProjectInfoEntity;

public interface ProjectInfoDao {

	void saveProjectInfo(ProjectInfoEntity projectInfoEntity);

	ProjectInfoEntity getProjectInfoById(Long id);
}