package com.weimob.ailf.jdktest;
/**
 * 
 *
 * @author 艾亮方
 * @date 2016年12月15日   上午8:48:43
 * @version 1.0
 **/
public class GamePlayerProxy implements IGamePlayer {
	
	private IGamePlayer player;
	
	public GamePlayerProxy(IGamePlayer gamePlayer) {
		this.player = gamePlayer;
	}
	

	@Override
	public void upgrade() {
		this.player.upgrade();
	}

	@Override
	public void login() {
		this.player.login();

	}


	@Override
	public IGamePlayer getProxy() {
		
		return this;
	}

}
