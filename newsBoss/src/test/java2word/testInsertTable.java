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

public class testInsertTable {
  public testInsertTable() {
    Document doc = null;
    try {
      doc = new Document();
      doc.newDoc("e:/asd.doc");
      doc.insertln("�����ĵ�");
      doc.insertln("��������Ʒ�б�");
      //doc.saveAs("e:/test2.doc");
            ArrayList tableData = new ArrayList(3);
            String[] title = {
                "���", "����", "����","��ַ"};
            tableData.add(title);
            String[] field1 = {
                "1", "751002", "�������Զ�������ƽ̨","www.heavenlake.com"};
            tableData.add(field1);
            String[] field2 = {
                "2", "751004", "��Ʒ���ݹ���ϵͳ","pdm.heavenlake.com"};
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
      doc.insert(tableData,"������");
      doc.insert("������","���� 1");
      doc.insertln();
      doc.insert("�ĵ�����");
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
