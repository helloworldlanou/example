package test.java2word;
/**
 * <p>Title: ����</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) ������2006</p>
 * <p>Company: ������ www.heavenlake.com</p>
 * @author �Թ� climber@pku.org.cn
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
      doc.insert("��һ�£���������","biaoti1");
      doc.insertAtBookmark("testbookm","��һ�£���������","biaoti1");
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
