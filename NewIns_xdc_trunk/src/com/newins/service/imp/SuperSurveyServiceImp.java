/**
 * 
 */
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

import com.newins.controller.AssessController;
import com.newins.dao.SuperSurveyDao;
import com.newins.model.SuperSurvey;
import com.newins.model.SurveyOrder;
import com.newins.model.VoteOrder;
import com.newins.service.SuperSurveyService;
import com.newins.service.SurveyOrderService;
import com.newins.service.VoteOrderService;
import com.newins.util.CommonComparator;
import com.newins.util.ErrorMessage;

/**
 * @Description 超级调查列表service
 * @author Guanziao
 * @time 2016年5月16日 下午4:13:49
 */

@Service(value = "SuperSurveyService")
public class SuperSurveyServiceImp implements SuperSurveyService {
	private static Logger log = Logger.getLogger(AssessController.class);
	@Autowired
	private SuperSurveyDao supersvyDao;
	@Autowired
	private SurveyOrderService surveyOrderService;
	@Autowired
	private VoteOrderService voteOrderService;

	/**
	 * @Title: getSuperSurveyList
	 * @Author: Guan
	 * @Description: 加载超级调查列表
	 * @return List<SuperSurvey>
	 * @Time 2016年5月17日 下午7:31:53
	 */
	@SuppressWarnings("unchecked")
	public Object getSuperSurveyList(int userId, int page, String superListCategory) {
		log.info("this is service: getSuperSurveyList ");

		// List<SuperSurvey> supersvyList = supersvyDao.getSuperSurvey();
		// 将调查和投票分别查询（为了支持调查问卷类型sqnCategory不得不这样，放弃了sql中的union）
		List<SuperSurvey> surveyList = supersvyDao.getSurveyList(superListCategory);
		List<SuperSurvey> voteList = supersvyDao.getVoteList(superListCategory);
		// 初始分页前List对象
		List<SuperSurvey> supersvyList = new ArrayList<SuperSurvey>();
		supersvyList.addAll(surveyList);
		supersvyList.addAll(voteList);
		// 初始化一个比较器
		CommonComparator comparator = new CommonComparator();
		// order by isTop showOrder
		comparator.setFields_user(new String[] { "isTop", "showOrder" });
		Collections.sort(supersvyList, comparator);

		// 实例化调查和投票的问卷idList
		List<Integer> sqnIdList = new ArrayList<Integer>();
		List<Integer> vqnIdList = new ArrayList<Integer>();
		List<SurveyOrder> surveyOrderList = new ArrayList<SurveyOrder>();
		List<VoteOrder> voteOrderList = new ArrayList<VoteOrder>();

		// 根据问卷类型存放问卷Id至问卷List
		for (int i = 0; i < supersvyList.size(); i++) {
			SuperSurvey supersvy = supersvyList.get(i);
			if (supersvy.getQnType() == 1) {
				sqnIdList.add(supersvy.getQnId());
			} else
				vqnIdList.add(supersvy.getQnId());
		}

		if (sqnIdList.size() != 0) {
			surveyOrderList = surveyOrderService.searchOrderBySqnIdList(userId,
					sqnIdList);
			log.info("=================>该用户已存在的调查订单" + surveyOrderList);
		}
		if (vqnIdList.size() != 0) {
			voteOrderList = voteOrderService.searchOrderByVqnIdList(userId,
					vqnIdList);
			log.info("=================>该用户已存在的投票订单" + voteOrderList);
		}

		int qnId, qnType, awardId,deliveryId;
		Integer lotteryId;
		SuperSurvey supersvy = null;
		SuperSurvey tempsupersvy = null;
		for (int i = 0; i < supersvyList.size(); i++) {
			supersvy = supersvyList.get(i);
			// 接收不为空的tag
			List<String> tags = new ArrayList<>();
			for (int j = 0; j < 5; j++) {
				String tag = supersvy.getTagByIndex(j + 1);
				if (tag != null && !("".equals(tag))) {
					tags.add(tag);
				}
			}
			supersvy.setTags(tags);

			qnId = supersvy.getQnId();
			deliveryId = supersvy.getDeliveryId();	//double bug修复
			awardId = supersvy.getAwardId();
			qnType = supersvy.getQnType();
			lotteryId = supersvy.getLotteryId();
			if (awardId != 0 && lotteryId == null) {
				supersvy.setawardMethod(1);// 1，定奖；2，抽奖；0，无奖
			} else if (awardId == 0 && lotteryId != null) {
				supersvy.setawardMethod(2);
			} else if (awardId == 0 && lotteryId == null) {
				supersvy.setawardMethod(0);
			} else {
				ErrorMessage errormsg = new ErrorMessage();
				log.info("=================>超级调查奖励信息配置冲突");
				errormsg.setErrCode("001");
				errormsg.setSuccess("false");
				errormsg.setErrInfo("奖励信息配置冲突");
				return errormsg;
			}
			// 根据调查问卷id获取该调查在调查订单表里的答题人数和获奖人数
			Map<String, Object> param = new HashMap<String, Object>();
			//param.put("qnId", qnId);
			param.put("deliveryId", deliveryId);
			param.put("qnType", qnType);
			tempsupersvy = supersvyDao.getSuperOrderByQnId(param);
			if (tempsupersvy != null) {
				supersvy.setCollectedNum(tempsupersvy.getCollectedNum());
				supersvy.setWinnerNum(tempsupersvy.getWinnerNum());
			}

			// 判断是不是答过
			supersvy.setAnswered(0);
			// 从调查订单list里查
			if (qnType == 1 && surveyOrderList != null) {
				for (int j = 0; j < surveyOrderList.size(); j++) {
					SurveyOrder surveyOrder = surveyOrderList.get(j);
					if (qnId == surveyOrder.getSqnId()) {
						supersvy.setAnswered(1);
						break;
					}
				}
			}

			// 从投票订单List里查
			if (qnType == 3 && voteOrderList != null) {
				for (int j = 0; j < voteOrderList.size(); j++) {
					VoteOrder voteOrder = voteOrderList.get(j);
					if (qnId == voteOrder.getVqnId()) {
						supersvy.setAnswered(1);
						break;
					}
				}
			}

		}

		// 分页后PageList
		if (supersvyList.size() != 0) {
			List<SuperSurvey> supersvyPageList = new ArrayList<SuperSurvey>();
			int bIndex, eIndex;// 分页起始和结束索引
			bIndex = 0 + 10 * (page - 1);
			eIndex = 9 + 10 * (page - 1);
			if (bIndex > supersvyList.size() - 1) {
				ErrorMessage error = new ErrorMessage();
				error.setSuccess("false");
				error.setErrCode("002");
				error.setErrInfo("bIndex is greater than list size");
				return error;
			}
			if (eIndex < supersvyList.size() - 1) {
				supersvyPageList = supersvyList.subList(bIndex, eIndex + 1);
			} else {
				supersvyPageList = supersvyList.subList(bIndex,
						supersvyList.size());
			}

			int totalPage = 0;
			// 总页数
			if (supersvyList.size() % 10 == 0) {
				totalPage = supersvyList.size() / 10;
			} else {
				totalPage = supersvyList.size() / 10 + 1;
			}
			JSONObject superObject = new JSONObject();
			superObject.put("success", "true");
			superObject.put("totalPage", totalPage);
			superObject.put("records", supersvyPageList);

			return superObject;
		} else {
			JSONObject superObject = new JSONObject();
			superObject.put("success", "true");
			superObject.put("totalPage", 1);
			superObject.put("records", supersvyList);
			return superObject;
		}
	}
}
