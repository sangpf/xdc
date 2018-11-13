package com.newins.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

public class SensitiveUtil {
	
	/**
	 * 返回敏感词
	 * @param content
	 * @return
	 */
	public static String SensitiveWords(String content,HttpServletRequest request){
		
		String words = test5(content,request);
		return words;
		
	}
	
	static ArrayList<String> wordsList;
//	static String tContent = "加快但波多结衣是在本书中，我们要比较某些商品据说罗马在第一硝酸甘油炸弹制作方法游精佑次普尼克战争之前的操你爷五年里就开始铸造银币；在此之前，罗马人一直只用铜币。所以，罗马共和国似乎一直拿铜币作价值尺度。罗马的一切账本，一切的财产价值，都以若干阿斯或者若干的塞斯特斯来估算。阿斯一直是铜币的名称。而塞斯特斯就是两个半的阿斯，所以塞斯特斯虽然是银币，但是其价值却常常以铜币计算。所以在罗马，提起欠债的人，大家会说他借了别人多少多少的铜在不同时间和不同地点之间的真实价值的差异，也就是比较这些商品能够换取的劳动的数量的差异。这样我们所要比较的，与其说是比较特定商品能换取多少白银，不如说不同白银能够买得多少的劳动量。不过，时间不同，地点不同，劳动的市场价格往往很难知道。而就算没有多少地方会正式记录谷物的市场价格，但是人们一般会比较清楚，而且历史学家和小说家也常常会留意谷物的价格。所以，一般而言，我们可以放心地拿谷物的价格来比较。这并不是因为谷物的价格永远和劳动的价格同步地涨落，而是二者之间总是能以最近似的比例上下浮动。我下面举几个比较的例子立法四大皆空共匪拉萨的建立科技实力肯定";
	static ArrayList<String> first = new ArrayList<String>();
	static String[] sortFirst;
	static char[] charFirst;
	static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	static HashMap<String, String[]> sortMap = new HashMap<String, String[]>();
	static HashMap<String, char[]> charMap = new HashMap<String, char[]>();


	/**
	 * 优化四
	 */
	public final static String test5(String content,HttpServletRequest request) {
		String realPath = request.getServletContext().getRealPath("/static/Sensitive.txt");
		
		//存储所有的敏感词集合
		wordsList = new ArrayList<String>();
		//读取本地文件,将所有的敏感词加入到集合中
		// 读取配置文件开始-----
		File file = new File(realPath);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		StringBuffer sb = new StringBuffer();
		if(file.exists() && file.isFile()){
			try {
				BufferedReader br = null;
				try {
					br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				String s = null;
				try {
					while((s=br.readLine()) !=null ){
						sb.append(s+"#");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			String wordStr = sb.toString();
			String[] split = wordStr.split("#");
			for (String str : split) {
				wordsList.add(str);
			}
			
		}
		// 读取配置文件结束-----
		System.out.println("检测到库中敏感词的数量:"+wordsList.size());
		
		
		ArrayList<String> temp;
		String key, value;
		int length;
		for (int n=0;n<wordsList.size();n++) {
			String k = wordsList.get(n);
			if (!first.contains(k.substring(0, 1))) {
				first.add(k.substring(0, 1));
			}
			length = k.length();
			for (int i = 1; i < length; i ++) {
				key = k.substring(0, i);
				value = k.substring(i, i + 1);
				if (i == 1 && !first.contains(key)) {
					first.add(key);
				}
				
				// 有，添加
				if (map.containsKey(key)) {
					if (!map.get(key).contains(value)) {
						map.get(key).add(value);
					}
				}
				// 没有添加
				else {
					temp = new ArrayList<String>();
					temp.add(value);
					map.put(key, temp);
				}
			}
		}
		sortFirst = first.toArray(new String[first.size()]);
		Arrays.sort(sortFirst); // 排序
		
		charFirst = new char[first.size()];
		for (int i = 0; i < charFirst.length; i ++) {
			charFirst[i] = first.get(i).charAt(0);
		}
		Arrays.sort(charFirst); // 排序
		
		String[] sortValue;
		ArrayList<String> v;
		Map.Entry<String, ArrayList<String>> entry;
		Iterator<Entry<String, ArrayList<String>>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			entry = (Map.Entry<String, ArrayList<String>>) iter.next();
			v = (ArrayList<String>)entry.getValue();
			sortValue = v.toArray(new String[v.size()]);
			Arrays.sort(sortValue); // 排序
			sortMap.put(entry.getKey(), sortValue);
		}
		
		char[] charValue;
		iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			entry = (Map.Entry<String, ArrayList<String>>) iter.next();
			v = (ArrayList<String>)entry.getValue();
			charValue = new char[v.size()];
			for (int i = 0; i < charValue.length; i ++) {
				charValue[i] = v.get(i).charAt(0);
			}
			Arrays.sort(charValue); // 排序
			charMap.put(entry.getKey(), charValue);
		}
		
		//----------------------封装数据完毕
		
		//-----------------------遍历内容集合 检索敏感词 ----开始--
		String r = null, f, c = content;
		char g;
		char[] temps;
		int length2 = c.length();
		tag : for (int i = 0; i < length2 - 1; i++) {
			g = c.charAt(i);
			// 二分查找
			if (Arrays.binarySearch(charFirst, g) > -1) {
				for (int j = i + 1; j < length2; j++) {
					f = c.substring(i, j);
					g = c.charAt(j);
					temps = charMap.get(f);
					if (temps == null) { // 找到了
						
						for (String word : wordsList) {
							if(word.equals(f)){
								System.out.println("ok");
								r = f;
								break tag;
							}
						}
					}
					// 二分查找
					if (Arrays.binarySearch(temps, g) > -1) {
						if (j == length2 - 1) {
							String subStr = c.substring(i, j + 1);
							//判断查询的类似敏感词是非为真正的敏感词
							for (String word : wordsList) {
								if(word.equals(subStr)){
									System.out.println("find!");
									r = subStr;
									break tag;
								}
							}
							
						}
					} else { // 没有找到了
						break;
					}
				}
			}
		}
		return r;
	}
	
	
}
