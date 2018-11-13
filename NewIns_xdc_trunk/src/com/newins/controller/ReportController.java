package com.newins.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.ReportItem;
import com.newins.service.imp.ReportServiceImp;
import com.newins.util.AjaxResult;
import com.newins.util.ErrorMessage;

/**
 * @Description 报告列表的controller,相应的Url为/wanx
 * @author MaNia_chAng
 * @time 2016年5月16日 下午3:01:01
 */
@Controller
@RequestMapping("/wanx")
public class ReportController {
	private static Logger log = Logger
			.getLogger(ReportController.class);

	@Autowired
	private ReportServiceImp reportService;

	/**
	 * @Title: getReportInfo
	 * @Author: MaNia_chAng
	 * @Description: 加载报告列表，相应的url为 /wanx/reportList
	 * @return List<ReportItem>
	 * @Time 2016年5月17日 下午3:12:54
	 */
	@RequestMapping(value = "/reportList", method = RequestMethod.GET)
	@ResponseBody
	public Object getReportInfo(HttpServletRequest request) {
		System.out.println("This is controller:getReportInfo()");
		//获取session；
		HttpSession session=request.getSession();
		//获取userId
		Object userId=session.getAttribute("userId");
//		Object userId=request.getParameter("userId");
		if(userId!=null){
			//调用相关方法
			List<ReportItem> reportList= reportService.getReportInfo();
			//循环设置isFavorite字段
			for (int i = 0; i < reportList.size(); i++) {
			//取出list中的reportId,调用查询问卷是否收藏方法
				int reportId=reportList.get(i).getReportId();
				int isFavorite=reportService.judgeIsFavorite(Integer.parseInt(userId.toString()), reportId);
				//如果isFavorite变量得到的不是0就说明收藏了
				if(isFavorite!=0){
					//设置reportList的isFavorite字段设置为1
					reportList.get(i).setIsFavorite(1);
				}else{
					//说明没有收藏就设置为0
					reportList.get(i).setIsFavorite(0);
				}
			}
			return reportList;
		}else{
			ErrorMessage error=new ErrorMessage();
			error.setErrCode("002");
			error.setErrInfo("userId is null");
			error.setSuccess("false");
			return error;
		}

	}

	/**
	 * @Title: addReportViewNum
	 * @Author: Guan
	 * @Description: 用户点击报告触发事件，每点击一次viewNum+1
	 * @return Object
	 * @Time 2016年8月4日 下午1:18:05
	 */
	@RequestMapping(value = "/addReportViewNum", method = RequestMethod.POST)
	@ResponseBody
	public Object addReportViewNum(HttpServletRequest request) {
		log.info("This is addReportViewNumController");
		String reportId = request.getParameter("reportId").trim();
		int report_Id = Integer.parseInt(reportId);
		 if(reportService.addReportViewNum(report_Id)){
			 return "{\"success\":\"true\",\"comments\":\"add viewNum successfully\"}";
		 }
		 else{
			 ErrorMessage errmsg=new ErrorMessage();
			 errmsg.setSuccess("false");
			 errmsg.setErrCode("001");
			 errmsg.setErrInfo("not find reportId in db");
			 return errmsg;
		 }
	}
	
	/**
	 * @Title: reportThumbUpAndDown  
	 * @Author: MaNia_chAng
	 * @Description: 更新报告点赞/鄙视
	 * @param request
	 * @return Object
	 * @Time 2016年9月18日 下午1:23:51
	 */
	@RequestMapping(value = "/reportThumbUpAndDown", method = RequestMethod.GET)
	@ResponseBody
	public Object reportThumbUpAndDown(HttpServletRequest request) {

		log.info("This is controller:updateReportThumbAndDown");
		String reportIdStr = request.getParameter("reportId").trim();
		String thumbUpStr = request.getParameter("thumbUp").trim();
		String thumbDownStr = request.getParameter("thumbDown").trim();		
		int reportId = Integer.parseInt(reportIdStr);
		int thumbUp = Integer.parseInt(thumbUpStr);
		int thumbDown = Integer.parseInt(thumbDownStr);
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("reportId", reportId);
		hashMap.put("thumbUp", thumbUp);
		hashMap.put("thumbDown", thumbDown);

		try {
			reportService.reportThumbUpAndDown(hashMap);
			return AjaxResult.successResult("updateReportThumbUpAndDown successfuly");
		} catch (Exception e) {
			return AjaxResult.errorResult("updateReportThumbUpAndDown error");
		}
	}

}
