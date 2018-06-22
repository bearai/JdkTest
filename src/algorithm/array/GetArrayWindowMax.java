package algorithm.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 *
 * @author 艾亮方
 * @date 2018年6月13日   下午11:31:20
 * @version 1.0
 **/
public class GetArrayWindowMax {
	
	public static int[] getWindowMaxArray2(int arr[], int w){
		if(arr.length<w) return null;
		int[] windowMaxArr = new int[arr.length-w+1];
		LinkedList<Integer> qmax = new LinkedList<>();
		for(int i=0;i<arr.length;i++){
			while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i]){
				qmax.pollLast();
			}
			qmax.offer(i);
			if(qmax.peekFirst() == i-w){
				qmax.poll();
			}
			if(i>=w-1){
				windowMaxArr[i-w+1] = arr[qmax.peekFirst()];
			}
		}
		return windowMaxArr;
	}
	
	public static int[] getWindowMaxArray(int[] arr,int w) {
		int len = arr.length;
		if(arr.length<w){
			return null;
		}
		int[] windowMaxArray = new int[len-w+1];
		int maxInd = -1;
		int begin = 0;
		int end = w-1;
		for(int i=0;i<len-w+1;i++){
			if(maxInd == -1){
				maxInd = getMaxInd(arr, begin, end);
				windowMaxArray[i] = maxInd;
			}else if(maxInd<begin){
				maxInd = getMaxInd(arr, begin, end);
				windowMaxArray[i] = maxInd;
			}else if(arr[maxInd]<arr[end]){
				maxInd = end;
				windowMaxArray[i] = end;
			}else {
				windowMaxArray[i] = maxInd;
			}
			begin++;
			end++;
		}
		for(int i=0;i<windowMaxArray.length;i++){
			windowMaxArray[i] = arr[windowMaxArray[i]];
		}
		return windowMaxArray;
	}
	
	private static int getMaxInd(int[] arr, int begin,int end){
		int index = begin;
		for(int i=begin+1;i<=end;i++){
			if(arr[i]>arr[index]){
				index = i;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{4,3,5,4,3,3,6,7};
		System.out.println(Arrays.toString(arr));
		int[] maxWindowArr = getWindowMaxArray(arr, 4);
		System.out.println(Arrays.toString(maxWindowArr));
		int[] maxWindowArr2 = getWindowMaxArray2(arr, 4);
		System.out.println(Arrays.toString(maxWindowArr2));
	}
}
