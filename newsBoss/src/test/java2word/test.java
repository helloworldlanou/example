package test.java2word;
/**
 * <p>Title: 测试</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 天池软件2006</p>
 * <p>Company: 天池软件 www.heavenlake.com</p>
 * @author 赵光 climber@pku.org.cn
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;

import com.heavenlake.wordapi.Document;
public class test {
  public test() {
    Document doc = null;
    try {
    	
     List l =new ArrayList();	
     for(int i=0;i<10;i++){
    	 l.add("asd"+i);
     }
     
    	
      doc = new Document();
      doc.open("d:/asd.doc");
      doc.insert("第一章：宪政概论","biaoti1");
      doc.insertAtBookmark("testbookm","第一章：宪政概论","biaoti1");
      doc.insertAtBookmark("testbookm",
                           new java.io.File("D:\\cs.JPG"));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      try {
        if(doc!=null) doc.close(true);
      }
      catch (Exception e) {
        e.printStackTrace();
      }

    }

  }

  public static void main(String[] args) {
    test test1 = new test();
  }

}
