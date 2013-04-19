package example.effective.p49;

public class IntegerVsInt {

	public void test1(){
		Integer a = new Integer(33);
		Integer b = new Integer(33);
		System.out.println(a==b);
		System.out.println(a.equals(b));
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(a.MAX_VALUE);
	}
	public void test2(){
		long a=System.currentTimeMillis();
		Long sum = 0l;
		for(long i=0;i<=Integer.MAX_VALUE;i++){
			sum += i;
		}
		System.out.println(sum + "\r执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
	}
	public void test3(){
		long a=System.currentTimeMillis();
		long sum = 0l;
		for(long i=0;i<=Integer.MAX_VALUE;i++){
			sum += i;
		}
		System.out.println(sum + "\r执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerVsInt test = new IntegerVsInt();
		test.test1();
		test.test2();
		test.test3();
	}
}
