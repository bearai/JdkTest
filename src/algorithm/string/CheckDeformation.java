package algorithm.string;
/**
 * 检查两个字符串是否互为变形词
 *
 * @author 艾亮方
 * @date 2018年4月16日   下午11:22:26
 * @version 1.0
 **/
public class CheckDeformation {

	public static boolean check(String str1,String str2){
		if(str1 == null || str2 == null || str1.length() != str2.length()){
			return false;
		}
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		int[] nums = new int[256];
		for(int i=0;i<arr1.length;i++){
			nums[arr1[i]]++;
		}
		for(int i=0;i<arr2.length;i++){
			if(nums[arr2[i]]-- < 0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str1 = "adfsafsaf";
		String str2 = "adfsafsaf(";
		if(check(str1, str2)){
			System.out.println("is deformation");
		}else {
			System.out.println("not deformation");
		}
	}
}
