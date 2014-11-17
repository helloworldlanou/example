package exam.sjcp.q169;
public class Tester{
	public static void main(String[] args) {
		try{
			args = null;
			args[0] = "test";
			System.out.println(args[0]);
		}catch(Exception ex){
			System.out.println("EXCEPTION");
		}catch(NullPointerException npe){
			System.out.println("Null");
		}
		
		
	}
}
