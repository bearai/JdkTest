package algorithm;
/**
 * 获取数组中需要排序的最短子串长度
 *
 * @author 艾亮方
 * @date 2018年5月19日   上午12:00:11
 * @version 1.0
 **/
public class GetLengthNotOrdered {
	
	public static int[] getLength(int[] arr){
		if(arr.length<3){
			return null;
		}
		int maxind = arr.length-1;
		if(arr[0] <= arr[maxind]){
			return getLengthInAsc(arr,maxind);
		}else {
			return getLengthInDesc(arr);
		}
	}
	
	private static int[] getLengthInAsc(int[] arr,int maxind){
		int i=1;
		boolean errorflag = false;
		for(;i<=maxind;i++){
			if(arr[i] < arr[i-1]){
				errorflag = true;
				break;
			}
		}
		if(!errorflag){
			return null;
		}
		int e1 = i;
		int b1 = 0;
		for(int k=i;k>=0;k--){
			if((k==0 || arr[k]>=arr[k-1]) && (k==maxind || arr[k]<arr[k+1])){
				b1 = k;
			}
		}
		errorflag = false;
		int j = maxind;
		for(;j>i;j--){
			if(arr[j]>arr[j+1]){
				errorflag = true;
				break;
			}
		}
		
		return null;
	}
	
	private static int[] getLengthInDesc(int[] arr){
		return null;
	}
	public static int[] getLength2(int[] arr){
		if(arr == null || arr.length<3){
			return null;
		}
		int len = arr.length;
		int min = arr[len-1];
		int noMinIndex = -1;
		for(int i=len-2;i!=-1;i--){
			if(arr[i]>min){
				noMinIndex = i;
			}else {
				min = Math.min(min, arr[i]);
			}
		}
		if(noMinIndex == -1){
			return null;
		}
		int noMaxIndex=-1;
		int max = arr[0];
		for(int j=1;j!=len;j++){
			if(arr[j]<max){
				noMaxIndex = j;
			}else {
				max = Math.max(max, arr[j]);
			}
		}
		if(noMaxIndex == -1){
			return null;
		}
		return new int[]{noMaxIndex,noMinIndex};
	}
	
	public static void main(String[] args) {
//		int[] arr = new int[]{2,2,5,7,3,6,8,9};
		int[] arr = new int[]{2,1,5,7,3,6,11,9};
		int[] lenarr = getLength2(arr);
		if(lenarr == null){
			System.out.println("no need for order");
		}else{
			System.out.println(lenarr[0]+"-"+lenarr[1]);
		}
	}
}
