package com.newins.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.NiTweetModel;
import com.newins.service.NiTweetServiec;
import com.newins.util.ErrorMessage;

/**
 * @Description 
 * @author 星仔
 * @time 2017年2月20日下午5:20:11
 */
@Controller
@RequestMapping("wanx")
public class NiTweetController {
	@Autowired
	@Qualifier("niTweetService")
	private NiTweetServiec niTweetServiec;

	public NiTweetServiec getNiTweetServiec() {
		return niTweetServiec;
	}

	public void setNiTweetServiec(NiTweetServiec niTweetServiec) {
		this.niTweetServiec = niTweetServiec;
	}
	
	
	@RequestMapping("tweet")
	@ResponseBody
	public Object tweetList(){
		try {
			List<NiTweetModel> list = niTweetServiec.getNiTweetList();			
			return list;
		} catch (Exception e) {
			ErrorMessage errormsg = new ErrorMessage();
			errormsg.setSuccess("false");
			errormsg.setErrCode("001");
			errormsg.setErrInfo("");
			return errormsg;
		}		
	}
}
