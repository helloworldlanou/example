package exam.sjcp;

public class Q16 {

	
	public static void parse(String str){
		try{
			float f = Float.parseFloat(str);
		}catch(NumberFormatException e){
			f = 0;
		} finally {
			System.out.println(f);
		}

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
