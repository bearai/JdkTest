package algorithm;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月26日   下午11:13:10
 * @version 1.0
 **/
public class ReverseABNode {
	
	public static Node reverseABNode(int begin,int end,Node ori){
		if(begin <= 0 || end<=begin || ori==null || ori.getNext() == null){
			return ori;
		}
		Node head = ori;
		int k=0;
		Node preBegin = null;
		Node newEnd = null;
		Node pre = null;
		Node next = null;
		while(true){
			++k;
			if(k == begin){
				newEnd = head;
			}
			if(begin > 1 && k == begin -1){
				preBegin = head;
				head = head.getNext();
			}else if(k >= begin && k<= end-1){
				next = head.getNext();
				head.setNext(pre);
				pre = head;
				head = next;
			}else if(k == end){
				if(head == null){
					newEnd.setNext(null);
				}else{
					newEnd.setNext(head.getNext());
				}
				if(preBegin != null){
					preBegin.setNext(head);
				}
				head.setNext(pre);
				if(preBegin == null){
					return head;
				}
				break;
			}else{
				head = head.getNext();
			}
		}
		return ori;
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(null, 100);
		Node n2 = new Node(n1, 99);
		Node n3 = new Node(n2, 48);
		Node n4 = new Node(n3, 33);
		Node n5 = new Node(n4, 21);
		Node n6 = new Node(n5, 20);
		Node n7 = new Node(n6, 1);
		
		printNode(n7);
		
		Node node = reverseABNode(1,2,n7);
		
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
	
//	public class Node{
//		public int value;
//		public Node next;
//		
//		Node(Node next,int value){
//			this.next = next;
//			this.value = value;
//		}
//	}
	
}
