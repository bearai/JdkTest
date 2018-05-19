package algorithm;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月26日   下午11:13:10
 * @version 1.0
 **/
public class DelMidNode {
	
	public static Node delMidNode(Node ori){
		if(ori == null || ori.getNext() == null){
			return ori;
		}
		if(ori.getNext().getNext() == null){
			return ori.getNext();
		}
		Node head = ori;
		Node cur = ori.getNext().getNext();
		while(cur.getNext()!=null && cur.getNext().getNext()!=null){
			head = head.getNext();
			cur = cur.getNext().getNext();
		}
		head.setNext(head.getNext().getNext());
		return ori;
	}
	
	
	
	public static void main(String[] args) {
		Node n1 = new Node(null, 100);
		Node n2 = new Node(n1, 99);
		Node n3 = new Node(n2, 48);
		Node n4 = new Node(n3, 33);
		Node n5 = new Node(n4, 20);
		Node n6 = new Node(n5, 20);
		Node n7 = new Node(n6, 1);
		
		printNode(n7);
		
		Node node = delMidNode(n7);
		
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
