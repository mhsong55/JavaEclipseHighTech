package appliedChapter7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class Practice1 {
	public static void main(String[] args) {
		// 읽어들일 file의 경로
		String filePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer"
				+ "\\Programming\\MH_git\\Java\\Eclipse\\HighTech\\";
		// 읽을 파일 이름
		String fileName = "gradle.properties";
		// Properties 객체 선언 : 읽어올 Properties file의 내용 handling 목적
		Reader reader = null;
		Properties prop = new Properties();
		try {
			// file을 읽는 객체 reader를 Reader타입으로 생성
			// reader는 이미 설정한 file을 읽는다.
			reader = new FileReader(filePath + fileName);
			prop.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("android.useAndroidX"));
	}
}
