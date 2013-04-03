package test.java2word;
import com.heavenlake.wordapi.Document;
import java.util.ArrayList;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 天池软件2006</p>
 * <p>Company: 天池软件</p>
 * @author 赵光
 * @version 1.0
 */

public class testReplaceTable {
  public testReplaceTable() {
    Document doc = null;
    try {
      doc = new Document();
      doc.open("e:/test4.doc");
            ArrayList tableData = new ArrayList(3);
            String[] title = {
                "序号", "代码", "名称","网址"};
            tableData.add(title);
            String[] field1 = {
                "1", "751002", "天池软件自动化生产平台","www.heavenlake.com"};
            tableData.add(field1);
            String[] field2 = {
                "2", "751004", "产品数据管理系统","pdm.heavenlake.com"};
            tableData.add(field2);
      //doc.replaceTable(1,3,2,tableData,"标题 1");
      doc.replaceTable(1,2,2,tableData);
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
    testReplaceTable test1 = new testReplaceTable();
  }

}
