package example.basic;

import java.util.ArrayList;

/**
 * int ,Integer ,LIST,传值问题。Integer是final的，所以改变的时候，其实已经指向别的实例了(此解释是错误的)。
 * @author root
 *
 */

public class IntegerVSint {
	
		private int n_int =0;
		private Integer N_Integer = 0;
		private String string = "str";
		private StringBuffer stringStringBuffer = new StringBuffer("str");
		private ArrayList list = new ArrayList<String>();
		private Integer[] ins = new Integer[1];
		//ins[0] = 0;
		
		public void add (int n){
			++n;
		}
		public void add (Integer N){
			++N;
		}
		public void add (ArrayList list){
			list.add("ok");
		}
		public void add(String str){
			str += " ing!";
		}
		public void add(StringBuffer str){
			str.append(" ing!");
		}
		public void add(Integer[] ins){
			ins[0]++;
		}
		
		public  static void main(String args[]){
			IntegerVSint a = new IntegerVSint();
			a.ins[0]=0;
			a.add(a.n_int);
			a.add(a.N_Integer);
			a.add(a.list);
			a.add(a.string);
			a.add(a.stringStringBuffer);
			a.add(a.ins);
			
			System.out.println("int    :"+a.n_int);
			System.out.println("Integer:"+a.N_Integer);
			System.out.println("list   :"+a.list.size());
			System.out.println("string :"+a.string);
			System.out.println("Stringbuffer:"+a.stringStringBuffer);
			System.out.println(a.ins[0]);
		}
}
