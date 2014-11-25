package exam.sjcp.q268;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MyInt implements Comparable {
	private int i;
	public MyInt(int i){
		this.i = i;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		MyInt i2 = (MyInt)o;
		return i-i2.i;
	}
	public String toString(){
		return ""+i;
	}
	public static void main(String[] args)  {
		ArrayList<MyInt> list = new ArrayList<MyInt>();
		list.add(new MyInt(2));
		list.add(new MyInt(1));
		Collections.sort(list);
		System.out.println(list);
	}



}

