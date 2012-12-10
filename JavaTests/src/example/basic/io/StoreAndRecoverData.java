package example.basic.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StoreAndRecoverData {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("/root/b")
						));
		dos.writeBoolean(true);
		dos.writeDouble(3.1234);
		dos.writeUTF("a我");
		dos.close();
		
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(new FileInputStream("/root/b")));
		System.out.println(in.readBoolean());
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		in.close();

	}

}
