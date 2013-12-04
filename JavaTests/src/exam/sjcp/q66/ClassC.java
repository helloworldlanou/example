package exam.sjcp.q66;

import java.util.HashMap;
import java.util.Map;

class ClassA{}
class ClassB extends ClassA{}
public class ClassC extends ClassA{
	public static void main(String[] args) {
		ClassA p0 = new ClassA();
		ClassB p1 = new ClassB();
		ClassC p2 = new ClassC();
		ClassA p3 = new ClassB();
		ClassA p4 = new ClassC();
		
		p0 = p1;
//		p1 = p2;
//		p2 = p4;
//		p2 = (ClassC)p1;
		p1 = (ClassB)p3;
		p2 = (ClassC)p4;
		
		Map<String, String> map = new HashMap();
		map.put(null, "a");
		map.put(null, "b");
		map.put("", "c");
		map.put("", "d");
		System.out.print(map.containsKey(null));
		System.out.print(map.get(null));
		System.out.print(map.get(""));
	}
}
