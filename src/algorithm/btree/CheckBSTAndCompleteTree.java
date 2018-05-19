package algorithm.btree;

import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.NodeList;

/**
 * 检测一个节点是否为搜索二叉树和完全二叉树
 *
 * @author 艾亮方
 * @date 2018年4月12日   下午10:30:34
 * @version 1.0
 **/
public class CheckBSTAndCompleteTree {
	
	public static boolean checkCbt(Node node){
		if(node == null){
			return true;
		}
		Queue<Node> queue = new LinkedList<>();
		boolean leaf = false;
		queue.offer(node);
		while(!queue.isEmpty()){
			Node head = queue.poll();
			Node left = head.left;
			Node right = head.right;
			
			if((leaf && (left!=null || right != null)) || (left==null && right!=null)){
				return false;
			}
			if(left != null){
				queue.offer(left);
			}
			if(right != null){
				queue.offer(right);
			}else{
				leaf = true;
			}
		}
		return true;
	}

	public static boolean checkBst(Node node){
		if(node == null){
			return true;
		}
		Integer max = checkAndGetMax(node);
		return (max != null && max.compareTo(node.value)>=0)?true:false;
	}
	
	public static Integer checkAndGetMax(Node node){
		Integer val = node.value;
		if(node.left != null){
			Integer leftMax = checkAndGetMax(node.left);
			if(leftMax == null || leftMax < node.left.value || leftMax >= val){
				return null;
			}
		}
		if(node.right != null){
			Integer rightMax = checkAndGetMax(node.right);
			if(rightMax == null || rightMax < node.right.value || rightMax <= val){
				return null;
			}
			return rightMax;
		}
		return val;
	}
	
//	private static boolean checkThreeNums(Integer left,Integer root,Integer right){
//		return (left == null || left.compareTo(root)<0) && (right == null || right.compareTo(root)>0);
//	}
	
	public static void main(String[] args) {
//		Node result = RecoverBST.recover(new int[]{65,77,70,83,88,85,80,92,91,90,105,112,120,115,110,100});
		//is bst & not cbt
//		String nodestr = "100!90!80!70!60!#!#!75!#!#!85!#!#!98!95!93!#!#!97!#!#!99!#!#!150!145!#!#!155!152!#!#!160!#!#!";
		//bst & cbt
//		String nodestr = "100!90!80!70!#!#!85!#!#!95!92!#!#!#!110!108!#!#!115!#!#!";
		//not bst & not cbt
//		String nodestr = "1!2!4!8!#!#!#!5!9!#!#!#!3!6!#!#!7!#!#!";
		String nodestr = "1!2!4!8!#!#!#!5!9!#!#!10!#!#!3!6!#!#!7!#!#!";
		
		Node result = SerializeBtree.deserialize(nodestr);
		if(checkBst(result)){
			System.out.println("is bst");
		}else{
			System.out.println("not bst");
		}
//		TraverseBtree.backTraverseRecursion(result);
		
		if(checkCbt(result)){
			System.out.println("is cbt");
		}else {
			System.out.println("not cbt");
		}
	}
	
}
