package com.newins.payment.utils;

import java.io.IOException;
import java.util.Properties;

public class PropUtils {
	
	
	public static String getValue_from_propties(String source,String key){
		
		Properties props = new Properties();
		
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(source));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String keyStr = (String) props.get(key);
		
		return keyStr;
		
	}
	
}
