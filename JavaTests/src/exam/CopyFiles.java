package exam;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @param args
 * 编写一个程序，将d:\javasource目录下的所有.java文件复制到d:\jad目录下，并将原来文件的扩展名从.java改为.jad
 * 策略模式，FilenameFilter,值得学习
 */
public class CopyFiles {
	//创建目录和文件
	String dirs_path;
	String dirt_path;
	
	public CopyFiles(String dirs_path,String dirt_path){
		this.dirs_path = dirs_path;
		this.dirt_path = dirt_path;
	}
	
	public void init(){
		File dirs = new File(dirs_path);
		if(!dirs.exists()){
			dirs.mkdirs();
		}
		FileWriter fw ;
		try {
			fw = new FileWriter(new File(dirs.getName(),"a.java"));
			fw.write("aaaaa"+"\n");//若是window要加\r\n
			fw.write("bbbb"+"\n");
			fw.flush();
			fw = new FileWriter(new File(dirs.getName(),"b.java"));
			fw.write("bb"+"\n");//若是window要加\r\n
			fw.write("aa"+"\n");
			fw.flush();
			fw = new FileWriter(new File(dirs.getName(),"bbcjava"));
			fw.write("bb"+"\n");//若是window要加\r\n
			fw.write("aa"+"\n");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void doCopy(){
		File dirt = new File(dirt_path);
		if(!dirt.exists()){
			dirt.mkdirs();
		}
		File dirs =  new File(dirs_path);
		File[] sources = dirs.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File arg0, String arg1) {
				if(arg1.endsWith(".java")){
					return true;
				}
				return false;
			}
		});
		try {
			for (File file : sources) {
				System.out.println(file.getName().replaceAll(".java$", ".jad"));
				FileWriter fw = new FileWriter(
						new File(dirt_path,
								file.getName().replaceAll("\\.java$", ".jad")));
				//replaceAll参数次识别的是正则表达式，若不用\\. 则可以匹配ajava而不是.java,要注意
				FileReader fr = new FileReader(file);
				int str;
				while((str=fr.read())!=-1){
					fw.write(str);
				}
				fw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void doClean(){
		File dirs = new File(dirs_path);
		File dirt = new File(dirt_path);
		if(dirs.exists()){
			File[] files = dirs.listFiles();
			for (File file : files) {
				System.out.println("delete file "+ file.getName()+" "+file.delete());
			}
			System.out.println(dirs.delete());
		}
		if(dirt.exists()){
			File[] files = dirt.listFiles();
			for (File file : files) {
				System.out.println("delete file "+ file.getName()+" "+file.delete());
			}
			System.out.println(dirt.delete());
		}
	}
	public static void main(String[] args) {
		String dir_path = "javasource";
		String dit_path = "jad";
		CopyFiles cf = new CopyFiles(dir_path,dit_path);
		cf.doClean();
		cf.init();
		cf.doCopy();
	}
}
