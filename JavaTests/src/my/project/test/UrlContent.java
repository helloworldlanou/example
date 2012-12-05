package my.project.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class UrlContent {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 * @throws URISyntaxException 
	 * 
	 * 
	 */
	/* <h4> URIs, URLs, and URNs </h4>
	 * A URI is a uniform resource <i>identifier</i> while a URL is a uniform
	 * resource <i>locator</i>.  Hence every URL is a URI, abstractly speaking, but
	 * not every URI is a URL.  This is because there is another subcategory of
	 * URIs, uniform resource <i>names</i> (URNs), which name resources but do not
	 * specify how to locate them.  The <tt>mailto</tt>, <tt>news</tt>, and
	 * <tt>isbn</tt> URIs shown above are examples of URNs.
	 */
	private static String addr1 = "http://blog.csdn.net";
	private static String addr2 = "http://www.baidu.com";
	private static String addr3 = "http://www.sogou.com";

	@Deprecated
	public void test1() throws MalformedURLException, URISyntaxException{
		 URL url = new URL(addr2);
		 URI uri = new URI(addr2);
		 StringBuffer text = new StringBuffer();
			try {
				BufferedReader bf = new BufferedReader(
							new  InputStreamReader(url.openStream(),"gb2312")
						);
				String temp;
				while((temp=bf.readLine())!=null){
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(text);
	}
	/*
	 * this method is ok,use iso-8859-1 for reader,then get the real charset and convert
	 */
	public String downloadContent(String url1) throws MalformedURLException, URISyntaxException{
		 URL url = new URL(url1);
		 String text = "";
				BufferedReader bf;
				try {
					bf = new BufferedReader(
//							new  InputStreamReader(url.openStream())
								new  InputStreamReader(url.openStream(),"iso-8859-1")
							);
					text = UrlContent.buffer2String(bf);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			return text;
	}
	
	public static String downloadContentuseClient(String url) throws MalformedURLException, URISyntaxException{

		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = null;
		InputStream instream = null;
		String text = "";
		try {
			response = httpclient.execute(httpget);
			System.out.println(response.getStatusLine());
			HttpEntity entity = response.getEntity();
			instream = entity.getContent();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(instream,"iso-8859-1"));
			text = UrlContent.buffer2String(reader);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				instream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		httpclient.getConnectionManager().shutdown();		  
		return text.toString();
	}
	
	public static String buffer2String(BufferedReader reader){
		String temp;
		String charset = null;
		StringBuffer text = new StringBuffer();
		try {
			while((temp=reader.readLine())!=null){
				System.out.println(temp);
				if(charset==null){
					int t = temp.indexOf("charset");
					if(t>0){
						int p = temp.substring(t).indexOf("\"");
					charset = temp.substring(t+7+1,t+p);
					}
				}
//				text.append(new String(temp)); 
//				text.append(new String(temp.getBytes("iso-8859-1"),"gb2312"));
//				text.append(new String(temp.getBytes(),"gb2312"));
				text.append(new String(temp.getBytes("iso-8859-1"),charset==null?"UTF-8":charset));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text.toString();
	}
	/**
	 * do search 
	 * @param pageContents
	 * @param searchString
	 * @param caseSensitive
	 * @return
	 */
	private boolean searchStringMatches(String pageContents, String searchString, boolean caseSensitive){
		String searchContents = pageContents; 
		System.out.println(pageContents);
		if (!caseSensitive) {//如果不区分大小写
			searchContents = pageContents.toLowerCase();
		}
		Pattern p = Pattern.compile("[\\s]+");//空格 tab等分隔符
		String[] terms = p.split(searchString);
		for (int i = 0; i < terms.length; i++) {
			if (caseSensitive) {
				if (searchContents.indexOf(terms[i]) == -1) {
					return false;
				}
			} else {
				if (searchContents.indexOf(terms[i].toLowerCase()) == -1) {
					return false;
				}
			} 
		}
		return true;
	}
	  
	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		
		UrlContent uc = new UrlContent();
//		System.out.println(uc.searchStringMatches(uc.downloadContent(addr1),"百度 搜狗",false));
//		System.out.println(Charset.defaultCharset());
		System.out.println(uc.searchStringMatches(uc.downloadContentuseClient(addr1),"百度 搜狗",false));

		
	}

}
