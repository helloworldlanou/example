package example.basic.concurrency;

public class LiftOff implements Runnable{
	protected int countDown = 10;
	private static int taskcount = 0;
	private final int id = taskcount++;
	public LiftOff() {
		System.out.println("init a LIFTOFF");
	}
	public LiftOff(int countDown){
		this.countDown = countDown;
	}
	
	private String getstatus(){
		return "#"+id+"@"+(countDown>0?countDown:"LiftOff!")+" ";
	}
	@Override
	public void run() {
		while(countDown-->0){
			System.out.print(this.getstatus());
			Thread.yield();//让步，使线程
		}
		// TODO Auto-generated method stub
	}
	
	public static void main(String args[]){
//		for(int i=0;i<=10;i++){
//			new Thread(new LiftOff()).start();
//		}
		
		System.out.println();
		
		LiftOff one = new LiftOff();
		for(int i=0;i<=10;i++){
			new Thread(one).start();
		}
	}
}