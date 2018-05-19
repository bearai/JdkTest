package algorithm;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月2日   下午10:22:47
 * @version 1.0
 **/
public class RemoveSpecialNode {
	
	private static void removeSpeical(Node removeNode){
		if(removeNode == null){
			return;
		}
		if(removeNode.getNext() == null){
			throw new IllegalArgumentException("cannot remove the tail node");
		}
		removeNode.setValue(removeNode.getNext().getValue());
		removeNode.setNext(removeNode.getNext().getNext());
	}
	
	
	
	public static void main(String[] args) {
		Node n1 = new Node(null, 9);
		Node n2 = new Node(n1, 99);
		Node n3 = new Node(n2, 48);
		Node n4 = new Node(n3, 33);
		Node n5 = new Node(n4, 211);
		Node n6 = new Node(n5, 2);
		Node n7 = new Node(n6, 11);
		
		Node.printNode(n7);
		
		removeSpeical(n2);
		
		Node.printNode(n7);
	}
	
}
