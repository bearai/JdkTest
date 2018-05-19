package com.weimob.ailf.jdktest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 *
 * @author 艾亮方
 * @date 2016年8月23日   下午11:10:48
 * @version 1.0
 **/
public class TestTheadLocal {



	private static ThreadLocal<Integer> LOCAL = new ThreadLocal<>();
	
	public static void main(String[] args) {
		
		Thread t = new Thread("thread one") {
			
			@Override
			public void run() {
//				System.out.println("thread one have id="+Thread.currentThread().getId());
				LOCAL.set(1);
//				try {
//					TimeUnit.SECONDS.sleep(5);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				System.out.println(this.getName()+" have local value="+LOCAL.get());
			}
		};
		Thread t1 = new Thread("thread two") {
			
			@Override
			public void run() {
//				System.out.println("thread two have id="+Thread.currentThread().getId());
//				LOCAL.set(2);
//				try {
//					TimeUnit.SECONDS.sleep(2);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				Thread current = Thread.currentThread();
				System.out.println("currentName:"+current.getName());
//				System.out.println((this == current) +"_"+this.equals(current));
				System.out.println(this.getName()+" have local value="+LOCAL.get());
			}
		};
		t.run();
		t1.run();
		
		
	}


	
}
