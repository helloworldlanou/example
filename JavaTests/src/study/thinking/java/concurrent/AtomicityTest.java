package study.thinking.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable{

	private int i = 0;//加 volatile 后程序无影响
	public int getValue(){
		return i;
	}
	private synchronized void evenIncrement(){
		i++;
		i++;
	}
	@Override
	public void run() {
		while(true){
			evenIncrement();
		}
	}
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicityTest at = new AtomicityTest();
		exec.execute(at);
		while(true){
			int val = at.getValue();
			if(val % 2 !=0){
				System.out.print(val);
				System.exit(0);
			}
		}
	}
}