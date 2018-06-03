package algorithm.array;

import java.util.Arrays;

/**
 * 数组partition调整，左半边排序，右半边不管
 *
 * @author 艾亮方
 * @date 2018年5月27日   下午9:14:16
 * @version 1.0
 **/
public class PartitionAdjust {

	public static void adjust(int[] arr){
		if(arr == null || arr.length<3){
			return;
		}
		int replacedInd = -1; //需要进行替换的数的最小index
		int pre = arr[0]; //每次比较的数的前一个数，因为交换的存在，数会移动位置，所以不能简单的用前一个index
		for(int i=1;i<arr.length;i++){
			if(arr[i] == pre && replacedInd == -1){
				replacedInd = i;
				pre = arr[i];
			}else if(arr[i] != pre && replacedInd != -1){
				pre = arr[i];
				int temp = arr[replacedInd];
				arr[replacedInd] = arr[i];
				arr[i] = temp;
				replacedInd++;
			}else {
				pre = arr[i];
			}
		}
	}
	
	
	
	public static void adjust2(int[] arr){
		int u =0;
		int i=1;
		while(i!=arr.length){
			if(arr[i++] != arr[u]){
				PartitionAdjust2.swap(arr, ++u, i-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,2,2,3,3,4,5,6,6,7,8,8,8,9};
//		int[] arr = new int[]{1,2,2,2,2,2,2,2,2,9};
//		int[] arr = new int[]{2,2,2,2,3,3,4,5,6,6,7,8,8,8,9};
//		int[] arr = new int[]{1,2,2,2,3,4,5,5,5,5};
		System.out.println(Arrays.toString(arr));
		adjust2(arr);
		System.out.println(Arrays.toString(arr));
	}
}
