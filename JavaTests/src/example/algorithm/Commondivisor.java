package example.algorithm;

public class Commondivisor {

	/**
	 * 求最大公约数，辗转相除法
	 * @param args
	 */
	
	/**
	 *  递归来计算
	 * @param a
	 * @param b
	 * @return
	 */
	public  static int getCommondivisor(int a,int b){
		if(a<0||b<0){
			return -1;
		}//not legal
		
		if(a<b){
			a = a + b;
			b = a - b;
			a = a - b;
		}//ensre a>=b
		
		if(b == 0){
			return a;
		}else{
			return getCommondivisor(b,a%b);
		}
	}
	/**
	 *  迭代来计算
	 * @param a
	 * @param b
	 * @return
	 */
	public  static int getCommondivisor1(int a,int b){
		if(a<0||b<0){
			return -1;
		}//not legal
		
		if(a<b){
			a = a + b;
			b = a - b;
			a = a - b;
		}//ensre a>=b
		
		while(b!=0){
			int t = b;
			b = a%b;
			a = t;
		}
		return a;
	}
	/**
	 * 最小公倍数。A*B/最大公约数
	 * @param a
	 * @param b
	 * @return
	 */
	public  static int getCommonmultiple(int a,int b){
		return a*b/getCommondivisor1(a,b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getCommondivisor(12,30));
		System.out.println(getCommondivisor1(12,30));
		System.out.println(getCommonmultiple(12,30));
	}

}
