package example.stringtext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * cut a String include chinese string 包含中文
 * @author root
 *
 */
public class CutString {

	static String FirstNBytes(String s, int n) {
		//第一个是判断的汉字，这个是对的
		//Pattern p = Pattern.compile("^[\\u4e00-\\u9fa5]$");
		Pattern p = Pattern.compile("^[^a-zA-Z]$");
		int i = 0, j = 0;
		for(char c : s.toCharArray()) {
			Matcher m = p.matcher(String.valueOf(c));
			i += m.find() ? 2 : 1;
			++j;
			if(i == n) break;
			if(i > n) {
				--j;
				break;
			}
		}
		return s.substring(0, j);
	}

	public static void main(String args[]) {
		String a = "我ABC汉DEF";
		for(int i = 0; i < 11; ++i)
			System.out.println("No." + i + ":" + FirstNBytes(a, i));
	}

}
