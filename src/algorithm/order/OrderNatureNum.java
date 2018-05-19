package algorithm.order;

import java.util.Arrays;

/**
 * 自然数组排序
 *
 * @author 艾亮方
 * @date 2018年5月19日   下午3:41:18
 * @version 1.0
 **/
public class OrderNatureNum {

	
	public static void order(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(arr[i] != i+1){
				while(arr[i] != i+1){
					int temp = arr[i];
					arr[i] = arr[temp-1];
					arr[temp-1] = temp;
				}
			}
		}
	}
	
	public static void order2(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(arr[i] != i+1){
				int temp = arr[i];
				while(temp != i+1){
					int temp2 = arr[temp-1];
					arr[temp-1]=temp;
					temp = temp2;
				}
				arr[i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,5,4,6,3};
		System.out.println(Arrays.toString(arr));
		order2(arr);
		System.out.println(Arrays.toString(arr));
	}
}
