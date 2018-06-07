package algorithm;

import java.util.HashMap;
import java.util.Set;

/**
 * 有setAll功能的hashMap，时间复杂度要求为O(1)
 *
 * @author 艾亮方
 * @date 2018年6月6日   下午11:48:29
 * @version 1.0
 **/
public class SetAllHashMap {

//	public class NewHashMap<K,V> extends HashMap<K, V>{
//
//		private static final long serialVersionUID = 7362242069058431791L;
//		
//		Set<K> keySet;
//		
//		boolean isReseted = false;
//		
//		V allValue;
//		
//		NewHashMap(){
//			super();
//		}
//		
//		@Override
//		public V get(Object key){
//			if(isReseted && !keySet.contains(key)){
//				return allValue;
//			}
//			return get(key);
//		}
//		@Override
//		public V put(K k,V v){
//			if(isReseted){
//				keySet.add(k);
//				// 如果所有的值都被更新了一遍，将isReseted置为false
//				if(keySet.size() == size()){
//					isReseted = false;
//				}
//			}
//			return put(k, v);
//		}
//		
//		public void setAll(V v){
//			isReseted = true;
//			this.allValue = v;
//			keySet.clear();
//		}
//		
//	}
	
	public static void main(String[] args) {
		NewHashMap2<Integer, String> map = new NewHashMap2<Integer,String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		System.out.println(map.toString());
		
		map.setAll("Ilove");
		System.out.println(map.toString());
		
		map.put(1, "d");
		map.put(2, "e");
		map.put(8, "8");
		System.out.println(map.toString());
		
		map.setAll("tttt");
		
		System.out.println(map.toString());
	}
	
}
