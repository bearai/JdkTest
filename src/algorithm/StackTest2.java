package algorithm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;


/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月22日   下午9:23:16
 * @version 1.0
 **/
public class StackTest2 {
	
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public StackTest2() {
		stackData = new Stack<>();
		stackMin = new Stack<>();
	}
	
	public Integer pop(){
		int num = stackData.pop();
		stackMin.pop();
		return num;
	}
	
	public void push(Integer num){
		if(num == null){
			throw new IllegalArgumentException();
		}
		stackData.push(num);
		if(stackMin.size() == 0){
			stackMin.push(num);
		}else{
			int ele = stackMin.peek();
			// 重点，相等的时候也要push进去，否则会有问题
			if(num < ele){
				stackMin.push(num);
			}else{
				stackMin.push(ele);
			}
		}
	}
	
	public Integer getMin(){
		if(stackMin.isEmpty()){
			return null;
		}
		return stackMin.peek();
	}
	
	
	public static void main(String[] args) {
		StackTest2 s = new StackTest2();
		s.push(5);
		s.push(8);
		s.push(6);
		s.push(4);
		s.push(10);
		s.push(4);
		
//		System.out.println(s.toString());
		
		
//		for(int i=0;i<6;i++){
//			int curr = s.pop();
//			System.out.println("pop="+curr+" min="+s.getMin());
//		}
		
		Map<String, Integer> map = new LinkedHashMap<>(10,0.7f,true);
		map.put("ailf", 11);
		map.put("zoo", 234);
		map.put("aaa", 2343);
		map.put("bd", 11);
		
		map.get("ailf");
		map.get("zoo");
		map.get("ailf");
		map.get("aaa");
		
		for(Entry<String, Integer> entry : map.entrySet()){
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
	}
	
}
