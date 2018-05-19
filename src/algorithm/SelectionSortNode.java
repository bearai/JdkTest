package algorithm;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月2日   下午10:22:47
 * @version 1.0
 **/
public class SelectionSortNode {
	
	private static Node selectionSort(Node ori){
		Node head = ori;
		Node max = null;
		Node maxPre = null;
		Node pre = null;
		while(head != null){
			if(max == null){
				max = head;
			}else if(max.getValue() < head.getValue()){
				max = head;
				maxPre = pre;
			}
			pre = head;
			head = head.getNext();
		}
		if(maxPre != null){
			maxPre.setNext(max.getNext());
			max.setNext(ori);
		}
		if(max.getNext() != null){
			max.setNext(selectionSort(max.getNext()));
		}
		return max;
	}
	
	private static Node selectionSort2(Node head){
		Node tail = null;
		Node cur = head;
		Node small = head;
		Node smallPre = null;
//		Node pre = null;
		while(cur != null){
			smallPre = getSmallPre(cur);
			if(smallPre != null){
				small = smallPre.getNext();
				smallPre.setNext(small.getNext());
			}else{
				small = cur;
			}
			
			cur = cur == small?cur.getNext():cur;
//			pre = cur == small?cur:pre;
			
			if(tail != null){
				tail.setNext(small);
			}else{
				//tail为空时，表明这是最小的节点，应该放在头部
				head = small;
			}
			tail = small;
		}
		return head;
	}
	
	private static Node getSmallPre(Node ori){
		Node head = ori;
		Node small = head;
		Node smallPre = null;
		Node pre = null;
		while(head != null){
			if(head.getValue()<small.getValue()){
				small = head;
				smallPre = pre;
			}
			pre = head;
			head = head.getNext();
		}
		return smallPre;
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
		
		Node node = selectionSort2(n7);
		
		Node.printNode(node);
	}
	
}
