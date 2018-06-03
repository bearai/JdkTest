package algorithm.array;

import java.util.Arrays;


/**
 * 获取不包括自身的累计积
 *
 * @author 艾亮方
 * @date 2018年5月25日   上午12:01:59
 * @version 1.0
 **/
public class GetMultipateSum {

	
	public static void deal(int[] arr){
		if(arr == null || arr.length<2){
			return;
		}
		int all = 1;
		int zerocount = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] != 0){
				all *= arr[i];
			}else {
				zerocount ++;
			}
		}
		for(int i=0;i<arr.length;i++){
			if(zerocount>=2){
				arr[i] = 0;
			}else if(zerocount == 1){
				if(arr[i]==0){
					arr[i]=all;
				}else{
					arr[i]=0;
				}
			}else {
				arr[i] = all/arr[i];
			}
		}
	}
	
	/**
	 * 不使用除法
	 * @param arr
	 */
	public static void deal2(int[] arr){
		if(arr == null || arr.length<2){
			return;
		}
		int[] tarr = new int[arr.length];
		tarr[0]=1;
		int val = 1;
		for(int i=1;i<arr.length;i++){
			val *= arr[i-1];
			tarr[i] = val;
		}
		val = 1;
		int temp=arr[arr.length-1];
		for(int j=arr.length-2;j>=0;j--){
			val *= temp;
			temp = arr[j];
			arr[j] = val*tarr[j];
		}
		arr[arr.length-1]=tarr[arr.length-1];
	}
	
	public static void main(String[] args) {
//		int[] arr = new int[]{1,2,3,4,5};
		int[] arr = new int[]{1,0,3,4,5};
//		int[] arr = new int[]{0,2,3,0,5,3,5};
		System.out.println(Arrays.toString(arr));
		deal2(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}
