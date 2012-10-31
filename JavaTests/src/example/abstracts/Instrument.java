package example.abstracts;
/**
 * 
 * @author root
 * 抽象类：1 用来包含一些不实现的方法
 * 2 用来明确这个类的用途，不能被实例化
 * 3 继承后必须实现所有的抽象方法
 * 4 抽象类可以不包含抽象方法，仅仅用于防止被实例化。实例化的时候报编译异常
 */
public abstract class Instrument {
	private int i;
	public abstract void play();
	public String what(){
		return "Instrument";
	}
	public abstract void adjust();
}
