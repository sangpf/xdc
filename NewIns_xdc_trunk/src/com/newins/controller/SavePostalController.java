package com.newins.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.Postal;
import com.newins.service.SavePostalService;
import com.newins.util.AjaxResult;
import com.newins.util.ErrorMessage;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年7月21日 下午1:44:44
 */
@Controller
@RequestMapping("/wanx")
public class SavePostalController {
	private static Logger log = Logger.getLogger(SavePostalController.class);
	
	@Resource
	private SavePostalService savePostalService;
	/**
	 * @Title: savePostal  
	 * @Author: MaNia_chAng
	 * @Description: 保存实物奖励邮寄信息
	 * @param request
	 * @param response
	 * @return AjaxResult
	 * @Time 2016年7月21日 下午2:05:49
	 */
	@RequestMapping(value = "/postal", method = RequestMethod.POST)
	@ResponseBody
	public Object savePostal(HttpServletRequest request,HttpServletResponse response){
		log.info("========================>>保存实物奖励邮寄信息");
		int userId=0;
		HttpSession session = request.getSession(true);
		Object userIdObj = session.getAttribute("userId");
		if(userIdObj==null){
			ErrorMessage error = new ErrorMessage();
			error.setSuccess("false");
			error.setErrCode("001");
			error.setErrInfo("userId is null");
			return error;
		}
		else{
			userId = Integer.parseInt(String.valueOf(userIdObj));
		}
		String recipientName = request.getParameter("recipientName");
		String recipientPhone = request.getParameter("recipientPhone");
		String mailAddress = request.getParameter("mailAddress");
		String postCode = request.getParameter("postCode");
		String province = request.getParameter("province");
		String email = request.getParameter("email");
		String schoolName = request.getParameter("schoolName");
		
		Postal postal = new Postal();
		postal.setUserId(Integer.valueOf(userId));
		postal.setRecipientName(recipientName);
		postal.setRecipientPhone(recipientPhone);
		postal.setMailAddress(mailAddress);
		postal.setPostCode(postCode);
		postal.setProvince(province);
		postal.setEmail(email);
		postal.setSchoolName(schoolName);
		log.info("============Saving user postal info:userId is  "+postal.getUserId()+"===============");
		int savePostal = 0;
		try{
			savePostal = savePostalService.savePostal(postal);
		}
		catch(Exception e){
			return AjaxResult.errorResult("保存失败╯﹏╰");
		}
		
		if(savePostal>0)
		log.info("==========================>>保存成功!");
		
		return AjaxResult.successResult("保存成功！^o^");	 
		
		
	}

}
