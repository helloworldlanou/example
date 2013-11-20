package exam.sjcp.q11;

class Person{
	String name = "No name";
	public Person(String nm){
		name = nm;
	}
//	public Person(){
//		
//	}
}
class Employee extends Person{
	String empID = "0000";
	String name ;
	public Employee(String id) {
		empID = id;
	}
}
public class EmployeeTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e = new Employee("4321");
		System.out.print(e.empID);
//		System.out.print(e.name);
	}
}
