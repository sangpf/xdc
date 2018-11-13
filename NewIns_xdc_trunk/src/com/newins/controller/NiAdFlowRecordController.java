package com.newins.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.NiAdFlowRecord;
import com.newins.service.NiAdFlowRecordService;
import com.newins.service.NiAdStatisticsService;
import com.newins.util.AjaxResult;
import com.newins.util.ErrorMessage;

/**
 * @author lj
 * @Description : 广告流水记录的Controller
 * @time : 2016年7月28日 下午8:02:34
 */
@Controller
@RequestMapping("/wanx")
@Transactional
public class NiAdFlowRecordController {
	
	//日志
	Logger log=Logger.getLogger(NiAdStatisticsController.class);
	
	@Autowired
	private NiAdFlowRecordService niAdFlowRecordService;
	
	@Autowired
	private NiAdStatisticsService niAdStatisticsService;
	

	/**
	 * @author lj
	 * @Description : 用户点击一次广告记录一次广告流水,同时更新广告统计表中的点击量
	 * @time : 2016年7月28日 下午8:05:55
	 * @param request
	 * @param response
	 * @return AjaxResult
	 */
	@RequestMapping(value="/adClickRecord",method=RequestMethod.POST)
	@ResponseBody
	public Object recordUserClickAd(HttpServletRequest request,HttpServletResponse response){
		
		AjaxResult ajaxResult=new AjaxResult();
		NiAdFlowRecord niAdFlowRecord=new NiAdFlowRecord();
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		
		//从前端页面接受参数
		//userId从session中取出
		int userId=0;
		HttpSession session=request.getSession(true);
		Object userIdObj=session.getAttribute("userId");
		if(userIdObj==null){
			ErrorMessage error = new ErrorMessage();
			error.setSuccess("false");
			error.setErrCode("001");
			error.setErrInfo("userId is null");
			return error;
		}else{
			userId=Integer.parseInt(userIdObj.toString());
		}
//		String userIdStr=request.getParameter("userId");
//		int userId=Integer.parseInt(userIdStr);
		
		String adId=request.getParameter("adId");
		String adPosCode=request.getParameter("adPosCode");
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String clickTime=dateFormat.format(new Date());
		
	//	NiAdStatistics niAdStatistics=niAdStatisticsService.selectListByPrimaryKey(Integer.valueOf(adId));
		
	//	int channel=niAdStatistics.getAdChannel();
		
		//配置NiAdFlowRecord对象
		niAdFlowRecord.setAdId(Integer.valueOf(adId));
		niAdFlowRecord.setUserId(userId);
		niAdFlowRecord.setAdPosCode(adPosCode);
		niAdFlowRecord.setAdChannel(1);
		niAdFlowRecord.setAdTapTime(Timestamp.valueOf(clickTime));
		
		
		//用户点击广告时记录广告流水
		int recordClickAd=0;
		log.info("========================>>记录用户点击广告");
		try {
			recordClickAd=niAdFlowRecordService.insertAdFlowRecord(niAdFlowRecord);
			if(recordClickAd > 0){
				//记录成功
				log.info("========================>>记录用户点击广告流水成功");
				ajaxResult.put("success", true);
				ajaxResult.put("msg", "记录用户点击广告成功");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			//写入记录失败
			log.info("========================>>记录用户点击广告流水失败");
			ajaxResult.put("success", false);
			ajaxResult.put("msg", "记录用户点击广告失败");
			e.printStackTrace();
		}
		
		
		//更新广告统计表[记录点击量]
		
		hashMap.put("adId", Integer.valueOf(adId));
		hashMap.put("adPosCode", adPosCode);
		int updateAdStatistics=0;
		try {
			updateAdStatistics=niAdStatisticsService.updateClickAdStatistics(hashMap);
			if(updateAdStatistics > 0){
				//更新成功
				log.info("========================>>更新用户点击量成功");
				ajaxResult.put("success", true);
				ajaxResult.put("msg", "记录用户点击广告成功");
			}
		} catch (Exception e) {
			
			//更新记录失败
			log.info("========================>>更新用户点击量失败");
			ajaxResult.put("success", false);
			ajaxResult.put("msg", "记录用户点击广告失败");
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return ajaxResult;
		
	}
}
