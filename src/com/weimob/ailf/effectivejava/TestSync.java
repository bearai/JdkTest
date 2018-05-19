package com.weimob.ailf.effectivejava;

import java.util.concurrent.TimeUnit;

/**
 * 
 *
 * @author 艾亮方
 * @date 2018年2月6日   上午8:05:18
 * @version 1.0
 **/
public class TestSync {
	
	private static boolean stopExecute;
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i=0;
				while(!stopExecute){
					i++;
				}
			}
		});
		thread.start();
		
		TimeUnit.SECONDS.sleep(1);
		stopExecute = true;
		
		
	}
}
