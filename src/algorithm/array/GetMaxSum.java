package algorithm.array;

import java.util.Arrays;

/**
 * 获取子数组的最大累加和
 *
 * @author 艾亮方
 * @date 2018年5月24日   上午12:23:45
 * @version 1.0
 **/
public class GetMaxSum {

	/**
	 * 返回累加和的起始和结束下标，异常情况返回null
	 * @param arr
	 * @return
	 */
	public static int[] getMax(int[] arr){
		if(arr == null || arr.length <2){
			return null;
		}
		int[] fromleftmax = getMaxByIndexDirection(arr, 0, arr.length-1, true);
		int[] fromrightmax = getMaxByIndexDirection(arr, fromleftmax[0], fromleftmax[1], false);
		return fromrightmax;
	}
	private static int[] getMaxByIndexDirection(int[] arr,int begin,int end,boolean fromleft){
		int[] maxind = new int[]{begin,end};
		int maxsum = getsumbyIndex(arr, begin, end);
		if(fromleft){
			int leftsum = 0;
			for(int i=begin;i<=end;i++){
				leftsum = getsumbyIndex(arr, i, end);
				if(maxsum >= leftsum){
					leftsum = 0;
				}else {
					return getMaxByIndexDirection(arr, i, end, true);
				}
			}
		}else{
			int rightsum = 0;
			for(int j=end;j>=begin;j--){
				rightsum = getsumbyIndex(arr, begin, j);
				if(rightsum<=maxsum){
					rightsum=0;
				}else {
					return getMaxByIndexDirection(arr, begin, j, false);
				}
			}
		}
		return maxind;
	}
	
	private static int getsumbyIndex(int[] arr,int begin,int end){
		int sum = 0;
		for(int i=begin;i<=end;i++){
			sum += arr[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
//		int[] arr = new int[]{1,-1,3,5,-2,6,-1};
//		int[] arr = new int[]{1,-2,3,5,-2,6,-1};
		int[] arr = new int[]{-1,-2,-3,-5,-2,6,-1};
//		int[] arr = new int[]{-1,-12,-3,-5,-2,-6,-100};
//		int[] arr = new int[]{-11,-12,-3,-5,-2,-6,-100}; //对于全部为负数的数组，直接求其最大值即可
		System.out.println(Arrays.toString(arr));
		int[] maxsumind = getMax(arr);
		if(maxsumind == null){
			System.out.println("arr is null or len =1");
		}else{
			System.out.println("max sum from "+(maxsumind[0]+1)+" to "+(maxsumind[1]+1));
			System.out.println("maxsum is "+getsumbyIndex(arr, maxsumind[0], maxsumind[1]));
		}
	}
	
}
