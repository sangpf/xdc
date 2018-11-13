package com.newins.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.NiSurveyQuestionMapper;
import com.newins.model.NiSurveyQuestion;
import com.newins.service.NiSurveyQuestionService;

@Service
public class NiSurveyQuestionServiceImp implements NiSurveyQuestionService{
	
	@Autowired
	private NiSurveyQuestionMapper niSurveyQuestionMapper;
	
	public int insert(NiSurveyQuestion record) {
		int insert = niSurveyQuestionMapper.insert(record);
		return insert;
	}

	@Override
	public int insertSelective(NiSurveyQuestion record) {
		// TODO Auto-generated method stub
		return 0;
	}

	//调用存储过程例子
	public List<NiSurveyQuestion> selectSurveyQuestion(int id) {
		List<NiSurveyQuestion> selectSurveyQuestion = niSurveyQuestionMapper.selectSurveyQuestion(id);
		return selectSurveyQuestion;
	}

}
