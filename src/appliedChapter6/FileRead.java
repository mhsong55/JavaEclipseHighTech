package appliedChapter6;

import java.io.FileReader;
import java.io.IOException;

public class FileRead {
	public static void main(String[] args) throws IOException {
		String fileAddr = "c:\\Users\\MHSong\\OneDrive\\Documents\\Developer"
				+ "\\Programming\\MH_git\\Java\\Eclipse\\HighTech\\save.dat";
		// 파일 열기
		FileReader fr = new FileReader(fileAddr);
		// 내용 작성
		int i = fr.read();
		while (i != -1) {
			char ch = (char) i;
			System.out.println(ch);
			i = fr.read();
		}
		fr.close();
	}
}
