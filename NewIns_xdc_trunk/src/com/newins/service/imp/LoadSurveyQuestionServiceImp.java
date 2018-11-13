/**
 * 
 */
package com.newins.service.imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.SurveyQuestionDao;
import com.newins.model.SurveyQuestionWithOption;
import com.newins.service.LoadSurveyQuestionService;

/**
 * @Description 加载问题完整信息service
 * @author Guan
 * @time 2016年6月29日 下午4:55:46
 */
@Service(value = "LoadSurveyQuestionService")
public class LoadSurveyQuestionServiceImp implements LoadSurveyQuestionService {
	@Autowired
	private SurveyQuestionDao svyQuestionDao;
	private static Logger log = Logger
			.getLogger(LoadSurveyQuestionServiceImp.class);
	//貌似与下一个写重了
	public List<SurveyQuestionWithOption> loadSurveyQuestionWithOption(int sqnId) {
		log.info("This is service:loadSurveyQuestionWithOption()");
		return svyQuestionDao.loadSurveyQuestionWithOption(sqnId);

	}
	
	//根据问卷Id来把该问卷的题目查出来(貌似与上一个写重了)
	public List<SurveyQuestionWithOption> selectSurveyQuestionBySqnId(int sqnId) {
		List<SurveyQuestionWithOption> surveyQuestionList = svyQuestionDao.selectSurveyQuestion(sqnId);
		return surveyQuestionList;
	}
	
	/**
	 * 核心题的
	 */
	public SurveyQuestionWithOption loadSurveyKeyQuestionWithOption(int sqnId, int keyQuestionNum) {
		log.info("This is service:loadSurveyQuestionWithOption()");
		return svyQuestionDao.loadSurveyKeyQuestionWithOption(sqnId,keyQuestionNum);

	}
}
