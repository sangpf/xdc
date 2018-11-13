package com.newins.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.payment.service.WanxPayService;
import com.newins.payment.service.WeixPayService;
import com.newins.util.AjaxResult;

@Controller
@RequestMapping("/wanx")
public class PayController {
	
	@Autowired
	private WeixPayService weixPayService;
	@Autowired
	private WanxPayService wanxPayService;
	
	// 玩校支付
	@RequestMapping("/wanxPay")
	@ResponseBody
	public AjaxResult wanxPay(HttpServletRequest request,Model model){
		
		return wanxPayService.wanxPay(request,model);
	}
	
	// 玩校支付后 通知地址
	@RequestMapping("/wanxPay_notice")
	public void wanxPay_callbak(HttpServletRequest request,HttpServletResponse response){
		
		try {
			wanxPayService.wanxPay_callbak(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// h5支付
	@ResponseBody
	@RequestMapping("/H5Pay")
	public AjaxResult H5Pay(HttpServletRequest request,Model model){
		return weixPayService.H5Pay(request,model);
	}
	
	/**
	 * 微信平台发起的回调方法
	 * 调用我们这个系统的这个方法接口，将扫描支付的处理结果告知我们系统
	 */
	@RequestMapping("/weixPay_notify")
	public void weixinNotify(HttpServletRequest request, HttpServletResponse response){
		try {
			weixPayService.weixinNotify(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
