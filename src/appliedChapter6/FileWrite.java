package appliedChapter6;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
	public static void main(String[] args) throws IOException {
		String fileAddr = "c:\\Users\\MHSong\\OneDrive\\Documents\\Developer"
				+ "\\Programming\\MH_git\\Java\\Eclipse\\HighTech\\save.dat";
		FileWriter fw = new FileWriter(fileAddr, true);
		fw.write("A");
		fw.flush();
		fw.close();
	}
}
