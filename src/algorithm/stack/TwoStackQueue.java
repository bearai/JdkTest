package algorithm.stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 用两个栈实现队列的功能
 *
 * @author 艾亮方
 * @date 2018年6月12日   下午10:35:21
 * @version 1.0
 **/
public class TwoStackQueue {
	
	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	
	public TwoStackQueue(){
		stackPop = new Stack<>();
		stackPush = new Stack<>();
	}
	
	public void add(int num){
		stackPush.push(num);
	}
	
	public int poll(){
		if(stackPop.isEmpty() && stackPush.isEmpty()){
			throw new EmptyStackException();
		}else if(stackPop.isEmpty()){
			while(!stackPush.isEmpty()){
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	
	public int peek(){
		if(stackPop.isEmpty() && stackPush.isEmpty()){
			throw new EmptyStackException();
		}else if(stackPop.isEmpty()){
			while(!stackPush.isEmpty()){
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
	
	public static void main(String[] args) {
		TwoStackQueue queue = new TwoStackQueue();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println("peek:"+queue.peek());
		System.out.println("poll:"+queue.poll());
		queue.add(100);
		queue.add(10);
		System.out.println("poll:"+queue.poll());
		System.out.println("poll:"+queue.poll());
		System.out.println("poll:"+queue.poll());
		System.out.println("poll:"+queue.poll());
	}
}
