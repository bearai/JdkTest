package algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月26日   下午11:13:10
 * @version 1.0
 **/
public class DelValueNode {
	

	public static Node delVal(Node ori,int value){
		Node head = ori;
		Node pre = null;
		while(head != null){
			if(head.getValue() == value){
				if(pre == null){
//					return delVal(head.getNext(), value);
					ori = head.getNext();
				}else{
					pre.setNext(head.getNext());
				}
			}else {
				pre = head;
			}
			head = head.getNext();
		}
		return ori;
	}
	
	public static Node delVal2(Node ori,int value){
		Stack<Node> nodes = new Stack<>();
		Node head = ori;
		while(head != null){
			if(head.getValue() != value){
				nodes.push(head);
			}
			head = head.getNext();
		}
		if(nodes.isEmpty()){
			return null;
		}else {
			Node next = null;
			Node head2 = null;
			while(!nodes.isEmpty()){
				head2 = nodes.pop();
				head2.setNext(next);
				next = head2;
			}
			return head2;
		}
		
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(null, 1);
		Node n2 = new Node(n1, 1);
		Node n3 = new Node(n2, 19);
		Node n4 = new Node(n3, 1);
		Node n5 = new Node(n4, 10);
		Node n6 = new Node(n5, 12);
		Node n7 = new Node(n6, 1);
		
		printNode(n7);
		
		Node node = delVal2(n7,1);
		
		printNode(node);
	}
	
	private static void printNode(Node ori){
		if(ori == null){
			System.out.println("linktable is empty");
			return;
		}
		while(true){
			System.out.print(ori.getValue()+",");
			ori = ori.getNext();
			if(ori == null){
				break;
			}
		}
//		System.out.println("ori.value="+ori.getValue());
		System.out.println();
	}
	
}
