package test.java2word;
import com.heavenlake.wordapi.Document;
import java.util.ArrayList;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) ������2006</p>
 * <p>Company: ������</p>
 * @author �Թ�
 * @version 1.0
 */

public class testMerge {
  public testMerge() {
    Document doc = null;
    try {
      doc = new Document();
      doc.open("e:/test4.doc");
      //doc.mergeCell(1,2,2,4,5);
      doc.mergeCell(1,2,2,4,5,"�ϲ�����������");
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
    testMerge test1 = new testMerge();
  }

}
