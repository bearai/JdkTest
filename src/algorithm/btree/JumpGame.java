package algorithm.btree;
/**
 * 跳跃问题 
 *
 * @author 艾亮方
 * @date 2018年4月15日   下午11:41:37
 * @version 1.0
 **/
public class JumpGame {
	
	public static int getMinStep(int[] arr){
		int jump = 0;
		int furtherest = 0;
		int curEnd = 0;
		
		for(int i=0;i<arr.length-1;i++){
			furtherest = Math.max(furtherest, i+arr[i]);
			if(curEnd == i){
				jump++;
				curEnd = furtherest;
				if(furtherest >= arr.length-1) return jump;
			}
		}
		return furtherest >= arr.length-1?jump:-1;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,2,1,1,4};
		int minStep = getMinStep(arr);
		if(minStep == -1){
			System.out.println("cannot jump to last");
		}else{
			System.out.println("min step is "+minStep);
		}
	}
	
}
