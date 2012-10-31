package example.basic.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilterWriter;
import java.io.IOException;

public class BufferedInputFile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static String read1(String filename) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuffer sb = new StringBuffer();
		while((s=in.readLine())!=null){
			sb.append(s+"\n");
		}
		in.close();
		return sb.toString();
	}
	/**
	 * 
	 * @param filename
	 * @return chinese code garble use this method
	 * @throws IOException
	 */
	public static String read2(String filename) throws IOException{
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));
		int s;
		StringBuffer sb = new StringBuffer();
		//StringBuilder st = new StringBuilder();
	 	while((s=in.read())!=-1){
			sb.append((char)s);
		}
		in.close();
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("begin——————————————————————————————————————————————————————————————————");
		System.out.println(read1("/root/a"));
		System.out.println("end—————————————————————————————————————————————————————————————————————");
		System.out.println("begin——————————————————————————————————————————————————————————————————");
		System.out.println(read2("/root/a"));
		System.out.println("end—————————————————————————————————————————————————————————————————————");

	}

}
