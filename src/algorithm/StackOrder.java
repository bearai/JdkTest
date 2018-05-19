package algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月24日   下午6:02:41
 * @version 1.0
 **/
public class StackOrder {

	public static void order(Stack<Integer> origin){
		if(origin.isEmpty()){
			System.out.println("origin stack is empty");
		}
		Stack<Integer> help = new Stack<>();
		while(!origin.isEmpty()){
			Integer num = origin.pop();
			if(help.isEmpty() || help.peek().compareTo(num)>=0){
				help.push(num);
			}else{
				opt(help, origin, num);
			}
		}
		System.out.println(Arrays.toString(help.toArray()));
	}
	
	private static void opt(Stack<Integer> help,Stack<Integer> origin,Integer num){
		while(!help.isEmpty()){
			Integer ele = help.peek();
			if(ele.compareTo(num) < 0){
				origin.push(help.pop());
			}else{
				help.push(num);
				return;
			}
		}
		help.push(num);
	}
	
	public static void order2(Stack<Integer> origin){
		if(origin.isEmpty()){
			System.out.println("origin stack is null");
		}
		Stack<Integer> help = new Stack<>();
		while(!origin.isEmpty()){
			Integer num = origin.pop();
			while(!help.isEmpty() && num.compareTo(help.peek())>0){
				origin.push(help.pop());
			}
			help.push(num);
		}
		System.out.println(Arrays.toString(help.toArray()));
	}
	
	public static void order3(Stack<Integer> origin){
		if(origin.isEmpty()){
			System.out.println("origin stack is null");
		}
		int dealedNum = 0;
		Integer times = 1;
		int maxsize = origin.size();
		Stack<Integer> help = new Stack<>();
		Integer evenMin = null;
		while(dealedNum < maxsize){
			if(times %2 == 0){
				evenMin = null;
				//偶数的时候，help->origin
				evenMin = moveAndGetMin(help, origin, 0);
				times++;
			}else{
				//奇数的时候，origin->help
				Integer min = moveAndGetMin(origin, help, dealedNum);
				if(evenMin != null){
					origin.push(evenMin);
					dealedNum++;
				}
				if(min == null){
					break;
				}
				origin.push(min);
				times++;
				dealedNum++;
			}
		}
		System.out.println(Arrays.toString(origin.toArray()));
	}
	
	private static Integer moveAndGetMin(Stack<Integer> source,Stack<Integer> target, Integer limit){
		Integer min = null;
		while(source.size()>limit){
			if(min == null){
				min = source.pop();
				continue;
			}
			if(min.compareTo(source.peek()) > 0){
				target.push(min);
				min = source.pop();
			}else{
				target.push(source.pop());
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(123);
		stack.push(1);
		stack.push(22);
		stack.push(21);
		stack.push(72);
		stack.push(99);
		stack.push(1);
		stack.push(123);
		stack.push(1);
		order3(stack);
	}
}
