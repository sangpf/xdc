package cn.xdc.common.util;

import java.util.HashSet;
import java.util.Set;

public class StrUtils {
	
	/**
	 * 判断是否为null或空串  
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str == null){
			return true;
		}
		if(str.trim().equals("")){
			return true;	
		}
		return false;
	}
	/**
	 * 判断是否不为null或空串
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	/**
	 * 按分隔符将字符串组装为字符串数组
	 * 如果传入为null 或空串,直接放回空数组
	 * @param toSplit
	 * @param delimiter
	 * @return
	 */
	public static String[] split(String toSplit,String delimiter){
		if(isNotEmpty(toSplit)){
			return toSplit.split(delimiter);
		}
		return new String[]{};
	}
	
    
	 public static void main(String[] args) {
          char[] A = "b".toCharArray();
          getFullPermutation(A);
//          Set<String> set = fullPer(A, 0, A.length - 1);
//          System.out.println("set:" + set + "\nSize:" + set.size());
      }
		 
	 public static Set<String> getFullPermutation(char[] A){
		 
		 Set<String> set = fullPer(A, 0, A.length - 1);
		 System.out.println(set);
		 return set;
	 }
	 
     /**
      * @param A 待全排列的字符数组
      * @param p 子数组左边界
      * @param r 子数组右边界
      * @return 全排列的集合
      */
     static Set<String> fullPer(char[] A, int p, int r) {
         if (r - p <= 1) {
             char[] cs = new char[2];
             cs[0] = A[p];
             cs[1] = A[r];
             Set<String> set = new HashSet<String>();
             set.add(new String(cs));
             cs[0] = A[r];
             cs[1] = A[p];
             set.add(new String(cs));
             return set;
         }
         return insertChar(A[p], fullPer(A, p + 1, r));
     }
 
     /**
      * 将字符 c 插入到集合setIn所有字符串的任意位置
      * @param c char
      * @param setIn Set<String>
      * @return  Set<String>
      */

     private static Set<String> insertChar(char c, Set<String> setIn) {
         Set<String> set = new HashSet<String>();
         for (String s : setIn) {
             char[] cs = s.toCharArray();
             int len = cs.length + 1;
              char[] result = new char[len];
            for (int i = 0; i < len; i++) {
                 result[i] = c;
                 for (int j = 0, k = 0; k < len - 1; j++, k++) {
                     if (j == i)
                         j++;
                     result[j] = cs[k];
                 }
                 set.add(new String(result));
             }
         }
         return set;
     }
 
 	// 将 string 转成 Integer
 	public static Integer changeToInt(String str){
 		
 		Integer valueOf = null;
 		if(isNotEmpty(str)){
 			valueOf = Integer.valueOf(str);
 		}
 		return valueOf;
 	}
	
}
