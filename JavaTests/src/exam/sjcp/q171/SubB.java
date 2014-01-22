package exam.sjcp.q171;

class X {
	public void foo(){
		System.out.println("X ");
	}
}
public class SubB extends X{
	public void foo() throws RuntimeException{
		super.foo();
		if(true) throw new RuntimeException();
		System.out.println("B ");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SubB().foo();

	}

}
