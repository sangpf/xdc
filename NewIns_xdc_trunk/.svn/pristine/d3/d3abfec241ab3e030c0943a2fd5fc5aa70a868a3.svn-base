package com.newins.payment.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.newcapec.campus.oauth2.client.exception.OpenCampusException;
import net.newcapec.campus.oauth2.client.request.WanxiaoContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.newins.dao.AssessDeliveryMapper;
import com.newins.model.AssessDelivery;
import com.newins.payment.dao.Paid_flowingDao;
import com.newins.payment.dao.Paid_orderDao;
import com.newins.payment.dao.Personal_product_Dao;
import com.newins.payment.dao.ProductPackage_Dao;
import com.newins.payment.model.Paid_flowing;
import com.newins.payment.model.Paid_order;
import com.newins.payment.model.Personal_product;
import com.newins.payment.model.ProductPackage;
import com.newins.payment.utils.DateUtils;
import com.newins.payment.utils.MoneyUtils;
import com.newins.payment.utils.ParseWanxPayMsg;
import com.newins.payment.utils.PropUtils;
import com.newins.util.AjaxResult;
import com.newins.util.RandomCodeUtil;
import com.newins.util.StrUtils;

@Service
public class WanxPayServiceImp implements WanxPayService {
	private static Logger log = Logger.getLogger(WanxPayServiceImp.class);
	
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
	
