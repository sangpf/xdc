package com.newins.service.imp;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.MyAwardDao;
import com.newins.model.MyAwardModel;
import com.newins.service.MyAwardService;
import com.newins.util.ErrorMessage;


/**
 * @Description 
 * @author 星仔
 * @time 2017年2月17日下午5:29:10
 */
@Service("myAwardService")
public class MyAwardServiceImp implements MyAwardService {
	
	@Autowired
	private MyAwardDao myAwardDao;
	
	public MyAwardDao getMyAwardDao() {
		return myAwardDao;
	}

	public void setMyAwardDao(MyAwardDao myAwardDao) {
		this.myAwardDao = myAwardDao;
	}


	@Override
	public Object getMyAwardList(int userId, int page) {
	
		List<MyAwardModel> myAwardList = null;
		//调用Dao方法，得到用户的评测数据
		myAwardList = myAwardDao.myAwardList(userId);
//		//循环打印list
//		for (int i = 0; i < myAwardList.size(); i++) {
//			System.out.println(myAwardList.get(i));
//		}
		//处理时间格式
		for (int i = 0; i < myAwardList.size(); i++) {
			String time = myAwardList.get(i).getAwardGetTime();
			String newTime = time.substring(0, 10);
			myAwardList.get(i).setAwardGetTime(newTime);
		}
		
		
		// 从List中分页
		// 先判断分页前List长度是否为0，若为0就不需要分页
		if (myAwardList.size() != 0) {
			List<MyAwardModel> myAwardPageList = null;// 返回的分页List
			int bIndex = (page - 1) * 20;
			int eIndex = (page - 1) * 20 + 19;
			int totalPage = 0;
			if (myAwardList.size() % 20 == 0) {
				totalPage = myAwardList.size() / 20;
			} else {
				totalPage = myAwardList.size() / 20 + 1;
			}
			if (bIndex > myAwardList.size() - 1) {
				JSONObject myAwardUpdateList = new JSONObject();
				myAwardUpdateList.put("success", "true");
				myAwardUpdateList.put("totalPage", totalPage);
				myAwardUpdateList.put("myAwardList", myAwardPageList);
				return myAwardUpdateList;
			}
			if (eIndex < myAwardList.size() - 1) {
				myAwardPageList = myAwardList.subList(bIndex, eIndex + 1);
			} else {
				myAwardPageList = myAwardList.subList(bIndex, myAwardList.size());
			}

			JSONObject myAwardUpdateList = new JSONObject();
			myAwardUpdateList.put("success", "true");
			myAwardUpdateList.put("totalPage", totalPage);
			myAwardUpdateList.put("myAwardList", myAwardPageList);
			return myAwardUpdateList;
		} else {
			JSONObject myAwardUpdateList = new JSONObject();
			myAwardUpdateList.put("success", "true");
			myAwardUpdateList.put("totalPage", 1);
			myAwardUpdateList.put("myAwardList", myAwardList);
			return myAwardUpdateList;
		}

	}
	
}
