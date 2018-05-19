package com.weimob.ailf.jdktest;
/**
 * 
 *
 * @author 艾亮方
 * @date 2016年12月15日   上午8:54:07
 * @version 1.0
 **/
public class ClientA {
	
	public static void main(String[] args) {
		IGamePlayer player = new GamePlayer("ailf");
		player.getProxy();
//		player.login();
//		player.upgrade();
		
		
		IGamePlayer proxy = new GamePlayerProxy(player);
		proxy.login();
		player.upgrade();
	}
}
