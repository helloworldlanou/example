package example.basic.concurrency;

import java.util.TreeMap;
/**
 * 生产者与消费者问题
 * @author wz
 *
 */
public class ProductorConsumer {

	public static void main(String[] args){
		
		SycnStack s = new SycnStack(5);
		new Thread(new Producer(s)).start();
		new Thread(new Consumer(s)).start();
	}
	
}

class Producer implements Runnable{
	private SycnStack stack;
	public Producer(SycnStack stack){
		this.stack = stack;
	}
	@Override
	public void run() {
		int i=10;
		while(i-->0){
			stack.push( (char)(26*Math.random()+'A'));
//			Thread.yield();
		}
	}
}
class Consumer implements Runnable{
	private SycnStack stack;
	public Consumer(SycnStack stack){
		this.stack = stack;
	}
	@Override
	public void run() {
		int i=10;
		while(i-->0){
			stack.pop();
			Thread.yield();
		}
	}
}

class SycnStack{
	private Integer index=0;
	private char[] data;
	
	public SycnStack(int num){
		data = new char[num];
	}
	
	public void push(char c){
		synchronized (index) {//对index加锁为何不行？？？必须this
			while(index==data.length-1) 
			{
				System.out.println("池子已经满，不能放入了！"+Thread.currentThread().toString());
				try {
					index.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			index.notify();//获取锁
				data[index]=c;
				System.out.println("放入"+c+" "+Thread.currentThread().toString());
				index++;
		}
	}
	public Character pop(){
		synchronized (index) {
			while(index==0){
				System.out.println("池子已经空了，取不了了！"+Thread.currentThread().toString());
				try {
					index.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			index.notify();
				index--;
				char c = data[index];
				System.out.println("取出"+c+" "+Thread.currentThread().toString());
				return c;
		}
	}
}