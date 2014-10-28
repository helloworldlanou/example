package exam.sjcp.q010;

interface A{
	public void doit(String thing);
}
class AImpl implements A{
	public void doit(String thing) {
	}
}
public class B {
	public A doit(){
		return null;
	}
	public void doit(A a){
	}
	public String execute(){
		return null;
	}
	public boolean equals(AImpl a){
		return false;
		
	}
}
class C extends B{
	public AImpl doit(){
		return null;
	}
	public void doit(AImpl a){
	}
	public Object execute(){
		return null;
	}
	
}
