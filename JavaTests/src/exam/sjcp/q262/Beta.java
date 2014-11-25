package exam.sjcp.q262;

import java.util.ArrayList;

class Alpha{
	private String alpha;
	public Alpha(){
		this("A");
	}
	protected Alpha(String a){
		alpha = a;
	}
}
public class Beta extends Alpha{
	public Beta(String a){
		super(a);
	}
	
	public static void main(String[] args)  {
		Alpha b = new Beta("hh");
		Alpha a = new Alpha("hh");
	}

}

