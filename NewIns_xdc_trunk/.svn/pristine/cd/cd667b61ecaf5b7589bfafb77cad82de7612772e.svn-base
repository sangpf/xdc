package com.newins.payment.service;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.newins.controller.UtilController;
import com.newins.dao.AssessDeliveryMapper;
import com.newins.model.AssessDelivery;
import com.newins.payment.controller.PayController;
import com.newins.payment.dao.Paid_flowingDao;
import com.newins.payment.dao.Paid_orderDao;
import com.newins.payment.dao.Personal_product_Dao;
import com.newins.payment.dao.ProductPackage_Dao;
import com.newins.payment.model.Paid_flowing;
import com.newins.payment.model.Paid_order;
import com.newins.payment.model.Personal_product;
import com.newins.payment.model.ProductPackage;
import com.newins.payment.utils.DateUtils;
import com.newins.payment.utils.HttpUtil;
import com.newins.payment.utils.MoneyUtils;
import com.newins.payment.utils.PayConfigUtil;
import com.newins.payment.utils.PayToolUtil;
import com.newins.payment.utils.PropUtils;
import com.newins.payment.utils.XMLUtil4jdom;
import com.newins.util.AjaxResult;
import com.newins.util.StrUtils;

@Service
public class WeixPayServiceImp implements WeixPayService {
	private static Logger log = Logger.getLogger(PayController.class);
	
	@Autowired
	private Paid_flowingDao paid_flowingDao;
	@Autowired
	private Paid_orderDao paid_orderDao;
	@Autowired
	private ProductPackage_Dao productPackage_Dao;
	@Autowired
	private Personal_product_Dao personal_product_Dao;
	@Autowired
	private AssessDeliveryMapper assessDeliveryMapper;
	
