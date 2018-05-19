package algorithm;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月2日   下午10:22:47
 * @version 1.0
 **/
public class AddToRoundNode {
	
	private static Node add(Node head,int num){
		if(head == null){
			return new Node(null, num);
		}
		if(head.getNext() == null){
			Node node = new Node(head, num);
			head.setNext(node);
			if(num>head.getValue()){
				return head;
			}else{
				return node;
			}
		}
		Node pre = head;
		Node cur = head.getNext();
		while(cur != head){
			if(num<=cur.getValue() && num>=pre.getValue()){
				Node nd = new Node(cur, num);
				pre.setNext(nd);
				return head;
			}
			pre = cur;
			cur = cur.getNext();
		}
		Node nd = new Node(null, num);
		pre.setNext(nd);
		nd.setNext(cur);
		if(num < cur.getValue()){
			return nd;
		}
		return head;
	}
	
	
	
	public static void main(String[] args) {
//		Node n1 = new Node(null, 199);
//		Node n2 = new Node(n1, 99);
//		Node n3 = new Node(n2, 48);
//		Node n4 = new Node(n3, 33);
//		Node n5 = new Node(n4, 21);
//		Node n6 = new Node(n5, 11);
		Node n7 = new Node(null, 11);
		
//		n1.setNext(n7);
		
		Node.printRoundNode(n7);
		
		Node nd = add(n7,5);
		
		Node.printRoundNode(nd);
	}
	
}
