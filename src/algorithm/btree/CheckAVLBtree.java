package algorithm.btree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月7日   下午11:36:22
 * @version 1.0
 **/
public class CheckAVLBtree {

	public static boolean check(Node node){
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(node, 1, res);
		return res[0];
	}
	
	private static int getHeight(Node node,int level,boolean[] res){
		if(node == null){
			return level;
		}
		int lefth = getHeight(node.left, level+1, res);
		if(!res[0]){
			return level;
		}
		int righth = getHeight(node.right, level+1, res);
		if(!res[0]){
			return level;
		}
		if(Math.abs(lefth-righth)>1){
			res[0]=false;
		}
		return Math.max(lefth, righth);
	}
	
	private static int getHeight(Node node,int level){
		if(node == null){
			return level;
		}
		return Math.max(getHeight(node.left, level+1), getHeight(node.right, level+1));
	}
	
//	public static boolean check3(Node node){
//		return check2(node, 1);
//	}
	
	public  static boolean check2(Node node){
		if(node == null){
			return true;
		}
		int lefth =  getHeight(node.left, 1);
		int righth = getHeight(node.right, 1);
		if(Math.abs(lefth-righth)>1){
			return false;
		}
		if(!check2(node.left) || !check2(node.right)){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Node head = SerializeBtree.deserialize("1!2!4!8!#!#!9!#!#!5!10!#!#!#!3!6!#!#!7!#!#!");
//		Node head = SerializeBtree.deserialize("1!2!6!2!3!9!#!#!8!#!#!5!#!#!#!8!#!#!5!#!2!6!#!#!9!#!11!#!#!");
		boolean balance = check2(head);
		if(balance){
			System.out.println("avl tree");
		}else{
			System.out.println("not avl");
		}
		
	}
	
}
