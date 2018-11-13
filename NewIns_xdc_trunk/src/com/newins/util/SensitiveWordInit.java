package com.newins.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SensitiveWordInit {
	private String ENCODING = "UTF-8";
	@SuppressWarnings("rawtypes")
	public HashMap sensitiveWordMap;
	
	public SensitiveWordInit(){
		super();
	}
	
	public Map initKeyWord(){
		try {
			Set<String> keyWordSet = readSensitiveWordFile();
//			Set<String> keyWordSet = new HashSet<String>();
//			keyWordSet.add("傻叉");
//			keyWordSet.add("白痴");
//			keyWordSet.add("豆逼");
//			keyWordSet.add("你妹的");
//			keyWordSet.add("我的西域");
			
			addSensitiveWordToHashMap(keyWordSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sensitiveWordMap;
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addSensitiveWordToHashMap(Set<String> keyWordSet) {
		sensitiveWordMap = new HashMap();     //初始化敏感词容器，减少扩容操作  
        String key = null; 
        Map nowMap = null;  
        Map<String, String> newWorMap = null;  
        //迭代keyWordSet  
        Iterator<String> iterator = keyWordSet.iterator();  
        while(iterator.hasNext()){  
            key = iterator.next();    //关键字  
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
        System.out.println("sensitiveWordMap:"+sensitiveWordMap);
	}

	/**
	 * 读取本地敏感词文件
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private Set<String> readSensitiveWordFile() throws Exception{
		Set<String> set = null;
		
		File file = new File("D:\\SensitiveWord.txt"); 
		InputStreamReader read = new InputStreamReader(new FileInputStream(file),ENCODING);
		try {
			if(file.isFile() && file.exists()){
				set = new HashSet<String>();
				BufferedReader bufferedReader = new BufferedReader(read);
				String txt = null;
				while((txt = bufferedReader.readLine()) != null){
					set.add(txt);
			    }
			}
			else{
				throw new Exception("异常");
			}
		} catch (Exception e) {
			throw e;
		}finally{
			read.close();     
		}
		return set;
	}
	
}
