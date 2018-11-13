package com.newins.controller;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.newcapec.campus.oauth2.client.utils.json.JSONObject;

import org.aspectj.weaver.AjAttribute.AjSynthetic;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.NiMessageboardModel;
import com.newins.service.NiMessageboardService;
import com.newins.util.AjaxResult;
import com.newins.util.ErrorMessage;

/**
 * @Description 留言建议
 * @author 星仔
 * @time 2017年2月24日上午10:59:25
 */
@Controller
@RequestMapping("wanx")
public class NiMessageController {
	@Autowired
	@Qualifier("niMessageboardService")
	private NiMessageboardService niMessageboardService;

	public NiMessageboardService getNiMessageboardService() {
		return niMessageboardService;
	}

	public void setNiMessageboardService(NiMessageboardService niMessageboardService) {
		this.niMessageboardService = niMessageboardService;
	}
	
	@RequestMapping("saveMessageBoard")
	@ResponseBody
	public Object addNiMessageboard(HttpServletRequest request){
		HttpSession session = request.getSession();
		Object oUserId = session.getAttribute("userId");
		
//		String oUserId = request.getParameter("userId");
		
		if (oUserId!=null) {
			
			//获取前台数据
			int userId = Integer.parseInt(oUserId.toString());
			String messageContent = request.getParameter("messageContent");
			Timestamp leaveMessageTime = new Timestamp(System.currentTimeMillis());
			String comment = null;
			
			NiMessageboardModel niMessageboard = new NiMessageboardModel(userId, messageContent, leaveMessageTime, comment);
			
			//调用service方法
			int num = niMessageboardService.useAddNiMessageboard(niMessageboard);
			
			if (num==1) {
				//增加成功，返回success
				AjaxResult ajaxResult = new AjaxResult();
				ajaxResult.put("success", true);
				ajaxResult.put("msg", "留言成功");
				return ajaxResult;
			}else {
				ErrorMessage errormsg = new ErrorMessage();
				errormsg.setSuccess("false");
				errormsg.setErrCode("002");
				errormsg.setErrInfo("insert failure");
				return errormsg;
			}
			
		}else {
			ErrorMessage errormsg = new ErrorMessage();
			errormsg.setSuccess("false");
			errormsg.setErrCode("001");
			errormsg.setErrInfo("userId is null");
			return errormsg;
		}
		
	}
}
