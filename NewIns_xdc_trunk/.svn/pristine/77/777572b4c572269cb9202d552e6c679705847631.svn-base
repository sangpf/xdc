/**
 * 
 */
package com.newins.service;

import java.util.List;
import java.util.Map;

import com.newins.model.ReportItem;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年6月16日 下午5:54:05
 */
public interface ReportService {
	public List<ReportItem> getReportInfo();
	
	public boolean addReportViewNum(int reportId);
	
	void reportThumbUpAndDown(Map<String, Object> hashMap); 
	/**
	 * 查询问卷是否收藏
	 * @param userId:要查询的用户
	 * @param reportId:要查询的问卷Id
	 * @return
	 */
	int judgeIsFavorite(int userId,int reportId);
}
