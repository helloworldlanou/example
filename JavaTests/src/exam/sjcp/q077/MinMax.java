package exam.sjcp.q077;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.codec.binary.StringUtils;
import org.jsoup.helper.StringUtil;

public class MinMax{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] colors = {
				"blue","red","green","yellow","orange"
		};
		Arrays.sort(colors);
		int s2 = Arrays.binarySearch(colors, "blue");
		int s3 = Arrays.binarySearch(colors, "no");
		System.out.println(s2 + " " + s3);
	}

}
