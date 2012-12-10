package example.designpattern.singleton;

public class Singleton1 {
	
	private static Singleton1 instance;
	public Singleton1(){
		
	}
	public static Singleton1 getinstance(){
		if(instance == null){
			instance = new Singleton1();
		}
			return instance;
		
	}
}
//problem ... 多个地方去调用getinstance的时候会出问题。还是会多创建instance。于是有个Singleton2