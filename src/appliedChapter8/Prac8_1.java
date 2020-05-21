package appliedChapter8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Prac8_1 {
	public static void main(String[] args) {
		URL url = null;
		String filePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer"
				+ "\\Programming\\MH_git\\Java\\Eclipse\\HighTech\\files\\";
		String fileName = "icon.ico";
		InputStreamReader inputStreamReader = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			url = new URL("https://alimipro.com/favicon.ico");
			bufferedInputStream = new BufferedInputStream(url.openStream());
			inputStreamReader = new InputStreamReader(url.openStream());
			bufferedOutputStream = new BufferedOutputStream
								  (new FileOutputStream(filePath + fileName));
			int i = 0;
			while ((i = bufferedInputStream.read()) != -1) {
				bufferedOutputStream.write(i);
			}
			bufferedOutputStream.flush();
			inputStreamReader.close();
			bufferedOutputStream.close();
		} catch (MalformedURLException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			try {
				if(inputStreamReader != null) {
					inputStreamReader.close();
				}
				if(bufferedOutputStream != null) {
					bufferedOutputStream.close();
				}
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}
}
