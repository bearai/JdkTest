package algorithm;


/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月26日   下午11:13:10
 * @version 1.0
 **/
public class ReverseDoubleNode {
	
	public static DoubleNode reverse(DoubleNode ori){
		DoubleNode pre = null;
		DoubleNode next = null;
		while(ori != null){
			next = ori.getNext();
			ori.setNext(pre);
			ori.setPre(next);
			pre = ori;
			ori = next;
		}
		return pre;
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
		
		DoubleNode node = reverse(n7);
		
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
