package algorithm.matrix;

import org.apache.commons.lang3.StringUtils;

/**
 * 转圈打印矩阵
 *
 * @author 艾亮方
 * @date 2018年4月29日   下午10:37:50
 * @version 1.0
 **/
public class LoopPrint {
	
	public static void main(String[] args) {
		int[][] arr = new int[][]{{1,2,3,4},{2,31,41,5},{6,7,8,9},{10,11,12,13}};
//		int[][] arr = new int[][]{{1,2,3,4}};
//		int[][] arr = new int[][]{{1},{2},{6},{10}};
//		int[][] arr = new int[][]{{1,2,3,4,100},{2,31,41,5,500},{6,7,8,9,92},{10,11,12,13,22}};
//		int[][] arr = new int[][]{{1,2,3,4,100},{2,31,41,5,500},{6,7,8,9,92},{10,11,12,13,22},{14,24,34,44,104},{15,25,35,45,105}};
		printMatrix(arr);
		MatrixCommon.print(arr);
		System.out.println();
		loopPrint(arr);
		System.out.println();
		loopPrint2(arr);
	}
	
	public static void printMatrix(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0; j<arr[i].length;j++){
				System.out.print(StringUtils.rightPad(String.valueOf(arr[i][j]), 5));
			}
			System.out.println("");
		}
	}
	
	public static void loopPrint2(int[][] arr){
		int lr = 0;
		int lc = 0;
		int rr = arr.length-1;
		int rc = arr[0].length-1;
		while(lr <= rr && lc <= rc){
			printSubLoopByIndex(arr,lr++,lc++,rr--,rc--);
		}
	}
	
	private static void printSubLoopByIndex(int[][] arr,int lr,int lc,int rr, int rc){
		// 只有一行
		if(lr == rr){
			for(int j=lc;j<=rc;j++){
				System.out.print(arr[lr][j]+" ");
			}
		}else if (lc == rc) {
			for(int i=lr;i<=rr;i++){
				System.out.print(arr[i][lc]+" ");
			}
		}else {
			for(int j=lc;j<rc;j++){
				System.out.print(arr[lr][j]+" ");
			}
			for(int i=lr;i<rr;i++){
				System.out.print(arr[i][rc]+" ");
			}
			for(int j=rc;j>lc;j--){
				System.out.print(arr[rr][j]+" ");
			}
			for(int i=rr;i>lr;i--){
				System.out.print(arr[i][lc]+" ");
			}
		}
	}
	
	public static void loopPrint(int[][] arr){
		if(arr == null){
			System.out.println("arr empty");
			return;
		}
		int rowmax = arr.length-1;
		int colmax = arr[0].length-1;
		int downOptTimes = 0; //向下操作的次数
		int leftOptTimes = 0; // 向左操作的次数
		int upOptTimes = 0; // 向上操作的次数
		int rightOptTimes = 0; //向右操作的次数
		int row = 0;
		int col = -1;
		int loopindex = 0;  //0=向右，1=向下，2=向左，3=向上
		while(true){
			if(loopindex == 0){
				//向右打印
				int maxright = colmax-downOptTimes;
				if(col == maxright){
					break;
				}
				for(int j=col+1;j<=maxright;j++){
					System.out.print(arr[row][j]+" ");
					col = j;
				}
				rightOptTimes++;
			}else if(loopindex == 1){
				// 向下打印
				int maxdown = rowmax - leftOptTimes;
				if(row == maxdown){
					break;
				}
				for(int i=row+1;i<=maxdown;i++){
					System.out.print(arr[i][col]+" ");
					row = i;
				}
				downOptTimes++;
			}else if(loopindex == 2){
				// 向左打印
				if(col == upOptTimes){
					break;
				}
				for(int j=col-1;j>=upOptTimes;j--){
					System.out.print(arr[row][j]+" ");
					col = j;
				}
				leftOptTimes++;
			}else{
				// 向上打印
				if(row == rightOptTimes){
					break;
				}
				for(int i=row-1;i>=rightOptTimes;i--){
					System.out.print(arr[i][col]+" ");
					row = i;
				}
				upOptTimes++;
			}
			loopindex++;
			if(loopindex>3){
				loopindex = 0;
			}
		}
	}
	
	
	
}
