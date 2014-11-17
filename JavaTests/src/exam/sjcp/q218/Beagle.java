package exam.sjcp.q218;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;

class Animal {
	Animal(int a){
		System.out.println("a");
	}
}
class Dog extends Animal implements Serializable{
	Dog(){
		super(1);
		System.out.println("b");
	}
}
public class Beagle extends Dog{
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("beagle.txt")));
		os.writeObject(new Beagle());
		
		 ObjectInputStream in=new ObjectInputStream(new FileInputStream(new File("beagle.txt")));
		 Beagle b=(Beagle)in.readObject();
	}

}

