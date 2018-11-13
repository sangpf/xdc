package com.newins.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.http.HttpRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.service.InsertJsonToDbService;

/**
 *补全44000个丢失用户数据controller
 * @author zhangwenhao
 *
 */
@Controller()
@RequestMapping("/wanx")
public class InsertJsonToDbController {
	//绑定相关Service属性
	@Autowired
	private InsertJsonToDbService insertJsonToDbService;
	
	@RequestMapping(value="/insrtJson",method=RequestMethod.GET)
	@ResponseBody
	public Object Insertjson(){
				System.out.println("开始调用添加三个表controller");
				//controller直接调用service就可以
				String temp=(String) insertJsonToDbService.InsertUser();
				System.out.println("结束调用添加三个表controller");
		return temp;
	}
}
