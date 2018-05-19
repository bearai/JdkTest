package algorithm.string;

import java.util.Arrays;

/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月19日   下午9:46:21
 * @version 1.0
 **/
public class TruncateO {
	
	public static String truncate(String ori,int k){
		if(k <= 0){
			return ori;
		}
		char[] arr = ori.toCharArray();
		StringBuilder str = new StringBuilder();
		int obegin = -1;
		int loopbegin = 0;
		int onums = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] == 'O'){
				if(obegin == -1){
					obegin = i;
				}
				onums++;
				if(i == arr.length-1 || arr[i+1] != 'O'){
					if(onums == k){
						str.append(ori.substring(loopbegin,obegin));
//						loopbegin = i+1;
					}
					else {
						str.append(ori.substring(loopbegin,i+1));
					}
					onums=0;
					obegin = -1;
					loopbegin = i+1;
				}
				
			}else if (i == arr.length-1) {
				str.append(ori.substring(loopbegin));
			}
		}
		return str.toString();
	}
	
	public static String truncate2(String ori,int k){
		if(ori == null || k<=0){
			return ori;
		}
		char[] arr = ori.toCharArray();
		int start=-1;
		int count=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] == 'O'){
				if(start == -1){
					start = i;
				}
				count++;
			}else {
				if(count == k){
					while(count-- != 0){
						arr[start++]=0;
					}
				}
				count = 0;
				start = -1;
			}
		}
		if(count == k){
			while(count-- != 0){
				arr[start++]=0;
			}
		}
		return String.valueOf(arr);
	}
	
	public static void main(String[] args) {
//		String ori = "afdasf";
//		String ori = "OdOaOfO3O";
		String ori = "OOOO";
		String truncate = truncate2(ori,4);
		System.out.println(ori);
		System.out.println(truncate.length()==0?"trucated left empty":truncate);
	}
}
