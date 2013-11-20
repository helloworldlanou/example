package exam.sjcp.q35;

interface Foo{}

class Alpha implements Foo {}

class Beta extends Alpha{}

public class Delta extends Beta{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Beta x = new Beta();
		Alpha a = x;
		Delta d = (Delta)x;
		Foo f = (Delta)x;
		Foo f2 = (Alpha)x;
		Beta b = (Beta)(Alpha)x;
	}

}
