package algorithm;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月2日   下午10:22:47
 * @version 1.0
 **/
public class CombineSortedNode {
	
	private static Node combine(Node node1,Node node2){
		if(node1 == null){
			return node2;
		}
		if(node2 == null){
			return node1;
		}
		Node cur1 = null;
		Node cur2 = null;
		Node head = null;
		Node pre = null;
		if(node1.getValue()<=node2.getValue()){
			cur1 = node1;
			cur2 = node2;
		}else{
			cur1 = node2;
			cur2 = node1;
		}
		head = cur1;
		while(true){
			if(cur1 == null){
				pre.setNext(cur2);
				break;
			}else if(cur2 == null) {
				break;
			}
			if(cur1.getValue()<=cur2.getValue()){
				pre = cur1;
				cur1 = cur1.getNext();
			}else{
				pre.setNext(cur2);
				pre = cur2;
				cur2 = cur2.getNext();
				pre.setNext(cur1);
			}
		}
		return head;
	}
	
	
	
	public static void main(String[] args) {
		Node n1 = new Node(null, 98);
//		Node n2 = new Node(n1, 79);
//		Node n3 = new Node(n2, 48);
//		Node n4 = new Node(n3, 33);
//		Node n5 = new Node(n4, 11);
		Node n6 = new Node(n1, 28);
		Node n7 = new Node(n6, 19);
		
		Node.printNode(n7);
		
		Node m1 = new Node(null, 998);
		Node m6 = new Node(m1, 3);
		Node m7 = new Node(m6, 1);
		
		Node.printNode(m7);
		
		
		Node node = combine(n7, m7);
		
		Node.printNode(node);
	}
	
}
