package algorithm.string;

import java.util.Arrays;

/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月23日   下午10:24:19
 * @version 1.0
 **/
public class ModifyAndReplace {

	
	public static void replace(char[] arr){
		if(arr == null || arr.length == 0){
			return;
		}
		int i=0;
		int num = 0;
		for(;i<arr.length; i++){
			if(arr[i] == 0){
				break;
			}else if(arr[i] == ' '){
				num++;
			}
		}
		int ind = i+num*2-1;
		for(int j=i-1;j>=0;j--){
			if(arr[j] == ' '){
				arr[ind--] = '0';
				arr[ind--] = '2';
				arr[ind--] = '%';
			}else {
				arr[ind--]=arr[j];
			}
//			arr[j]=0;
		}
	}
	
	public static void modify(char[] arr){
		int ind = arr.length-1;
		int num = 0;
		for(int i=arr.length-1;i>=0;i--){
			if(arr[i] != '*'){
				arr[ind] = arr[i];
//				if(i != ind){
//					arr[i] = '*';
//				}
				ind--;
				num++;
			}
		}
		for(int i=0;i<arr.length-num;i++){
			arr[i] = '*';
		}
	}
	
	public static void main(String[] args) {
		char[] arr = new char[]{' ',' ',' ','d',' ','c',' ',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		replace(arr);
		System.out.println(Arrays.toString(arr));
		
//		char[] arr2 = new char[]{'a','*','b','*','*','c','d','*'};
//		char[] arr2 = new char[]{'a','b','*','c','*','*','d'};
		char[] arr2 = new char[]{'a','*','*','*','*','*','d'};
		modify(arr2);
		System.out.println(Arrays.toString(arr2));
	}
}
