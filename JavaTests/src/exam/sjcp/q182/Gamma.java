package exam.sjcp.q182;

class Foo {
	private int x;
	public Foo (int x) { this.x = x;}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
}
public class Gamma {

	static Foo fooBar(Foo foo){
		foo = new Foo(100);
		return foo;
	}
	Foo fooBar2(Foo foo){
		foo = new Foo(100);
		return foo;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Foo foo = new Foo(300);
		System.out.print(foo.getX() + "-");
		
		Foo fooFoo = fooBar(foo);
		System.out.print(foo.getX() + "-");
		System.out.print(fooFoo.getX() + "-");
		
		fooFoo = fooBar(fooFoo);
		System.out.print(foo.getX() + "-");
		System.out.print(fooFoo.getX() + "-");
		
		foo = new Foo(300);
		fooFoo = (new Gamma()).fooBar2(foo);
		System.out.print(foo.getX() + "-");
		System.out.print(fooFoo.getX() + "-");
	}

}
