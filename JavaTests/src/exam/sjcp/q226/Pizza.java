package exam.sjcp.q226;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;

class PepperoniPizza extends Pizza{
//	public void addTopping(String topping){
//		toppings.add(topping);
//	}
	public final void removeTopping(String topping){
		toppings.remove(topping);
	}
	public final void do1(){
		System.out.println("ok");
	}
}
public class Pizza {
	ArrayList toppings;
	public final void addTopping(String topping){
		toppings.add(topping);
	}
	public final void removeTopping(String topping){
		toppings.remove(topping);
	}
	private final void  do1(){
		System.out.println("not ok");
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	}

}

