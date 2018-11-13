package com.newins.payment.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoneyUtils {
	
    public static void main(String[] args) { 
//        System.out.println(MoneyUtils.fromFenToYuan("2012"));  
//        System.out.println(MoneyUtils.fromFenToYuan("201a"));  
//        System.out.println(MoneyUtils.fromYuanToFen("20.12"));  
//        System.out.println(MoneyUtils.fromYuanToFen("20.12a")); 
    	
    	
    	String fromYuanToFen = fromYuanToFen("5555555");
    	
    	System.out.println(fromYuanToFen);
    	
    }
    
    /**  
     * 分转换为元.  
     *   
     * @param fen  
     *            分  
     * @return 元  
     */  
    public static String fromFenToYuan(final String fen) {  
        String yuan = "";  
        final int MULTIPLIER = 100;  
        Pattern pattern = Pattern.compile("^[1-9][0-9]*{1}");  
        Matcher matcher = pattern.matcher(fen);  
        if (matcher.matches()) {  
            yuan = new BigDecimal(fen).divide(new BigDecimal(MULTIPLIER)).setScale(2).toString();  
        } else {  
            System.out.println("参数格式不正确!");  
        }  
        return yuan;  
    }  
  
    /**  
     * 元转换为分.  
     *   
     * @param yuan  
     *            元  
     * @return 分  
     */  
    public static String fromYuanToFen(final String yuan) {  
        String fen = "";  
//        Pattern pattern = Pattern.compile("^[0-9]+(.[0-9]{2})?{1}");  

        Pattern pattern = Pattern.compile("^(0|[1-9][0-9]{0,9})(\\.[0-9]{1,2})?$"); 
        
//        ^(0|[1-9][0-9]{0,9})(\.[0-9]{1,2})?$
        
        Matcher matcher = pattern.matcher(yuan);  
        if (matcher.matches()) {  
            try {  
                NumberFormat format = NumberFormat.getInstance();  
                Number number = format.parse(yuan);  
                double temp = number.doubleValue() * 100.0;  
                // 默认情况下GroupingUsed属性为true 不设置为false时,输出结果为2,012  
                format.setGroupingUsed(false);  
                // 设置返回数的小数部分所允许的最大位数  
                format.setMaximumFractionDigits(0);  
                fen = format.format(temp);  
            } catch (ParseException e) {  
                e.printStackTrace();  
            }  
        }else{  
            System.out.println("参数格式不正确!");  
        }  
        return fen;  
    }  
	
}
