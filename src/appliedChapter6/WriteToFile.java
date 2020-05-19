package appliedChapter6;

import java.io.*;
public class WriteToFile {
	public static void main(String[] args) throws IOException {
		String fileAddr = "c:\\Users\\MHSong\\OneDrive\\Documents\\Developer\\"
				+ "Programming\\MH_git\\Java\\Eclipse\\HighTech\\save.dat";
		try (FileWriter fw = new FileWriter(fileAddr, true)) {
			fw.write('A');
			fw.flush();
		} catch(IOException e) {
			// 예외 처리
		}
	}
}
//	
//	{String msg = "Hello Wrold";
//	Reader reader = new StringReader(msg);
//	char ch1 = (char) reader.read();	// H
//  char ch2 = (char) reader.read();	// e
//	}
//	{
//		String fileAddr = "c:\\Users\\MHSong\\OneDrive\\Documents\\Developer\\Programming\\MH_git\\Java\\Eclipse\\HighTech\\save.dat";
//		try (FileWriter fw = new FileWriter(fileAddr, true)) {
//			fw.write('A');
//			fw.flush();
//		} catch(IOException e) {
//			// 예외 처리
//		}
//	}
//	public static void main(String[] args) {
//	String message = "This is a sample message.\n";
//	File file = new File("test1.txt");
//	FileWriter writer = null;
//	try {
//		// 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
//		writer = new FileWriter(file, true);
//		writer.write(message);
//		writer.flush();
//		System.out.println("DONE");
//	} catch(IOException e) {
//		e.printStackTrace();
//	} finally {
//		try {
//			if(writer != null) writer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}

