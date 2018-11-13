package com.newins.service.imp;


import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.LoadVqnMapper;
import com.newins.model.NiVoteQuestionnaire;
import com.newins.model.VqnOption;
import com.newins.model.VqnItem;
import com.newins.service.LoadVqnService;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年6月28日 下午5:09:53
 */
@Service
public class LoadVqnServiceImp implements LoadVqnService{
	@Autowired
	private LoadVqnMapper loadVqnMapper;
	@Autowired
	private VqnItem vqnItem;
	@Autowired
	private NiVoteQuestionnaire niVoteQuestionnaire;
	public VqnItem loadVqn(int vqnId){
		//NiVoteQuestionnaire niVoteQuestionnaire=new NiVoteQuestionnaire();
		niVoteQuestionnaire = loadVqnMapper.loadVqn(vqnId);//投票问题表里所有的信息
		vqnItem.setQuestionQty(1);
		vqnItem.setComment(niVoteQuestionnaire.getComment());
		vqnItem.setCorrectAnswer(niVoteQuestionnaire.getCorrectAnswer());
		vqnItem.setEpilogue(niVoteQuestionnaire.getEpilogue());
		vqnItem.setIsSelfDefine(niVoteQuestionnaire.getIsSelfDefine());
		vqnItem.setOptionNum(niVoteQuestionnaire.getOptionNum());
		vqnItem.setOptMaxNum(niVoteQuestionnaire.getOptMaxNum());	//如果最大可选个数为0，则表示不限制
		vqnItem.setOptMinNum(niVoteQuestionnaire.getOptMinNum());
		vqnItem.setPerface(niVoteQuestionnaire.getPerface());
		vqnItem.setPublisherName(niVoteQuestionnaire.getPublisherName());
		vqnItem.setQuestionType(niVoteQuestionnaire.getQuestionType());
		vqnItem.setRequired(niVoteQuestionnaire.getRequired());
		vqnItem.setVqnClassName(niVoteQuestionnaire.getVqnClassName());
		vqnItem.setVqnSummary(niVoteQuestionnaire.getVqnSummary());
		vqnItem.setVqTitle(niVoteQuestionnaire.getVqTitle());
		vqnItem.setVqnName(niVoteQuestionnaire.getVqnName());
		vqnItem.setSuccess("true");
		vqnItem.setPicPath(niVoteQuestionnaire.getPicPath());
		vqnItem.setqImgUrl(niVoteQuestionnaire.getqImgUrl());
		
		int optionNum = vqnItem.getOptionNum();

		List<VqnOption> voteOptionList = new ArrayList<VqnOption>();
		
		for(int i=0;i<optionNum;i++){
			
			VqnOption vqnOptionItem = new VqnOption();
			vqnOptionItem.setOptionOrder(i+1);
			vqnOptionItem.setOptionDes(niVoteQuestionnaire.getOptionDesByIndex(i+1));
			vqnOptionItem.setOptionFeedback(niVoteQuestionnaire.getOptionFeedbackByIndex(i+1));
			vqnOptionItem.setOptionPic(niVoteQuestionnaire.getOptionPicByIndex(i+1));
			voteOptionList.add(vqnOptionItem);
		}
		
		vqnItem.setOptions(voteOptionList);
		return vqnItem;
	}

}
