package exam.sjcp.q168;
public class Tester{
	public void go(int x){
		assert(x>0);
		switch(x){
		case 2:;
		default:assert false;
		}
	}
	private void go2(int x){
		assert(x<0);
	}
	public static void main(String[] args) {
		Tester t = new Tester();
		t.go(-3);
		t.go2(4);
	}
}
