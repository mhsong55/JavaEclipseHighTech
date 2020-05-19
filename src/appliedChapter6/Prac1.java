package appliedChapter6;

import java.io.*;
import java.util.zip.*;

public class Prac1 {
	public static void main(String[] args) {
		// 원본 파일 경로
		String oriFilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer"
				+ "\\Programming\\MH_git\\Java\\Eclipse\\HighTech\\";
		String oriFileName = "save.txt";
		// 복사될 파일 경로
		String copyFilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer"
				+ "\\Programming\\MH_git\\Java\\Eclipse\\HighTech\\";
		String copyFileName = "copy.txt";
		fileCopy(oriFilePath + oriFileName, copyFilePath + copyFileName);
		// 압축된 파일 경로
		String compFilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer"
				+ "\\Programming\\MH_git\\Java\\Eclipse\\HighTech\\";
		String compFileName = "compressedFile.gz";
		compress(oriFilePath + oriFileName, compFilePath + compFileName);
		// 압축풀 파일 경로
		String decompFilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer"
				+ "\\Programming\\MH_git\\Java\\Eclipse\\HighTech\\decompFile.txt";
		String decompFileName = "decompFile.txt";
		decompress(decompFilePath + decompFileName, compFilePath + compFileName);
	}
	public static void fileCopy(String oriFilePath, String copyFilePath) {
		try {
			// 읽을 파일
			FileInputStream fis = new FileInputStream(oriFilePath);
			// 복사할 파일
			FileOutputStream fos = new FileOutputStream(copyFilePath);
			int fileByte = 0;
			// fis.read()가 -1이면 파일 다 읽은 것
			while ((fileByte = fis.read()) != -1) {
				fos.write(fileByte);
			}
			fos.flush();
			// 자원 사용 종료
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void compress(String oriFile, String compFile) {
		long startTime = System.currentTimeMillis();
		BufferedReader in;
		try {
			in = new BufferedReader
					(new FileReader(oriFile));
			BufferedOutputStream out = new BufferedOutputStream
							(new GZIPOutputStream
							(new FileOutputStream(compFile)));
			String s;
			while (null != (s = in.readLine())) {
				out.write(s.getBytes());
				out.write("\n".getBytes());
			}
			in.close();
			out.close();
			long endTime = System.currentTimeMillis();
			System.out.println("compress elapsed time : " + (endTime - startTime) + " ms");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void decompress(String decompFile, String compFile) {
		try {
			long startTime = System.currentTimeMillis();
			BufferedReader in = new BufferedReader(
								new InputStreamReader
								(new GZIPInputStream
								(new FileInputStream(compFile))));
			BufferedOutputStream out = new BufferedOutputStream
										(new FileOutputStream(decompFile));
			String s;
			while (null != (s = in.readLine())) {
				out.write(s.getBytes());
				out.write("\n".getBytes());
			}
			in.close();
			out.close();
			long endTime = System.currentTimeMillis();
			System.out.println("decompress elapsed time : " + (endTime - startTime) + " ms");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
