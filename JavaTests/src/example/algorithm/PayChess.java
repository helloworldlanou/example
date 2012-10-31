package example.algorithm;
/**
 * 棋盘走棋问题，m*n的棋盘，从00走到mn的走法有多少种
 * @author wz
 *
 */
public class PayChess {

	 public static int process(int m,int n){
		if(m == 0 && n == 0) return 0;
		if(m == 1 && n == 0) return 1;
		if(m == 0 && n == 1) return 1;
		if(m == 0){
			return process(m,n-1);
		}
		if(n == 0){
			return process(m-1,n);
		}
		return process(m,n-1)+process(m-1,n);
	}
	
	public static void main(String[] args) {
		int x = process(3,4);
		System.out.println(x);
	}

}
