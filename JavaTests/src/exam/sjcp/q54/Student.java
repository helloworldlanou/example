package exam.sjcp.q54;

class Person{
	protected void finalize(){
		System.out.println(this.hashCode()+" finalize person");
	}
}
public class Student extends Person{
	protected void finalize(){
//		super.finalize();//不会被自动调用
		System.out.println(this.hashCode()+" finalize student");
	}
	/**
	 * @param test finalize
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student();
		s.finalize();
	}

}
