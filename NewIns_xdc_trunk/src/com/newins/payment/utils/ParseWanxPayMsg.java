package com.newins.payment.utils;

import java.util.HashMap;
import java.util.Map;

public class ParseWanxPayMsg {

	public static void main(String[] args) {

		Map<String, Object> returnParameterMap = returnParameterMap("acccode=301508&app_id=116&bill_no=2017111045525333&body=产品包支付&business_no=2017111046179006&merchant_olid=3398526&order_createdt=2017/11/10 4:14:36&order_no=1510301676679hwv&order_paytime=2017/11/10 16:14:44&order_status=1&paycode=100201&sign=C64598D7A1FB5960&subject=心发现心理测评&total_fee=1.00&ver=0.1");

		String total_fee = (String) returnParameterMap.get("total_fee");

		String substring = total_fee.substring(0, total_fee.indexOf("."));

		String price_yuan = MoneyUtils.fromFenToYuan(substring); // 转化为元
		Double price = Double.valueOf(price_yuan);

		System.out.println(substring);
		System.out.println(price);

	}

	public static Map<String, Object> returnParameterMap(String str) {

		String[] arr = str.split("&");

		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		for (int i = 0; i < arr.length; i++) {

			String string = arr[i];

			String[] split2 = string.split("=");

			for (int j = 0; j < 1; j++) {

				String key = split2[0];
				String value = split2[1];

				hashMap.put(key, value);

			}

		}

		System.out.println(hashMap.toString());

		return hashMap;
	}

}
