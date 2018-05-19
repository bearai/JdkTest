package algorithm.btree;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月12日   下午10:30:34
 * @version 1.0
 **/
public class CheckBST {
	
	public static boolean checkBstByArr(int[] arr){
		if(arr == null || arr.length==1){
			return true;
		}
		return checkBst(arr,0,arr.length-1);
	}
	
	private static boolean checkBst(int[] arr,int begin,int end){
		if(begin == end) return true;
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
		if(leftend == -1 || rightbegin == end){
			return checkBst(arr, begin, end-1);
		}
		if(leftend != rightbegin-1){
			return false;
		}
		return checkBst(arr, begin, leftend) && checkBst(arr, rightbegin, end-1);
	}
	
	public static void main(String[] args) {
		boolean result = checkBstByArr(new int[]{65,77,70,83,88,85,80,92,91,90,105,112,120,115,110,100});
		if(result){
			System.out.println("is a bst");
		}else {
			System.out.println("not a bst");
		}
	}
	
}
