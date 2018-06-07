package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 具有setall功能的hashmap
 *
 * @author 艾亮方
 * @date 2018年6月7日   上午12:08:00
 * @version 1.0
 **/
public class NewHashMap<K,V> extends HashMap<K, V> {
	
	private static final long serialVersionUID = 7362242069058431791L;
	
	Set<K> keys = new HashSet<>();
	
	boolean isReseted = false;
	
	V allValue;
	
	NewHashMap(){
		super();
	}
	
	@Override
	public V get(Object key){
		if(isReseted && !keys.contains(key)){
			return allValue;
		}
		return super.get(key);
	}
	
	@Override
	public V put(K k,V v){
		if(isReseted){
			keys.add(k);
		}
		return super.put(k, v);
	}
	
	public void setAll(V v){
		isReseted = true;
		this.allValue = v;
		keys.clear();
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder("{");
		if(size()>0){
			for(K k: keySet()){
				sb.append(k).append("=").append(get(k)).append(",");
			}
		}
		sb.append("}");
		return sb.toString();
		
	}
}
