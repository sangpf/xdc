package com.newins.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.ReportDao;
import com.newins.model.ReportItem;
import com.newins.service.ReportService;

/**@Description  报告列表Service
 * @author MaNia_chAng
 * @time 2016年5月16日 下午3:21:49
 */
@Service
public class ReportServiceImp  implements ReportService{
	@Autowired
	private ReportDao reportDao;
	
	/**
	 * @Title: getReportInfo  
	 * @Author: MaNia_chAng
	 * @Description: 加载报告列表
	 * @return List<ReportItem>
	 * @Time 2016年5月17日 下午3:17:17
	 */
	public List<ReportItem> getReportInfo(){
		System.out.println("This is service:getReportInfo()");
		List<ReportItem> reportList=reportDao.getReportInfo();
		return reportList;
	}
	
	/**
	 * 用户点击报告触发事件，viewNum+1
	 */
	public boolean addReportViewNum(int reportId){
		return reportDao.addReportViewNum(reportId);
	}
	
	public void reportThumbUpAndDown(Map<String, Object> hashMap) {
		reportDao.reportThumbUpAndDown(hashMap);
	}

	@Override
	public int judgeIsFavorite(int userId, int reportId) {
		//调用Dao相关方法
		return reportDao.judgeIsFavorite(userId, reportId);
	}

}