	public AjaxResult H5Pay(HttpServletRequest request, Model model) {
		AjaxResult ajaxResult = new AjaxResult();
		
		HttpSession session = request.getSession();
		Object userId_obj = session.getAttribute("userId");
		if(userId_obj == null){
			return AjaxResult.errorResult("用户未登录,无法支付");
		}
		Integer userId = (Integer) userId_obj;
		
		String contentId_Str = request.getParameter("contentId");
		String contentType_Str = request.getParameter("contentType"); //付费内容类型 1, 玩校付费测评问卷 , 2, 微信付费测评问卷 , 3 产品包
		
		//---------------获取一堆配置参数----------
		String appid = PayConfigUtil.APP_ID;  // appid   
		String mch_id = PayConfigUtil.MCH_ID; // 商业号     
		String key = PayConfigUtil.API_KEY; // key  
        // 随机字符串 
        /*
         * 微信支付API接口协议中包含字段nonce_str，主要保证签名不可预测。我们推荐生成随机数算法如下：
         * 调用随机数函数生成，将得到的值转换为字符串。
         * */
        String currTime = PayToolUtil.getCurrTime();  
        String strTime = currTime.substring(8, currTime.length());  
        String strRandom = PayToolUtil.buildRandom(4) + "";  
        String nonce_str = strTime + strRandom;
        //-------------------生成随机字符串结束----------------
        
		 String out_trade_no = "" + System.currentTimeMillis(); //订单号 （调整为自己的生产逻辑）
		 
        
        Integer contentId = StrUtils.changeToInt(contentId_Str);
        Integer contentType = StrUtils.changeToInt(contentType_Str);
        if(contentType_Str == null || contentType == null){
        	return AjaxResult.errorResult("缺少参数");
        }
        
        String body = "";
        Double price = null;  // 原价格
        
        if(contentType == 3){  // 产品包
        	
            ProductPackage productPackage = productPackage_Dao.select_key(contentId);
            if(productPackage == null){
            	return AjaxResult.errorResult("未获取产品包,可能id参数错误");
            }
            
            body = productPackage.getTitle();  //商品描述
            price = productPackage.getDiscount();
            
        }else if(contentType == 1){  //玩校付费测评问卷
        	
        	AssessDelivery assessDelivery = assessDeliveryMapper.getDeliveryStatusById(contentId);
        	if(assessDelivery == null){
        		return AjaxResult.errorResult("未获得付费测评问卷信息");
        	}
        	body = assessDelivery.getShowTitle();
        	price = assessDelivery.getPrice();
        	
        }else{
        	return AjaxResult.errorResult("不支持该类型付费内容");
        }
		// ---------------------- 生成订单------------->>
		log.info("=====================>>准备生成订单..");
		
		 String fen = MoneyUtils.fromYuanToFen(price+"");  // 支付价格  价格的单位为分  
		 log.info("--------------------------->> 要支付的价格为 :"+fen+"分");
		 
   		 Paid_order paid_order = new Paid_order();
   		 
   		 paid_order.setContentId(contentId);
   		 paid_order.setContentType(contentType);//付费内容类型 1, 玩校付费测评问卷 , 2, 微信付费测评问卷 , 3 产品包
   		 paid_order.setTime(new Date());
   		 paid_order.setState(1);   //1.未支付，2.已支付  3,退款中, 4, 已经退款
   		 paid_order.setMoney(price);
   		 paid_order.setUserId(userId);
   		 paid_order.setChannelId(1);  // 2 威信服务号   1 完美校园
   		 paid_order.setPaidmethodId(1);  // 付费方式 int //1.微信，2.支付宝
   		 paid_order.setOut_trade_no(out_trade_no);
   		try {
   			paid_orderDao.insert(paid_order);
   		} catch (Exception e1) {
   			e1.printStackTrace();
   			return AjaxResult.errorResult("创建订单失败");
   		}
		log.info("=====================>>生成订单结束, 订单号 : "+out_trade_no);
		 // --------------------保存订单结束----------------------
		
		String spbill_create_ip = UtilController.getIpAddr(request);  //终端IP
		
		String notify_url = PropUtils.getValue_from_propties("pay_config.properties", "notify_url");   //通知地址
		
		String trade_type = "MWEB";
		String scene_info = "{ 'h5_info': '{'type':'Wap','wap_url': 'http://new-insight.cn','wap_name': "+body+"}' }" ;
		Map<Object,Object> requestMap = new TreeMap<Object,Object>();
		
        requestMap.put("appid", appid);
        requestMap.put("mch_id", mch_id);  // 商户号
        requestMap.put("nonce_str", nonce_str);  // 随机字符串
        requestMap.put("body", body);  //（调整为自己的名称）
        requestMap.put("out_trade_no", out_trade_no); // 订单号
        requestMap.put("total_fee", fen); //价格的单位为分  
        requestMap.put("spbill_create_ip", spbill_create_ip);  // 获取发起电脑 ip
        requestMap.put("notify_url", notify_url);   //异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
        requestMap.put("trade_type", trade_type);  // JSAPI--公众号支付、NATIVE--原生扫码支付
        requestMap.put("scene_info", scene_info);
		
        // 计算签名
        String sign = PayToolUtil.createSign("UTF-8", requestMap, key);
        requestMap.put("sign", sign);
		
     // 将map集合数据转化为 xml格式数据
        String requestXML = PayToolUtil.getRequestXml(requestMap);
        log.info("-------------------------------->>xml请求文件数据 :");  
        log.info(requestXML);
        
        //发送请求
        String responseXml = HttpUtil.postData(PayConfigUtil.UFDODER_URL, requestXML);
        log.info("------------------------------>>发送请求后返回 xml 格式的数据   responseXml :");
        log.info(responseXml);
        
        // 将xml格式的数据转为map集合
        Map<Object,Object> responseMap = null;
		try {
			responseMap = XMLUtil4jdom.doXMLParse(responseXml);
			
			String mweb_url = (String) responseMap.get("mweb_url");
			log.info("请求微信支付的链接 : "+mweb_url);
			
			String pay_url_return = "";
			if(contentType == 3){
				
				pay_url_return = PropUtils.getValue_from_propties("pay_config.properties", "package_pay_url");
				
			}else if(contentType == 1){
				
				pay_url_return = PropUtils.getValue_from_propties("pay_config.properties", "wx_assessQuestion_pay_url");
				
			}else{
				return AjaxResult.errorResult("支付内容类型错误");
			}
			log.info("------------------>> 付费类型为 :"+contentType+"  , 将要跳转到的地址为 : "+pay_url_return);
			
			String encode_redirect_url = URLEncoder.encode(pay_url_return+"?contentId="+contentId+"&pageType="+2+"&contentType="+contentType, "utf-8");
			
			ajaxResult.put("success", true);
//			ajaxResult.put("payUrl", mweb_url+"&redirect_url="+encode_redirect_url);
			ajaxResult.put("payUrl", mweb_url);
			
			log.info("--------------------->>发起H5支付的 url 地址 : "+mweb_url+"&redirect_url="+encode_redirect_url);
			
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.errorResult("服务器错误");
		}
		
		log.info("--------------->> 返回 map 数据 responseMap:");
        log.info(responseMap);
        
        return ajaxResult;
	}

