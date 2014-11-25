package exam.sjcp.q271;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Single {
	private static Single instance;
	public static Single getInstance(){
		if(instance==null)instance = create();
		return instance;
	}
	private Single(){
		
	}
	protected Single create(){
		return new Single();
	}
	public static void main(String[] args)  {
	}



}

