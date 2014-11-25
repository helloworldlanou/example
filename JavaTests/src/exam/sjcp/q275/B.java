package exam.sjcp.q275;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class A{
	
}
public class B extends A{
	public static void main(String[] args)  {
		List<A> listA = new LinkedList<A>();
		List<B> listB = new LinkedList<B>();
		List<Object> list0 = new LinkedList<Object>();
		List listi = new LinkedList();
		m1(listA);
		m2(listA);
		m1(listB);
		m2(listB);
		m1(list0);
		m2(list0);
		
		m1(listi);
	}

	public static void m1(List<? extends A> list){
	}
	public static void m2(List<A> list){
		
	}
	

}

