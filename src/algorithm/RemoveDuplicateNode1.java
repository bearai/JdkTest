package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月26日   下午11:13:10
 * @version 1.0
 **/
public class RemoveDuplicateNode1 {
	

	public static Node remove(Node ori){
		Set<Integer> val = new HashSet<>();
		Node head = ori;
		Node pre = null;
		while(head != null){
			if(val.contains(head.getValue())){
				pre.setNext(head.getNext());
			}else{
				val.add(head.getValue());
				pre = head;
			}
			head = head.getNext();
		}
		return ori;
	}
	
	public static Node remove2(Node ori){
		Node head = ori;
		while(head != null){
			int val = head.getValue();
			Node begin = head.getNext();
			Node pre = head;
			while(begin != null){
				if(begin.getValue() == val){
					pre.setNext(begin.getNext());
				}else{
					pre = begin;
				}
				begin = begin.getNext();
			}
			head = head.getNext();
		}
		
		return ori;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(null, 1);
		Node n2 = new Node(n1, 20);
		Node n3 = new Node(n2, 2);
		Node n4 = new Node(n3, 33);
		Node n5 = new Node(n4, 20);
		Node n6 = new Node(n5, 2);
		Node n7 = new Node(n6, 1);
		
		printNode(n7);
		
		Node node = remove2(n7);
		
		printNode(node);
	}
	
	private static void printNode(Node ori){
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
