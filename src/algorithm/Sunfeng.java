package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月20日   下午11:08:04
 * @version 1.0
 **/
public class Sunfeng {
	
	public static void main(String[] args) {
		int minNums = 1;
		int maxNums = 15;
		int[] numArray = {509,838,924,650,604,793,564,651,697,649,747,787,701,605,644};
		int maxTons = 5000;
		order(numArray);
		System.out.println(Arrays.toString(numArray));
		minNums = getMinNums(numArray, maxTons);
		maxNums = getMaxNums(numArray, maxTons);
		System.out.println("minNums="+minNums+"  maxNums="+maxNums);
		Map<Integer,String> map = new HashMap<>();			
		
	}
	
	private static void getMaxSumByNums(int number,int maxTons,int[] numArray,Map<Integer,String> map){
		
	}
	
	private static int getMinNums(int[] numArray,int maxTons){
		int len = numArray.length;
		int sum = 0;
		int nums = 0;
		for(int i=len-1;i>0;i--){
			sum = sum+numArray[i];
			if(sum > maxTons){
				System.out.println(sum-numArray[i]);
				break;
			}else{
				nums+=1;
			}
		}
		
		return nums==0?1:nums;
	}
	
	private static int getMaxNums(int[] numArray,int maxTons){
		int len = numArray.length;
		int sum = 0;
		int nums = 0;
		for(int i=0;i<len;i++){
			sum = sum+numArray[i];
			if(sum > maxTons){
				System.out.println(sum-numArray[i]);
				break;
			}else{
				nums+=1;
			}
		}
		
		return nums==0?1:nums;
	}
	
	
	private static void order(int[] numArray){
		int len = numArray.length;
		for(int i=0;i<numArray.length-1;i++){
			for(int j=i+1;j<len;j++){
				if(numArray[i] > numArray[j]){
					int temp = numArray[i];
					numArray[i] = numArray[j];
					numArray[j] = temp;
				}
			}
		}
	}
}
