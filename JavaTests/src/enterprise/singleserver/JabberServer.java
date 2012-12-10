package enterprise.singleserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JabberServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static final int PORT  = 8082;
	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(PORT);
		try {
			System.out.println(s.toString() + " start");
			Socket socket = s.accept();
			try {
				BufferedReader in = new BufferedReader(
						new InputStreamReader(
								socket.getInputStream()));
				PrintWriter out = new PrintWriter(
						new BufferedWriter(
								new OutputStreamWriter(
										socket.getOutputStream())),true);
				while(true){
					String str = in.readLine();
					if(str.equals("end"))break;
					System.out.println("Echoing:"+str);
					out.println("server:"+str);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				System.out.println("close");
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			s.close();
		}
	}
}
