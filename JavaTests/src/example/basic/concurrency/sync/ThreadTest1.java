package example.basic.concurrency.sync;

/*
 * 对于一个成员方法加synchronized关键字，这实际上是以这个成员方法所在的对象本身作为对象锁。
 * 在本例中，就是以ThreadTest类的一个具体对象，也就是该线程自身作为对象锁的。一共十个线程，每个线程持有自己 线程对象的那个对象锁。这必然不能产生同步的效果。
 * 换句话说，如果要对这些线程进行同步，那么这些线程所持有的对象锁应当是共享且唯一的！
 */
public class ThreadTest1 extends Thread {
	private int threadNo;
	public ThreadTest1(int threadNo) {
		this.threadNo = threadNo;
	}
	public static void main(String[] args) throws Exception {
		for (int i = 1; i < 10; i++) {
			new ThreadTest1(i).start();
			Thread.sleep(10);
		}
	}
	@Override
	public synchronized void run() {
		for (int i = 1; i < 1000; i++) {
			System.out.print("No." + threadNo + ":" + i + "  ");
			if(i%10 == 0){
				System.out.println();
			}
		}
	}


}