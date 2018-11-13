/**
 * 
 */
package com.newins.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.SurveyQuestionDao;
import com.newins.dao.SurveyQuestionnaireDao;
import com.newins.dao.SurveyResultMapper;
import com.newins.model.SurveyAnswer;
import com.newins.model.SurveyQuestion;
import com.newins.model.SurveyQuestionOption;
import com.newins.model.SurveyQuestionWithOption;
import com.newins.model.SurveyQuestionnaire;
import com.newins.service.LoadSurveyQuestionService;
import com.newins.service.LoadSurveyQuestionnaireService;
import com.newins.util.ErrorMessage;

/**
 * @Description 动态加载调查问卷内容service
 * @author Guan
 * @time 2016年6月28日 下午9:21:19
 */
@Service(value = "LoadSurveyQuestionnaireService")
public class LoadSurveyQuestionnaireServiceImp implements
		LoadSurveyQuestionnaireService {
	@Autowired
	private SurveyQuestionnaireDao SvyQnDao;
	@Autowired
	private SurveyQuestionDao SvyQuestionDao;
	@Autowired
	private LoadSurveyQuestionService loadSqService;
	@Autowired
	private SurveyResultMapper surveyResultMapper;
	
	private static Logger log = Logger
			.getLogger(LoadSurveyQuestionnaireServiceImp.class);
	public Object loadSurveyQuestionnaire(int sqnId,int userId,String answered, int sqnCategory) {
		log.info("This is service loadSurveyQuestionnaire()");
	//	List<String> userAnswerList = new ArrayList<String>();
		List<SurveyAnswer> surveyAnswerList=null;
		if(answered.equals("1")&&sqnCategory==1){//如果用户答过这份问卷，且题目种类是知识型总分题
			//查询用户回答的答案
			Map<String, Object> param = new HashMap<String, Object>();// 将参数封装成map格式
			param.put("userId", userId);
			param.put("sqnId", sqnId);
			try {
				//得到该问卷的答案
				surveyAnswerList = surveyResultMapper
						.getSurveyAnswerList(param);
			} catch(Exception e){
				//如果找不到答案返回错误信息
				ErrorMessage errMess = new ErrorMessage();
				errMess.setSuccess("false");
				errMess.setErrInfo("找不到用户答案");
				errMess.setErrCode("002");
				return errMess;
			}
		}
		//得到该问卷信息
		SurveyQuestionnaire svyQuestionnaire = SvyQnDao
				.loadSurveyQuestionnaire(sqnId);
		//判断是否得到该问卷信息
		if (svyQuestionnaire != null) {
			//将问卷信息的success属性设置为true
			svyQuestionnaire.setSuccess("true");
			// 将ni_survey_question表中指定问卷的所有问题信息读出
			List<SurveyQuestionWithOption> svyQuestionWithOptionList = loadSqService
					.loadSurveyQuestionWithOption(sqnId);
			//创建问卷完整信息list
			List<SurveyQuestion> svyQuestionList = new ArrayList<SurveyQuestion>();// 对应接口的question列表

			for (int i = 0; i < svyQuestionWithOptionList.size(); i++) {
				List<SurveyQuestionOption> svyOptionList = new ArrayList<SurveyQuestionOption>();// 对应接口的问题选项列表
				SurveyQuestionWithOption sqWithOptionTem = svyQuestionWithOptionList
						.get(i);// 第i个问题的完整信息
				SurveyQuestion sqTem = new SurveyQuestion();
				int qType=sqWithOptionTem.getQuestionType();//获取这个题的问题类型，为了下面判断
				// 从完整信息中抽取question相关的信息，付给question对象
				sqTem.setSqId(sqWithOptionTem.getSqId());
				sqTem.setQuestionNum(sqWithOptionTem.getQuestionNum());
				sqTem.setSqTitle(sqWithOptionTem.getSqTitle());
				sqTem.setQuestionType(qType);
				sqTem.setRequired(sqWithOptionTem.getRequired());
				sqTem.setOptionNum(sqWithOptionTem.getOptionNum());
				sqTem.setOptMaxNum(sqWithOptionTem.getOptMaxNum());	//如果最大可选个数为0，则表示不限制
				sqTem.setOptMinNum(sqWithOptionTem.getOptMinNum());
				sqTem.setIsSelfDefine(sqWithOptionTem.getIsSelfDefine());
				sqTem.setqImgUrl(sqWithOptionTem.getqImgUrl());
				sqTem.setDecimalDigits(sqWithOptionTem.getDecimalDigits());
				sqTem.setTextLength(sqWithOptionTem.getTextLength());
				sqTem.setTextMaxVal(sqWithOptionTem.getTextMaxVal());
				sqTem.setTextMinVal(sqWithOptionTem.getTextMinVal());
				//正确答案如果非空转换为大写
				String correctAnswerStr = sqWithOptionTem.getCorrectAnswer();
				if (correctAnswerStr!=null&&!correctAnswerStr.equals("")){
					correctAnswerStr = correctAnswerStr.toUpperCase();
				}
				sqTem.setCorrectAnswer(correctAnswerStr);
				sqTem.setAnswerAnalysis(sqWithOptionTem.getAnswerAnalysis());
				if(answered.equals("1")&&sqnCategory==1&&surveyAnswerList!=null&&surveyAnswerList.size()>0){//如果用户答过题，且题目种类是知识型总分题
					//将用户选择的答案付给SurveyQuestion 的 userAnswer属性
					if(qType==1||qType==2||qType==6){//单选，多选，
						sqTem.setUserAnswer(surveyAnswerList.get(i).getChoice());
					}else {
						sqTem.setUserAnswer(surveyAnswerList.get(i).getSelfDefine());
					}
					
				}
				for (int j = 1; j <= sqTem.getOptionNum(); j++) {
					SurveyQuestionOption sqOption = new SurveyQuestionOption();
					sqOption.setOptionDes(sqWithOptionTem
							.getOptionDesByIndex(j));
					sqOption.setOptionLink(sqWithOptionTem
							.getOptionLinkByIndex(j));
					sqOption.setOptionFeedback(sqWithOptionTem
							.getOptionFeedbackByIndex(j));
					sqOption.setOptionOrder(j);
					svyOptionList.add(j - 1, sqOption);
				}// 将选项付给相应的问题
				sqTem.setOptions(svyOptionList);// 将选项列表添加到问题属性
				svyQuestionList.add(i, sqTem);
			}
			svyQuestionnaire.setQuestions(svyQuestionList);// 将问题列表添加到问卷属性
			return svyQuestionnaire;
		} else {
			ErrorMessage errMess = new ErrorMessage();
			errMess.setSuccess("false");
			errMess.setErrInfo("找不到问卷呢");
			errMess.setErrCode("001");
			return errMess;
		}
	}
}
