package algorithm.string;

/**
 * 保持单词字母不变，翻转字符串
 * 保持指定长度的字符串顺序不变，翻转字符串
 *
 * @author 艾亮方
 * @date 2018年4月25日   上午12:08:50
 * @version 1.0
 **/
public class RotateString {
	
	private static void rotate(char[] arr,int begin,int end){
		if(begin == end){
			return;
		}
		for(int i=begin;end>i;i++){
			char temp = arr[i];
			arr[i] = arr[end];
			arr[end] = temp;
			end --;
		}
	}
	
	public static String rotateString(String ori){
		if(ori == null || ori.length()<=1){
			return ori;
		}
		char[] arr = ori.toCharArray();
		rotate(arr, 0, ori.length()-1);
		int begin = -1;
		int end = -1;
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=' '){
				if(begin == -1){
					begin = i;
				}
				if(i==arr.length-1 || arr[i+1]==' '){
					end = i;
					rotate(arr, begin, end);
					begin = -1;
					end = -1;
				}
			}
			
		}
		return String.valueOf(arr);
	}
	
	public static String reverseStringByLength(String ori,int len){
		if(ori == null || ori.length()==0 || len <=0){
			return ori;
		}
		char[] arr = ori.toCharArray();
		rotate(arr, 0, len-1);
		rotate(arr, len, arr.length-1);
		rotate(arr, 0, arr.length-1);
		return String.valueOf(arr);
	}
	
	public static String reverseStringByLength2(String ori,int len){
		if(ori == null || ori.length()==0 || len <=0){
			return ori;
		}
		char[] arr = ori.toCharArray();
		int leftlen = ori.length()-len;
		rotate(arr, 0, arr.length-1);
		rotate(arr, 0, leftlen-1);
		rotate(arr, leftlen, arr.length-1);
		return String.valueOf(arr);
	}
	
	public static void main(String[] args) {
		String str = " myname is ai'lf k";
//		char[] arr = str.toCharArray();
//		rotate(arr, 1, 6);
		System.out.println(rotateString(str));
		
		String str2 = "ABCedfg";
		System.out.println(reverseStringByLength(str2, 3));
		System.out.println(reverseStringByLength2(str2, 3));
	}
	
}
