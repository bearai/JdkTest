package algorithm;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月26日   下午10:13:44
 * @version 1.0
 **/
public class Node {
	
	private Integer value;
	
	private Node next;
	
	public Node(Node next,Integer value) {
		this.value = value;
		this.next = next;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
	public static void printNode(Node ori){
		if(ori == null){
			System.out.println("empty linked table");
		}
		while(true){
			System.out.print(ori.getValue()+",");
			ori = ori.getNext();
			if(ori == null){
				break;
			}
		}
		System.out.println();
	}
	
	public static void printRoundNode(Node ori){
		if(ori == null){
			System.out.println("empty linked table");
		}
		if(ori.getNext() == null){
			System.out.println(ori.getValue());
			return;
		}
		Node pre = ori;
		Node cur = ori.getNext();
		System.out.print(pre.getValue()+",");
		while(cur != ori){
			System.out.print(cur.getValue()+",");
			pre = cur;
			cur = cur.getNext();
		}
		System.out.println();
	}
}
