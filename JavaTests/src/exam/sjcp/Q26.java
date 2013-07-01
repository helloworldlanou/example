package exam.sjcp;

public class Q26 {

	
	public static void parse(String str) throws Exception{

//		throw new Exception();
	}
	
	public static void parse2(String str){
		float f = Float.parseFloat(str);
		Q26.parse(str);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parse("invalid");
		StringBuilder sb = new StringBuilder("abc");
	}

}
