package algorithm.string;
/**
 * 
 *
 * @author 艾亮方
 * @date 2018年4月23日   上午12:10:12
 * @version 1.0
 **/
public class StatisticString {

	public static String statistic(String ori){
		if(ori == null || ori.length() == 0){
			return ori;
		}
		char[] arr = ori.toCharArray();
		StringBuilder str = new StringBuilder();
		int num=0;
		for(int i=0;i<arr.length;i++){
			num++;
			if(i == arr.length-1 || arr[i] != arr[i+1]){
				str.append(arr[i]).append("_").append(num);
				num=0;
				if(i != arr.length-1){
					str.append("_");
				}
			}
		}
		return str.toString();
	}
	
	public static String statistic2(String ori){
		if(ori == null || ori.length() == 0){
			return ori;
		}
		if(ori.length()==1){
			return ori+"_1";
		}
		char[] arr = ori.toCharArray();
		StringBuilder str = new StringBuilder();
		int num=1;
		str.append(arr[0]).append("_");
		for(int i=1;i<arr.length;i++){
			if(arr[i] != arr[i-1]){
				str.append(num).append("_").append(arr[i]).append("_");
				num = 1;
			}else {
				num++;
			}
		}
		str.append(num);
		return str.toString();
	}
	
	public static char getCharByIndex(String statStr,int index){
		char[] arr = statStr.toCharArray();
		int sum = 0;
		int num = 0;
		char cur = 0;
		boolean stage = true;
		for(int i=0;i<arr.length;i++){
			if(arr[i] == '_'){
				stage = !stage;
			}else if(stage){
				sum += num;
				if(index<=sum){
					return cur;
				}
				cur = arr[i];
				num=0;
			}else{
				num = num*10 + Integer.parseInt(arr[i]+"");
//				if(i == arr.length-1 || arr[i+1] == '_'){
//					sum = sum+num;
//					if(index<=sum){
//						return cur;
//					}else {
//						num = 0;
//					}
//				}
			}
		}
		sum = sum+num;
		if(index<=sum){
			return cur;
		}
		return 0;
	}
	public static void main(String[] args) {
		String ori = "abcdefgaaaaakaku";
//		String ori = "uuuuu";
		System.out.println("statistic string = "+statistic(ori));
//		System.out.println("statistic string2 = "+statistic2(ori));
		String statistic = statistic(ori);
		int index = 6;
		char c = getCharByIndex(statistic, index);
		if(c == 0){
			System.out.println("not found");
		}else {
			System.out.println("char is "+c);
		}
	}
}
