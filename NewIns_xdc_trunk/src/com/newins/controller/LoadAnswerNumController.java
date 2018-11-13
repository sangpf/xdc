package com.newins.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.newins.service.LoadAnswerNumService;

/**
 * 加载指定投放的答题人数控制层
 * @author ZhangWenHao
 *
 */
@RequestMapping("/wanx")
@Controller
public class LoadAnswerNumController {
	
	@Autowired
	private LoadAnswerNumService loadAnswerNumService;
	
	@RequestMapping(value="/loadAnswerNum",method=RequestMethod.GET)
	@ResponseBody
	public Object DoGet(HttpServletRequest request){
		//获取前端参数
		int deliveryId=Integer.parseInt(request.getParameter("deliveryId").toString());
		int qnId=Integer.parseInt(request.getParameter("qnId").toString());
		//调用service方法查询参加测试人数
		Integer answerNum=loadAnswerNumService.ToDo(deliveryId);
		System.out.println("answerNum是:"+answerNum);
		if(answerNum==null||answerNum.equals("null")){
			answerNum=0;
		}
		//调用Service方法查询结果页显示方式
		int resultShowType=loadAnswerNumService.GetResultShowType(qnId);
		//包装数据
		JSONObject json=new JSONObject();
		json.put("answerNum", answerNum);
		json.put("resultShowType", resultShowType);
		return json;
	}
}
