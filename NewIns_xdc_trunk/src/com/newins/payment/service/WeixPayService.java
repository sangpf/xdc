package com.newins.payment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.newins.util.AjaxResult;

public interface WeixPayService {

	
	AjaxResult H5Pay(HttpServletRequest request, Model model);

	void weixinNotify(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
}
