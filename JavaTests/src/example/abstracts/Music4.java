package example.abstracts;

public class Music4 {
	public static void main(String args[]){
		Instrument i1 = new Wind();
		i1.play();
		System.out.println(i1.what());
		//Cannot instantiate the abstract class
		//Instrument a = new Instrument();
	}
	
	
}
