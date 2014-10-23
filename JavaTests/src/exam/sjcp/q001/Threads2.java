package exam.sjcp.q001;

public class Threads2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run");
		throw new RuntimeException("problem");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Threads2()).start();
		System.out.println("end");
		
	}
}
