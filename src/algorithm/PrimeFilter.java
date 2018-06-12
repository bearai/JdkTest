package algorithm;

import java.util.Random;

/**
 * 素数筛选，判断函数是否为素数
 *
 * @author 艾亮方
 * @date 2018年6月11日   上午9:18:39
 * @version 1.0
 **/
public class PrimeFilter {
	
	public static boolean isPrime(int num){
		if(num == 1) return true;
		int p = (int)Math.sqrt(num);
		for(int i=2;i<=p;i++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		for(int i=1;i<100;i++){
			int randnum = rand.nextInt(Integer.MAX_VALUE);
			System.out.println("num="+randnum+" isPrime="+isPrime(randnum));
		}
	}
}
