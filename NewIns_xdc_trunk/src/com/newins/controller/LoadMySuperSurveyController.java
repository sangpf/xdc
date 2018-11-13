package com.newins.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.service.MySuperSurveyService;
import com.newins.util.ErrorMessage;

/**
 * 加载我参与的调查List数据Controller
 * @author zhangwenhao
 *
 */
@Controller
@RequestMapping("/wanx")
public class LoadMySuperSurveyController {
	//自动绑定相关Service
	@Autowired
	private MySuperSurveyService mySuperSurveyService;
	
	private static Logger logger=Logger.getLogger(LoadMySuperSurveyController.class);
	@ResponseBody
	@RequestMapping(value="/mySuperSurvey",method=RequestMethod.GET)
	public Object LoginMySuperSurvey(HttpServletRequest request){
		logger.info("this is controller : LoginMySuperSurveyController ");
		//声明JSON接收方法返回的数据
		JSONObject jsonList=new JSONObject();
		//得到session
		HttpSession session=request.getSession();
//		//从session中获取userId
		Object userId=session.getAttribute("userId");
//		Object userId=request.getParameter("userId");
//		//获取前端传递来的分页第几页
		int page=Integer.parseInt(request.getParameter("page").toString());
		//判断userId是否为空
		if(userId!=null){
			//将Object类型的userId转为int类型
			int newUserId=Integer.parseInt(userId.toString());
			//说明userId不是空的，调用加载指定用户参加的调查和投票
			jsonList=(JSONObject) mySuperSurveyService.getMysuperSuveyInfo(newUserId, page);
			return jsonList;
		}else{
			ErrorMessage error=new ErrorMessage();
			error.setErrInfo("userId is null");
			error.setErrCode("001");
			error.setSuccess("false");
			return error;
		}
	}
}
