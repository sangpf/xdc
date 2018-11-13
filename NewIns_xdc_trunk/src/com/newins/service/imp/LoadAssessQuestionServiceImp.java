/**
 * 
 */
package com.newins.service.imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.AssessQuestionDao;
import com.newins.model.AssessQuestionWithOption;
import com.newins.service.LoadAssessQuestionService;

/**
 * @Description 加载问题完整信息service
 * @author Guan
 * @time 2016年6月29日 下午4:55:46
 */
@Service(value = "LoadAssessQuestionService")
public class LoadAssessQuestionServiceImp implements LoadAssessQuestionService {
	@Autowired
	private AssessQuestionDao assQuestionDao;
	private static Logger log = Logger
			.getLogger(LoadAssessQuestionServiceImp.class);

	public List<AssessQuestionWithOption> loadAssessQuestionWithOption(int aqnId) {
		log.info("This is service:loadAssessQuestionWithOption()");
		return assQuestionDao.loadAssessQuestionWithOption(aqnId);

	}
}
