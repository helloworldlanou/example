package test.java2word;
import com.heavenlake.wordapi.Document;
import java.util.List;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 天池软件2006</p>
 * <p>Company: 天池软件</p>
 * @author 赵光
 * @version 1.0
 */

public class testReadTable {
  public testReadTable() {
    Document doc = null;
    try {
      doc = new Document();
      doc.open("e:/test1.doc");
      //读取第一张表，从首行(表头)开始读取
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
