package com.newins.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.QnAdvert;
import com.newins.service.imp.QnAdvertServiceImp;


/**
 * @Description 答题结果页广告Controller
 * @author Guan
 * @time 2016年5月23日 下午2:06:42
 */

@Controller
@RequestMapping("/wanx")
public class QnAdvertController {

	@Autowired
	private QnAdvertServiceImp qnAdvertService;

	/**
	 * @Title: getQnAdvertInfo
	 * @Author: Guan
	 * @Description: 通过入参deliveryId加载相应的广告信息
	 * @return QnAdvert
	 * @Time 2016年5月23日 下午8:47:41
	 */
	@RequestMapping(value = "/qnAd", method = RequestMethod.GET)
	@ResponseBody
	public QnAdvert getQnAdvertInfo(HttpServletRequest request) {
		System.out.println("this is controller: getQnAdvertInfo()");
		String deliveryIdStr = request.getParameter("deliveryId");
		int deliveryId = 0;
		if(deliveryIdStr!=null){
			deliveryId = Integer.parseInt(deliveryIdStr);
		}
		
		
		return qnAdvertService.getQnAdvert(deliveryId);
	}

}
