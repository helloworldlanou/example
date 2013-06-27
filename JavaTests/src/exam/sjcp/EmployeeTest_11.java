package exam.sjcp;

class Person {
	String name = "no name";
	public Person(String nm){
		name = nm;
	}
}

class Employee extends Person{
	String empID = "0000";
	public Employee(String id) {
		empID = id;
	}
}

public class EmployeeTest_11{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e = new Employee("4321");
	}
}
