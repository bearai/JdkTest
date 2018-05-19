package algorithm.order;

import org.apache.commons.lang3.StringUtils;

/**
 * 归并排序
 *
 * @author 艾亮方
 * @date 2018年4月28日   上午12:44:17
 * @version 1.0
 **/
public class MergeOrder {
	
	
	public static void main(String[] args) {
//		System.out.println(10>>4);
		int a = 100;
		int b = 500;
		
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println("a="+a+" b="+b);
		
		int a1 = -15;
		int a2 = 15;
		System.out.println("a1>>2 = "+(a1>>2)+"  a2>>2 = "+(a2>>2));
		
//		printEven(10);
		int c = 15;
		int c2 = -100;
		System.out.println("reverse c="+reverse(c));
		System.out.println("reverse c2="+reverse(c2));
		
		exchange(15);
		findLostNum();
	}
	
	private static void findLostNum(){
		int[] numcompair = {1, 347, 6, 9, 13, 65, 889, 712, 889, 347, 1, 9, 65, 13, 712};
		int num = 0;
		for(int i=0;i<numcompair.length;i++){
			num ^= numcompair[i];
		}
		System.out.println("lost num="+num);
	}
	
	private static void exchange(int num){
		System.out.println(StringUtils.leftPad(Integer.toBinaryString(num), 16, '0'));
		int num2 = (num>>8) | (num<<8);
		System.out.println(StringUtils.leftPad(Integer.toBinaryString(num2), 16, '0'));
	}
	
	private static int reverse(int num){
		return ~num+1;
	}
	
	private static void printEven(int num){
		for(int i=1;i<=num;i++){
			if((i&1)==0){
				System.out.println(i);
			}
		}
	}
}
