package algorithm.btree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月7日   下午11:36:22
 * @version 1.0
 **/
public class SerializeBtree {

	public static String serialize(Node head){
		if(head == null){
			return "#!";
		}
		String str = head.value+"!";
		str += serialize(head.left);
		str += serialize(head.right);
		
		return str;
	}
	
	public static Node deserialize(String str){
		String[] values = str.split("!");
		Queue<String> tempQueue = new LinkedList<>();
		for(int i=0;i<values.length;i++){
			tempQueue.offer(values[i]);
		}
		return getNodeFromQueue(tempQueue);
	}
	
	private static Node getNodeFromQueue(Queue<String> queue){
		String val = queue.poll();
		if(val.equals("#")){
			return null;
		}
		
		Node nd = new Node(Integer.parseInt(val));
		nd.left = getNodeFromQueue(queue);
		nd.right = getNodeFromQueue(queue);
		return nd;
	}
	
	private static Node getNodeByVal(String val){
		if(val.equals("#")){
			return null;
		}
		
		return new Node(Integer.parseInt(val));
	}
	
	public static void main(String[] args) {
		Node head = new Node(10);
		Node n1 = new Node(100);
		Node left1 = new Node(8,null,n1);
		head.left = left1;
		String str = serialize(head);
		System.out.println(str);
		deserialize(str);
	}
	
}
