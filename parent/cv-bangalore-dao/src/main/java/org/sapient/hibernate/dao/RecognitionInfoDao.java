package org.sapient.hibernate.dao;

import org.sapient.hibernate.entity.RecognitionInfoEntity;

public interface RecognitionInfoDao {

	void saveRecognitionInfo(RecognitionInfoEntity recognitionInfo);
	
	RecognitionInfoEntity getRecognitionInfoById(Long id);
}