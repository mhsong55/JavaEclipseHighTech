package project3rdExam;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		String oriFilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer\\Programming\\MH_git\\Java\\Eclipse\\HighTech\\src\\project3rdExam\\";
		String oriFileName = "log.csv";
		String writeFilePath = oriFilePath;
		
		String keyword = "Male";
		String writeFileName = "male.csv";
		String originalFile = oriFilePath + oriFileName;
		String writeFile = writeFilePath + writeFileName;
		genderFilteredMemberInfoToCSV(originalFile, writeFile, keyword);
		
		keyword = "Female";
		writeFileName = "female.csv";
		originalFile = oriFilePath + oriFileName;
		writeFile = writeFilePath + writeFileName;
		genderFilteredMemberInfoToCSV(originalFile, writeFile, keyword);
	}
	
	public static List<Member> getMemberData(String originalFile, String writeFile) {
		List<Member> result = new ArrayList<>();
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		StringBuilder sb = new StringBuilder();
		try {
			// 읽을 파일
			bufferedReader = new BufferedReader(
							 new FileReader(originalFile));
			bufferedWriter = new BufferedWriter(
							 new FileWriter(
							 new File(writeFile)));
			String readLineStr = "";
			String[] splittedLine;
			String memberName = "";
			int count = 0;
			while ((readLineStr = bufferedReader.readLine()) != null) {
				System.out.println(readLineStr);
				splittedLine = readLineStr.split(",");
				memberName = sb.append(splittedLine[1]).append(" ").append(splittedLine[2]).toString();
				result.add(new Member(
							Integer.parseInt(splittedLine[0])						// Member`s id
											, memberName 							// Member`s name
											, splittedLine[3]						// Member`s email
											, splittedLine[4]						// Member`s gender
											, splittedLine[5]						// Member`s signupDate
											, splittedLine[6]						// Member`s lastLoginDate
											, splittedLine[7]						// Member`s lastLoginTime
											, Double.parseDouble(splittedLine[8])	// Member`s lastLoginTime
							)
				);
				bufferedWriter.write(sb.append(readLineStr).append("\n").toString());
				bufferedWriter.flush();
				sb.setLength(0);
				count++;
			}
			System.out.println(String.format("\nTotal member count : %d\n", count));
			bufferedReader.close();
			bufferedWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			try {	// 자원 사용 종료
				if(bufferedReader != null) {
					bufferedReader.close();
				}
				if(bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			} 
		}
		return result;
	}
	
	public static void genderFilteredMemberInfoToCSV(String originalFile, String writeFile, String keyword) {
		StringBuilder sb = new StringBuilder();
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			// 읽을 파일
			bufferedReader = new BufferedReader(
							 new FileReader(originalFile));
			bufferedWriter = new BufferedWriter(
							 new FileWriter(
							 new File(writeFile)));
//			List<List<String>> line = new ArrayList<>();
			String readLineStr = "";
			String[] splittedLine;
			String keySearchRegexp = sb.append("^.*,").append(keyword).append(",.*$").toString();
			sb.setLength(0);
			int count = 0;
			while ((readLineStr = bufferedReader.readLine()) != null) {
				if(readLineStr.matches(keySearchRegexp)) {
					System.out.println(readLineStr);
					splittedLine = readLineStr.split(",");
					
					bufferedWriter.write(sb.append(readLineStr).append("\n").toString());
					bufferedWriter.flush();
					sb.setLength(0);
					count++;
				};
			}
			System.out.println(String.format("\n%s count : %d\n", keyword, count));
			bufferedReader.close();
			bufferedWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			try {	// 자원 사용 종료
				if(bufferedReader != null) {
					bufferedReader.close();
				}
				if(bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			} 
		}
	}
	
	public static void femaleMemberInfoToCSV() {
		
	}
}
/*
   		String oriFilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer\\Programming\\MH_git\\Java\\Eclipse\\HighTech\\src\\project3rdExam\\";
		String oriFileName = "log.csv";
		String writeFilePath = oriFilePath;
		String keyWord = "Male";
		String writeFileName = keyWord + "MemberInfo.csv";
		String originalFile = oriFilePath + oriFileName;
		String writeFile = writeFilePath + writeFileName;
		
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			// 읽을 파일
			bufferedReader = new BufferedReader(
							 new FileReader(oriFilePath + oriFileName));
			bufferedWriter = new BufferedWriter(
							 new FileWriter(
							 new File(writeFilePath + writeFileName)));
			List<List<String>> line = new ArrayList<>();
			String readLineStr = "";
			String[] splittedLine;
			int count = 0; 
			while ((readLineStr = bufferedReader.readLine()) != null) {
				if(readLineStr.matches("^.*,Male,.*$")) {
					System.out.println(readLineStr);
					bufferedWriter.write(readLineStr + "\n");
					bufferedWriter.flush();
					count++;
				};
//				splittedLine = readLineStr.split(",");
//				line.add(Arrays.asList(splittedLine));
//				fileWriter.write(fileByte);
			}
			System.out.println(String.format("Male count = %d", count));
			bufferedReader.close();
			bufferedWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			try {	// 자원 사용 종료
				if(bufferedReader != null) {
					bufferedReader.close();
				}
				if(bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			} 
		}
 */
