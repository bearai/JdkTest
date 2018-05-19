package algorithm.string;

import com.sun.security.ntlm.Client;

/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月17日   下午11:39:22
 * @version 1.0
 **/
public class SumNums {

	public static int sum(String str){
		if(str == null || str.trim().length() == 0){
			return -1;
		}
		char[] clst = str.toCharArray();
		// - = 45 0=48 9=57
		int sum = 0;
		int begin = 0;
		int end = 0;
		int nums = -1;
		boolean numseiral = false;
		for(int i=0;i<clst.length;i++){
			char c = clst[i];
			if(isNum(c)){
				if(!numseiral){
					begin = i;
				}
				end = i;
				numseiral = true;
				if(i == clst.length-1 || !isNum(clst[i+1])){
					sum += getnum(nums,begin,end,str);
					begin = 0;
					end = 0;
					nums = -1;
					numseiral = false;
				}
			}else if(c == 45 && i!=clst.length-1){
				if(clst[i+1] == 45 || isNum(clst[i+1])){
					nums = nums==-1?1:nums+1;
				}
			}
		}
		return sum;
	}
	
	private static boolean isNum(char c){
		return c<=57 && c>=48;
	}
	
	private static int getnum(int nums,int begin,int end,String str){
		Integer num = Integer.parseInt(str.substring(begin,end+1));
		if(nums>0 && nums%2 != 0){
			num = 0-num;
		}
		return num;
	}
	
	public static void main(String[] args) {
//		if(isNum('0')){
//			System.out.println("yes");
//		}else {
//			System.out.println("no");
//		}
//		if('-' == 45){
//			System.out.println("goods");
//		}
//		String str = "12abcd---30d2";
		String str = "22acded30-d12a-50--";
		int sum = sum(str);
		System.out.println("sum of str='"+str+"' is="+sum);
	}
}
