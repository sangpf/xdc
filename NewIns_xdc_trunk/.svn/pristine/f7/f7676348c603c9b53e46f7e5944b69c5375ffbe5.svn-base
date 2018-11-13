package com.newins.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.service.NiAdStatisticsService;
import com.newins.util.AjaxResult;
import com.newins.util.StrUtils;

/**
 * @author lj
 * @Description : 后台记录用户浏览广告行为响应的Controller
 * @time : 2016年7月28日 下午4:32:15
 */
@Controller
@RequestMapping("/wanx")
public class NiAdStatisticsController {
	
	//日志记录
	Logger log=Logger.getLogger(NiAdStatisticsController.class);
	
	@Autowired
	private NiAdStatisticsService niAdStatisticsService;

	/**
	 * @author lj
	 * @Description : 用户加载出广告之后将浏览量和广告位置更新到广告统计表中
	 * @time : 2016年7月28日 下午4:43:09	
	 * @param hashMap
	 * @return AjaxResult
	 */
	@RequestMapping(value="/adOnloadRecord",method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult updateAdStatistics(HttpServletRequest request,HttpServletResponse response){
		AjaxResult ajaxResult=new AjaxResult();
		HashMap<String, Object> hashMap=new HashMap<>();
		//接受从前端传回的参数
		String adId=request.getParameter("adId");
		String adPosCode=request.getParameter("adPosCode");
		
		if(StrUtils.isNotEmpty(adId) && !adId.equals("undefined")){
			//放入hashMap中
			hashMap.put("adId", Integer.valueOf(adId));
			
			hashMap.put("adPosCode", adPosCode);
			
			int updAdStatistics=0;
			
			//更新数据库
			try {
				updAdStatistics=niAdStatisticsService.updateAdStatistics(hashMap);
				log.info("========================>>更新广告统计表");
				if(updAdStatistics > 0){
					//更新成功
					log.info("========================>>更新广告统计表成功");
					ajaxResult.put("success", true);
					ajaxResult.put("msg", "更新广告统计表成功");
				}
			} catch (Exception e) {
				log.info("========================>>更新广告统计表失败");
				
				ajaxResult.put("success", false);
				ajaxResult.put("msg", "更新广告统计表失败");
				e.printStackTrace();
				// TODO: handle exception
			}
			
			return ajaxResult;
			
		}else{
			return AjaxResult.errorCode("adId is invalid", "001");
		}
		

	}
}
