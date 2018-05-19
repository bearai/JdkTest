package algorithm.matrix;
/**
 * 将一个NxN的矩阵旋转90度
 *
 * @author 艾亮方
 * @date 2018年5月13日   下午10:18:19
 * @version 1.0
 **/
public class RotateNinety {

	
	public static void rotate(int[][] ori){
		int num = ori.length;
		for(int i=0;i< num>>1;i++){
			subRotate(ori,i,i,num-i-1,num-i-1);
		}
	}
	
	private static void subRotate(int[][] ori,int lr,int lc,int rr,int rc){
		// 外部需要进行rb-lb次交换
		for(int i=lc;i<rc;i++){
			int num = rc-i+lc;
			// 四个元素进行三次两两交换A->B,A->C,A->D
			exchange(ori, lr, i, i, rc);
			exchange(ori, lr, i, rc, num);
			exchange(ori, lr, i, num, lr);
		}
	}
	private static void exchange(int[][] ori,int ar,int ac,int br,int bc){
		int temp = ori[ar][ac];
		ori[ar][ac]=ori[br][bc];
		ori[br][bc] = temp;
	}
	
	public static void main(String[] args) {
//		int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] arr = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		MatrixCommon.print(arr);
		rotate(arr);
		MatrixCommon.print(arr);
	}
}
