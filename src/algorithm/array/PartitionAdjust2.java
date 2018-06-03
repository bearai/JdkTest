package algorithm.array;

import java.util.Arrays;

/**
 * 数组partition调整附加题目,调整数组里面0,1,2的位置，0都在左边，1在中间，2在最右边
 * 数组里面只有0,1,2三种数
 *
 * @author 艾亮方
 * @date 2018年5月27日   下午9:33:44
 * @version 1.0
 **/
public class PartitionAdjust2 {

	public static void adjust(int[] arr){
		int zeroind = -1; //从左到右，第一个非0的数的下标
		for(int i=0;i<arr.length;i++){
			if(arr[i] !=0){
				zeroind = i;
				break;
			}
		}
		int twoind = -1; //从右到左，第一个非2的数的下标
		for(int j=arr.length-1;j>=0;j--){
			if(arr[j] != 2){
				twoind = j;
				break;
			}
		}
		int moveind = zeroind;
		while(moveind < arr.length){
			if(arr[moveind] == 2){
				//TODO  不好处理
			}
		}
	}
	
	public static void adjust2(int[] arr){
		int left = -1;
		int index=0;
		int right = arr.length;
		while(index<right){
			if(arr[index]==0){
				swap(arr, ++left, index++);
			}else if(arr[index] == 2){
				swap(arr, --right, index);
			}else{
				index++;
			}
		}
	}
	
	public static void swap(int[] arr, int a,int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,0,1,2,2,0,1,2,0,0,1,1};
		System.out.println(Arrays.toString(arr));
		adjust2(arr);
		System.out.println(Arrays.toString(arr));
	}
}
