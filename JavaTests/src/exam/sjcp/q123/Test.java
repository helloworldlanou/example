package exam.sjcp.q123;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Test {
	public static void main(String[] args)  {
		String s = "123456789";
		StringBuffer sb = new StringBuffer("123456789");
		sb.delete(0, 3).replace(1, 3, "24").delete(4, 6);
		System.out.println(sb);
	}

}
