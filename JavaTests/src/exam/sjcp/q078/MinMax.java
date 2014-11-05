package exam.sjcp.q078;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.codec.binary.StringUtils;
import org.jsoup.helper.StringUtil;

public class MinMax{

	/**
	 * @param <K>
	 * @param args
	 */
	public static <K> void main(String[] args) {
		HashMap props = new  HashMap();
		props.put("key34", "some value");
		props.put("key14", "some 2  value");
		props.put("key43", "some 3 value");
		Set s = props.keySet();
//		Arrays.sort(s);
		s = new TreeSet(s);
//		Collections.sort(s);
//		s = new SortedSet(s);
	}

}
