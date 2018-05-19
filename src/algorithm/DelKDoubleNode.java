package algorithm;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月26日   下午11:13:10
 * @version 1.0
 **/
public class DelKDoubleNode {
	
	public static DoubleNode delKNode(int k,DoubleNode ori){
		DoubleNode head = ori;
		while(head != null){
			k-- ;
			head = head.getNext();
		}
		if(k == 0){
			ori = ori.getNext();
			ori.setPre(null);
			return ori;
		}else if(k<0){
			DoubleNode head2 = ori;
			while(++k != 0){
				head2 = head2.getNext();
			}
			head2.setNext(head2.getNext().getNext());
			if(head2.getNext() != null){
				head2.getNext().setPre(head2);
			}
		}
		return ori;
	}
	
	public static void main(String[] args) {
		DoubleNode n1 = new DoubleNode(null, 100);
		DoubleNode n2 = new DoubleNode(n1, 99);
		DoubleNode n3 = new DoubleNode(n2, 48);
		DoubleNode n4 = new DoubleNode(n3, 33);
		DoubleNode n5 = new DoubleNode(n4, 20);
		DoubleNode n6 = new DoubleNode(n5, 20);
		DoubleNode n7 = new DoubleNode(n6, 1);
		
		n7.setPre(null);
		n6.setPre(n7);
		n5.setPre(n6);
		n4.setPre(n5);
		n3.setPre(n4);
		n2.setPre(n3);
		n1.setPre(n2);
		
		printNode(n7);
		
		DoubleNode node = delKNode(2, n7);
		
		printNode(node);
	}
	
	private static void printNode(DoubleNode ori){
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
