package exam.sjcp.q110;

import java.util.ArrayList;

class Person{
	int a = 10;
}
public class Test {

	public enum Dogs{collie,harrier,happy};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dogs myDog = Dogs.harrier;
		switch(myDog){
//		case Dogs.collie:   //The qualified case label Test.Dogs.collie must be replaced with the unqualified enum constant collie
		case collie:
			System.out.print("collie ");
		case harrier:
			System.out.print("harrier ");
		case happy:
			System.out.print("happy ");
		}
		
		ArrayList list = new ArrayList();
		Integer a = new Integer(400);
		list.add(a);
		a = null;
		System.out.println(list.get(0));
		ArrayList list2 = new ArrayList();
		Person b = new Person();
		list2.add(b);
		b.a = 200;
		System.out.println(((Person)list2.get(0)).a);
	}

}
