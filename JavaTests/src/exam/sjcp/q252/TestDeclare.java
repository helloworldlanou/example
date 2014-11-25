package exam.sjcp.q252;

interface Declare{
	public static final int EASY =3;
	void doStuff(int t);
}
public class TestDeclare implements Declare{
	public static void main(String[] args)  {
		int x = 5;
		new TestDeclare().doStuff(++x);
	}

	@Override
	public void doStuff(int s) {
		s += EASY + ++s;
		System.out.println("s " + s);
	}

}

