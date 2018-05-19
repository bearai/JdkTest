package algorithm.string;
/**
 * 替换字符串中连续出现的指定字符串
 *
 * @author 艾亮方
 * @date 2018年4月21日   下午10:48:01
 * @version 1.0
 **/
public class ReplaceString {
	
	public static String replace(String origin,String source,String target){
		if(origin == null || origin.length() == 0){
			return origin;
		}
		char[] oriarr = origin.toCharArray();
		char[] sarr = source.toCharArray();
		int match = 0;
		for(int i=0;i<oriarr.length;i++){
			if(oriarr[i] == sarr[match++]){
				if(match == sarr.length){
					setZero(oriarr, i, sarr.length);
					match=0;
				}
			}else {
				if(oriarr[i] == sarr[0]){
					i--;
				}
				match = 0;
			}
		}
		String res = "";
		String cur = "";
		for(int i=0;i<oriarr.length;i++){
			if(oriarr[i] != 0){
				cur += String.valueOf(oriarr[i]);
			}else if(oriarr[i] == 0 && (i == 0 || oriarr[i-1]!=0)){
				res = res+cur+target;
				cur = "";
			}
		}
		if(cur!=""){
			res += cur;
		}
		return res;
	}
	
	private static void setZero(char[] arr,int end,int len){
		while(len-- != 0){
			arr[end--]=0;
		}
	}

	public static void main(String[] args) {
		String str = "123abcabc";
//		System.out.println(str.replace("abc", "x"));
		System.out.println(replace(str, "z", "x"));
	}
}
