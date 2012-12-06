package exam.exception;

public class DoAfterException {

	/**
	 * @param args
	 * @throws Exception 
	 */
	@SuppressWarnings("finally")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("begin");
		String a = "abc";
		try{
			a.subSequence(0, 5);
			throw new Exception("aaexception1");
		}
		catch(StringIndexOutOfBoundsException e){
			System.out.println("catch StringIndexOutOfBoundsException");
			throw new Exception("aaexception2");
		}
		catch(Exception x){
			System.out.println("catch x");
		}
		finally{
//			throw new Exception("aaexception4");
			System.out.println("end0");
		}
		
		System.out.println("end");
	}

}
