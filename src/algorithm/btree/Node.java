package algorithm.btree;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月7日   下午10:56:07
 * @version 1.0
 **/
public class Node {

	public int value;
	public Node left;
	public Node right;
	
	public Node(int value, Node left, Node right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public Node(){
		
	}

	public Node(int value) {
		super();
		this.value = value;
	}
	
	
	
}
