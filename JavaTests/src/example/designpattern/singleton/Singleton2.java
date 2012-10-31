package example.designpattern.singleton;

public class Singleton2 {
	
	private static Singleton2 instance;
	public Singleton2(){
		
	}
	public static synchronized Singleton2 getinstance(){
		if(instance == null){
			instance = new Singleton2();
		}
			return instance;
		
	}
}
//problem ... 一次只有一个可以调用getinstance，性能不是特别好，其实只有第一次需要同步，后面的调用都同步是一种累赘。于是有个Singleton3