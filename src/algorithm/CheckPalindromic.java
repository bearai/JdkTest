package algorithm;
/**
 * 判断一个数是否为回文数
 *
 * @author 艾亮方
 * @date 2018年6月10日   下午11:54:14
 * @version 1.0
 **/
public class CheckPalindromic {
	
	public static boolean check(int num){
		if(num==Integer.MIN_VALUE) return false;
		if(Math.abs(num)<10) return true;
		num = Math.abs(num);
		int len = (num+"").length();
		int help = (int)Math.pow(10, len-1);
		int times = len >> 1;
		while(times>0){
			if(num/help != num%10){
				return false;
			}
			num = (num%help)/10;
			help = help/100;
			times--;
		}
		return true;
	}
	
	public static boolean check2(int num){
		if(num == Integer.MIN_VALUE) return false;
		char[] arr = (Math.abs(num)+"").toCharArray();
		int compareTimes = arr.length >> 1;
		int ind = arr.length-1;
		for(int i=0; i<compareTimes;i++){
			if(arr[i] != arr[ind]){
				return false;
			}
			ind -- ;
		}
		return true;
	}

	public static void main(String[] args) {
		boolean isPalindromic = check2(19891);
		if(isPalindromic){
			System.out.println("is a palindromic");
		}else{
			System.out.println("not palindromic");
		}
	}
}
