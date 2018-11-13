package com.newins.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newins.dao.NiAssessQuestionMapper;
import com.newins.model.NiAssessQuestion;
import com.newins.service.NiAssessQuestionService;

@Service
public class NiAssessQuestionServiceImp implements NiAssessQuestionService{
	@Resource
	private NiAssessQuestionMapper niAssessQuestionMapper;
	@Override
	public int insert(NiAssessQuestion record) {
		int insert = niAssessQuestionMapper.insert(record);
		return insert;
	}

}
