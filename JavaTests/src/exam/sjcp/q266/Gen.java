package exam.sjcp.q266;

import java.util.ArrayList;
import java.util.List;

public class Gen<T> {
	private T object;
	public Gen(T object){
		this.object = object;
	}
	public T getObject(){
		return object;
	}
	public static void main(String[] args)  {
		Gen<String> str = new Gen<String>("ansver");
		Gen<Integer> ints = new Gen<Integer>(42);
		System.out.println(str.getObject() + "=" + ints.getObject());
	}

}

