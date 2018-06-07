package algorithm;
/**
 * 获取两个数的最大公约数
 *
 * @author 艾亮方
 * @date 2018年6月5日   下午9:55:57
 * @version 1.0
 **/
public class Gcd {

	public static int gcd(int m,int n){
		return n==0?m:gcd(n, m%n);
	}
	
	public static void main(String[] args) {
		System.out.println(12%18);
		System.out.println(gcd(12,18));
	}
	
}
