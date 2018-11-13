package com.newins.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.newcapec.campus.oauth2.client.request.WanxiaoContext;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.Consume;
import com.newins.service.ConsumeService;
import com.newins.util.AjaxResult;
import com.newins.util.ErrorMessage;
import com.newins.util.StrUtils;

/**
 * 打赏controller
 * @author Zhang
 *
 */
@Controller
@RequestMapping("/wanx")
public class GratuityContrller {
	Logger log=Logger.getLogger(GratuityContrller.class);
	@Autowired
	private ConsumeService consumeService;
	/**
	 * 打赏积分
	 * @return
	 */
	@RequestMapping(value="/donateWanxScore",method=RequestMethod.GET)
	@ResponseBody
	public Object Gratuityscore(HttpServletRequest request){
		log.info("this is controller donateWanxScore");
		//获取session
		HttpSession session=request.getSession();
		//创建错误信息对象
		ErrorMessage error=new ErrorMessage();
		//获取userId
		Object userId=session.getAttribute("userId");
//		Object userId=request.getParameter("userId");
		//获取前端传递的要打赏的积分数量
		int score=Integer.parseInt(request.getParameter("score"));
		JSONObject jsonObject=new JSONObject();
		//获取接入完校接口的令牌
		Object access_Token = session.getAttribute("access_Token");
		//获取当前时间
		DateFormat dateFormat=DateFormat.getDateInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String nowTime=sdf.format(new Date());
		//获取qnTyepe
		int qnType=Integer.parseInt(request.getParameter("qnType"));
		//获取deliveryId
		int deliveryId=Integer.parseInt(request.getParameter("deliveryId"));
		//判断userId是否为空
		if(userId!=null){
			//调用玩校查询指定用户积分接口
			//判断积分是否为负的，因为完校接口需要负数才可以减去积分，如果不是负数就会增加积分
			if(score<0){
				//进入这里表示积分是负的，继续扣除积分操作
				//========================>查询指定用户的完校积分
				//1.实例化完校接口对象
				WanxiaoContext wanxiaoContext = null;
				if(access_Token!=null){
					wanxiaoContext = new WanxiaoContext((String) access_Token);
				}
				//2.调用查询用户积分方法
				//创建接受方法返回值变量
				String returnValue=null;
				returnValue=wanxiaoContext.getScore();
				JSONObject formatDate=null;
				if(returnValue!=null){
					formatDate=JSONObject.fromObject(returnValue);
				}
				int returnScore=0;
				//3.取出完校接口返回的值
				if(formatDate!=null){
					returnScore=Integer.parseInt(formatDate.get("grade").toString());
				}
				//把负数转为正数--用户判断用户是否可以扣除相应积分
				int Positivescore=Math.abs(score);
				//4.判断用户积分是否可以打赏
				if(returnScore>Positivescore||returnScore==Positivescore){
					//进入这里表示用户可以打赏
					//========================> 添加玩校积分 
					//添加积分
					String scoreAdd = "";
					if(wanxiaoContext!=null){
						try {
							scoreAdd = wanxiaoContext.scoreAdd(score);
						} catch (Exception e) {
							e.printStackTrace();
							return AjaxResult.errorResult("给当前用户扣除积分失败!");
						}
					
					}
					log.info("===================>> 用户扣除积分信息:" +scoreAdd );
					JSONObject scoreAddJSON = null;
					if(StrUtils.isNotEmpty(scoreAdd)){
						scoreAddJSON = JSONObject.fromObject(scoreAdd);
					}
					//获取完校方法返回信息
					int result_code = -1;
					if(scoreAddJSON!=null){
						result_code = scoreAddJSON.getInt("result_code");
					}
					//如果result_code是0表示扣除成功
					if(result_code == 0){
						
						jsonObject.put("success", true);
						jsonObject.put("message", "扣除积分"+score+"成功");
						//打赏成功后调用方法判断用户是否第一次打赏该问卷
						int isFirstdonate=0;
						if(consumeService.isGratuity(Integer.parseInt(userId.toString()),deliveryId)!=0){
							isFirstdonate=1;
						}
						jsonObject.put("isFirstdonate", isFirstdonate);
						
					}else{
						//进入这里表示扣除积分失败
						return AjaxResult.errorResult("给当前用户扣除积分失败!");
					}
						//1.给添加打赏流水的方法需要的参数添加数据
						//将要扣除的积分特殊处理
						String consumeQuantity=String.valueOf(score);
						//把负号截取掉
						consumeQuantity=consumeQuantity.substring(1);
						//1.1.创建消费流水实体对象
						Consume consume=new Consume(Integer.parseInt(userId.toString()), 1, nowTime, qnType, deliveryId, 1, consumeQuantity, 1);
						//调用打赏流水表操作方法
						int value=consumeService.addConsume(consume);
						
						//判断消费流水表是否操作成功
						if(value==0){
							//用户不能打赏，返回错误信息
							error.setErrCode("004");
							error.setErrInfo(" 消费流水表打赏记录未添加 ");
							error.setSuccess("false");
							return error;
						}
						
						//返回扣除成功信息
						return jsonObject;
					}else{
						//用户不能打赏，返回错误信息
						error.setErrCode("003");
						error.setErrInfo(" 积分余额不足");
						error.setSuccess("false");
						return error;
					}
				}else{
					//进入这里表示积分不是负数，返回错误信息
					error.setErrCode("002");
					error.setErrInfo(" 积分不是负数 ");
					error.setSuccess("false");
					return error;
			}
				
		}else{
			//userId为空，返回错误信息
			error.setErrCode("001");
			error.setErrInfo("userId is null");
			error.setSuccess("false");
			return error;
		}
	}
	/**
	 * 格式化金额静态方法[暂时不用]
	 * @param str 要处理的数据
	 * @param len 小数点长度
	 * @return
	 */
	public static String insertComma(String str, int len) {
	    NumberFormat formater = null;
	    //转为double类型
	    double num = Double.parseDouble(str);
	    if (len == 0) {
	    	//初始化格式
	        formater = new DecimalFormat("###,###");
	 
	    } else {
	    	//拼接
	        StringBuffer buff = new StringBuffer();
	        buff.append("###,###.00");
	        for (int i = 0; i < len; i++) {
	            buff.append("#");
	        }
	        formater = new DecimalFormat(buff.toString());
	    }
	    //返回数据
	    return formater.format(num);
	}
}
