package algorithm.matrix;

import org.apache.commons.lang3.StringUtils;

/**
 * 通用的操作矩阵的类
 *
 * @author 艾亮方
 * @date 2018年5月13日   下午10:11:11
 * @version 1.0
 **/
public class MatrixCommon {

	
	public static void print(int[][] matrix){
		if(matrix == null){
			System.out.println("empty matrix");
		}
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				System.out.print(StringUtils.rightPad(String.valueOf(matrix[i][j]), 5));
			}
			System.out.println();
		}
		System.out.println();
	}
}
