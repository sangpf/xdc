package com.newins.util.weibo;

import java.io.Serializable;

import org.apache.commons.httpclient.HttpClient;

public class Weibo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected static HttpClient client = new HttpClient();
	
	protected String access_token;
	
}
