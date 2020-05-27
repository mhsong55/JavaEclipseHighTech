package project3rdExam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class K26_LastLoginDate { 
// implements Comparable<LocalDate> {
	private int k26_memberID = 0;
	private LocalDate k26_lastLoginDate = LocalDate.now();
	private DateTimeFormatter k26_formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	
	public K26_LastLoginDate() {}
	
	public K26_LastLoginDate(String k26_memberID, String k26_localDate) {
		this.k26_memberID = Integer.parseInt(k26_memberID);
		this.k26_lastLoginDate = LocalDate.parse(k26_localDate, k26_formatter);
	}
	
	public int getk26_MemberID() {
		return k26_memberID;
	}

	public void setk26_MemberID(int memberID) {
		this.k26_memberID = memberID;
	}


	public LocalDate getk26_LastLoginDate() {
		return k26_lastLoginDate;
	}

	public void setk26_LastLoginDate(LocalDate lastLoginDate) {
		this.k26_lastLoginDate = lastLoginDate;
	}
	
	public boolean k26_isBefore(LocalDate other) {
		
		return k26_lastLoginDate.isBefore(other);
	}
	
	public boolean k26_isAfter(LocalDate other) {
		
		return k26_lastLoginDate.isAfter(other);
	}
	
	public boolean k26_isEqual(LocalDate other) {
		
		return k26_lastLoginDate.isEqual(other);
	}
	
	@Override
	public String toString() {
		return k26_lastLoginDate.format(k26_formatter);
	}
}
