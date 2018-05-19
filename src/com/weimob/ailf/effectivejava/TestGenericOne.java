package com.weimob.ailf.effectivejava;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 * @author 艾亮方
 * @date 2017年12月19日 下午11:02:01
 * @version 1.0
 **/
public class TestGenericOne {

	public static void main(String[] args) {
		List<String> lststr = new ArrayList<>();
		unsafeAdd(lststr, new Integer(32));
//		unsafeAdd2(lststr, new Integer(32));
		String s = lststr.get(0);
	}

	private static void unsafeAdd(List lst, Object obj) {
		lst.add(obj);
	}
	
	private static void unsafeAdd2(List<Object> lst, Object obj){
		lst.add(obj);
	}
	
	private static void unsafeAdd3(List<?> lst,Object obj){
//		lst.add(obj);
//		The method add(capture#1-of ?) in the type List<capture#1-of ?> is not applicable for the arguments (Object)
		
		List<?> newlst = new ArrayList<>();
		newlst.add(null);
//		newlst.add("ddd");
	}
}
