package com.newins.dao;

import java.util.List;

import com.newins.model.SuperSurvey;
import com.newins.model.SurveyAnswer;
import com.newins.model.SurveyOrder;

/**
 * @Description 递交问卷答案Dao层
 * @author Guan
 * @time 2016年5月24日 上午8:55:53
 */

public interface SubmitSurveyAnswerDao {
/*	@Autowired
	private SqlSessionFactory sqlfactory;*/

	/**
	 * @Title: postSurveyAnswer
	 * @Author: Guan
	 * @Description: 将问卷答案List递交至数据库
	 * @param surveyAnswerList
	 *            void
	 * @Time 2016年5月31日 上午11:14:43
	 */
	boolean setSurveyAnswer(List<SurveyAnswer> surveyAnswerList); /*{
		System.out.println("this is Dao：postSurveyAnswer");
		try {
			// submit data to mysql
			SqlSession session = sqlfactory.openSession(true);
			session.insert(
					"com.newins.sqlmapping.surveyAnswerMapper.setSurveyAnswer",
					surveyAnswerList);
			session.commit();
			session.close();
		} catch (Exception e) {
			throw e;
		}
		return true;

	}*/

	/**
	 * @Title: initSurveyOrder
	 * @Author: Guan
	 * @Description: 初始化一条订单，将订单写入数据库
	 * @param svyOrder
	 *            void
	 * @Time 2016年6月3日 下午4:15:40
	 */
	void initSurveyOrder(SurveyOrder svyOrder); /*{
		System.out.println("this is initSurveyOrderDao");

		SqlSession session = sqlfactory.openSession(true);
		// 由userId和sqnId创建一条新的order
		session.insert(
				"com.newins.sqlmapping.surveyAnswerMapper.initSurveyOrder",
				svyOrder);
		session.commit();
		session.close();
	}*/
	/**
	 * @Title: getCollectedNumById  
	 * @Author: Guan
	 * @Description: 根据deliveryId获取已收集问卷数和需要收集问卷数
	 * @param sqnId
	 * @return SuperSurvey
	 * @Time 2016年6月28日 下午6:38:05
	 */
	SuperSurvey getCollectedNumById(int deliveryId);
	/**
	 * @Title: changeDeliveryStatus  
	 * @Author: Guan
	 * @Description: 将Delivery status置为完成状态
	 * @param sqnId void
	 * @Time 2016年6月28日 下午6:38:10
	 */
	void changeDeliveryStatus(int sqnId);
	
	/**
	 * @Title: getSurveyChoiceBySqnId  
	 * @Author: Guan
	 * @Description: 根据sqnId查询选择题结果，目前用户核心题统计
	 * @param sqnId
	 * @return List<SurveyAnswer>
	 * @Time 2016年11月21日 上午10:58:28
	 */
	public List<String> getSurveyChoiceBySqId(int sqnId);
}