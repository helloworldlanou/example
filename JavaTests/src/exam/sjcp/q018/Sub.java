package exam.sjcp.q018;

class Super{
	protected int a;
	protected Super(int a){
		this.a = a;
	}
}

public class Sub extends Super{
	private int a;
	public Sub(int a){
		super(a);
	}
	public Sub(){
		this(5);
		System.out.println(this.a);
		System.out.println(super.a);
	}
	public static void main(String[] args) {

		Sub s = new Sub();
		
	}
}
