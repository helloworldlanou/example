package exam.sjcp.q114;

class TestException extends Exception{
	
}
class A{
	public String sayHello(String name) throws TestException{
		if(name == null) throw new TestException();
		return "hello" + name;
	}
}
public class Test {

	public static void main(String[] args) throws TestException {
		new A().sayHello("peter");
//		throw new AssertionError();
	}

}
