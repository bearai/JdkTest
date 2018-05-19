package com.weimob.ailf.jdktest;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年1月5日   上午8:59:02
 * @version 1.0
 **/
public class TestRemoveOne {

	
	public static void main(String[] args) {
//		System.out.println((((byte)0xff) >>> 7));
//		System.out.println((byte)0xff);
		int n=0;
		int i=1;
		while(true){
			if(i%2==0 || i%3==0){
				n++;
			}
			if(n == 2333){
				break;
			}
			i++;
		}
		System.out.println(i);
	}
}
