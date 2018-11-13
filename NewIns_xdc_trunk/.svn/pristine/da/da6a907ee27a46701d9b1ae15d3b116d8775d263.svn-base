package com.newins.dao;

import java.util.List;
import java.util.Map;

import com.newins.model.ReportItem;

/**@Description  报告列表Dao
 * @author MaNia_chAng
 * @time 2016年5月16日 下午3:34:52
 */
public interface ReportDao {

	/**
	 * @Title: getReportInfo  
	 * @Author: MaNia_chAng
	 * @Description: 加载报告列表
	 * @return List<ReportItem>
	 * @Time 2016年5月17日 下午3:14:55
	 */
	public List<ReportItem> getReportInfo();
	/**
	 * @Title: addReportViewNum  
	 * @Author: Guan
	 * @Description: 根据reportId对相应的wanxViewNum字段+1
	 * @param reportId
	 * @return boolean
	 * @Time 2016年8月4日 下午1:34:11
	 */
	public boolean addReportViewNum(int reportId);
	
	/**
	 * @Title: reportThumbUpAndDown  
	 * @Author: MaNia_chAng
	 * @Description: 更新报告点赞/鄙视
	 * @param hashMap void
	 * @Time 2016年9月18日 下午1:30:28
	 */
	void reportThumbUpAndDown(Map<String, Object> hashMap);
	/**
	 * 查询问卷是否收藏
	 * @param userId
	 * @param reportId:问卷Id
	 * @return
	 */
	int judgeIsFavorite(int userId,int reportId);
}
