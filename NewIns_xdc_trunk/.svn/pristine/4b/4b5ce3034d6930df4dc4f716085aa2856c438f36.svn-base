package com.newins.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.service.UpdateAwardGetStatusService;
import com.newins.util.AjaxResult;
import com.newins.util.ErrorMessage;

/**@Description  更新订单表中的奖品领取和发放状态接口
 * @author MaNia_chAng
 * @time 2016年8月19日 下午3:36:16
 */
@Controller
@RequestMapping("/wanx")
public class UpdateAwardGetStatusController {
	@Resource
	private UpdateAwardGetStatusService updateAwardGetStatusService;
	
	private static Logger log = Logger.getLogger(UpdateAwardGetStatusController.class);
	
	@RequestMapping(value = "/updateAwardGetStatus", method = RequestMethod.POST)
	@ResponseBody
	public Object updateAwardGetAndPayStatus(HttpServletRequest request){
		log.info("This is controller: UpdateAwardGetStatusController");

		int userId = 0;
		HttpSession session = request.getSession(true);
		Object userIdObj = session.getAttribute("userId");
		if (userIdObj == null) {
			ErrorMessage error = new ErrorMessage();
			error.setSuccess("false");
			error.setErrCode("001");
			error.setErrInfo("userId is null");
			return error;
		} else {
			userId = Integer.parseInt(String.valueOf(userIdObj));
		}
		//String userIdStr = request.getParameter("userId");
		//int userId = Integer.parseInt(userIdStr);
		String qnIdStr = request.getParameter("qnId");
		String qnTypeStr = request.getParameter("qnType");
		String awardGetStatusStr = request.getParameter("awardGetStatus");
		String awardPayStatusStr = request.getParameter("awardPayStatus");
		
		int qnId = Integer.parseInt(qnIdStr.trim());
		int qnType = Integer.parseInt(qnTypeStr.trim());
		int awardGetStatus = Integer.parseInt(awardGetStatusStr.trim());
		int awardPayStatus = Integer.parseInt(awardPayStatusStr.trim());
		
		int updateAwardGetAndPayStatus = updateAwardGetStatusService.updateAwardGetAndPayStatus(userId,qnId,qnType,awardGetStatus,awardPayStatus);
		if(updateAwardGetAndPayStatus>0){
			return AjaxResult.successResult("更新奖品领取发放状态成功！");	 
		}
		else {
			return AjaxResult.errorResult("更新失败");
		}
	}
	
}
