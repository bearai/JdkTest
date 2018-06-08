package algorithm;

import java.util.Random;

/**
 * 以等概率打印N个数的数组中的M个数
 *
 * @author 艾亮方
 * @date 2018年6月8日   下午11:22:56
 * @version 1.0
 **/
public class PrintMInN {
	
	public static void printRandomM(int arr[],int m){
		if(arr==null || arr.length<3){
			System.out.println("error arr");
			return;
		}
		int len = arr.length;
		if(len<m){
			System.out.println("m bigger than arr len");
			return;
		}
		Random rand = new Random();
		while(m>0){
			int ind = rand.nextInt(len);
			System.out.print(arr[ind]+",");
			swap(arr,ind,len-1);
			m--;
			len--;
		}
	}
	
	private static void swap(int[] arr,int a,int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11};
		for(int i=0;i<10;i++){
			printRandomM(arr, 4);
			System.out.println();
		}
	}
}
