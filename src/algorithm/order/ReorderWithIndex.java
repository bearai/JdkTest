package algorithm.order;

import java.util.Arrays;

/**
 * 奇数下标都是奇数或者偶数下标都是偶数
 *
 * @author 艾亮方
 * @date 2018年5月21日   上午12:23:18
 * @version 1.0
 **/
public class ReorderWithIndex {
	
	public static void reorder2(int[] arr){
		int oddind = 1;
		int evenind = 0;
		int maxind = arr.length-1;
		boolean oddok = true;
		boolean evenok = true;
		while(oddind<=maxind && evenind<=maxind){
			evenok = evenok(arr,evenind);
			oddok = oddok(arr,oddind);
			if(!oddok && !evenok){
				exchange(arr, oddind, evenind);
				evenind += 2;
				oddind += 2;
				continue;
			}
			if(evenok){
				evenind += 2;
			}else if(oddok){
				oddind += 2;
			}
		}
	}
	
	private static boolean oddok(int[] arr,int ind){
		return arr[ind]%2==0?false:true;
	}
	private static boolean evenok(int[] arr,int ind){
		return arr[ind]%2==0?true:false;
	}

	public static void reorder(int[] arr){
		int oddindex = 1;
		int evenindex = 0;
		int val = 0;
		int maxind = arr.length-1;
		while(oddindex<arr.length && evenindex<arr.length){
			val = arr[maxind];
			if(val%2==0){
				exchange(arr, maxind, evenindex);
				evenindex += 2;
			}else {
				exchange(arr, maxind, oddindex);
				oddindex += 2;
			}
		}
	}
	
	private static void exchange(int[] arr,int a,int b){
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{2,8,3,2,4,6,7};
		System.out.println("ori="+Arrays.toString(arr));
		reorder2(arr);
		System.out.println("now="+Arrays.toString(arr));
	}
}
