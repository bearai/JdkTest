package algorithm.btree;

import com.sun.swing.internal.plaf.basic.resources.basic_es;

/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月12日   下午10:30:34
 * @version 1.0
 **/
public class RecoverBST {
	
	public static Node recover(int[] arr){
		if(arr == null){
			return null;
		}
		if(arr.length == 1){
			return new Node(arr[0]);
		}
		return recoverByArr(arr,0,arr.length-1);
	}
	
	private static Node recoverByArr(int[] arr,int begin,int end){
		if(begin == end){
			return new Node(arr[end]);
		}
		int leftend = -1;
		int rightbegin = end;
		for(int i=begin;i<end;i++){
			if(arr[i] < arr[end]){
				leftend = i;
			}else{
				if(rightbegin == end){
					rightbegin = i;
				}
			}
		}
		Node node = new Node(arr[end]);
		// leftend == -1 表示只有右子树
		// rightbegin==end 表示只有左子树
		if(rightbegin != end){
			node.right = recoverByArr(arr, leftend == -1?begin:rightbegin, end-1);
		}
		if(leftend != -1){
			node.left = recoverByArr(arr, begin, rightbegin == end?end-1:leftend);
		}
		return node;
	}
	
	public static void main(String[] args) {
		Node result = recover(new int[]{65,77,70,83,88,85,80,92,91,90,105,112,120,115,110,100});
		TraverseBtree.backTraverseRecursion(result);
	}
	
}
