package algorithm.string;
/**
 * 判断两个字符串是否互为旋转词
 *
 * @author 艾亮方
 * @date 2018年4月20日   下午10:14:10
 * @version 1.0
 **/
public class CheckRotate {

	public static boolean checkRotate(String ori,String str){
		if(ori == null && str == null) return true;
		if(ori == null || str == null) return false;
		if(ori.length() != str.length()) return false;
		char[] oriarr = ori.toCharArray();
		char[] strarr = str.toCharArray();
		int begin = -1;
		for(int i=0;i<strarr.length;i++){
			if(i == 0){
				for(int j=0;j<oriarr.length;j++){
					if(oriarr[j] == strarr[i]){
						begin = j;
						break;
					}
				}
				if(begin == -1){
					return false;
				}
				begin = begin == oriarr.length-1?0:++begin;
			}else {
				if(strarr[i] == oriarr[begin]){
					begin = begin == oriarr.length-1?0:++begin;
				}else {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String ori = "e";
		String str = "e";
		if(checkRotate(ori, str)){
			System.out.println("is rotate");
		}else {
			System.out.println("not rotate");
		}
	}
}
