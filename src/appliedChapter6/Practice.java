package appliedChapter6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Practice {
	public static void main(String[] args) {
		try {
			String filePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer"
					+ "\\Programming\\MH_git\\Java\\Eclipse\\HighTech\\";
			String fileName = "test.dat";
			FileReader fr = new FileReader(filePath + fileName);
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
