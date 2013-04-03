package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class Download {
    //�½�һ��SmartUpload����
    SmartUpload su = new SmartUpload();
    
    public void download(PageContext pc,String fileName){

        //filename = toUtf8String(filename);
        try {
            su.initialize(pc);
            //��ֹ������Լ����ļ�
            su.setContentDisposition(null);
            su.downloadFile(fileName);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
    }

    public static String toUtf8String(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("utf-8");
                } catch (Exception ex) {
                    //System.out.println(ex);
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0)
                        k += 256;
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String hs = "�����Ǹ������.txt";
        hs = toUtf8String(hs);
        //System.out.println(hs);

    }

}
