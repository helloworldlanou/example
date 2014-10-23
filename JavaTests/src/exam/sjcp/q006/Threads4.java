package exam.sjcp.q006;

public class Threads4 {

	public void go(){
		Runnable r = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("foo");
			}
		};
		Thread t = new Thread(r);
		t.start();
		t.start();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Threads4().go();
	}

}
