package com.newins.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.VoteData;
import com.newins.service.VoteResultService;
import com.newins.util.ErrorMessage;

/**@Description  加载投票结果controller
 * @author MaNia_chAng
 * @time 2016年8月18日 下午7:00:01
 */
@Controller
@RequestMapping(value = "/wanx", method = RequestMethod.POST)
public class VoteResultController {
	@Autowired
	private VoteResultService voteResultService;
	@Autowired
	private VoteData voteData;
	
	private static Logger log = Logger.getLogger(VoteResultController.class);
	
	@RequestMapping(value = "/getVoteResult", method = RequestMethod.GET)
	@ResponseBody
	public Object getVoteResult(HttpServletRequest request){
		log.info("This is controller:VoteResultController");
		HttpSession newSession = request.getSession(true);
		Object userIdObj = newSession.getAttribute("userId");
		String vqnIdStr = request.getParameter("vqnId").trim();
		String deliveryIdStr = request.getParameter("deliveryId").trim();
		int vqnId = Integer.parseInt(vqnIdStr);
		int deliveryId = Integer.parseInt(deliveryIdStr);
		
		//String userIdObj = request.getParameter("userId"); 
		
		
		if (userIdObj != null) {	
			int userId = Integer.parseInt(String.valueOf(userIdObj));
			voteData = voteResultService.getVoteData(vqnId,deliveryId,userId);
			return voteData;
			
		}else {
			log.info("=======================>Assess page userId is null");
			ErrorMessage errormsg = new ErrorMessage();
			errormsg.setSuccess("false");
			errormsg.setErrCode("001");
			errormsg.setErrInfo("userId is null");
			return errormsg;
		}
		

	}

}
