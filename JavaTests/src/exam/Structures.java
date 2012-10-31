package exam;
/**
 * B继承A，B里有C，创建B的实例，问构造过程
 */
class A {
	A(){
		System.out.println("构造a");
	}
}
class B extends A{
	B(){
		System.out.println("构造b");
	}
	private C c = new C();
}
class C{
	C(){
		System.out.println("构造c");
	}
}
public class Structures {
	public static void main(String[] args) {
		B b = new B();
	}
}
