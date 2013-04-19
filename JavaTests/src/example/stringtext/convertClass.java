package example.stringtext;

public class convertClass {
	
	
	public String convert(String str){
		String a = "";
		if(str==null || str.equals("")){return null;}
		else{
		for(int i=str.length()-1;i>=0;i--){
		   a = a + str.charAt(i);
		  }
		
		}
		return a;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		convertClass cc = new convertClass();
		System.out.println(cc.convert("我是中国人abc"));
		
		int a = (Integer) null;
		System.out.println(a);
	}

}
