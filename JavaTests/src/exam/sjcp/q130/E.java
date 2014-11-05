package exam.sjcp.q130;


interface A{void aMethod();}
interface B{void bMethod();}
interface C extends A,B{void cMethod();}
class D implements B{
	public void bMethod() {}
}
public class E  extends D implements C{
	public void aMethod() {}
	public void bMethod() {}
	public void cMethod() {}
	public static void main(String[] args)  {
	}
}
