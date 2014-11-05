package exam.sjcp.q076;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.codec.binary.StringUtils;
import org.jsoup.helper.StringUtil;

public class MinMax{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSet<Integer> s = new TreeSet<Integer>();
		TreeSet<Integer> subs = new TreeSet<Integer>();
		for(int i=606;i<613;i++){
			if(i%2==0) 
				s.add(i);
		}
		subs = (TreeSet<Integer>) s.subSet(608, true, 611, true);
		s.add(609);
		System.out.println(s + " " + subs);
	}

}
