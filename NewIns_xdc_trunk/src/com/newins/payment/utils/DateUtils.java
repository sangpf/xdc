package com.newins.payment.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.newins.util.StrUtils;

public class DateUtils {
	
	public static void main(String[] args) {
		
		Date dateFormat_from_Str = getDateFormat_from_Str("2018-10-01", "yyyy-MM-dd");
		
		System.out.println(dateFormat_from_Str);
		
	}

	
	public static Date getDateFormat_from_Str(String str,String format){
		
		Date l_date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		
		if(StrUtils.isNotEmpty(str) && StrUtils.isNotEmpty(format)){
			
			try {
				l_date = simpleDateFormat.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return l_date;
		
	}
	
	public static String getCurrentTime_format(String pattern){
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		String format = simpleDateFormat.format(new Date());
		
		return format;
	}
	
	
}
