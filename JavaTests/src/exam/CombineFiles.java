package exam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 笔试题目：合并文件。要求，文件1中有回车分割，2中回车或者空格分割，分别取出1和2交替插入到文件3中，回车分割
 */
public class CombineFiles {
	
	public static void main(String[] args) {
		File a = new File("a.txt");
		File b = new File("b.txt");
		try {
			FileWriter fw = new FileWriter(a);
			fw.write("baby" + "\r\n");//windows 下不加\r的话，不换行，真恶心
			fw.write("I"+ "\n");
			fw.append("love"+ "\r\n");
			fw.append("you"+ "\r\n");
			fw.flush();
			fw = new FileWriter(b);
			fw.append("baby" + " ");
			fw.append("I"+ " ");
			fw.append("love"+ " ");
			fw.append("you"+ "\r\n");
			fw.append("ok");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File c = new File("c.txt");
		Fileproc afile = new Fileproc(a);
		Fileproc bfile = new Fileproc(b);
		try {
			FileWriter fw = new FileWriter(c);
			while(afile.hasNext()||bfile.hasNext()){
				String as= afile.getNext();
				String bs= bfile.getNext();
				if(as!=null){
					fw.append(as+"\r\n");
				}
				if(bs!=null){
					fw.append(bs+"\r\n");
				}
			}
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
 class Fileproc{
	 private File me;
	 private String [] ss;
	 int index = -1;
	public Fileproc(File a){
		this.me = a;
		try {
			BufferedReader br =new BufferedReader( new FileReader(me));
			StringBuffer sb = new StringBuffer();
			String x;
			try {
				while((x=br.readLine())!=null){
					sb.append(x+" ");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.ss = sb.toString().split(" ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public boolean hasNext(){
		if(index<ss.length-1){
			return true;
		}else return false;
	}
	public String getNext(){
		this.index++;
		if(index>=ss.length){
			return null;
		}else
		return ss[index];
	}
	
}
 