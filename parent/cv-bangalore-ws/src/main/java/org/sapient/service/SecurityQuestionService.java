package org.sapient.service;

import java.util.List;

import org.sapient.service.beans.SecurityQuestionVO;

public interface SecurityQuestionService {

	List<SecurityQuestionVO> retrieveAllSecurityQuestions();
}
