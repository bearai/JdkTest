package algorithm.stack;

import java.util.Stack;

/**
 * 不借助其他数据结构，用递归的方式将栈逆序
 *
 * @author 艾亮方
 * @date 2018年6月12日   下午10:59:17
 * @version 1.0
 **/
public class ReverseStack {

	
	public static void reverse(Stack<Integer> stack){
		if(stack.isEmpty()) return;
		int last = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(last);
	} 
	
	private static int getAndRemoveLastElement(Stack<Integer> stack){
		int result = stack.pop();
		if(stack.isEmpty()){
			return result;
		}else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		reverse(s);
		while(!s.isEmpty()){
			System.out.print(s.pop()+",");
		}
	}
	
	
}
