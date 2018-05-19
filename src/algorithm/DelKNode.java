package algorithm;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月26日   下午11:13:10
 * @version 1.0
 **/
public class DelKNode {
	
	public static Node delKNode(int k,Node ori){
		Node head = ori;
		while(true){
			k = k-1;
			head = head.getNext();
			if(head == null){
				break;
			}
		}
		if(k == 0){
			return ori.getNext();
		}else if(k<0){
			Node head2 = ori;
			while(true){
				k = k+1;
				if(k == 0){
					head2.setNext(head2.getNext().getNext());
					return ori;
				}
				head2 = head2.getNext();
				if(head2 == null){
					break;
				}
			}
		}
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
		
		Node node = delKNode(1, n7);
		
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
