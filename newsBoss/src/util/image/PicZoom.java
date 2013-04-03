package util.image;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class PicZoom
{
    public static BufferedImage zoom(String srcFileName,
                                     int outputWidth,
                                     int outputHeight)
    {
        //ʹ��Դͼ���ļ�������ImageIcon����
        ImageIcon imgIcon=new ImageIcon(srcFileName);
        //�õ�Image����
        Image img=imgIcon.getImage();
        
        
        return zoom(img,outputWidth,outputHeight);
    }
    
    public static BufferedImage zoom(Image srcImage,
                                     int outputWidth,
                                     int outputHeight)
    {
        //����һ��Ԥ�����ͼ�����͵�BufferedImage����
        BufferedImage buffImg=new BufferedImage(outputWidth,outputHeight,
                                                BufferedImage.TYPE_INT_RGB);
                                                
        //����Graphics2D����������BufferedImage�����ϻ�ͼ��
        Graphics2D g=buffImg.createGraphics();
        
        //����ͼ�������ĵĵ�ǰ��ɫΪ��ɫ��
        g.setColor(Color.WHITE);
        //��ͼ�������ĵĵ�ǰ��ɫ���ָ���ľ�������
        g.fillRect(0,0,outputWidth,outputHeight);
        
        //�������ŵĴ�С��BufferedImage�����ϻ���ԭʼͼ��
        g.drawImage(srcImage,0,0,outputWidth,outputHeight,null);
        //�ͷ�ͼ��������ʹ�õ�ϵͳ��Դ��
        g.dispose();
        
        return buffImg;
    }
}