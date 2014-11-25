package exam.sjcp.q279;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


enum Element{
	EARTH,VIND,
	Fire{
		public String info(){
			return "Hot";
		}
	};
	public String info(){
		return "element";
	}
}
public class B {
	public static void main(String[] args) throws IOException  {
		BufferedWriter b1 = new BufferedWriter(new PrintWriter(new FileWriter("aa.out")));
		PrintWriter b2 = new PrintWriter(new BufferedWriter(new FileWriter("aa.out")));
	}


}

