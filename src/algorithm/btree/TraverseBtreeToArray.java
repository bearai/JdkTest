package algorithm.btree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 遍历一棵二叉树，生成一个数组
 *
 * @author 艾亮方
 * @date 2018年4月12日   下午12:56:05
 * @version 1.0
 **/
public class TraverseBtreeToArray {
	
	public static void backTraverseRecursion(Node root){
		if(root.left != null){
			backTraverseRecursion(root.left);
		}
		if(root.right != null){
			backTraverseRecursion(root.right);
		}
		printNode(root);
	}
	
	public static void midTraverseNoCursion(Node root){
		Stack<Node> stack = new Stack<>();
		if(root == null){
			System.out.println("empty tree");
		}
		putNodeToStackForMid(stack, root);
		while(!stack.isEmpty()){
			Node node = stack.pop();
			if(node.left == null && node.right == null){
				printNode(node);
			}else{
				putNodeToStackForMid(stack, node);
			}
		}
	}
	
	public static void backTraverseNoCursion(Node root){
		Stack<Node> stack = new Stack<>();
		if(root == null){
			System.out.println("empty tree");
		}
		putNodeToStack(stack, root);
		while(!stack.isEmpty()){
			Node node = stack.pop();
			if(node.left == null && node.right == null){
				printNode(node);
			}else{
				putNodeToStack(stack, node);
			}
		}
	}
	
	private static void putNodeToStackForMid(Stack<Node> stack,Node root){
		if(root == null){
			System.out.println("empty tree");
		}
		Node cur = root;
		while(cur != null){
			if(cur.right != null){
				stack.push(cur.right);
			}
			stack.push(cur);
			Node node = cur.left;
			cur.left = null;
			cur.right = null;
			cur = node;
		}
	}
	
	private static void putNodeToStack(Stack<Node> stack,Node root){
		if(root == null){
			System.out.println("empty tree");
		}
		Node cur = root;
		while(cur != null){
			stack.push(cur);
			if(cur.right != null){
				stack.push(cur.right);
			}
			Node node = cur.left;
			cur.left = null;
			cur.right = null;
			cur = node;
		}
	}
	
	public static void midTraverseRecursion(Node root){
		if(root.left != null){
			midTraverseRecursion(root.left);
		}
		printNode(root);
		if(root.right != null){
			midTraverseRecursion(root.right);
		}
	}
	
	public static void levelTraverse(Node root){
		if(root == null){
			System.out.println("empty tree");
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			Node node = queue.poll();
			System.out.println(node.value);
			if(node.left != null){
				queue.offer(node.left);
			}
			if(node.right != null){
				queue.offer(node.right);
			}
		}
	}
	
	public static void frontTraverseNoRecursion(Node root){
		Stack<Node> stack = new Stack<>();
		if(root == null){
			System.out.println("empty btree");
		}
		Node begin = root;
		while(begin != null || !stack.isEmpty()){
			if(begin == null){
				begin = stack.pop();
			}
			printNode(begin);
			if(begin.right != null){
				stack.push(begin.right);
			}
			begin = begin.left;
		}
		
	}
	
	private static void printNode(Node node){
		if(node != null){
			System.out.println(node.value);
		}
	}
	
	public static void main(String[] args) {
//		String nodeStr = "1!2!#!#!3!#!5!#!#!";
//		String nodeStr = "1!2!5!11!#!#!#!8!#!2!#!#!6!3!#!#!#!";
		String nodeStr = "100!90!80!70!65!#!#!77!#!#!85!83!#!#!88!#!#!91!#!92!#!#!110!105!#!#!115!112!#!#!120!#!#!";
		Node root = SerializeBtree.deserialize(nodeStr);
//		frontTraverseNoRecursion(root);
//		System.out.println("后序遍历");
//		backTraverseRecursion(root);
//		System.out.println("非递归的后序遍历");
//		backTraverseNoCursion(root);
//		System.out.println("中序遍历");
//		midTraverseRecursion(root);
//		System.out.println("非递归的中序遍历");
//		midTraverseNoCursion(root);
		System.out.println("层次遍历，广度优先");
		levelTraverse(root);
	}
}
