package util.string;

public class StringUtil {
	/**
	 *@author WZ
	 * @param source ÒªÅÐ¶ÏµÄ×Ö·û´®
	 * @return ×Ö·û´®Àïº¬ÓÐÍ¼Æ¬·µ»ØÍ¼Æ¬Â·¾¶£¬ÎÞÍ¼Æ¬Ôò·µ»ØNULL
	 */
	public String getPicFromFckStr(String source){
		if(source==null){
			return null;
		}
		else{
			if(source.indexOf("<img")!=-1){
				Integer p=source.indexOf("src=\"");
				p=p+5;
				String temp=source.substring(p);
				int q=temp.indexOf("\"");
				q=q+p;
				
				return source.substring(p, q);
			}else{
			return null;		
			}
		}
		
	}

}
