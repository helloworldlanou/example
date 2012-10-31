package example.designpattern.singleton;

public class Singleton4 {
	
	private volatile static Singleton4 instance;
	public Singleton4(){
		
	}
	public static  Singleton4 getinstance(){
		if(instance == null){
			synchronized(Singleton4.class){
				if(instance == null){
					instance = new Singleton4();
				}
			}
		}
			return instance;
	}
}
//problem ... 双重加锁 JDK5以后适用