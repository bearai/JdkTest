package algorithm;

import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;

/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月26日   下午10:14:18
 * @version 1.0
 **/
public class SortNode {
	
	public static void printCommonValue(Node head1,Node head2){
		if(head1 == null || head2 == null){
			return;
		}
		if(head1.getValue().compareTo(head2.getValue()) < 0){
			printCommonValue(head1.getNext(), head2);
		}else if(head1.getValue().compareTo(head2.getValue()) > 0){
			printCommonValue(head1, head2.getNext());
		}else{
			printCommonValue(head1.getNext(), head2.getNext());
			System.out.println(head1.getValue());
		}
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(null, 100);
		Node n2 = new Node(n1, 99);
		Node n3 = new Node(n2, 48);
		Node n4 = new Node(n3, 33);
		Node n5 = new Node(n4, 20);
		Node n6 = new Node(n5, 20);
		Node n7 = new Node(n6, 1);
		
		
		Node m1 = new Node(null, 100);
		Node m2 = new Node(m1, 91);
		Node m3 = new Node(m2, 49);
		Node m4 = new Node(m3, 34);
		Node m5 = new Node(m4, 25);
		Node m6 = new Node(m5, 20);
		Node m7 = new Node(m6, 11);
		
		printCommonValue(n7, m7);
	}
	
}
