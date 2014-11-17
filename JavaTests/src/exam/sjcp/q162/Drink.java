package exam.sjcp.q162;

import java.util.Iterator;
import java.util.TreeSet;

public class Drink implements Comparable{

	public String name;
	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
	public static void main(String[] args){
		Drink one = new Drink();
		Drink two = new Drink();
		one.name = "Coffee";
		two.name = "Tea";
		TreeSet set = new TreeSet();
		set.add(one);
		set.add(two);
		System.out.println(set.size());
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(((Drink)it.next()).name);
		}
	}
//	
//	public void go(int x){
//		assert (x > 0);
//		switch(x){
//		case 2:;
//		default:assert false;
//		}
//	}
//	private void go2(int x){
//		assert (x<0);
//	}
}
