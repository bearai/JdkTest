package algorithm;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月2日   下午10:22:47
 * @version 1.0
 **/
public class ReCompositeNode {
	
	private static Node recomposite(Node ori){
		if(ori == null || ori.getNext() == null){
			return ori;
		}
		Node secondBegin = ori.getNext();
		int secondBeginIndex = 2;
		Node cur = ori.getNext();
		int ttnum = 2;
		while(cur != null){
			int index = getBeginIndex(ttnum);
			if(index != secondBeginIndex){
				secondBeginIndex = index;
				secondBegin = secondBegin.getNext();
			}
			ttnum++;
			cur = cur.getNext();
		}
//		System.out.println(secondBegin.getValue()+"-"+secondBeginIndex);
		return recomposite(ori,secondBegin);
//		return null;
	}
	
	private static Node recomposite(Node ori,Node secondBegin){
		Node cur1 = ori;
		Node cur2 = secondBegin;
		Node head = null;
		Node newCur = null;
		while(cur1 != secondBegin){
			// 要改变当前循环节点的下一个，又要保持原有循环，因此需要新的变量保存当前指向，然后循环变量指向下一个
			// 改变的时候，使用新的变量
			Node node1 = cur1;
			Node node2 = cur2;
			cur1 = cur1.getNext();
			cur2 = cur2.getNext();
			// 新节点慢慢延伸的时候，因为头节点head是要返回的，因此不能使用头节点来操作，使用一个专门指向新链表最后一个节点的变量是合适的
			if(head == null){
				head = node1;
				head.setNext(node2);
			}else{
				newCur.setNext(node1);
				node1.setNext(node2);
			}
			newCur = node2;
		}
		if(cur2 != null){
			newCur.setNext(cur2);
		}
		return head;
	}
	
	private static int getBeginIndex(int ttnum){
		int halfCeil = ttnum%2==0?ttnum/2:ttnum/2+1;
		return ttnum-(halfCeil-1);
	}
	
	public static void main(String[] args) {
		Node n0 = new Node(null, 777);
		Node n1 = new Node(n0, 98);
		Node n2 = new Node(n1, 79);
		Node n3 = new Node(n2, 48);
		Node n4 = new Node(n3, 33);
		Node n5 = new Node(n4, 11);
		Node n6 = new Node(n5, 28);
		Node n7 = new Node(n6, 19);
		
		Node.printNode(n7);
		
		Node node = recomposite(n7);
		
		Node.printNode(node);
	}
	
}
