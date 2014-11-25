package exam.sjcp.q265;

import java.util.ArrayList;
import java.util.List;

public class X {
	public static void foo(List<Object> list){
		
	}
	
	public static void main(String[] args)  {
		ArrayList<String> x1 = new ArrayList<String>();
		foo(x1);
		
		List<Object> x2 = new ArrayList<String>();
		foo(x2);
		
		ArrayList<Object> x3 = new ArrayList<Object>();
		foo(x3);
		
		ArrayList x4 = new ArrayList();
		foo(x4);
	}

}

