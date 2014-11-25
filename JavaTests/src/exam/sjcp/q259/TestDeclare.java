package exam.sjcp.q259;

public class TestDeclare{
	public static void main(String[] args) throws InterruptedException  {
		Runnable r = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					System.out.println("interrupted");
				}
				System.out.println("ran");
			}
			
		};
		Thread t = new Thread(r);
		t.start();
		System.out.println("started");
		t.sleep(20000); //是不是等于Thread.sleep(20000)?这里sleep的似乎是主线程，而不是t
		System.out.println("interrupting");
		t.interrupt();
		System.out.println("end");
	}


}