	public AjaxResult wanxPay(HttpServletRequest request, Model model) {
		
		log.info("=====================>> 请求玩校支付接口 ... begin .. ");
		AjaxResult ajaxResult = new AjaxResult();
		
		// 先从session中获取 token
		HttpSession session = request.getSession(true);
		String accessToken = (String) session.getAttribute("access_Token");
		
		Object userId_obj = session.getAttribute("userId");
		if(userId_obj == null){
			return AjaxResult.errorResult("用户未登录,无法支付");
		}
		Integer userId = (Integer) userId_obj;
		
		// 获取支付类型 , 和支付内容id , 
		String contentId_Str = request.getParameter("contentId");
		String contentType_Str = request.getParameter("contentType"); //付费内容类型 1, 玩校付费测评问卷 , 2, 微信付费测评问卷 , 3 产品包
		
		
        Integer contentId = StrUtils.changeToInt(contentId_Str);
        Integer contentType = StrUtils.changeToInt(contentType_Str);
        if(contentType_Str == null || contentType == null){
        	return AjaxResult.errorResult("缺少参数");
        }
        
        String body = "";
        Double price = null;  // 原价格
        
        // 判断是产品包支付, 还是单个付费测评问卷支付
        if(contentType == 3){  // 产品包
        	log.info("------------------>>产品包支付 ");
        	
            ProductPackage productPackage = productPackage_Dao.select_key(contentId);
            if(productPackage == null){
            	return AjaxResult.errorResult("未获取产品包,可能id参数错误");
            }
            
            body = productPackage.getTitle();  //商品描述
            price = productPackage.getDiscount();
            
        }else if(contentType == 1){  //玩校付费测评问卷
        	log.info("------------------>>玩校付费测评问卷支付 ");
        	
        	AssessDelivery assessDelivery = assessDeliveryMapper.getDeliveryStatusById(contentId);
        	if(assessDelivery == null){
        		return AjaxResult.errorResult("未获得付费测评问卷信息");
        	}
        	body = assessDelivery.getShowTitle();
        	price = assessDelivery.getPrice();
        	
        }else{
        	log.info("------------------>>不支持该类型付费内容 ");
        	return AjaxResult.errorResult("不支持该类型付费内容");
        }
        log.info("=====================>>准备生成订单... begin ..");
        
        //支付金额  分
        log.info("----------------需要支付的价格(元转分前) :"+price+" 元");
        String fromYuanToFen = MoneyUtils.fromYuanToFen(price+"");
        log.info("----------------需要支付的价格(元转分后) :"+fromYuanToFen+" 分");
        int money = 0;
		try {
			money = Integer.valueOf(fromYuanToFen);
		} catch (NumberFormatException e2) {
			e2.printStackTrace();
		}
		
        // 生成3位随机数字字母组合 字符串
        String generateNumber_Str = RandomCodeUtil.generateNumber_Str(3);
        // 生成一个随机订单号
        String order_no = System.currentTimeMillis() + generateNumber_Str;
        
  		 Paid_order paid_order = new Paid_order();
   		 
  		 paid_order.setContentId(contentId);
  		 paid_order.setContentType(contentType);//付费内容类型 1, 玩校付费测评问卷 , 2, 微信付费测评问卷 , 3 产品包
  		 paid_order.setTime(new Date());
  		 paid_order.setState(1);   //1.未支付，2.已支付  3,退款中, 4, 已经退款
  		 paid_order.setMoney(price);
  		 paid_order.setUserId(userId);
  		 paid_order.setChannelId(1);  // 2 威信服务号   1 完美校园
  		 paid_order.setPaidmethodId(2);  // 付费方式 int //1.微信，2.支付宝
  		 paid_order.setOut_trade_no(order_no);
  		try {
  			paid_orderDao.insert(paid_order);
  		} catch (Exception e1) {
  			e1.printStackTrace();
  			return AjaxResult.errorResult("创建订单失败");
  		}
		log.info("=====================>>生成订单结束, 订单号 : "+order_no);
		// --------------------保存订单结束----------------------
		
        
        // 支付完成通知地址
        String notify_url = PropUtils.getValue_from_propties("prop/pay_config.properties", "wanxpay_notify_url");
        log.info("--------------------->> 通知地址 : "+notify_url);
        
		String order_createdt = DateUtils.getCurrentTime_format("yyyy-MM-dd hh:mm:ss");
		
        //-------------------
        
        WanxiaoContext wanxiaoContext = new WanxiaoContext(accessToken);
        try {
            String merchant_id = "3398526"; //商户账号 (需要第三方申请，参考：申请方式)
            String norce_str = System.currentTimeMillis() + (int) (Math.random() * 100000) + "";
            
            // 第一步：进行支付帐号的申请：
            
            //第四步：进行下单操作，进行支付
            String orderInfo = wanxiaoContext.payOrder(merchant_id, order_no, money, order_createdt,
            		"1m", "18813151120", "心发现心理测评", "产品包支付", norce_str , notify_url, "");
            log.info("--------------------->>进行下单操作，进行支付 : "+orderInfo);
            
            // 第二步：进行支付参数签名
            // 玩校APP收银台支付报文签名接口。 （玩校APP上插件进行调起玩校收银台支付时，需要对报文进行签名）
            String orderInfoSign = wanxiaoContext.paySign(merchant_id, order_no, money, "心发现付费内容", norce_str);
            log.info("-------------------->>进行支付参数签名 : "+orderInfoSign);
            
            
            //第三步：进行支付方式获取
            // 获取支付方式,获取支付方式模式2
//            String payGateways = wanxiaoContext.payGateways(merchant_id, norce_str);
//            log.info("--------------------->>获取支付方式,获取支付方式模式2 : "+payGateways);
            // 第五步：进行订单查询
//            String payOrderQuery = wanxiaoContext.payOrderQuery(merchant_id, order_no, norce_str);
//            log.info("--------------------->>进行订单查询 :"+payOrderQuery);
            ajaxResult.put("orderInfo", orderInfoSign);
            
        } catch (OpenCampusException e) {
            //未做异常处理，请处理
        	e.printStackTrace();
        	return AjaxResult.errorResult("玩校支付  错误 ");
        }
        
        ajaxResult.put("success", true);
        return ajaxResult;
	}
	
	public void wanxPay_callbak(HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("----------------------------->> 玩校支付完成后 , 调用通知地址, begin ... ");
		
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String nextElement = parameterNames.nextElement();
			
			log.info("==========================>>request.getParameterNames :" + nextElement);
		}
		
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<Entry<String, String[]>> entrySet = parameterMap.entrySet();
		
