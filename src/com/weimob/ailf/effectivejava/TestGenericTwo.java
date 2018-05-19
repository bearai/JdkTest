package com.weimob.ailf.effectivejava;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 * @author 艾亮方
 * @date 2017年12月19日   下午11:21:00
 * @version 1.0
 **/
public class TestGenericTwo {
	
	public static void main(String[] args) throws ClassNotFoundException {
		List<String> a = new ArrayList<>();
		Class s =a.getClass();
		Class<List> c = List.class;
		Class c2 = List.class;
		List<Long> a2 = new ArrayList<>();
		Class s2 = a2.getClass();
		if(c == c2){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		if(s == s2){
			System.out.println("true-2");
		}
	}
	
}
