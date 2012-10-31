package exam;
import java.util.HashMap;
import java.util.Map;

public class StaticChar {
	/**
	 * @param args
	 * 如果一串字符如"aaaabbc中国1512"要分别统计英文字符的数量，
	 * 中文字符的数量，和数字字符的数量，假设字符中没有中文字符、
	 * 英文字符、数字字符之外的其他特殊字符。
	 */
	public static <K, V> Map doprocess(String str){
		Map result = new HashMap<String , String>();
		int c_n=0,n_n=0,o_n=0;
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c>='0'&&c<='9'){
				n_n++;
			}else if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
				c_n++;
			}else{
				o_n++;
			}
		}
		result.put("char_number", c_n);
		result.put("num_number", n_n);
		result.put("other_number", o_n);
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "aaaabbc中国1512";
		Map result = doprocess(a);
		System.out.println(result.toString());
	}
}
