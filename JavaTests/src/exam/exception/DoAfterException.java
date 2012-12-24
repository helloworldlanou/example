package exam.exception;

public class DoAfterException {

	/**
	 * @param args
	 * @throws Exception 
	 */
	
	/**
	 * try中throw，能否直接catch
	 */
	public void method1(){
		try{
			throw new StringIndexOutOfBoundsException("method1 catch");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	/**
	 * 有多个catch的情况
	 */
	public void method2(){
		try{
			throw new StringIndexOutOfBoundsException("method2");
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("method2 catch 1");
		}catch(Exception e){
			System.out.println("method2 catch 2");
		}
	}
	
	/**
	 * catch中throw new exception,下边继续catch能否catch到？
	 */
	public void method3(){
		try{
			throw new StringIndexOutOfBoundsException("method3 1");
		}catch(StringIndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			throw new StringIndexOutOfBoundsException("method3 2");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * catch中和finally中都throw new exception
	 */
	@SuppressWarnings("finally")
	public void method4(){
		try{
			throw new StringIndexOutOfBoundsException("method4 1");
		}catch(StringIndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			throw new StringIndexOutOfBoundsException("method4 2");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			throw new StringIndexOutOfBoundsException("method4 finally");
		}
	}
	
	/**
	 * try中代码执行哪些？try catch 后面代码是否执行？输出什么
	 */
	public void method5(){
		try{
			System.out.println("method step1");
			new String("abc").subSequence(0, 5);
			System.out.println("method step2");
		}catch(StringIndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("method step3");
	}
	
	public void method22(String a){
		try{
			a.subSequence(0, 5);
			throw new Exception("aaexception1");
		}
		catch(StringIndexOutOfBoundsException e){
			System.out.println("catch StringIndexOutOfBoundsException");
//			throw new Exception("aaexception2");
		}
		catch(Exception x){
			System.out.println("catch x");
		}
		finally{
//			throw new Exception("aaexception4");
			System.out.println("end0");
		}
	}
	
	public void method33(String a){
			a.subSequence(0, 5);
	}
	
	
	public void method34(String a){
		System.out.println("method3 start");
		this.method1();
		System.out.println("method3 end");
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DoAfterException de = new DoAfterException();
		System.out.println("begin");
		de.method1();
		de.method2();
//		de.method3();
		de.method4();
		System.out.println("end");
	}

}
