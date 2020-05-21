package appliedChapter6;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileoutputstreamEx {
	public static void main(String[] args) {
		try {
			String fileAddr = "c:\\Users\\MHSong\\OneDrive\\Documents"
					+ "\\Developer\\Programming\\MH_git\\Java\\Eclipse"
					+ "\\HighTech\\save.dat";
			FileOutputStream fos = new FileOutputStream(fileAddr);
			fos.write(65);	// 2진수 01000001
		    fos.flush();
		    fos.close();
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}
}
