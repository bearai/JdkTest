package algorithm.order;

import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.portable.Streamable;

/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月29日   下午9:19:53
 * @version 1.0
 **/
public class BitOperate {

	
	public static void main(String[] args) {
		int num = 10;
		int num2 = -10;
		printIntegerBinaryString(num2);
		for(int i=0;i<4;i++){
//			num = num<<1;
//			System.out.println("num"+i+"="+num);
			num2 = num2 <<1;
//			printIntegerBinaryString2(num2);
			printIntegerBinaryString(num2);
//			print3(num2);
			System.out.println("num2"+i+"="+num2);
		}
//		printIntegerBinaryString(num);
//		printIntegerBinaryString(num2);
	}
	
	public static void printIntegerBinaryString2(int num){
		System.out.println(Integer.toBinaryString(num));
	}
	
	public static void print3(int num){
		System.out.println(StringUtils.leftPad(Integer.toBinaryString(num), 32, "0"));
	}
	
	public static void printIntegerBinaryString(int num){
		String format = StringUtils.leftPad(Integer.toBinaryString(num), 32, "0");
		StringBuilder str = new StringBuilder(format);
		for(int i=28;i>0 && i%4==0;i-=4){
			str.insert(i, ",");
		}
		System.out.println(str.toString());
		
	}
}
