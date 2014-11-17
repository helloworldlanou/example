package exam.sjcp.q211;

import java.io.Console;
import java.text.DateFormat;
import java.util.Locale;

public class Gamma implements Runnable{
	public void run() {
		for(int x=1;x<1000;x++){
			Thread.yield();
			if(x%100 == 0){
				System.out.println("t");
			}
		}
	}
	 void go() throws Exception{
		 Thread t = new Thread(new Gamma());
		 t.start();
		 for(int x=1;x<1000;x++){
			 Thread.yield();
				if(x%100 == 0){
					System.out.println("g");
				}
			}
	 }
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Gamma g = new Gamma();
		g.go();
//		Console c = System.console();
//		String s =new String( c.readPassword("%s", "pw"));
	}

}

