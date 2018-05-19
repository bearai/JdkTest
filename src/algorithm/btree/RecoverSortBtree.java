package algorithm.btree;
/**
 * 根据有序数组恢复成平衡搜索二叉树
 *
 * @author 艾亮方
 * @date 2018年4月13日   下午10:46:30
 * @version 1.0
 **/
public class RecoverSortBtree {
	
	public static Node recover(int arr[]){
		if(arr.length == 0){
			return null;
		}
		return recoverByArr(arr,0,arr.length-1);
	}
	
	public static Node recoverByArr(int arr[],int start,int end){
		if(start > end){
			return null;
		}
		int mid = (start+end)/2;
		Node node = new Node(arr[mid]);
		node.left = recoverByArr(arr, start, mid-1);
		node.right = recoverByArr(arr, mid+1, end);
		return node;
	}
	
	public static void main(String[] args) {
//		int[] arr = new int[]{60,70,80,85,100,110,120,130,150};
		int[] arr = new int[]{61,62,63,64,65,66,67,68,69};
		Node head = recover(arr);
		System.out.println(SerializeBtree.serialize(head));
		TraverseBtree.midTraverseNoCursion(head);
	}
}
