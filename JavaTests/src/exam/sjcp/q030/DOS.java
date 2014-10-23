package exam.sjcp.q030;

import java.io.File;
import java.io.IOException;

public class DOS {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File dir = new File("dir");
		dir.mkdir();
		File f1 =new File(dir,"f1.txt");
		try {
			f1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File newdir = new File("newdir");
		dir.renameTo(newdir);
	}

}
