/**
 * 
 */
package com.newins.dao;

import java.util.List;
import java.util.Map;

import com.newins.model.SuperSurvey;

/**
 * @Description 超级调查Dao
 * @author Guanziao
 * @time 2016年5月16日 下午3:07:31
 */
public interface SuperSurveyDao {
/*
	@Autowired
	private SqlSessionFactory sqlfactory;*/

	/**
	 * @Title: getSuperSurvey
	 * @Author: Guan
	 * @Description: 加载超级调查列表
	 * @return List<SuperSurvey>
	 * @Time 2016年5月16日 下午4:21:00
	 */
	List<SuperSurvey> getSuperSurvey();//暂时弃用，因为sql没法union了
	
	/**
	 * @Title: getSurveyOrderData  
	 * @Author: Guan
	 * @Description: 根据调查问卷id获取该调查在调查订单表里的答题人数和获奖人数
	 * @param qnId 问卷Id
	 * @return SuperSurvey
	 * @Time 2016年5月18日 上午10:42:09
	 */
	SuperSurvey getSuperOrderByQnId(Map<String, Object> param);
	
	/**
	 * @Title: getSurveyList  
	 * @Author: Guan
	 * @Description: 加载超级调查列表之——加载调查问卷
	 * @return List<SuperSurvey>
	 * @Time 2016年10月14日 上午10:23:04
	 */
	List<SuperSurvey> getSurveyList(String superListCategory);
	
	/**
	 * @Title: getVoteList  
	 * @Author: Guan
	 * @Description: 加载投票列表之——加载投票问卷
	 * @return List<SuperSurvey>
	 * @Time 2016年10月14日 上午10:23:52
	 */
	List<SuperSurvey> getVoteList(String superListCategory);
}
