package icinga.dao;

public class MyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long startTime=System.currentTimeMillis();   //获取开始时间 
		for(int i=0;i<100;i++){
//			new Thread(new MyRun2()).start();
			Thread x = new Thread(new MyRun2());
			x.start();
		}
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
	}

}
