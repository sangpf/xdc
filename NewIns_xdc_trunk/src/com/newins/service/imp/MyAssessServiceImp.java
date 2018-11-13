package com.newins.service.imp;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.MyAssessDao;
import com.newins.model.MyAssessModel;
import com.newins.service.MyAssessService;
import com.newins.util.ErrorMessage;

/**
 * @Description 操作用户的历史评测信息实现类
 * @author 星仔
 * @time 2017年2月17日上午11:34:47
 */
@Service("myAssessService")
public class MyAssessServiceImp implements MyAssessService {
	
	@Autowired
	private MyAssessDao myAssessDao;
	
	public MyAssessDao getNiAssessOrderDao() {
		return myAssessDao;
	}

	public void setNiAssessOrderDao(MyAssessDao niAssessOrderDao) {
		this.myAssessDao = niAssessOrderDao;
	}



	@Override
	public Object getMyAssessList(int userId, int page) {
		
		List<MyAssessModel> myAssessList = myAssessDao.myAssessList(userId);
		for (int i = 0; i < myAssessList.size(); i++) {
			//处理时间格式
			String time = myAssessList.get(i).getAnswerETime();
			String newTime = time.substring(0, 10);
			myAssessList.get(i).setAnswerETime(newTime);
			
			//插入isFavorite属性
			int isFavorite = this.getUserIsFavorite(userId, myAssessList.get(i).getReportId());
			myAssessList.get(i).setIsFavorite(isFavorite);
		}
		
		
	
		// 从List中分页
		// 先判断分页前List长度是否为0，若为0就不需要分页
		if (myAssessList.size() != 0) {
			List<MyAssessModel> myAssessPageList = null;// 返回的分页List
			int bIndex = (page - 1) * 20;
			int eIndex = (page - 1) * 20 + 19;
			int totalPage = 0;
			if (myAssessList.size() % 10 == 0) {
				totalPage = myAssessList.size() / 20;
			} else {
				totalPage = myAssessList.size() / 20 + 1;
			}
			if (bIndex > myAssessList.size() - 1) {
				JSONObject myAssessUpdateList = new JSONObject();
				myAssessUpdateList.put("success", "true");
				myAssessUpdateList.put("totalPage", totalPage);
				myAssessUpdateList.put("myAssessList", myAssessPageList);
				return myAssessUpdateList;
			}
			if (eIndex < myAssessList.size() - 1) {
				myAssessPageList = myAssessList.subList(bIndex, eIndex + 1);
			} else {
				myAssessPageList = myAssessList.subList(bIndex, myAssessList.size());
			}

			JSONObject myAssessUpdateList = new JSONObject();
			myAssessUpdateList.put("success", "true");
			myAssessUpdateList.put("totalPage", totalPage);
			myAssessUpdateList.put("myAssessList", myAssessPageList);
			return myAssessUpdateList;
		} else {
			JSONObject myAssessUpdateList = new JSONObject();
			myAssessUpdateList.put("success", "true");
			myAssessUpdateList.put("totalPage", 1);
			myAssessUpdateList.put("myAssessList", myAssessList);
			return myAssessUpdateList;
		}
	}



	@Override
	public int getUserIsFavorite(int userId, int reportId) {
		//调用Dao层方法
		int num = myAssessDao.userIsFavorite(userId, reportId);
		if (num!=0) {			
			return 1;
		}else {
			return 0;
		}
	}

//	@Override
//	public int getIsMakeReport(int aqnId) {
//		//调用Dao层方法
//		int num = myAssessDao.isMakeReport(aqnId);
//		if (num!=0) {
//			return 1;
//		}else {
//			return 0;
//		}
//	}


}
