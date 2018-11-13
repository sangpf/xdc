/**
 * 
 */
package com.newins.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.AssessQuestionDao;
import com.newins.dao.AssessQuestionnaireDao;
import com.newins.model.AssessQuestion;
import com.newins.model.AssessQuestionOption;
import com.newins.model.AssessQuestionWithOption;
import com.newins.model.AssessQuestionnaire;
import com.newins.service.LoadAssessQuestionService;
import com.newins.service.LoadAssessQuestionnaireService;
import com.newins.util.ErrorMessage;

/**
 * @Description 动态加载调查问卷内容service
 * @author Guan
 * @time 2016年6月28日 下午9:21:19
 */
@Service(value = "LoadAssessQuestionnaireService")
public class LoadAssessQuestionnaireServiceImp implements LoadAssessQuestionnaireService {
	
	@Autowired
	private AssessQuestionnaireDao assQnDao;
	@Autowired
	private AssessQuestionDao assQuestionDao;
	@Autowired
	private LoadAssessQuestionService loadSqService;
	
	private static Logger log = Logger
			.getLogger(LoadAssessQuestionnaireServiceImp.class);

	public Object loadAssessQuestionnaire(int aqnId) {
		log.info("------------------------->> 加载测评问卷 ... begin ..");

		AssessQuestionnaire assQuestionnaire = assQnDao.loadAssessQuestionnaire(aqnId);
		
		
		if (assQuestionnaire != null) {
			assQuestionnaire.setSuccess("true");
			// 将ni_Assess_question表中某个问卷的所有问题信息读出
			List<AssessQuestionWithOption> assQuestionWithOptionList = loadSqService
					.loadAssessQuestionWithOption(aqnId);
			
			List<AssessQuestion> assQuestionList = new ArrayList<AssessQuestion>();// 对应接口的question列表

			for (int i = 0; i < assQuestionWithOptionList.size(); i++) {
				List<AssessQuestionOption> assOptionList = new ArrayList<AssessQuestionOption>();// 对应接口的问题选项列表
				AssessQuestionWithOption SqWithOptionTem = assQuestionWithOptionList
						.get(i);// 第i个问题的完整信息
				
				AssessQuestion SqTem = new AssessQuestion();
				// 从完整信息中抽取question相关的信息，付给question对象
				SqTem.setAqId(SqWithOptionTem.getAqId());
				SqTem.setQuestionNum(SqWithOptionTem.getQuestionNum());
				SqTem.setAqTitle(SqWithOptionTem.getAqTitle());
				SqTem.setQuestionType(SqWithOptionTem.getQuestionType());
				SqTem.setRequired(SqWithOptionTem.getRequired());
				SqTem.setOptionNum(SqWithOptionTem.getOptionNum());
				SqTem.setIsSelfDefine(SqWithOptionTem.getIsSelfDefine());
				SqTem.setCorrectAnswer(SqWithOptionTem.getCorrectAnswer());
				SqTem.setqImgUrl(SqWithOptionTem.getqImgUrl());
				
				for (int j = 1; j <= SqTem.getOptionNum(); j++) {
					AssessQuestionOption SqOption = new AssessQuestionOption();
					SqOption.setOptionDes(SqWithOptionTem
							.getOptionDesByIndex(j));
					SqOption.setOptionLink(SqWithOptionTem
							.getOptionLinkByIndex(j));
					SqOption.setOptionFeedback(SqWithOptionTem
							.getOptionFeedbackByIndex(j));
					SqOption.setOptionOrder(j);
					assOptionList.add(j - 1, SqOption);
				}// 将选项付给相应的问题
				SqTem.setOptions(assOptionList);// 将选项列表添加到问题属性
				assQuestionList.add(i, SqTem);
			}
			
			assQuestionnaire.setQuestions(assQuestionList);// 将问题列表添加到问卷属性
			return assQuestionnaire;
		}else {
			ErrorMessage errMess = new ErrorMessage();
			errMess.setSuccess("false");
			errMess.setErrInfo("找不到问卷呢");
			errMess.setErrCode("001");
			return errMess;
		}
	}
}