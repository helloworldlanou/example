package example.basic.finalTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

	public static final String[] values = {"a","b"};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<String> list = Collections.unmodifiableList(Arrays.asList(values));
		for (String string : list) {
			System.out.print(string);
		}
		values[0] = "xx";
		for (String string : list) {
			System.out.print(string);
		}
	}

}
