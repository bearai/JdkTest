package algorithm;

import java.util.Stack;

/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月30日   下午11:10:38
 * @version 1.0
 **/
public class CombineNode {
	
	public static Node combine(Node n1,Node n2){
		Node m1 = ReverseNode.reverseNode(n1);
		printNode(m1);
		Node m2 = ReverseNode.reverseNode(n2);
		printNode(m2);
		int num = 0;
		Node head = null;
		Node pre = null;
		while(m1!=null || m2!=null){
			int m1val = m1 == null?0:m1.getValue();
			int m2val = m2 == null?0:m2.getValue();
			int nodeval = num+m1val+m2val;
			num = nodeval/10;
			nodeval = nodeval%10;
			Node node = new Node(null, nodeval);
			if(head == null){
				head = node;
				pre = head;
			}else{
				pre.setNext(node);
				pre = node;
			}
			if(m1 != null){
				m1 = m1.getNext();
			}
			if(m2 != null){
				m2 = m2.getNext();
			}
		}
		if(num==1){
			Node node1 = new Node(null, 1);
			pre.setNext(node1);
		}
		
		return ReverseNode.reverseNode(head);
	}
	
	public static Node combine2(Node n1,Node n2){
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		
		Node m1 = n1;
		while(m1 != null){
			s1.push(m1.getValue());
			m1 = m1.getNext();
		}
		
		Node m2 = n2;
		while(m2 != null){
			s2.push(m2.getValue());
			m2 = m2.getNext();
		}
		int v1,v2=0;
		int ca=0;
		int tt=0;
		Node pre=null;
		Node head=null;
		while(!s1.isEmpty() || !s2.isEmpty()){
			v1 = s1.isEmpty()?0:s1.pop();
			v2 = s2.isEmpty()?0:s2.pop();
			tt = v1+v2+ca;
			ca = tt/10;
			Node node = new Node(null, tt%10);
			if(head == null){
				head = node;
			}else {
				pre.setNext(node);
			}
			pre = node;
		}
		if(ca == 1){
			Node node = new Node(null, 1);
			pre.setNext(node);
		}
		return ReverseNode.reverseNode(head);
	}
	public static Node combine3(Node n1,Node n2){
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		
		Node m1 = n1;
		while(m1 != null){
			s1.push(m1.getValue());
			m1 = m1.getNext();
		}
		
		Node m2 = n2;
		while(m2 != null){
			s2.push(m2.getValue());
			m2 = m2.getNext();
		}
		int v1,v2=0;
		int ca=0;
		int tt=0;
		// 直接从尾部开始，不需要再反转结果
		Node next=null;
		Node node = null;
		while(!s1.isEmpty() || !s2.isEmpty()){
			v1 = s1.isEmpty()?0:s1.pop();
			v2 = s2.isEmpty()?0:s2.pop();
			tt = v1+v2+ca;
			ca = tt/10;
			node = new Node(null, tt%10);
			node.setNext(next);
			next = node;
		}
		if(ca == 1){
			node = new Node(null, 1);
			node.setNext(next);
		}
		return node;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(null, 2);
//		Node n2 = new Node(n1, 9);
//		Node n3 = new Node(n2, 2);
		Node n4 = new Node(n1, 3);
		printNode(n4);
		
		Node n5 = new Node(null, 9);
		Node n6 = new Node(n5, 9);
		Node n7 = new Node(n6, 9);
		printNode(n7);
		
		Node node = combine2(n4, n7);
		
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
		System.out.println();
	}
}
