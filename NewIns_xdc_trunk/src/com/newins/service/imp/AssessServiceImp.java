/**
 * 
 */
package com.newins.service.imp;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.AssessDao;
import com.newins.model.Assess;
import com.newins.model.AssessOrder;
import com.newins.service.AssessOrderService;
import com.newins.service.AssessService;
import com.newins.util.ErrorMessage;

/**
 * @Description 加载测评列表service实现类
 * @author Guan
 * @time 2016年6月17日 下午7:54:03
 */
@Service(value = "AssessService")
public class AssessServiceImp implements AssessService {
	private static Logger log = Logger.getLogger(AssessServiceImp.class);
	@Autowired
	private AssessDao assessDao;
	@Autowired
	private AssessOrderService assessOrderService;

	/**
	 * @Title: getSuperSurveyList
	 * @Author: Guan
	 * @Description: 加载测评列表
	 * @return List<SuperSurvey>
	 * @Time 2016年5月17日 下午7:31:53
	 */
	public Object getAssessList(int userId, int page,String assessListCategory) {
		// System.out.println("this is service: getAssessList() ");
		log.info("this is service: getAssessList() ");
		
		long time1 = System.currentTimeMillis();
		List<Assess> assessList = assessDao.getAssess(assessListCategory);
		
		long time2 = System.currentTimeMillis();
		log.info("-----------------------加载专业测评栏目, 查询数据库 所需时间 : "+(time2-time1));
		
		List<Integer> aqnIdList = new ArrayList<Integer>();
		List<AssessOrder> assessOrderList = new ArrayList<AssessOrder>();

		// 获取该用户在列表中的aqnId的order
		for (int i = 0; i < assessList.size(); i++) {
			Assess assess = assessList.get(i);
			aqnIdList.add(i, assess.getAqnId());
		}
		if (aqnIdList.size() != 0) {
			assessOrderList = assessOrderService.searchOrderByAqnIdList(userId,
					aqnIdList);
			log.info("=================>该用户已存在的订单" + assessOrderList);
		}

		int aqnId, awardId,deliveryId;
		Integer lotteryId;
		Assess assess = null;
		Assess tempAssess = null;
		
		long time3 = System.currentTimeMillis();
		
		for (int i = 0; i < assessList.size(); i++) {
			assess = assessList.get(i);
			// 接收不为空的tag
			List<String> tags = new ArrayList<>();
			for (int j = 0; j < 5; j++) {
				String tag = assess.getTagByIndex(j + 1);
				if (tag != null && !("".equals(tag))) {
					tags.add(tag);
				}
			}
			assess.setTags(tags);

			assess = assessList.get(i);
			aqnId = assess.getAqnId();
			deliveryId = assess.getDeliveryId();//double bug修复
			awardId = assess.getAwardId();
			lotteryId = assess.getLotteryId();
			if (awardId != 0 && lotteryId == null) {
				assess.setawardMethod(1);// 1，定奖；2，抽奖；0，无奖
			} else if (awardId == 0 && lotteryId != null) {
				assess.setawardMethod(2);
			} else if (awardId == 0 && lotteryId == null) {
				assess.setawardMethod(0);
			} else {
				log.info("=================>测评奖励信息配置冲突");
				ErrorMessage errormsg = new ErrorMessage();
				errormsg.setErrCode("001");
				errormsg.setSuccess("false");
				errormsg.setErrInfo("奖励信息配置冲突");
				return errormsg;
			}
			// 根据测评问卷id获取该测评在测评订单表里的答题人数和获奖人数
			tempAssess = assessDao.getAssessOrderByAqnId(deliveryId);
			if (tempAssess != null) {
				assess.setCollectedNum(tempAssess.getCollectedNum());
				assess.setWinnerNum(tempAssess.getWinnerNum());

			}
			// 判断是不是答过
			if (assessOrderList != null) {
				for (int j = 0; j < assessOrderList.size(); j++) {
					AssessOrder assessOrder = assessOrderList.get(j);
					if (aqnId == assessOrder.getAqnId()) {
						assess.setAnswered(1);
						break;
					} else
						assess.setAnswered(0);
				}
			} else {
				assess.setAnswered(0);
			}
		}
		
		long time4 = System.currentTimeMillis();
		log.info("------------------------->> 查询专业测评数据库后, 执行for循环, 改for循环中有操作数据库, 所需时间 :"+(time4-time3));
		
		// 从List中分页
		if (assessList.size() != 0) {
			List<Assess> assessPageList = null;// 返回的分页List
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
				assessPageList = assessList.subList(bIndex, eIndex + 1);
			} else {
				assessPageList = assessList.subList(bIndex, assessList.size());
			}

			JSONObject assessPage = new JSONObject();
			assessPage.put("success", "true");
			assessPage.put("totalPage", totalPage);
			assessPage.put("record", assessPageList);

			return assessPage;
		} else {
			JSONObject assessPage = new JSONObject();
			assessPage.put("success", "true");
			assessPage.put("totalPage", 1);
			assessPage.put("record", assessList);
			return assessPage;
		}
		
	}
}
