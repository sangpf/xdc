package com.newins.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.service.ThumbUpAndDownService;
import com.newins.util.AjaxResult;

/**
 * @Description
 * @author MaNia_chAng
 * @time 2016年8月29日 下午4:24:47
 */
@Controller
@RequestMapping("/wanx")
public class ThumbUpAndDownController {

	private static Logger log = Logger.getLogger(ThumbUpAndDownController.class);
	@Resource
	private ThumbUpAndDownService thumbUpAndDownService;

	/**
	 * @Title: updateThumbUpAndDown
	 * @Author: Guan
	 * @Description: 赞踩
	 * @param request
	 * @return Object
	 * @Time 2017年1月6日 下午4:21:45
	 */
	@RequestMapping(value = "/updateThumbUpAndDown", method = RequestMethod.GET)
	@ResponseBody
	public Object updateThumbUpAndDown(HttpServletRequest request) {

		log.info("This is controller:updateThumbUpAndDown");
		String qnTypeStr = request.getParameter("qnType").trim();
		String deliveryIdStr = request.getParameter("deliveryId").trim();
		String thumbUpStr = request.getParameter("thumbUp").trim();
		String thumbDownStr = request.getParameter("thumbDown").trim();
		int qnType = Integer.parseInt(qnTypeStr);
		int deliveryId = Integer.parseInt(deliveryIdStr);
		int thumbUp = Integer.parseInt(thumbUpStr);
		int thumbDown = Integer.parseInt(thumbDownStr);
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("qnType", qnType);
		hashMap.put("deliveryId", deliveryId);
		hashMap.put("thumbUp", thumbUp);
		hashMap.put("thumbDown", thumbDown);

		try {
			thumbUpAndDownService.updateThumbUpAndDown(hashMap);
			return AjaxResult.successResult("updateThumbUpAndDown successfuly");
		} catch (Exception e) {
			return AjaxResult.errorResult("updateThumbUpAndDown error");
		}
	}

}
