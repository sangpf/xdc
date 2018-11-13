package cn.xdc.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Redom {
	
	public static void main(String[] args) {

		String str = "多,果,香,肉,脯,味,色,养,谷,益,甜";
		
		List<String> randomStr = randomStr(str);
		
		Iterator<String> iterator = randomStr.iterator();
		
		while(iterator.hasNext()){
			String str_new = iterator.next();
			
			System.out.println(str_new);
			
		}
		
		System.out.println(randomStr.size());
		
	}
	
	
	public static List<String> randomStr(String str){
		
		List<String> dataList = new ArrayList<>();
		ArrayList<String> indexList = new ArrayList<>();
		
		String[] split = str.split(",");
		
		int[] arr_ind = new int[3];
		
		for(int i=0;i<split.length; i++){
			
			for(int j=0; j<split.length ; j++){
				
				for(int y =0; y<split.length ; y++){
					
					String str_i = split[i];
					String str_j = split[j];
					String str_y = split[y];
					
					arr_ind[0] = i;
					arr_ind[1] = j;
					arr_ind[2] = y;
					
					Arrays.sort(arr_ind);
					
					String ind_str = "";
					for(int x =0 ; x<arr_ind.length ; x++){
						
						ind_str += arr_ind[x];
						
					}
					
					boolean contains = indexList.contains(ind_str);
					
					if(!contains){
						indexList.add(ind_str);
						
						if( !(str_i.equals(str_j) && str_i.equals(str_y)) ){
							dataList.add(str_i+str_j+str_y);
						}
						
					}
					
				}
				
			}
			
		}
		
		return dataList;
	}
	
}
