package algorithm.order;

import java.util.Arrays;


/**
 * 插入排序
 * 从左到右遍历，在第k个位置，k-1之前的位置总是排好序的，寻找第k个位置在前面排好序的序列中的位置
 *
 * @author 艾亮方
 * @date 2018年4月17日   上午9:29:40
 * @version 1.0
 **/
public class InsertOrder {

	public static void order(int arr[]){
		if(arr == null || arr.length == 0){
			throw new IllegalArgumentException("arry is empty");
		}
		for(int i=1;i<arr.length;i++){
			int val = arr[i]; // 第i个位置 需要插入前面i-1个已经排好序的序列中
			int j = i-1; // 倒序比较
			while(j>=0 && arr[j]>=val){
				// 从小到大排列，如果比第i个位置的大，那么需要往后挪
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=val; //编辑到j的时候，不再比第i个位置的值大，那么将这个值放到j+1位置上
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{19,3,20,5,4,9,100,33,2,1};
		System.out.println("origin arr="+Arrays.toString(arr));
		order(arr);
		System.out.println("ordered arr="+Arrays.toString(arr));
	}
}
