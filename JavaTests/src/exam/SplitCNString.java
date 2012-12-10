package exam;

/**
 * 截取字符串，汉字当作两个。“a我是好人”截取3 输出“a我”
 * @author root
 *
 */
public class SplitCNString {

	public static int compute(String a,int n){
		int num = 0;
		char[] chars = a.toCharArray();
			for(int i = 0 ;i<chars.length;i++){
				num++;
				if(num==n)return i+1;
				byte[] bs = (chars[i]+"").getBytes();
				System.out.println(bs.length);//为什么汉字输出的是3 ??
				if(bs.length>=2){
					System.out.println("发现汉字！");
					num++;
					if(num==n)return i+1;
				}
			}
		return n;
	}
	public static void main(String[] args) {
		String str = "a我是BCD好人";
		int ok = compute(str,6);
		System.out.println(str.substring(0, ok<=str.length()?ok:str.length()));
	}
}