	public void weixinNotify(HttpServletRequest request,HttpServletResponse response) throws Exception {

		log.info("======================>> h5 支付完成后 , 微信支付系统调用 商家后台服务接口.. ...  ");
		
		//读取参数
        InputStream inputStream ;  
        StringBuffer sb = new StringBuffer();  
        // 从请求中读取 输入流数据
        inputStream = request.getInputStream();  
        String str ;  
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));  
        while ((str = reader.readLine()) != null){
            sb.append(str);
        }
        reader.close();
        inputStream.close();
        
        log.info("===============>> 从请求中读取数据拼接成 stringBuffer :"+sb.toString());
        
        //解析xml成map
        Map<String, String> retMap = new HashMap<String, String>();  
        retMap = XMLUtil4jdom.doXMLParse(sb.toString());  
        
        //过滤空 设置 TreeMap  
        SortedMap<Object,Object> treeMap = new TreeMap<Object,Object>();        
        Iterator it = retMap.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            String valueStr = retMap.get(key);
            
            String v = "";  
            if(null != valueStr) {
                v = valueStr.trim();  
            }  
            treeMap.put(key, v);  
        }
          
        // 账号信息  
        String key = PayConfigUtil.API_KEY; //key
        
        //判断签名是否正确  
        if(PayToolUtil.isTenpaySign("UTF-8", treeMap,key)) {
            //------------------------------  
            //处理业务开始  
            //------------------------------  
            String resXml = "";  
            if("SUCCESS".equals((String)treeMap.get("result_code"))){
                // 这里是支付成功
                //////////执行自己的业务逻辑////////////////  
                String mch_id = (String)treeMap.get("mch_id");  
                String openid = (String)treeMap.get("openid");  
                String is_subscribe = (String)treeMap.get("is_subscribe");  
                String out_trade_no = (String)treeMap.get("out_trade_no");  // 商户订单号
                String transaction_id = (String)treeMap.get("transaction_id");  // 商品订单号
                
                String total_fee = (String)treeMap.get("total_fee");  
                
                String price_yuan = MoneyUtils.fromFenToYuan(total_fee);  // 转化为元
                
                Double price = Double.valueOf(price_yuan);
                
                //////////执行自己的业务逻辑////////////////
                //暂时使用最简单的业务逻辑来处理：只是将业务处理结果保存到session中
                //（根据自己的实际业务逻辑来调整，很多时候，我们会操作业务表，将返回成功的状态保留下来）
                log.info("================================>> notify 通知地址 .支付成功 !!!");
                
                // ----------------------更新订单表---------------------------
                Paid_order paid_order = paid_orderDao.select_out_trade_no(out_trade_no);
                if(paid_order != null){
                	
                	// ---------------------更新订单表 -------------------
                	
                	paid_order.setState(2);
                	paid_order.setTransactionId(transaction_id);
                	// 更新订单状态 --------------------
                	try {
                		paid_orderDao.update(paid_order);
                	} catch (Exception e) {
                		e.printStackTrace();
                		log.info("========================>>支付成功后,更新订单状态为已支付失败!!!!");
                	}
                	
                	// 获取用户id
                	Integer userId = paid_order.getUserId();
                	Integer contentId = paid_order.getContentId();
                	Integer contentType = paid_order.getContentType();
                	
                	if(userId != null){
                		// -------------------新增 统计流水表-----------------
                		Paid_flowing paid_flowing = new Paid_flowing();
                		
                		paid_flowing.setContentId(contentId);
                		paid_flowing.setContentType(contentType);
                		paid_flowing.setPayTime(new Date());
                		paid_flowing.setMoney(price);
                		paid_flowing.setUserId(userId);
                		paid_flowing.setOut_trade_no(out_trade_no);
                		paid_flowing.setTransactionId(transaction_id);
                		
                		try {
                			paid_flowingDao.insert(paid_flowing);
						} catch (Exception e) {
							e.printStackTrace();
							log.info("========================>> 支付完成 回调接口中,  新增用户 微信支付流水表");
						}
                		
                		if(contentType == 3){ // 个人购买产品包
                			// ---------------------- 记录信息到 个人_产品包关联表 -----------
                			Personal_product personal_product = new Personal_product();
                			
                			personal_product.setUserId(userId);
                			personal_product.setPackageId(contentId);
                			personal_product.setStatus(1);
                			personal_product.setbTime(new Date());
                			Date eTime = DateUtils.getDateFormat_from_Str("2018-10-01", "yyyy-MM-dd");
                			personal_product.seteTime(eTime);
                			
                			personal_product_Dao.insert(personal_product);
                			
                		}
                		
                	}else{
                		log.info("========================>> 支付完成 回调接口中, 更新 用户付费统计表, 查询用户id为空");
                	}
                	
                }else{
                	log.info("========================>> 支付完成 回调接口中, 更新订单状态, 查询此条订单为空 , 订单不存在");
                }
                
                //通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.  
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"  
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";  
                
            } else {
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"  
                        + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";  
            }
            //------------------------------  
            //处理业务完毕  
            //------------------------------  
            BufferedOutputStream out = new BufferedOutputStream(  
                    response.getOutputStream());
            
            out.write(resXml.getBytes());  
            out.flush();  
            out.close();  
        } else{  
        	System.out.println("通知签名验证失败");  
        }
	}
}
