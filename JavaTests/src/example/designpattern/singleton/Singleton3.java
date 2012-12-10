package example.designpattern.singleton;

public class Singleton3 {
	
	private static Singleton3 instance = new Singleton3();
	public Singleton3(){
		
	}
	public static  Singleton3 getinstance(){
			return instance;
	}
}
//problem ... eagerly create急切创建实例 .如果您仍然关心性能，可使用Singleton4