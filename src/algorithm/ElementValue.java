package algorithm;
/**
 * 有setall功能的hashmap的元素
 *
 * @author 艾亮方
 * @date 2018年6月7日   上午8:57:51
 * @version 1.0
 **/
public class ElementValue<V> {
	
	
	private V value;
	
	private int time = 0;
	
	public ElementValue(){
		
	}
	
	public ElementValue(V value,int time){
		this.value = value;
		this.time = time;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
}
