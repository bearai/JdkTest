package algorithm.matrix;
/**
 * 按照之字型打印矩阵 
 *
 * @author 艾亮方
 * @date 2018年5月14日   下午11:17:18
 * @version 1.0
 **/
public class Zprint {

	
	public static void zprint(int[][] arr){
		if(arr == null){
			System.out.println("empty matrix");
		}
		boolean up = true;
		int br = 0;
		int bc = 0;
		int maxrow = arr.length-1;
		int maxcol = arr[0].length-1;
		while(br<=maxrow && bc<=maxcol && br>=0 && bc>=0){
			int[] last = null;
			if(up){
				last = printUpGetLast(arr, br, bc, maxrow, maxcol);
			}else {
				last = printDownGetLast(arr, br, bc, maxrow, maxcol);
			}
			int[] nxnode = getNextBeginNode(arr, up, last[0], last[1], maxrow, maxcol);
			br = nxnode[0];
			bc = nxnode[1];
			up = !up;
		}
		
	}
	
	private static int[] getNextBeginNode(int[][] arr, boolean flag,int lastr,int lastc, int maxr,int maxc){
		// flag为true的时候，表示上一次为向上
		if(flag){
			// 转为向下时，优先向右找第一个节点
			if(lastc+1 <= maxc){
				return new int[]{lastr,lastc+1};
			}else {
				return new int[]{lastr+1,lastc};
			}
		}
		// 转为向上时，优先向下找第一个节点
		if(lastr+1 <= maxr){
			return new int[]{lastr+1,lastc};
		}else {
			return new int[]{lastr,lastc+1};
		}
	}
	
	private static int[] printUpGetLast(int[][] arr,int br,int bc,int maxr,int maxc){
		int r = br;
		int c = bc;
		while(r<=maxr && r>=0 && c<=maxc && c>=0){
			System.out.print(arr[r][c]+" ");
			r -= 1;
			c += 1;
		}
		return new int[]{r+1,c-1};
	}
	
	private static int[] printDownGetLast(int[][] arr,int br,int bc,int maxr,int maxc){
		int r = br;
		int c = bc;
		while(r<=maxr && r>=0 && c<=maxc && c>=0){
			System.out.print(arr[r][c]+" ");
			r += 1;
			c -= 1;
		}
		return new int[]{r-1,c+1};
	}
	
	public static void main(String[] args) {
//		int[][] arr = new int[][]{{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24}};
//		int[][] arr = new int[][]{{1,2,3},{7,8,9},{13,14,15}};
//		int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
		int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		MatrixCommon.print(arr);
		System.out.println();
		zprint(arr);
	}
}
