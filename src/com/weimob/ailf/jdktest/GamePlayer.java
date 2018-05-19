package com.weimob.ailf.jdktest;
/**
 * 
 *
 * @author 艾亮方
 * @date 2016年12月15日   上午8:46:15
 * @version 1.0
 **/
public class GamePlayer implements IGamePlayer {
	
	private IGamePlayer gamePlayerProxy;
	
	private String name;
	
	public GamePlayer(String name){
		this.name = name;
	}
	
	public boolean isProxy(){
		return gamePlayerProxy != null;
	}
	
	@Override
	public IGamePlayer getProxy(){
		if(gamePlayerProxy == null){
			gamePlayerProxy = new GamePlayerProxy(this);
		}
		return gamePlayerProxy;
	}

	@Override
	public void upgrade() {
		if(!isProxy()){
			System.out.println("dont have a proxy,pls contact my proxy");
			return;
		}
		System.out.println(name+" upgraded!");
	}

	@Override
	public void login() {
		if(!isProxy()){
			System.out.println("dont have a proxy,pls contact my proxy");
			return;
		}
		System.out.println(name+" logined!");

	}

}
