package enterprise.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import enterprise.singleserver.JabberServer;

public class JabberClient {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InetAddress addr = InetAddress.getByName(null);
		System.out.println("addr = " + addr);
		Socket socket = new Socket(addr,JabberServer.PORT);
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
			PrintWriter out = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
									socket.getOutputStream())),true);
			for(int i=0;i<10;i++){
				out.println("howdy"+i);
//				String str = in.readLine();
//				System.out.println(str);
			}
			System.out.println("out all!");
			while(in.readLine()!=null){
				String str = in.readLine();
				System.out.println(str);
			}
			
			
			out.print("end");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			System.out.println("client closing...");
			socket.close();
		}
	}

}
