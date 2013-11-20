package exam.sjcp.q42;

class TestException extends Exception{}
class B{
	public void method2() throws TestException{
		throw new TestException();
	}
	public void method4(){
		//throw new TestException();//报错
	}
	public void method3(){
		throw new RuntimeException();
	}
}
public class A {
	public void method1(){
			B b = new B();
			try {
				b.method2();
			} catch (TestException e) {
				throw new RuntimeException(e);
			}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		a.method1();
	}

}
