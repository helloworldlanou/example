package exam.sjcp.q001;
//主线程终止，子线程是否继续执行
public class Threads3 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0;i<10000;i++) {
			System.out.println("run" + i);
			try {
				Thread.currentThread().sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Threads3()).start();
//		System.exit(1);
		throw new Error();
	}
}
