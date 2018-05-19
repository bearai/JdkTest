package com.weimob.ailf.effectivejava;

import java.util.HashMap;
import java.util.Map;

import com.weimob.ailf.jdktest.Father;
import com.weimob.ailf.jdktest.GamePlayer;
import com.weimob.ailf.jdktest.Son;

/**
 * 
 *
 * @author 艾亮方
 * @date 2017年12月27日   上午8:43:44
 * @version 1.0
 **/
public class Favorites {
	
	private Map<Class<?>,Object> map = new HashMap<>();
	
	public <T> void putFavorites(Class<T> clz,T instance){
//		map.put(clz, instance);
//		clz.isInstance(instance)
		map.put(clz, clz.cast(instance));
	}
	
	public <T> T getFavorites(Class<T> clz){
		return  clz.cast(map.get(clz));
	}
	
	public static void main(String[] args) {
		Favorites f = new Favorites();
		f.putFavorites(Integer.class, 100);
		f.putFavorites(String.class, "abcd");
		f.putFavorites(Son.class, new Son());
		Class clz = Father.class;
		f.putFavorites(clz, new GamePlayer("abcd"));
		System.out.println(f.getFavorites(Integer.class));
		System.out.println(f.getFavorites(String.class));
		System.out.println(f.getFavorites(Son.class));
		System.out.println(f.getFavorites(clz));
	}
	
}
