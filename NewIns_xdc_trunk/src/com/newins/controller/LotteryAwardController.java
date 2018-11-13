package com.newins.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.LotteryAward;
import com.newins.service.LotteryAwardService;

/**@Description  抽奖奖品 1，2，3等奖奖品信息
 * @author MaNia_chAng
 * @time 2016年7月4日 下午2:36:32
 */
@Controller
@RequestMapping("/wanx")
public class LotteryAwardController {
	
	@Autowired
	private LotteryAwardService lotteryAwardService;
	
	@RequestMapping(value = "lotteryAward",method = RequestMethod.GET)
	@ResponseBody
	public List<LotteryAward> getLotteryAward(HttpServletRequest request){
		
		String deliveryIdStr = request.getParameter("deliveryId");
		String qnTypeStr = request.getParameter("qnType");
		String channelStr = request.getParameter("channel");
		String awardMethodStr = request.getParameter("awardMethod");
		
		int deliveryId = 0;
		if(deliveryIdStr!=null){
			deliveryId = Integer.parseInt(deliveryIdStr);
		}
		int qnType = 0;
		if(qnTypeStr!=null){
			qnType = Integer.parseInt(qnTypeStr);
		}
		int channel = 0;
		if(channelStr!=null){
			channel = Integer.parseInt(channelStr);
		}
		int awardMethod = 0;//区分是倾向型抽奖还是随机抽奖
		if(awardMethodStr!=null){
			awardMethod = Integer.parseInt(awardMethodStr);
		}
		
		List<LotteryAward> awards = new ArrayList<>();
		awards = lotteryAwardService.getLotteryAward(deliveryId,qnType,channel,awardMethod);
		return awards;
		
	}

}
