package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 有setall功能的hashmap
 *
 * @author 艾亮方
 * @date 2018年6月7日   上午8:59:10
 * @version 1.0
 **/
public class NewHashMap2<K,V> {

	private Map<K,ElementValue<V>> valueMap = new HashMap<>();
	
	private ElementValue<V> allVal;
	
	private int time = 0;
	
	public V get(Object k){
		if(valueMap.containsKey(k)){
			if(allVal != null){
				return valueMap.get(k).getTime()<allVal.getTime()?allVal.getValue():valueMap.get(k).getValue();
			}else{
				return valueMap.get(k).getValue();
			}
		}
		return null;
	}
	
	public boolean containsKey(Object k){
		return valueMap.containsKey(k);
	}
	
	public V put(K key,V value){
		valueMap.put(key, new ElementValue<>(value,time++));
		return value;
	}
	
	public void setAll(V v){
		if(allVal == null){
			allVal = new ElementValue<>(v,time++);
		}else{
			allVal.setValue(v);
			allVal.setTime(time++);
		}
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder("{");
		if(valueMap.size()>0){
			for(K k: valueMap.keySet()){
				sb.append(k).append("=").append(get(k)).append(",");
			}
		}
		sb.append("}");
		return sb.toString();
		
	}
}
