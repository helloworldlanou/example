package exam.sjcp.q179;

import java.util.Date;
import java.util.HashMap;

public class SubB{
	private final int id;
	public SubB(int id){
		this.id = id;
	}
	public void updateId(int newId){
		id = newId;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap map = new HashMap(55);
		int a = 500;
		Integer b = new Integer(50);
		Integer c = new Integer(50);
		Integer d = 100;
		Integer e = 100;
		Integer f = 500;
		Integer g = 500;
		System.out.println(a==g);
		System.out.println(c==b);
		System.out.println(d==e);
		System.out.println(f==g);
	}

}
