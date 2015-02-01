package org.sapient.hibernate.dao;

import java.util.List;

import org.sapient.hibernate.entity.SecurityQuestionEntity;

public interface SecurityQuestionDao {

	List<SecurityQuestionEntity> getAllSecurityQuestions();
}
