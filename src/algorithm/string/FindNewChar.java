package algorithm.string;
/**
 * 根据字符串和位置k，找到k位置对应的新型字符串
 *
 * @author 艾亮方
 * @date 2018年4月25日   下午10:24:45
 * @version 1.0
 **/
public class FindNewChar {

	
	public static String find(String ori,int k){
		if(ori == null) return ori;
		if(k<0 || k>ori.length()-1){
			return null;
		}
		int nums = 0;
		char[] arr = ori.toCharArray();
		for(int i=k-1;i>=0;i--){
			if(isUpper(arr[i])){
				nums++;
			}else {
				break;
			}
		}
		if(nums%2 !=0){
			return ori.substring(k-1, k+1);
		}else if(!isUpper(arr[k])){
			return ori.substring(k, k+1);
		}else if(k != arr.length-1){
			return ori.substring(k, k+2);
		}
		return null;
	}
	
	private static boolean isUpper(char c){
		return (int)c>=65 && (int)c<=90;
	}
	
	public static void main(String[] args) {
		String ori = "afAEKKGfdaDefHHE";
		String special = find(ori, 3);
		if(special == null){
			System.out.println("not find");
		}else {
			System.out.println(special);
		}
	}
}
