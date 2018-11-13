package com.newins.service.imp;

import java.util.Date;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newins.dao.NiAssessQuestionMapper;
import com.newins.dao.NiAssessQuestionnaireMapper;
import com.newins.model.NiAssessQuestion;
import com.newins.model.NiAssessQuestionnaire;
import com.newins.service.NiAssessQuestionnaireService;
import com.newins.util.ExcelTool;

@Service
public class NiAssessQuestionnaireServiceImp implements NiAssessQuestionnaireService{
	private static Logger log = Logger.getLogger(NiAssessQuestionnaireServiceImp.class); 
	@Resource
	private NiAssessQuestionnaireMapper niAssessQuestionnaireMapper;
	@Resource
	private NiAssessQuestionMapper niAssessQuestionMapper;
	
	//读取测评问卷
		@Transactional
		public void readEvaluationExcel() throws Exception{
			ResourceBundle bundle = ResourceBundle.getBundle("excel");
			String fileName = bundle.getString("evaluation");
//			String fileName = "G:/workspace01/NewIns/WebRoot/测评问卷导入模板_0620.xlsx";
			StringBuffer sb = ExcelTool.getExcelData(fileName, ".xlsx");
			String string = sb.toString();
			//截取字符串得到每页内容
			String[] strings = string.split(";");
			log.info("截取的页数的长度====================>>"+strings.length);
			String excel0 = strings[0];  //第一页中内容
			//得到第一页中具体内容
			String[] strs = excel0.split("!");
			//得到题目数量
			Integer qNum = Integer.valueOf(strs[2]);
			
			NiAssessQuestionnaire niAssessQuestionnaire = new NiAssessQuestionnaire();
			NiAssessQuestion niAssessQuestion = new NiAssessQuestion();
			
			try {
				//保存调查问卷表
				String aqnName = strs[0];  //测评问卷标题
				String sqnSummary = strs[1];//问卷简介
				Integer questionNum = Integer.valueOf(strs[2]); //题目数量
				String picPath = strs[3];  // 问卷标题图
				String publisherName = strs[4]; //发布者名称
				String perface = strs[5];  //卷首语
				Integer recommandQty = Integer.valueOf(strs[6]); //建议回收数量
				Integer validation = Integer.valueOf(strs[7]); // 有效性验证方式
				Integer sqnClassId = Integer.valueOf(strs[8]); //问卷分类ID
				Integer tag1Id = Integer.valueOf(strs[9]);
				Integer tag2Id = Integer.valueOf(strs[11]);
				Integer tag3Id = Integer.valueOf(strs[13]);
				Integer tag4Id = Integer.valueOf(strs[15]);
				Integer tag5Id = Integer.valueOf(strs[17]);
				String epilogue = strs[19];  //结语
				String editor = strs[20]; //问卷编辑人
				String comment = strs[21]; //问卷备注 publisherId
				
/*				Random random = new Random();
				int nextInt = random.nextInt();
				niAssessQuestionnaire.setAqnid(nextInt);
				niAssessQuestionnaire.setPublisherid(000);*/
				
				niAssessQuestionnaire.setAqnname(aqnName);
				niAssessQuestionnaire.setAqnsummary(sqnSummary);
				niAssessQuestionnaire.setQuestionnum(questionNum);
				niAssessQuestionnaire.setPicpath(picPath);
				niAssessQuestionnaire.setPublishername(publisherName);
				niAssessQuestionnaire.setPerface(perface);
				niAssessQuestionnaire.setRecommandqty(recommandQty);
				niAssessQuestionnaire.setValidation(validation);
				niAssessQuestionnaire.setAqnclassid(sqnClassId);
				niAssessQuestionnaire.setTag1id(tag1Id);
				niAssessQuestionnaire.setTag2id(tag2Id);
				niAssessQuestionnaire.setTag3id(tag3Id);
				niAssessQuestionnaire.setTag4id(tag4Id);
				niAssessQuestionnaire.setTag5id(tag5Id);
				niAssessQuestionnaire.setEpilogue(epilogue);
				niAssessQuestionnaire.setEditor(editor);
				niAssessQuestionnaire.setComment(comment);
				niAssessQuestionnaire.setCtime(new Date());  //创建时间
				niAssessQuestionnaire.setStaus(1); //草稿状态
				
				int insert = niAssessQuestionnaireMapper.insert(niAssessQuestionnaire);
				if(insert>0){
					log.info("添加测评问卷成功");
				}else{
					log.info("添加测评问卷失败");
				}
				//添加测评问题
				for(int i =1 ;i<qNum+1;i++){  //qNum代表题目数量   2
					String exceli = strings[i];  // exceli 代表每一题
					String[] strsi = exceli.split("!");
					
					Integer questionNum2 = Integer.valueOf(strsi[0]);
					Integer viewOrder = Integer.valueOf(strsi[1]);
					Integer optionNum = Integer.valueOf(strsi[2]);
					Integer questionType = Integer.valueOf(strsi[3]);
					String sqTitle = strsi[4];
					Integer required = Integer.valueOf(strsi[5]);
					Integer isSelfDefine = Integer.valueOf(strsi[6]);
					String correctAnswer = strsi[7];
					String titleImgUrl = strsi[8];
					String comment2 = strsi[9];
					
					String option1Des = strsi[10];  //选项1描述
					Integer option1TagId = Integer.valueOf(strsi[11]);   //选项1标签id
					Integer option1Link = Integer.valueOf(strsi[14]);  //选项1标签跳转
					String option1Feedback = strsi[15];  //选项1反馈
					Integer option1Score = Integer.valueOf(strsi[17]);  //选项1分值
					
					String option2Des = strsi[18];  //选项1描述
					Integer option2TagId = Integer.valueOf(strsi[19]);   //选项1标签id
					Integer option2Link = Integer.valueOf(strsi[22]);  //选项1标签跳转
					String option2Feedback = strsi[23];  //选项1反馈
					Integer option2Score = Integer.valueOf(strsi[25]);  //选项1分值
					
					String option3Des = strsi[26];  //选项1描述
					Integer option3TagId = Integer.valueOf(strsi[27]);   //选项1标签id
					Integer option3Link = Integer.valueOf(strsi[30]);  //选项1标签跳转
					String option3Feedback = strsi[31];  //选项1反馈
					Integer option3Score = Integer.valueOf(strsi[33]);  //选项1分值
					
					String option4Des = strsi[34];  //选项1描述
					Integer option4TagId = Integer.valueOf(strsi[35]);   //选项1标签id
					Integer option4Link = Integer.valueOf(strsi[38]);  //选项1标签跳转
					String option4Feedback = strsi[39];  //选项1反馈
					Integer option4Score = Integer.valueOf(strsi[41]);  //选项1分值
					
					Integer aqnid = niAssessQuestionnaire.getAqnid(); //获取测评问卷id
					
					niAssessQuestion.setAqnid(aqnid);
					niAssessQuestion.setQuestionnum(questionNum2);
					niAssessQuestion.setVieworder(viewOrder);
					niAssessQuestion.setOptionnum(optionNum);
					niAssessQuestion.setQuestiontype(questionType);
					niAssessQuestion.setAqtitle(sqTitle);
					niAssessQuestion.setRequired(required);
					niAssessQuestion.setIsselfdefine(isSelfDefine);
					niAssessQuestion.setCorrectanswer(correctAnswer);
					niAssessQuestion.setTitleimgurl(titleImgUrl);
					niAssessQuestion.setComment(comment2);
					
					niAssessQuestion.setOption1des(option1Des);
					niAssessQuestion.setOption1tagid(option1TagId);
					niAssessQuestion.setOption1link(option1Link);
					niAssessQuestion.setOption1feedback(option1Feedback);
					niAssessQuestion.setOption1score(option1Score);
					
					niAssessQuestion.setOption2des(option2Des);
					niAssessQuestion.setOption2tagid(option2TagId);
					niAssessQuestion.setOption2link(option2Link);
					niAssessQuestion.setOption2feedback(option2Feedback);
					niAssessQuestion.setOption2score(option2Score);
					
					niAssessQuestion.setOption3des(option3Des);
					niAssessQuestion.setOption3tagid(option3TagId);
					niAssessQuestion.setOption3link(option3Link);
					niAssessQuestion.setOption3feedback(option3Feedback);
					niAssessQuestion.setOption3score(option3Score);
					
					niAssessQuestion.setOption4des(option4Des);
					niAssessQuestion.setOption4tagid(option4TagId);
					niAssessQuestion.setOption4link(option4Link);
					niAssessQuestion.setOption4feedback(option4Feedback);
					niAssessQuestion.setOption4score(option4Score);
					
					int insert1 = niAssessQuestionMapper.insert(niAssessQuestion);
					if(insert1>0){
						log.info("================》》题目添加成功");
					}else{
						log.info("==================>>题目添加失败");
					}
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}

}
