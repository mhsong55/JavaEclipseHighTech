package project3rdExam;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class K26_Main {
	private static StringBuilder k26_stringBuilder = new StringBuilder();
	public static void main(String[] args) {
//		String oriFilePath = "E:\\onedrive\\Documents\\Developer\\HighTech\\06 Examination\\20200522_3rd Exam\\";
		String k26_oriFilePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer\\Programming\\MH_git\\Java\\Eclipse\\HighTech\\src\\project3rdExam\\";
		String k26_oriFileName = "log.csv";
		
		// log.csv file에서 모든 member data load
		List<K26_Member> k26_memberList = k26_getMemberData(k26_oriFilePath + k26_oriFileName);
		
		List<K26_Member> k26_maleMemberList = new ArrayList<>();
		List<K26_Member> k26_femaleMemberList = new ArrayList<>();
		List<K26_Member> k26_lastLoginPast3Months = new ArrayList<>();
		List<K26_Member> k26_amZeroToSixList = new ArrayList<>();
		List<K26_Member> k26_pointTop100MemberList = new ArrayList<>();
		
		int k26_maleCount = 0;
		int k26_femaleCount = 0;
		int k26_lastLoginPast3MonthsCount = 0;
		int k26_amZeroToSixCount = 0;
		int k26_lastLoginHour = 0;
		int k26_lastLoginMin = 0;
		for(K26_Member k26_member : k26_memberList) {
			if(k26_member.getk26_Gender().contentEquals("Male")) {
				// #1. 남자 고객 정보가 id 순서대로 저장된 male.csv 파일 생성
				// gender "Male" -> "남" 으로 변경
				k26_member.setk26_Gender("남");
				// maleMemberList에 add
				k26_maleMemberList.add(k26_member);
				k26_maleCount++;
			} else {
				// #2. 여자 고객 정보가 id 순서대로 저장된 female.csv 파일 생성
				// gender "Female" -> "여" 변경
				k26_member.setk26_Gender("여");
				// gender != Male인 member를 femaleMemberList에 add
				k26_femaleMemberList.add(k26_member);
				k26_femaleCount++;
			}
			/* #3. 마지막으로 접속한 날짜가 최근 3달 이내인 고객을 접속 날짜가 
			 * 	    오래된 순서대로 정렬하여 저장된 last_login.csv file export 
			 *     - 이번 달이 5월 22일이면 최근 3달의 정의는 5, 4, 3월에 접속한 것으로 한다.*/
			// 1. if(lastLoginDate의 year == LocalDate.getYear()? --> true) 
			// 2. if(lastLoginDate의 month >= 3 && month <= 5 ? --> true)
			// 3. lastLoginPast3Months.add(Member)
			if(k26_member.getk26_LastLoginDate().getk26_LastLoginDate().getYear() == LocalDate.now().getYear()) {
				if((k26_member.getk26_LastLoginDate().getk26_LastLoginDate().getMonthValue() >= 3)
						&& (k26_member.getk26_LastLoginDate().getk26_LastLoginDate().getMonthValue() <= 5)) {
					k26_lastLoginPast3Months.add(k26_member);
					k26_lastLoginPast3MonthsCount++;
				}
			}
			/* #4. 마지막 로그인 시간 정보를 토대로 새벽 시간대 AM 00:00 ~ AM 06:00)에 접속한
			 * 	    고객정보가 id 순서대로 저장된 am.csv file export */ 
			if(k26_member.getk26_LastLoginTime().matches("^.*AM$")) {
				k26_lastLoginHour = Integer.parseInt(k26_member.getk26_LastLoginTime().split(":")[0]);
				k26_lastLoginMin = Integer.parseInt(k26_member.getk26_LastLoginTime().split(":")[1].substring(0, 1));
				if(LocalTime.of(k26_lastLoginHour, k26_lastLoginMin).isBefore(LocalTime.of(6, 0))) {
					k26_amZeroToSixList.add(k26_member);
					k26_amZeroToSixCount++;
				}
			}
		}
		
		// #1., #2., #4. ID 순으로 정렬
		K26_IDComparator k26_idComparator = new K26_IDComparator();
		Collections.sort(k26_maleMemberList, k26_idComparator);
		Collections.sort(k26_femaleMemberList, k26_idComparator);
		Collections.sort(k26_amZeroToSixList, k26_idComparator);
		
		// #3. 오래된 순으로 정렬
		Collections.sort(k26_lastLoginPast3Months, new K26_LastLoginDateComparator());
		
		// #5. 포인트가 가장 많은 순으로 상위 100명의 정보를 best.csv file export 
		Collections.sort(k26_memberList, new K26_PointComparator());
		k26_memberList.stream().limit(100).forEach(k26_element -> k26_pointTop100MemberList.add(k26_element));
		
		// 결과 확인을 위한 Console 출력
		// Male member list
		System.out.println("\nMale Member List\n");
		k26_maleMemberList.stream().forEach(System.out::println);
		System.out.println(String.format("\nMale Count : %d\n", k26_maleCount));
		
		// Female member list
		System.out.println("\nFemale Member List\n");
		k26_femaleMemberList.stream().forEach(System.out::println);
		System.out.println(String.format("\nFemale Count : %d\n", k26_femaleCount));
		
		// Last Login Date, past 3 Months
		System.out.println("\nMembers List during Last Login Date of past 3 Months\n");
		k26_lastLoginPast3Months.stream().forEach(System.out::println);
		System.out.println(String.format("\nLastLoginPast3Months Count : %d\n", k26_lastLoginPast3MonthsCount));
		
		// Last Login Time, 00:00 ~ 06:00 AM
		System.out.println("\nMembers List of Last Login Time is 00:00 ~ 06:00 AM\n");
		k26_amZeroToSixList.stream().forEach(System.out::println);
		System.out.println(String.format("\nLastLoginPast3Months Count : %d\n", k26_amZeroToSixCount));
		
		// Member List of Top 100 of Point
		System.out.println("\nMember List of Top 100 of Point\n");
		k26_pointTop100MemberList.stream().forEach(System.out::println);
		System.out.println(String.format("\npointTop100MemberList Size : %d\n", k26_pointTop100MemberList.size()));
		
		// maleMemberList의 Member data를 male.csv file에 write
		String writeFilePath = k26_oriFilePath;
		String writeFileName = "male.csv";
		k26_memberDataToCSV(k26_maleMemberList, writeFilePath + writeFileName);
		
		// femaleMemberList의 Member data를 female.csv file에 write
		writeFilePath = k26_oriFilePath;
		writeFileName = "female.csv";
		k26_memberDataToCSV(k26_femaleMemberList, writeFilePath + writeFileName);
		
		// lastLoginPast3Months의 Member data를 last_login.csv file에 write
		writeFilePath = k26_oriFilePath;
		writeFileName = "last_login.csv";
		k26_memberDataToCSV(k26_lastLoginPast3Months, writeFilePath + writeFileName);
		
		// amZeroToSixList의 Member data를 am.csv file에 write
		writeFilePath = k26_oriFilePath;
		writeFileName = "am.csv";
		k26_memberDataToCSV(k26_amZeroToSixList, writeFilePath + writeFileName);
		
		// pointTop100MemberList의 Member data를 best.csv file에 write
		writeFilePath = k26_oriFilePath;
		writeFileName = "best.csv";
		k26_memberDataToCSV(k26_pointTop100MemberList, writeFilePath + writeFileName);
	}
	
	public static List<K26_Member> k26_getMemberData(String readFilePath) {
		List<K26_Member> k26_result = new ArrayList<>();
		BufferedReader k26_bufferedReader = null;
		try {
			// 읽을 파일
			k26_bufferedReader = new BufferedReader(
							 new FileReader(readFilePath));
			String k26_readLineStr = "";
			String[] k26_splittedLine;
			String k26_memberName = "";
			String k26_header = "id,first_name,last_name,email,gender,signup_date,last_login_date,last_login_time,point";
			String[] k26_lastLoginDateSplitted = new String[3];
			while ((k26_readLineStr = k26_bufferedReader.readLine()) != null) {
				if(!k26_readLineStr.equals(k26_header)) {
					k26_splittedLine = k26_readLineStr.split(",");
					
					// For LocalTime Formatter("yyyy/MM/dd")
					// Ref: https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_OFFSET_DATE_TIME
					if(k26_splittedLine[6].length() != "MM/dd/yyyy".length()) {
						k26_lastLoginDateSplitted = k26_splittedLine[6].split("/");
						if(k26_lastLoginDateSplitted[0].length() == 1) {
							k26_lastLoginDateSplitted[0] = k26_strOneToTwoFormat(k26_lastLoginDateSplitted[0]);
						}
						if(k26_lastLoginDateSplitted[1].length() == 1) {
							k26_lastLoginDateSplitted[1] = k26_strOneToTwoFormat(k26_lastLoginDateSplitted[1]);
						}
						for(int i=0; i < k26_lastLoginDateSplitted.length; i++) {
							if(i != (k26_lastLoginDateSplitted.length - 1)) {
								k26_stringBuilder.append(k26_lastLoginDateSplitted[i]).append("/");
							} else {
								k26_stringBuilder.append(k26_lastLoginDateSplitted[i]);
							}
						}
						k26_splittedLine[6] = k26_stringBuilder.toString();
						k26_stringBuilder.setLength(0);
					}
						
					// name format change : "first_name" + "last_name" = "first_name last_name" 
					k26_memberName = k26_stringBuilder.append(k26_splittedLine[1]).append(" ").append(k26_splittedLine[2]).toString();
					
					k26_result.add(new K26_Member(
										k26_splittedLine[0]		// Member`s id
										, k26_memberName 		// Member`s name
										, k26_splittedLine[3]	// Member`s email
										, k26_splittedLine[4]	// Member`s gender
										, k26_splittedLine[5]	// Member`s signupDate
										, k26_splittedLine[6]	// Member`s lastLoginDate
										, k26_splittedLine[7]	// Member`s lastLoginTime
										, k26_splittedLine[8])	// Member`s point
					);
				}
				k26_stringBuilder.setLength(0);
			}
			k26_bufferedReader.close();
		} catch (FileNotFoundException k26_Error) {
			System.out.println(k26_Error.getLocalizedMessage());
		} catch (IOException k26_Error) {
			System.out.println(k26_Error.getLocalizedMessage());
		} finally {
			try {	// 자원 사용 종료
				if(k26_bufferedReader != null) {
					k26_bufferedReader.close();
				}
			} catch (IOException k26_Error) {
				System.out.println(k26_Error.getLocalizedMessage());
			} 
		}
		return k26_result;
	}
	
	public static String k26_strOneToTwoFormat (String k26_oneString) {
		String k26_result = k26_stringBuilder.append("0").append(k26_oneString).toString(); 
		k26_stringBuilder.setLength(0);
		return k26_result;
	}
	
	public static void k26_memberDataToCSV(List<K26_Member> k26_memberList, String k26_outFilePath) {
		BufferedWriter k26_bufferedWriter = null;
		try {
			// 읽을 파일
			k26_bufferedWriter = new BufferedWriter(
							 new FileWriter(
							 new File(k26_outFilePath)));
			String k26_logHeader = "id,name,email,gender,signup_date,last_login_date,last_login_time,point\n";
			k26_bufferedWriter.write(k26_logHeader);
			k26_bufferedWriter.flush();
			String[] k26_lastLoginDateSplitted = new String[3];
			String k26_manipulatedStr = "";
			StringBuilder k26_dateStrManipulateSB = new StringBuilder();
			for(K26_Member k26_member : k26_memberList) {
			k26_lastLoginDateSplitted = k26_member.getk26_LastLoginDate().toString().split("/");
			k26_stringBuilder.append(k26_member.getk26_Id()).append(",").append(k26_member.getk26_Name()).append(",")
			.append(k26_member.getk26_Email()).append(",").append(k26_member.getk26_Gender()).append(",")
			.append(k26_member.getk26_SignupDate()).append(",");
			for(String k26_zeroCheckStr : k26_lastLoginDateSplitted) {
				if(k26_zeroCheckStr.length() == 2) {
					if(k26_zeroCheckStr.charAt(0) == '0') {
						k26_dateStrManipulateSB.append(k26_zeroCheckStr.substring(1)).append("/");
					} else {
						k26_dateStrManipulateSB.append(k26_zeroCheckStr).append("/");
					}
				} else {
					k26_dateStrManipulateSB.append(k26_zeroCheckStr);
					k26_manipulatedStr = k26_dateStrManipulateSB.toString();
					k26_dateStrManipulateSB.setLength(0);
				}
			}
			k26_stringBuilder.append(k26_manipulatedStr).append(",")
					.append(k26_member.getk26_LastLoginTime()).append(",")
					.append(k26_member.getk26_Point()).append("\n");
			k26_bufferedWriter.write(k26_stringBuilder.toString());
			k26_bufferedWriter.flush();
			k26_stringBuilder.setLength(0);
			}
			k26_bufferedWriter.close();
		} catch (FileNotFoundException k26_Error) {
			System.out.println(k26_Error.getLocalizedMessage());
		} catch (IOException k26_Error) {
			System.out.println(k26_Error.getLocalizedMessage());
		} finally {
			try {	// 자원 사용 종료
				if(k26_bufferedWriter != null) {
					k26_bufferedWriter.close();
				}
			} catch (IOException k26_Error) {
				System.out.println(k26_Error.getLocalizedMessage());
			} 
		}
	}
}
