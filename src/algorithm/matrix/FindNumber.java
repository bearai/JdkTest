package algorithm.matrix;


/**
 * 在已经排好序的矩阵中查找数
 *
 * @author 艾亮方
 * @date 2018年5月19日   下午2:21:05
 * @version 1.0
 **/
public class FindNumber {

	public static int[] find(int[][] arr,int num){
		if(arr == null){
			return null;
		}
		int maxj = arr[0].length-1;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<=maxj;j++){
				if(arr[i][j]==num){
					return new int[]{i,j};
				}else if (arr[i][j]>num) {
					maxj = j;
				}
			}
		}
		return null;
	}
	
	public static int[] find2(int[][] arr,int num){
		if(arr == null){
			return null;
		}
		int row = arr.length-1;
		int col = 0;
		while(row>=0 && col<arr[0].length){
			if(arr[row][col] == num){
				return new int[]{row,col};
			}else if(arr[row][col] > num){
				row--;
			}else {
				col++;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		MatrixCommon.print(arr);
		int[] ind = find2(arr, 8);
		if(ind == null){
			System.out.println("num not exist in matrix");
		}else{
			System.out.println("row="+(ind[0]+1)+" col="+(ind[1]+1));
		}
	}
	
}
