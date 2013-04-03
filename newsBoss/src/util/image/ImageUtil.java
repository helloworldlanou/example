package util.image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
public class ImageUtil {
	/**
	 * �ж���Ƭ���� .jpg .png .gif Ŀǰֻ֧�������ָ�ʽ
	 * 
	 * @param file
	 * @return
	 */
	public static boolean isPhoto(String fileName){
		fileName = getString(fileName);
		if (fileName.equals(""))
			return false;
		if ((fileName.toLowerCase().endsWith(".jpg"))
				|| (fileName.toLowerCase().endsWith(".gif"))
				|| (fileName.toLowerCase().endsWith(".png")))
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String getString(String str) {
		if (str == null)
			str = "";
		if (str.equals("null"))
			str = "";
		str = str.trim();
		return str;
	}

	/**
	 * �ж��ļ��Ƿ����
	 * 
	 * @param fileName
	 * @param dir
	 * @return
	 */
	public static boolean isFileExist(String fileName, String dir) {
		File files = new File(dir + fileName);
		return (files.exists()) ? true : false;
	}

	/**
	 * ������
	 * 
	 * @param fileName
	 * @param dir
	 */
	public static void rename(String fileName, String dir) {
		String extendFile = "";
		if (isJpg(fileName))
			extendFile = ".jpg";
		else if (isGif(fileName))
			extendFile = ".gif";
		else if (isPng(fileName))
			extendFile = ".png";
		else
			extendFile = ".jpg";
		Random random = new Random();
		int add = random.nextInt(10000);
		String ret = fileName + add + extendFile;
		while (isFileExist(ret, dir)) {
			UUID uuid = UUID.randomUUID();
			ret = fileName + uuid.toString() + extendFile;
		}
		File file = new File(dir + fileName);
		File reFile = new File(dir + ret);
		file.renameTo(reFile);
	}
	
	public static String rename(String fileName) {
		String extendFile = "";
		if (isJpg(fileName))
			extendFile = ".jpg";
		else if (isGif(fileName))
			extendFile = ".gif";
		else if (isPng(fileName))
			extendFile = ".png";
		else
			extendFile = ".jpg";
		UUID uuid = UUID.randomUUID();
		return uuid + extendFile;

	}

	public static boolean isGif(String file) {
		if (file.toLowerCase().endsWith(".gif")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isJpg(String file) {
		if (file.toLowerCase().endsWith(".jpg")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isPng(String file) {
		if (file.toLowerCase().endsWith(".png")) {
			return true;
		} else {
			return false;
		}
	}
	
	//�õ�����ͼ��ԭͼ���ļ���
	public static String getSmallPic(String path,String bigName,Integer newWidth){
		String ext = bigName.substring(bigName.indexOf("."),bigName.length());
		String big = bigName.substring(0,bigName.indexOf("."));
		try {
		    java.io.File file = new java.io.File(path+bigName);//����ղ��ϴ����ļ�
		    String small=path+"\\"+big+"_min"+ext;  //�µ�����ͼ�����ַ
		    Image src = javax.imageio.ImageIO.read(file);//����Image����
		    float tagsize=newWidth;//������ͼ�Ŀ��
		    int old_w=src.getWidth(null); //�õ�Դͼ��
		    int old_h=src.getHeight(null); //�õ�Դͼ��  
		    int new_w=0;
		    int new_h=0;
		    float tempdouble; 
		    if(old_w>old_h){
		     tempdouble=old_w/tagsize;
		    }else{
		     tempdouble=old_h/tagsize;
		    }
		    new_w=Math.round(old_w/tempdouble);
		    new_h=Math.round(old_h/tempdouble);//������ͼ����
		    BufferedImage tag = new BufferedImage(new_w,new_h,BufferedImage.TYPE_INT_RGB);
		    tag.getGraphics().drawImage(src,0,0,new_w,new_h,null);       //������С���ͼ
		    FileOutputStream newimage = null;
			
				newimage = new FileOutputStream(small);
			     //������ļ���
		    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);       
		    encoder.encode(tag);                                               //��JPEG����
		    newimage.close(); 
		    
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ImageFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
			return big+"_min"+ext;
	}
	
}
