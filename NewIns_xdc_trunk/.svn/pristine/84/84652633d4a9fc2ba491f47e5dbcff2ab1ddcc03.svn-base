package com.newins.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.newcapec.campus.oauth2.client.request.WanxiaoContext;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.util.AjaxResult;
import com.newins.util.StrUtils;

@Controller
@RequestMapping("/wanx")
public class WanxUserScoreController {
	private static Logger log = Logger.getLogger(WanxUserScoreController.class);
	
	/**
	 * 给当前登录用户添加玩校积分
	 * @param score   积分
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addWanxScore",method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult AddWanxUserScore(HttpServletRequest request){
		
		String scoreNum = request.getParameter("score");
		Integer score_Num = 0;
		if(StrUtils.isNotEmpty(scoreNum)){
			score_Num = Integer.valueOf(scoreNum);
		}
		
		AjaxResult ajaxResult = new AjaxResult();
		HttpSession session = request.getSession();
		Object access_Token = session.getAttribute("access_Token");
		//========================> 添加玩校积分 
		WanxiaoContext wanxiaoContext = null;
		if(access_Token!=null){
			wanxiaoContext = new WanxiaoContext((String) access_Token);
		}
		
		//添加积分
		String scoreAdd = "";
		if(wanxiaoContext!=null){
			try {
				scoreAdd = wanxiaoContext.scoreAdd(score_Num);
			} catch (Exception e) {
				e.printStackTrace();
				return AjaxResult.errorResult("给当前用户添加积分失败!");
			}
		}
		log.info("===================>> 用户添加积分信息:" +scoreAdd );
		JSONObject scoreAddJSON = null;
		if(StrUtils.isNotEmpty(scoreAdd)){
			scoreAddJSON = JSONObject.fromObject(scoreAdd);
		}
		int result_code = -1;
		if(scoreAddJSON!=null){
			result_code = scoreAddJSON.getInt("result_code");
		}
		if(result_code == 0){
			ajaxResult.put("success", true);
			ajaxResult.put("message", "添加积分"+score_Num+"成功");
		}else{
			return AjaxResult.errorResult("给当前用户添加积分失败!");
		}
		
		return ajaxResult;
	}
	
	/**
	 * 获取当前登录用户玩校积分
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getWanxScore",method = RequestMethod.GET)
	public int getWanxUserScore(HttpServletRequest request){
		HttpSession session = request.getSession();
		Object access_Token = session.getAttribute("access_Token");
		WanxiaoContext wanxiaoContext = null;
		if(access_Token!=null){
			wanxiaoContext = new WanxiaoContext((String) access_Token);
		}
		
		String score = wanxiaoContext.getScore();
		log.info("===================>> 当前用户积分信息 :"+score);
		JSONObject scoreJson = JSONObject.fromObject(score);
		String grade = scoreJson.getString("grade");
		//当前用户的积分
		Integer gradeScore = null;
		if(StrUtils.isNotEmpty(grade)){
			gradeScore = Integer.valueOf(grade);
		}
		session.setAttribute("score", gradeScore);
		
		return gradeScore;
	}
	
}
