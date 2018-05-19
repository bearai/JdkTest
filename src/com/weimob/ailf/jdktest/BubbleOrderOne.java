package com.weimob.ailf.jdktest;

import java.util.Arrays;

/**
 * 
 *
 * @author 艾亮方
 * @date 2017年10月10日   下午10:57:06
 * @version 1.0
 **/
public class BubbleOrderOne {

	
	public static void main(String[] args) {
		int[] nums = {1,22,0,99,10,2,1,0,22};
		int len = nums.length;
		int temp = 0;
		for(int i=1; i<len; i++){
			for(int j=0;j<len-i;j++){
				if(nums[j] > nums[j+1]){
					temp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = temp;
				}
			}
		}
		
		for(int i=0;i<len;i++){
			System.out.println(nums[i]);
		}
	}
}
