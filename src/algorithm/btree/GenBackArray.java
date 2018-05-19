package algorithm.btree;

import java.util.Arrays;

/**
 * 根据前序数组和后序数组，在不重建一棵树的情况下，生成中序数组
 * 
 * @author 艾亮方
 * @date 2018年4月15日   上午11:12:45
 * @version 1.0
 **/
public class GenBackArray {

	public static int[] getBackArray(int[] frontArr,int[] midArr){
		if(frontArr.length != midArr.length){
			throw new IllegalArgumentException("参数错误，前序数组和中序数组长度不一致");
		}
		if(frontArr.length == 0 || frontArr.length == 1){
			return frontArr;
		}
		int[] backArr = new int[frontArr.length];
		updateBackArrByMidAndFront(frontArr,0,frontArr.length-1,midArr,0,midArr.length-1,backArr,0,backArr.length-1);
		return backArr;
	}
	
	public static void updateBackArrByMidAndFront(int[] front,int frontStart,int frontEnd,
			int[] middle,int midStart,int midEnd,
			int[] back,int backStart,int backEnd){
		int headval = front[frontStart];
		back[backEnd] = headval;
		if(frontStart == frontEnd){
			return;
		}
		int midheadindex = searchIndexByValue(middle, headval, midStart, midEnd);
		//head没有找到，报错
		if(midheadindex == -1){
			throw new NullPointerException("head value="+headval+" not found between start="+midStart+" and end="+midEnd);
		}
		if(midheadindex == midStart){
			// 没有左子树
			updateBackArrByMidAndFront(front, frontStart+1, frontEnd, middle, midheadindex+1, midEnd, back, backStart, backEnd-1);
		}else if(midheadindex == midEnd){
			// 没有右子树
			updateBackArrByMidAndFront(front, frontStart+1, frontEnd, middle, midStart, midheadindex-1, back, backStart, backEnd-1);
		}else {
			// 左右子树都有
			int leftlen = midheadindex-midStart;
			int frontLeftEnd = leftlen+frontStart;
			int index = leftlen+backStart-1;
			// 左子树递归
			updateBackArrByMidAndFront(front, frontStart+1, frontLeftEnd, middle, midStart, midheadindex-1, back, backStart, index);
			// 右子树递归
			updateBackArrByMidAndFront(front, frontLeftEnd+1, frontEnd, middle, midheadindex+1, midEnd, back, index+1, backEnd-1);
		}
	}
	
	private static int searchIndexByValue(int[] arr,int value,int start,int end){
		for(int i=start;i<=end;i++){
			if(value == arr[i]){
				return i;
			}
		}
//		throw new NullPointerException("value="+value+" not found between start="+start+" and end="+end);
		return -1;
	}
	
	public static void main(String[] args) {
		int[] frontarr = new int[]{1,5,10,9,11,8,21,20,15,6};
		int[] midarr = new int[]{10,5,9,1,21,8,20,11,6,15};
		int[] backarr = getBackArray(frontarr, midarr);
		System.out.println(Arrays.toString(backarr));
	}
	
//	private static void printArr(int[] arr)
}
