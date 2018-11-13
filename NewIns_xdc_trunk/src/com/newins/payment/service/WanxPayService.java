package com.newins.payment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.newins.util.AjaxResult;

public interface WanxPayService {

	AjaxResult wanxPay(HttpServletRequest request, Model model);

	void wanxPay_callbak(HttpServletRequest request,
			HttpServletResponse response) throws Exception ;
	
}
