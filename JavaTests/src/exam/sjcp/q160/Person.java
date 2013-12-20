package exam.sjcp.q160;

import java.util.HashSet;

public class Person {

	private String name;
	public Person(String name){
		this.name = name;
	}
	public int hashCode(){
		return 420;
	}
	
	public static void main(String[] args){
		HashSet set = new HashSet();
		Person p1 = new Person("Jonh");
		set.add(p1);
		set.add(new Person("Lily"));
		System.out.println(set.size());
//		System.out.println(set.contains(new Person("Jonh")));
		System.out.println(set.contains(p1));
	}
}
