package test.java2word;
import com.heavenlake.wordapi.Document;
import java.util.List;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) ������2006</p>
 * <p>Company: ������</p>
 * @author �Թ�
 * @version 1.0
 */

public class testReadTable {
  public testReadTable() {
    Document doc = null;
    try {
      doc = new Document();
      doc.open("e:/test1.doc");
      //��ȡ��һ�ű�������(��ͷ)��ʼ��ȡ
      List tableData = doc.readTable(1, 1);
      for (int i = 0; i < tableData.size(); i++) {
        List rowData = (List) tableData.get(i);
        for (int j = 0; j < rowData.size(); j++) {
          //System.out.print("|" + rowData.get(j));
        }
        //System.out.println("|");
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      try {
        if(doc!=null) doc.close(false);
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    testReadTable testReadTable1 = new testReadTable();
  }

}
