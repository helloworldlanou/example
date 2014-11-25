package exam.sjcp.q130;


interface A{void aMethod();}
interface B{void bMethod();}
interface C extends A,B{void cMethod();}
class D implements B{
	private Integer a;
	public void bMethod() {}
	void show(){
		System.out.println(a);
	}
}
public class E  extends D implements C{
	private Integer a = 5;
	public void aMethod() {}
	public void bMethod() {}
	public void cMethod() {}
	public static void main(String[] args)  {
		D e = new E();
		e.show();
		
	}
}
