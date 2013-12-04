package exam.sjcp.q115;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class ListTest {

	public static Collection get(){
		Collection sorted = new LinkedList();
		sorted.add("B");
		sorted.add("C");
		sorted.add("A");
		return sorted;
	}
	public static Collection get2(){
		Collection sorted = new ArrayList();
		sorted.add("B");
		sorted.add("C");
		sorted.add("A");
		return sorted;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(Object obj:get()){
			System.out.print(obj + ",");
		}
		for(Object obj:get2()){
			System.out.print(obj + ",");
		}
	}

}
