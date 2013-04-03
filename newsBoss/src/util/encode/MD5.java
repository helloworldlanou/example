package util.encode;

import java.security.MessageDigest;

public class MD5 {

    public static String encode(String s){
        char hexDigits[] = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f'};
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }catch (Exception e){
            return null;
        }
    }
    
    public static String encode2(String s)
    {
    	String x = MD5.encode(s);
    	String z1 = x.substring(0, 15);
    	String z2 = x.substring(16, 31);
    	String z = z2+z1;
    	return encode(z);
    }
    
    public static void main(String[] args) {
        String x = "qwe123";
        System.out.println(encode2(x));
        
        
        //System.out.println(x.replace("\'", ""));
        
    }
}
