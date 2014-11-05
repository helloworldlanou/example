package exam.sjcp.q110;

public class Test {

	public enum Dogs{collie,harrier,happy};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dogs myDog = Dogs.harrier;
		switch(myDog){
//		case Dogs.collie:   //The qualified case label Test.Dogs.collie must be replaced with the unqualified enum constant collie
		case collie:
			System.out.print("collie ");
		case harrier:
			System.out.print("harrier ");
		case happy:
			System.out.print("happy ");
		}
	}

}
