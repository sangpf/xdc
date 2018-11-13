package com.newins.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class SensitivewordFilter {
	@SuppressWarnings("rawtypes")
	private static Map sensitiveWordMap = null;
	public static int minMatchTYpe = 1;      
	public static int maxMatchType = 2;      
	
	
	public SensitivewordFilter(){
		sensitiveWordMap = new SensitiveWordInit().initKeyWord();
	}
	
	public boolean isContaintSensitiveWord(String txt,int matchType){
		boolean flag = false;
		for(int i = 0 ; i < txt.length() ; i++){
			int matchFlag = this.CheckSensitiveWord(txt, i, matchType); 
			if(matchFlag > 0){    
				flag = true;
			}
		}
		return flag;
	}
	
	public Set<String> getSensitiveWord(String txt , int matchType){
		Set<String> sensitiveWordList = new HashSet<String>();
		
		for(int i = 0 ; i < txt.length() ; i++){
			int length = CheckSensitiveWord(txt, i, matchType);
			if(length > 0){
				sensitiveWordList.add(txt.substring(i, i+length));
				i = i + length - 1;   
			}
		}
		
		return sensitiveWordList;
	}
	
	public String replaceSensitiveWord(String txt,int matchType,String replaceChar){
		String resultTxt = txt;
		Set<String> set = getSensitiveWord(txt, matchType);     
		Iterator<String> iterator = set.iterator();
		String word = null;
		String replaceString = null;
		while (iterator.hasNext()) {
			word = iterator.next();
			replaceString = getReplaceChars(replaceChar, word.length());
			resultTxt = resultTxt.replaceAll(word, replaceString);
		}
		
		return resultTxt;
	}
	
	private String getReplaceChars(String replaceChar,int length){
		String resultReplace = replaceChar;
		for(int i = 1 ; i < length ; i++){
			resultReplace += replaceChar;
		}
		
		return resultReplace;
	}
	
	public static int CheckSensitiveWord(String txt,int beginIndex,int matchType){
		boolean  flag = false;    //敏感词结束标识位：用于敏感词只有1位的情况  
        int matchFlag = 0;     //匹配标识数默认为0  
        char word = 0;  
        Map nowMap = sensitiveWordMap;  
        //{我={的={isEnd=0, 西={isEnd=0, 域={isEnd=1}}}, isEnd=0}}
        for(int i = beginIndex; i < txt.length() ; i++){  
            word = txt.charAt(i);  
            nowMap = (Map) nowMap.get(word);     //获取指定key   
            if(nowMap != null){     //存在，则判断是否为最后一个     
            	matchFlag++;     //找到相应key，匹配标识+1  
                if("1".equals(nowMap.get("isEnd"))){       //如果为最后一个匹配规则,结束循环，返回匹配标识数  
                    flag = true;       //结束标志位为true     
                    if(SensitivewordFilter.minMatchTYpe == matchType){    //最小规则，直接返回,最大规则还需继续查找  
                        break;  
                    }  
                }  
            }  
            else{     //不存在，直接返回  
                break;  
            }  
        }  
        if(matchFlag < 2 && !flag){
            matchFlag = 0;
        }
        if(flag){
        	return matchFlag; 
        }
        return 0;
	}
	
	/**
	 * 返回敏感词
	 * @param content
	 * @return
	 * @throws IOException 
	 */
	public static Set<String> SensitiveWords(String content,HttpServletRequest request) throws IOException{
		
		String realPath = request.getServletContext().getRealPath("/static/Sensitive.txt");
		
		// ---------读取敏感词文件-----
		File file = new File(realPath);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Set<String> keyWordSet = null;
		InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
		
		//-----------将敏感词封装到集合中--------
		try {
			if(file.isFile() && file.exists()){
				keyWordSet = new HashSet<String>();
				BufferedReader bufferedReader = new BufferedReader(read);
				String txt = null;
				while((txt = bufferedReader.readLine()) != null ){
					keyWordSet.add(txt);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			read.close();
		}
		
		//---------遍历敏感词set集合-----
		sensitiveWordMap = new HashMap<>();
        String key = null; 
        Map nowMap = null;  
        Map<String, String> newWorMap = null; 
		
		Iterator<String> iterator = keyWordSet.iterator();
		while(iterator.hasNext()){
			key = iterator.next();
			nowMap = sensitiveWordMap;
            for(int i = 0 ; i < key.length() ; i++){  
                char keyChar = key.charAt(i);       //转换成char型  
                Object wordMap = nowMap.get(keyChar);       //获取  
                  
                if(wordMap != null){        //如果存在该key，直接赋值  
                    nowMap = (Map) wordMap;  
                }  
                else{     //不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个  
                    newWorMap = new HashMap<String,String>();  
                    newWorMap.put("isEnd", "0");     //不是最后一个  
                    nowMap.put(keyChar, newWorMap);  
                    nowMap = newWorMap;  
                }  
                  
                if(i == key.length() - 1){  
                    nowMap.put("isEnd", "1");    //最后一个  
                }  
            } 
		}
		
		//---------循环内容---检查敏感词
		Set<String> sensitiveWordList = new HashSet<String>();
		
		for(int i = 0 ; i < content.length() ; i++){
			int length = CheckSensitiveWord(content, i, 1);
			if(length > 0){
				sensitiveWordList.add(content.substring(i, i+length));
				i = i + length - 1;   
			}
		}
		
		//--------敏感词封装到集合中----sensitiveWordList
		System.out.println("检测敏感词个数:"+sensitiveWordList.size()+"包含敏感词:"+sensitiveWordList);
		
		return sensitiveWordList;
		
	}
	
	public static void main(String[] args) {
		
//		SensitivewordFilter filter = new SensitivewordFilter();
//        System.out.println("敏感词库：" + filter.sensitiveWordMap.size());
//        String content = "电脑是我的西域";
//        long beginTime = System.currentTimeMillis();
//        Set<String> set = filter.getSensitiveWord(content, 1);
//        long endTime = System.currentTimeMillis();
//        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含敏感词：" + set);
//        System.out.println("总共消耗时间为：" + (endTime - beginTime));
	}
}
