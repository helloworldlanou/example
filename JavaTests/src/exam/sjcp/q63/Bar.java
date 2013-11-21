package exam.sjcp.q63;
class Foo{
	public int a = 3;
	public void addFive(){
		a +=5;
		System.out.print("f ");
	}
}
public class Bar extends Foo{
	public int a = 8;
	public void addFive(){
		this.a +=5;
		System.out.print("b ");
	}
	public static void main(String[] args) {
		Foo f = new Bar();
		f.addFive();
		System.out.print(f.a);
	}
}
