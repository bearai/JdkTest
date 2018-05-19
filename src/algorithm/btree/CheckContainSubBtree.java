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
public class CheckContainSubBtree {

	public static boolean check(Node head,Node head2){
		if(head2 == null){
			return true;
		}
		if( head == null){
			return false;
		}
		boolean headvaluecheck = head.value == head2.value;
		boolean leftcheck = check(head.left, head2.left);
		boolean rightcheck = check(head.right, head2.right);
		if(headvaluecheck && leftcheck && rightcheck){
			return true;
		}
		if(check(head.left, head2) || check(head.right, head2)){
			return true;
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
//		Node head = SerializeBtree.deserialize("1!2!4!8!#!#!9!#!#!5!10!#!#!#!3!6!#!#!7!#!#!");
//		Node head2 = SerializeBtree.deserialize("2!4!8!#!#!#!5!#!#!");
		Node head = SerializeBtree.deserialize("1!2!6!2!3!9!#!#!8!#!#!5!#!#!#!8!#!#!5!#!2!6!#!#!9!#!11!#!#!");
		Node head2 = SerializeBtree.deserialize("2!3!7!#!#!#!5!#!#!");
		boolean contain = check(head, head2);
		if(contain){
			System.out.println("head contain head2");
		}else{
			System.out.println("not contain");
		}
		
	}
	
}
