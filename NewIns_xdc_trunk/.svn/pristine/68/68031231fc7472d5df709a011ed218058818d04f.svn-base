package com.newins.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.KuRunGather;
import com.newins.model.KuRunSurvey;
import com.newins.service.KuRunService;
import com.newins.util.ErrorMessage;

/**
 * 库润相关controller
 * @author Zhangwenhao
 *
 */
@Controller
@RequestMapping("/wanx")
public class KuRunController {
	private Logger logger=Logger.getLogger(KuRunController.class);
	//自动绑定相关Service
	@Autowired
	private KuRunService kuRunService;
	/**
	 * 保存库润采集信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/saveGather",method=RequestMethod.POST)
	@ResponseBody
	public Object SaveGather(HttpServletRequest request,HttpServletResponse response){
		//创建json对象
		JSONObject jsonObject=new JSONObject();
		//获取session会话
		HttpSession session=request.getSession();
		//从session中获取userId;
		Object userId=session.getAttribute("userId");
		//Object userId=request.getParameter("userId");
		//前端数据编码处理
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset:UTF-8");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//判断userId是否为空
		if(userId!=null){
			//进入这里表示不是空的就继续操作
			//获取前端传来的参数
			String city=request.getParameter("city");
			//对城市进行编码处理
			try {
				city=new String(city.getBytes(),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int age=Integer.parseInt(request.getParameter("age"));
			String province=request.getParameter("province");
			//对省份进行编码处理
			try {
				province=new String(province.getBytes(),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String oldSex=request.getParameter("sex");
			//前端传来的sex是String类型，数据库需要int类型，所有要特殊处理一下
			int sex;
			//女=0，男=1
			if(oldSex=="女"){
				sex=0;
			}else{
				sex=1;
			}
			//创建库润采集实体类
			KuRunGather kr=new KuRunGather(Integer.parseInt(userId.toString()), city, age, province,sex);
			//调用service的方法
			int resultNum=kuRunService.SaveGather(kr);
			//判断是否成功
			if(resultNum>=1){
				//进入这里表示成功
				//返回正确信息
				jsonObject.put("success",true);
				jsonObject.put("comments", "提交成功!");
				return jsonObject;
			}else{
				//进入这里表示接口出现了问题
				jsonObject.put("success",false);
				jsonObject.put("comments", "接口异常");
				return jsonObject;
			}
		}else{
			//进入这里表示userId是空的
			//创建错误信息对象，并set错误信息
			ErrorMessage error=new ErrorMessage();
			error.setErrCode("001");
			error.setSuccess("false");
			error.setErrInfo("userId is Null");
			//返回错误信息
			return error;
		}
	}
	
	/**
	 * 查询用户是否填写过采集信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/isGather",method=RequestMethod.GET)
	@ResponseBody
	public Object IsGather(HttpServletRequest request,HttpServletResponse response){
		//获取session
		HttpSession session=request.getSession();
		//从session会话中获取userId
		Object userId=session.getAttribute("userId");
		//Object userId=request.getParameter("userId");
		//创建json对象
		JSONObject json=new JSONObject();
		//判断用户是否为空
		if(userId!=null){
			//进入这里表示用不为空，继续进一步操作
			//1.调用相关方法
			int resultData=kuRunService.IsGather(Integer.parseInt(userId.toString()));
			//判断方法返回的数据
			if(resultData>=1){
				//进入这里表示用户已经填写过采集信息了
				json.put("success", true);
				json.put("isGather", 1);
				json.put("comments", "用户已填写过采集信息");
				return json;
			}else{
				//进入这里表示用户还没有填写过采集信息
				json.put("success", true);
				json.put("isGather", 0);
				json.put("comments", "用户未填写过采集信息");
				return json;
			}
		}else{
			//进入这里表示userId为空
			//创建错误信息对象
			ErrorMessage error=new ErrorMessage();
			error.setSuccess("false");
			error.setErrInfo("userId is null");
			error.setErrCode("001");
			return error;
		}
	}
	/**
	 * 获取库润问卷列表
	 * @return
	 */
	@RequestMapping(value="/getKuRunList",method=RequestMethod.POST)
	@ResponseBody
	public Object GetKuRunList(HttpServletRequest request,HttpServletResponse response){
		//获取session
		HttpSession session=request.getSession();
		//设置前端传递的汉字编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset:utf-8");
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//创建json对象返回接收的数据
		JSONObject json=new JSONObject();
		//获取session中userId
		Object userId=session.getAttribute("userId");
		//Object userId=request.getParameter("userId");
		//声明输出流对象
		InputStream isr=null;
		//获取前端传递的参数
		String City=null;
		try {
			City = new String(request.getParameter("city").getBytes(),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//城市
		String Province=null;
		try {
			Province = new String(request.getParameter("province").getBytes(),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//省份
		String Sex = null;
		try {
			Sex = new String(request.getParameter("sex").getBytes(),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//性别
		int Age=Integer.parseInt(request.getParameter("age"));//年龄
		//声明url对象
		URL connUrl=null;
		//定义BufferReader输入流来读取url的响应数据
		BufferedReader br=null;
		//创建对象接收响应数据
		StringBuffer sb=new StringBuffer();
		//编写请求url
		String url=null;
		try {
			url = new String(("http://project.1diaocha.com/survey/OsourceJson.aspx?t=777DC6D8C9A455C49E9C9819EEAC88EA&uid="+userId+"&city="+City+"&age="+Age+"&sex="+Sex+"&province="+Province).getBytes(),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//判断userId是否为空
		if(userId!=null){
			//进入这里说明用户id不为空继续操作
			//1.给url对象赋值
			try {
				connUrl=new URL(url);
				//2.打开与url之间的连接
				URLConnection connection=connUrl.openConnection();
				//3.设置通用的请求属性
				connection.setRequestProperty("accept", "*/*");
				connection.setRequestProperty("connection", "Keep-Alive");
				connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
				//4.建立实际连接
				connection.connect();
				//5.获取相应响应头字段
				Map<String,List<String>> headers=connection.getHeaderFields();
				//6.创建输出流对象
				isr=connection.getInputStream();
				//7.获取输入流对象
				br=new BufferedReader(new InputStreamReader(isr,"utf-8"));
				String line;
				while((line=br.readLine())!=null){
					sb.append(line);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				//8.释放资源
				if(br!=null){
					//如果输入流不为空就关闭
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(isr!=null){
					//如果输出流不为空就关闭
					try {
						isr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			//10.将响应的数据封装成JSONArray
			JSONArray jsonarray=JSONArray.fromObject(sb.toString());
			//11.返回封装好的响应数据
			return jsonarray;
			
		}else{
			//userId为空就返回错误信息
			ErrorMessage error=new ErrorMessage();
			error.setErrCode("001");
			error.setSuccess("false");
			error.setErrInfo("userId is null");
			return error;
		}
	}
	/**
	 * 获取用户的采集信息
	 * @return:采集信息
	 */
	@RequestMapping(value="/getGather",method=RequestMethod.GET)
	@ResponseBody
	public Object GetGather(HttpServletRequest request){
		//获取session
		HttpSession session=request.getSession();
		//获取session中的userId
		Object userId=session.getAttribute("userId");
		//Object userId=request.getParameter("userId");
		//创建库润实体类对象
		KuRunGather krg=new KuRunGather();
		//判断用户Id是否为null
		if(userId!=null){
			//进入这里表示userId不为空继续操作
			//1.调用service相关方法，接收返回值
			krg=kuRunService.getGather(Integer.parseInt(userId.toString()));
			JSONObject json=new JSONObject();
			json.put("city", krg.getCity());
			json.put("userId", krg.getUserId());
			json.put("age", krg.getAge());
			json.put("province", krg.getProvince());
			json.put("sex", krg.getSex());
			//2.返回数据
			return json;
		}else{
			//进入这里表示用户Id为空
			//返回错误信息
			ErrorMessage error=new ErrorMessage();
			error.setErrCode("001");
			error.setSuccess("false");
			error.setErrInfo("userId is null");
			return error;
		}
	}
	
	/**
	 * 查询用户是否领过奖
	 * @return
	 */
	@RequestMapping(value="/checkKuRunAward",method=RequestMethod.GET)
	@ResponseBody
	public Object CheckKuRunAward(HttpServletRequest request){
		//获取session
		HttpSession session=request.getSession();
		//获取session中的userId;
		Object userId=session.getAttribute("userId");
		//Object userId=request.getParameter("userId");
		//获取传递的deliveryId
		int deliveryId=Integer.parseInt(request.getParameter("deliveryId").toString());
		//判断userId是否为null
		if(userId!=null){
			//进入这里表示userId不是空的
			//调用service相关方法
			int result=kuRunService.checkKuRunAward(Integer.parseInt(userId.toString()), deliveryId);
			return result;
		}else{
			//返回错误信息
			ErrorMessage em=new ErrorMessage();
			em.setErrCode("001");
			em.setErrInfo("userId is null");
			em.setSuccess("false");
			return em;
		}
	}
	/**
	 * 保存问卷结果
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/saveKuRunSurvey",method=RequestMethod.GET)
	@ResponseBody
	public Object SaveKuRunSurvey(HttpServletRequest request){
		//获取session
		HttpSession session=request.getSession();
		//获取session中保存的用户Id
		int userId=Integer.parseInt(session.getAttribute("userId").toString());
		//获取前端传递的数据
		String statestr=request.getParameter("state");
		int state=0;
		//将statestr转为数据库中对应的数字
		if(statestr=="C"||statestr.equals("C")){
			state=0;
		}else if(statestr=="S"||statestr.equals("S")){
			state=1;
		}else if(statestr=="Q"||statestr.equals("Q")){
			state=2;
		}
		int surveyId=Integer.parseInt(request.getParameter("surveyId"));
		//获取当前系统时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String nowTime=sdf.format(new Date());
		//将要操作的数据保存到实体类中
		KuRunSurvey kuRunSurvey=new KuRunSurvey(userId, state, surveyId, nowTime);
		//调用setvice相关方法
		int result=kuRunService.SaveKuRunSurvey(kuRunSurvey);
		//返回响应行数
		return result;
	}
}
