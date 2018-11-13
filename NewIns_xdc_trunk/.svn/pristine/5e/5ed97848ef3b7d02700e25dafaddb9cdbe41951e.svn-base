package com.newins.service.imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.controller.ActivityController;
import com.newins.dao.ActivityDao;
import com.newins.model.ActivityItem;
import com.newins.model.AssessOrder;
import com.newins.model.SurveyOrder;
import com.newins.model.VoteOrder;
import com.newins.service.ActivityService;
import com.newins.service.AssessOrderService;
import com.newins.service.SurveyOrderService;
import com.newins.service.VoteOrderService;
import com.newins.util.CommonComparator;
import com.newins.util.ErrorMessage;

/**
 * @Description 活动service
 * @author Fanyuelin
 * @time May 15, 2016 12:13:16 PM
 */
@Service(value = "ActivityService")
public class ActivityServiceImp implements ActivityService {
	private static Logger log = Logger.getLogger(ActivityController.class);
	@Autowired
	private ActivityDao activityDao;
	@Autowired
	private SurveyOrderService surveyOrderService;
	@Autowired
	private AssessOrderService assessOrderService;
	@Autowired
	private VoteOrderService voteOrderService;

	/**
	 * @Title: getActivityList
	 * @Author: Fanyuelin
	 * @Description: 加载活动页列表
	 * @return List<ActivityList>
	 * @Time May 15, 2016 12:14:19 PM
	 */
	@SuppressWarnings("unchecked")
	public Object getActivityList(int userId, int activityType, int page) {
		log.info("this is service: getActivityList() ");

		// 获得三更列表的信息，包括调查、测评和投票（弃用）
		// List<ActivityItem> activityList =
		// activityDao.getActivityList(activityType);
		List<ActivityItem> surveyList = activityDao.getSurveyList(activityType);
		List<ActivityItem> assessList = activityDao.getAssessList(activityType);
		List<ActivityItem> voteList = activityDao.getVoteList(activityType);
		List<ActivityItem> activityList = new ArrayList<ActivityItem>();
		activityList.addAll(surveyList);
		activityList.addAll(assessList);
		activityList.addAll(voteList);
		// 初始化一个比较器
		CommonComparator comparator = new CommonComparator();
		// order by isTop showOrder
		comparator.setFields_user(new String[] { "isTop", "showOrder" });
		Collections.sort(activityList, comparator);

		// 实例化三种问卷的idList
		List<Integer> sqnIdList = new ArrayList<Integer>();
		List<Integer> aqnIdList = new ArrayList<Integer>();
		List<Integer> vqnIdList = new ArrayList<Integer>();
		// 实例化三种Order的List

		List<SurveyOrder> surveyOrderList = new ArrayList<SurveyOrder>();
		List<AssessOrder> assessOrderList = new ArrayList<AssessOrder>();
		List<VoteOrder> voteOrderList = new ArrayList<VoteOrder>();
		// 根据问卷类型将问卷的Id存到相应的List
		for (int i = 0; i < activityList.size(); i++) {
			ActivityItem activityItem = activityList.get(i);
			if (activityItem.getQnType() == 1) {
				sqnIdList.add(activityItem.getQnId());
			} else if (activityItem.getQnType() == 2) {
				aqnIdList.add(activityItem.getQnId());
			} else {
				vqnIdList.add(activityItem.getQnId());
			}
		}
		// 该用户所有的调查、测评、投票订单
		if (sqnIdList.size() != 0) {
			surveyOrderList = surveyOrderService.searchOrderBySqnIdList(userId,
					sqnIdList);
			log.info("=================>该用户已存在的调查订单" + surveyOrderList);
		}
		if (aqnIdList.size() != 0) {
			assessOrderList = assessOrderService.searchOrderByAqnIdList(userId,
					aqnIdList);
			log.info("=================>该用户已存在的测评订单" + assessOrderList);
		}
		if (vqnIdList.size() != 0) {
			voteOrderList = voteOrderService.searchOrderByVqnIdList(userId,
					vqnIdList);
			log.info("=================>该用户已存在的投票订单" + voteOrderList);
		}

		// qnId在调查里对应sqnId,在测评里对应aqnId,在投票里对应vqnId
		int qnId, qnType;
		ActivityItem activityItem = null;
		ActivityItem tempD3uItem = null;
		for (int i = 0; i < activityList.size(); i++) {
			activityItem = activityList.get(i);
			qnId = activityItem.getQnId();
			qnType = activityItem.getQnType();
			// 判断答没答过
			activityItem.setAnswered(0);
			// 判断用户是否答过，答过直接从list中去掉
			// 从调查订单list里查
			if (qnType == 1 && surveyOrderList != null) {
				for (int j = 0; j < surveyOrderList.size(); j++) {
					SurveyOrder surveyOrder = surveyOrderList.get(j);
					if (qnId == surveyOrder.getSqnId()) {
						activityItem.setAnswered(1);
						break;
					}
				}
			}
			// 从测评订单List里查
			if (qnType == 2 && assessOrderList != null) {
				for (int j = 0; j < assessOrderList.size(); j++) {
					AssessOrder assessOrder = assessOrderList.get(j);
					if (qnId == assessOrder.getAqnId()) {
						activityItem.setAnswered(1);
						break;
					}
				}
			}
			// 从投票订单List里查
			if (qnType == 3 && voteOrderList != null) {
				for (int j = 0; j < voteOrderList.size(); j++) {
					VoteOrder voteOrder = voteOrderList.get(j);
					if (qnId == voteOrder.getVqnId()) {
						activityItem.setAnswered(1);
						break;
					}
				}
			}
			// 接收不为空的tag
			List<String> tags = new ArrayList<>();
			for (int j = 0; j < 5; j++) {
				String tag = activityItem.getTagByIndex(j + 1);
				if (tag != null && !("".equals(tag))) {
					tags.add(tag);
				}
			}

			activityItem.setTags(tags);

			if (activityItem.getAwardId() == 0
					&& activityItem.getLotteryId() == null) {
				activityItem.setawardMethod(0);
			} else if (activityItem.getAwardId() != 0
					&& activityItem.getLotteryId() == null) {
				activityItem.setawardMethod(1);
			} else if (activityItem.getAwardId() == 0
					&& activityItem.getLotteryId() != null) {
				activityItem.setawardMethod(2);
			}

			// 根据调查问卷、测评或投票ID,获取该调查在调查、测评或投票订单表里的答题人数和获奖人数

			Map<String, Object> param = new HashMap<String, Object>();
			param.put("qnId", qnId);
			param.put("qnType", qnType);
			tempD3uItem = activityDao.getOrderData(param);

			if (tempD3uItem != null) {
				activityItem.setCollectedNum(tempD3uItem.getCollectedNum());
				activityItem.setWinnerNum(tempD3uItem.getWinnerNum());
			} else {
				activityItem.setCollectedNum(0);
				activityItem.setWinnerNum(0);
			}// 没有查询到订单，还没有人答过
		}

		// 从List中分页
		if (assessList.size() != 0) {
			List<ActivityItem> activityPageList = null;// 返回的分页List
			int bIndex = (page - 1) * 10;
			int eIndex = (page - 1) * 10 + 9;
			int totalPage = 0;
			if (assessList.size() % 10 == 0) {
				totalPage = assessList.size() / 10;
			} else {
				totalPage = assessList.size() / 10 + 1;
			}
			if (bIndex > assessList.size() - 1) {
				ErrorMessage error = new ErrorMessage();
				error.setSuccess("false");
				error.setErrCode("003");
				error.setErrInfo("bIndex is greater than list size");
				return error;
			}
			if (eIndex < assessList.size() - 1) {
				activityPageList = activityList.subList(bIndex, eIndex + 1);
			} else {
				activityPageList = activityList.subList(bIndex,
						assessList.size());
			}

			JSONObject activityPage = new JSONObject();
			activityPage.put("success", "true");
			activityPage.put("totalPage", totalPage);
			activityPage.put("record", activityPageList);

			return activityPage;
		} else {
			JSONObject activityPage = new JSONObject();
			activityPage.put("success", "true");
			activityPage.put("totalPage", 1);
			activityPage.put("record", activityList);

			return activityPage;
		}

		// return activityList;

	}
}
