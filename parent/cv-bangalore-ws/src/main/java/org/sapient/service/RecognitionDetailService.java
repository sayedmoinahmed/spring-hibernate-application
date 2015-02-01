/**
 * 
 */
package org.sapient.service;

import java.util.List;

import org.sapient.service.beans.RecognitionInfoVO;
import org.sapient.service.beans.RecognitionTypeVO;

/**
 * @author brout
 * 
 */
public interface RecognitionDetailService {

	Long saveRecognitionDetails(RecognitionInfoVO recognitionInfoVO);

	List<RecognitionInfoVO> retrieveRecognitionDetailByUserId(Long userId);
	
	RecognitionInfoVO retrieveRecognitionDetailById(Long id);

	List<RecognitionTypeVO> retrieveAllRecognitions();
	
	void removeRecognitionDetail(Long userId, Long recognitionInfoId);
}
