package util.string;

public class StringUtil {
	/**
	 *@author WZ
	 * @param source Ҫ�жϵ��ַ���
	 * @return �ַ����ﺬ��ͼƬ����ͼƬ·������ͼƬ�򷵻�NULL
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
