package example.arithmetic.recursion;

public class Fibonacci {

	/**
	 * @param args
	 */
	public static long compute(long n){
		long n1 ,n2 , s;
		n1=1;
		n2=1;
		s=1;
	    for(long i=1;i<n;i++){
	        s = n1 + n2;
	        n1 = n2;
	        n2 = s;
	    }
	    return s;
	}
	public static long compute2(long n){
		if(n == 1 || n==2){
			return n;
		}else{
			return compute2(n-1) + compute2(n-2);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Fibonacci.compute(10));
		System.out.println(Fibonacci.compute2(10));
	}

}
