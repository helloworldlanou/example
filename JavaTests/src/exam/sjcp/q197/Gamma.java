package exam.sjcp.q197;

public class Gamma {

	public String doit(int... a){
		return "a";
	}
	public String doit(int a,int b){
		return "b";
	}
	/**
	 * @param args
	 */
	public static void main(String[]... args) {
		// TODO Auto-generated method stub
		Gamma g = new Gamma();
		System.out.println(g.doit(4,5));
	}

}
