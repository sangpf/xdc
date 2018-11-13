package com.newins.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.newins.service.CheckUserIdTemporaryService;

/**
 * 查询用户是否是临时用户Controller
 * 
 * @author Zhangwenhao
 *
 */
@Controller
@RequestMapping("/wanx")
public class CheckUserIdTemporaryController {
	
	@Autowired
	private CheckUserIdTemporaryService checkUserIdTemporaryService;
	
	@RequestMapping(value = "/checkUser", method = RequestMethod.GET)
	@ResponseBody
	public Object checkUser(HttpServletRequest request){
		boolean result=false;
		//得到session
		HttpSession session=request.getSession();
		//获取userId
		Integer userId=null;
		Object userType=null;
		JSONObject json=new JSONObject();
		//获取qnId
		int qnId=Integer.parseInt(request.getParameter("qnId").toString());
		//调用Service方法获取结果页显示类型
		int resultShowType=checkUserIdTemporaryService.getResultShowType(qnId);
		if(session.getAttribute("userId")!=null){
			userId=Integer.parseInt(session.getAttribute("userId").toString());
			//获取comment来判断当前用户是否为临时用户
			userType=checkUserIdTemporaryService.checkUserType(userId);
			if(userType==null&&userId!=null){
				//调用Service方法获取用户昵称
				String nickName=checkUserIdTemporaryService.getNickName(userId);
				json.put("userId",userId);
				json.put("nickName",nickName);
				json.put("resultShowType", resultShowType);
				json.put("tempUser", false);
				return json;
			}
		}
		if(userId==null||userType=="tmpUser"||userType.equals("tmpUser")){
			json.put("tempUser", true);
			json.put("resultShowType", resultShowType);
		}
		return json;
	}
}
