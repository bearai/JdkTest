package algorithm;

/**
 * 修改随机数[0,x)的概率，给定一个大于0的正整数k，修改概率为x的k次方
 *
 * @author 艾亮方
 * @date 2018年6月8日   上午12:21:12
 * @version 1.0
 **/
public class ChangeRandomProbability {

	public static double getRandom(int k){
		if(k<=0){
			return -1;
		}
		double res = -1;
		for(int i=0;i<k;i++){
			res = Math.max(Math.random(), res);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int oneTimes = 0;
		int twoTimes = 0;
		int threeTimes = 0;
		for(int i=0;i<1000;i++){
			if(getRandom(1)<0.5){
				oneTimes++;
			}
			if(getRandom(2)<0.5){
				twoTimes++;
			}
			if(getRandom(3)<0.5){
				threeTimes++;
			}
		}
		System.out.println(oneTimes);
		System.out.println(twoTimes);
		System.out.println(threeTimes);
	}
}
