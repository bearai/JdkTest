package com.weimob.ailf.jdktest;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 *
 * @author 艾亮方
 * @date 2017年9月4日   下午10:05:02
 * @version 1.0
 **/
public class TestRegex {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\s*[,]+\\s*");
//		Matcher m =p.matcher("  	,,,,   ");
		String[] values = p.split(" abcd , daf,,zzz, d d,f");
		System.out.println(Arrays.asList(values));
		System.out.println(values[1]);
//		if(m.find()){
//			System.out.println(m.group());
//		}else{
//			System.out.println("find nothing");
//		}
		System.out.println(Math.sqrt(33));
		System.out.println(Math.floor(Math.sqrt(33)));
		double num = 33;
		for(int i=3;i<=Math.floor(Math.sqrt(num));i+=1){
			if(num % i == 0){
				System.out.println("number is prime");
				break;
			}
		}
		
	}
}
