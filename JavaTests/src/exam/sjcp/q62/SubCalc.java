package exam.sjcp.q62;

class SuperCalc{
	protected static int multiply(int a,int b){
		return a*b;
	}
}
public class SubCalc extends SuperCalc{
	public int x;
	public static int multiply(int a,int b){
		int c = super.multiply(a,b);
		this.x = 0;
		return c;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
