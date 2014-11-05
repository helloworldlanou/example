package exam.sjcp.q109;

public class Pass2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{test();}
		catch(Exception ex){
			System.out.print("exception");
		}
	}
	static void test(){
		try{
			String x = null;
			System.out.print(x.toString()+" ");
		}finally{
			System.out.print("finally ");
		}
	}
}
