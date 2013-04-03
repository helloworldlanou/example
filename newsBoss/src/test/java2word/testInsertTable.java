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

public class testInsertTable {
  public testInsertTable() {
    Document doc = null;
    try {
      doc = new Document();
      doc.newDoc("e:/asd.doc");
      doc.insertln("测试文档");
      doc.insertln("天池软件产品列表");
      //doc.saveAs("e:/test2.doc");
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

                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                tableData.add(field2);
                
      //doc.insert(tableData);
      doc.insert(tableData,"流行型");
      doc.insert("表格结束","标题 1");
      doc.insertln();
      doc.insert("文档结束");
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
    testInsertTable test1 = new testInsertTable();
  }

}
