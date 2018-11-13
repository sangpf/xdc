package com.newins.service.imp;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.NiTweetDao;
import com.newins.model.MyAssessModel;
import com.newins.model.NiTweetModel;
import com.newins.service.NiTweetServiec;
/**
 * @Description 
 * @author 星仔
 * @time 2017年2月20日下午5:17:58
 */
@Service("niTweetService")
public class NiTweetServiceImp implements NiTweetServiec {
	@Autowired
	private NiTweetDao niTweetDao;
	
	public NiTweetDao getNiTweetDao() {
		return niTweetDao;
	}


	public void setNiTweetDao(NiTweetDao niTweetDao) {
		this.niTweetDao = niTweetDao;
	}

	

	@Override
	public List<NiTweetModel> getNiTweetList() {
		List<NiTweetModel> list = niTweetDao.niTweetList();
		for (int i = 0; i < list.size(); i++) {
			String time = list.get(i).getpTime();
			String newTime = time.substring(0, 10);
			list.get(i).setpTime(newTime);
		}
		
//		// 从List中分页
//		// 先判断分页前List长度是否为0，若为0就不需要分页
//		if (list.size() != 0) {
//			List<NiTweetModel> myAssessPageList = null;// 返回的分页List
//			int bIndex = (page - 1) * 20;
//			int eIndex = (page - 1) * 20 + 19;
//			int totalPage = 0;
//			if (list.size() % 10 == 0) {
//				totalPage = list.size() / 20;
//			} else {
//				totalPage = list.size() / 20 + 1;
//			}
//			if (bIndex > list.size() - 1) {
//				JSONObject niTweetUpdateList = new JSONObject();
//				niTweetUpdateList.put("success", "true");
//				niTweetUpdateList.put("totalPage", totalPage);
//				niTweetUpdateList.put("list", myAssessPageList);
//				return niTweetUpdateList;
//			}
//			if (eIndex < list.size() - 1) {
//				myAssessPageList = list.subList(bIndex, eIndex + 1);
//			} else {
//				myAssessPageList = list.subList(bIndex, list.size());
//			}
//
//			JSONObject niTweetUpdateList = new JSONObject();
//			niTweetUpdateList.put("success", "true");
//			niTweetUpdateList.put("totalPage", totalPage);
//			niTweetUpdateList.put("list", myAssessPageList);
//			return niTweetUpdateList;
//		} else {
//			JSONObject niTweetUpdateList = new JSONObject();
//			niTweetUpdateList.put("success", "true");
//			niTweetUpdateList.put("totalPage", 1);
//			niTweetUpdateList.put("list", list);
//			return niTweetUpdateList;
//		}
		return list;
	}

}
