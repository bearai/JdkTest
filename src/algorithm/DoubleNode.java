package algorithm;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年3月26日   下午10:13:44
 * @version 1.0
 **/
public class DoubleNode {
	
	private Integer value;
	
	private DoubleNode next;
	
	private DoubleNode pre;
	
	public DoubleNode(DoubleNode next,Integer value) {
		this.value = value;
		this.next = next;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public DoubleNode getNext() {
		return next;
	}

	public void setNext(DoubleNode next) {
		this.next = next;
	}

	public DoubleNode getPre() {
		return pre;
	}

	public void setPre(DoubleNode pre) {
		this.pre = pre;
	}
	
	
	
}