		Iterator<Entry<String, String[]>> iterator = entrySet.iterator();
		
		while(iterator.hasNext()){
			Entry<String, String[]> entry = iterator.next();
			
			String key = entry.getKey();
			String[] value = entry.getValue();
			
			log.info("==============================>>key :"+key+",value :"+value);
		}
		
		
		StringBuffer sb = new StringBuffer();
		// 从请求中读取 输入流数据
		ServletInputStream inputStream = request.getInputStream();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
		
		String str ;
		while( (str = bufferedReader.readLine()) != null ){
			sb.append(str);
		}
		// 关闭流 
		inputStream.close();
		bufferedReader.close();
		
		String returnStr = sb.toString();
		log.info("===============>> 从请求中读取数据拼接成 stringBuffer :"+returnStr);
		
//		Map<String, Object> returnParameterMap = ParseWanxPayMsg.returnParameterMap(returnStr);
		
//		String order_status = (String) returnParameterMap.get("order_status");//账单状态； 0-未付款 1-已付款  2-已通知到商户 4-已关闭  （1和2为成功标识，其他状态可以视为失败状态）
//		String merchant_olid = (String) returnParameterMap.get("merchant_olid");//商户账号
//		String acccode = (String) returnParameterMap.get("acccode");  //业务编码
//		String bill_no = (String) returnParameterMap.get("bill_no");  //账单号，玩校支付唯一编号
//		String business_no = (String) returnParameterMap.get("business_no"); //玩校支付平台在三方支付平台上的商户订 单号 , 新发现生成订单号
//		String order_no = (String) returnParameterMap.get("order_no"); //商户订单号
//		String total_fee = (String) returnParameterMap.get("total_fee"); //账单金额,单位：分
//		String subject = (String) returnParameterMap.get("subject"); //商品标题
//		String body = (String) returnParameterMap.get("body");  //商品描述
//		String order_createdt = (String) returnParameterMap.get("order_createdt"); //账单创建日期
//		String order_paytime = (String) returnParameterMap.get("order_paytime");//账单支付日期
		
		// --------------------------
		String order_status = request.getParameter("order_status");
		String merchant_olid = request.getParameter("merchant_olid");
		String total_fee = request.getParameter("total_fee");
		String order_no = request.getParameter("order_no");
		String business_no = request.getParameter("business_no");
		
        log.info("====================>> 支付完成后从请求中获取参数 , 从request中获取 order_status : "+order_status+",merchant_olid:"+merchant_olid+
        		",total_fee :"+total_fee+",order_no :"+order_no+", business_no : "+business_no
        		);
        
        log.info("=======================>> (0-未付款 1-已付款  2-已通知到商户 4-已关闭 ) 订单支付状态 :"+order_status);
        
        // 数据库
        String substring_total_fee = total_fee.substring(0, total_fee.indexOf("."));
        String price_yuan = MoneyUtils.fromFenToYuan(substring_total_fee);  // 转化为元
        Double price = Double.valueOf(price_yuan);
        
        String resMsg = "";  
        
        if(order_status.equals("1")){
            log.info("================================>> notify 通知地址 .支付成功 !!!");
            
            // ----------------------更新订单表---------------------------
            Paid_order paid_order = paid_orderDao.select_out_trade_no(order_no);
            if(paid_order != null){
            	
            	// ---------------------更新订单表 -------------------
            	
            	paid_order.setState(2);
            	paid_order.setTransactionId(business_no); // 设置商品订单号
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
            		paid_flowing.setOut_trade_no(order_no); //商户订单号
            		paid_flowing.setTransactionId(business_no); //商品订单号
            		
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
            
            resMsg = "success";
        }else{
        	
        	resMsg = "fail";
        }

        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(resMsg.getBytes());
        
	}
	
	
}
