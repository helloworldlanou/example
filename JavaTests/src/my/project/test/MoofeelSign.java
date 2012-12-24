package my.project.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
/**
 * 参考：http://blog.csdn.net/mxiaochi/article/details/7255508
 * @author root
 *
 */
public class MoofeelSign {

	private static String site = "http://www.moofeel.com/forum-96-1.html";
	 private static String loginUrl = "http://www.moofeel.com/member.php?mod=logging&action=login&loginsubmit=yes&infloat=yes";
	 private static String userName = "username";
	 private static String passWord = "password";

	 // The HttpClient is used in one session
	 private static HttpResponse response;
	 private static DefaultHttpClient httpclient = new DefaultHttpClient();

	 public static void main(String[] args) throws Exception {
		 MoofeelSign moofeel = new MoofeelSign();
		 moofeel.printText();
	 }

	 private boolean login() {
	  HttpPost httpost = new HttpPost(loginUrl);
	  // All the parameters post to the web site
	  List<NameValuePair> nvps = new ArrayList<NameValuePair>();
	  //下面标记部分需替换为真实账号密码
	  nvps.add(new BasicNameValuePair(userName, "nightfight"));
	  nvps.add(new BasicNameValuePair(passWord, "nightfight"));

	  try {
	   httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
	   response = httpclient.execute(httpost);
	  } catch (Exception e) {
	   e.printStackTrace();
	   return false;
	  } finally {
	   httpost.abort();
	  }
	  return true;
	 }

	 

	 private String getText(String redirectLocation) {
	  HttpGet httpget = new HttpGet(redirectLocation);
	  // Create a response handler
	  ResponseHandler<String> responseHandler = new BasicResponseHandler();
	  String responseBody = "";
	  try {
	   responseBody = httpclient.execute(httpget, responseHandler);
	  } catch (Exception e) {
	   e.printStackTrace();
	   responseBody = null;
	  } finally {
	   httpget.abort();
	   httpclient.getConnectionManager().shutdown();
	  }
	  return responseBody;
	 }

	 public void printText() {
	  if (login()) {
	   System.out.println();
	   Document doc = Jsoup.parse(getText(site));
	  }
	 }

}
