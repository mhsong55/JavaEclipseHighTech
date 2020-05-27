package project3rdExam;

import java.time.LocalDate;

public class K26_Member {
	private static StringBuilder k26_stringBuilder = new StringBuilder();
	private String k26_id;
	private String k26_name;
	private String k26_email;
	private String k26_gender;
	private String k26_signupDate;
	private K26_LastLoginDate k26_lastLoginDate;
	private String k26_lastLoginTime;
	private String k26_point;
	
	public K26_Member() {}
	
	public K26_Member(String k26_id, String k26_name, String k26_email
			, String k26_gender, String k26_signupDate, String k26_lastLoginDate,
			String k26_lastLoginTime, String k26_point) {
		this.k26_id = k26_id;
		this.k26_name = k26_name;
		this.k26_email = k26_email;
		this.k26_gender = k26_gender;
		this.k26_signupDate = k26_signupDate;
		this.k26_lastLoginDate = new K26_LastLoginDate(k26_id, k26_lastLoginDate);
		this.k26_lastLoginTime = k26_lastLoginTime;
		this.k26_point = k26_point;
	}
	public String getk26_Id() {
		return k26_id;
	}
	public void setk26_Id(String k26_id) {
		this.k26_id = k26_id;
	}
	public String getk26_Name() {
		return k26_name;
	}
	
	public void setk26_Name(String k26_name) {
		this.k26_name = k26_name;
	}
	public String getk26_Email() {
		return k26_email;
	}
	public void setk26_Email(String k26_email) {
		this.k26_email = k26_email;
	}
	public String getk26_Gender() {
		return k26_gender;
	}
	public void setk26_Gender(String k26_gender) {
		this.k26_gender = k26_gender;
	}
	public String getk26_SignupDate() {
		return k26_signupDate;
	}
	public void setk26_SignupDate(String k26_signupDate) {
		this.k26_signupDate = k26_signupDate;
	}
	public K26_LastLoginDate getk26_LastLoginDate() {
		return k26_lastLoginDate;
	}
	public void setk26_LastLoginDate(String k26_lastLoginDate) {
		this.k26_lastLoginDate.setk26_LastLoginDate(LocalDate.parse(k26_lastLoginDate));
	}
	public String getk26_LastLoginTime() {
		return k26_lastLoginTime;
	}
	public void setk26_LastLoginTime(String k26_lastLoginTime) {
		this.k26_lastLoginTime = k26_lastLoginTime;
	}
	public String getk26_Point() {
		return k26_point;
	}
	public void setk26_Point(String k26_point) {
		this.k26_point = k26_point;
	}

	@Override
	public String toString() {
		String k26_result = k26_stringBuilder.append("Member [").append(k26_id).append(", ")
						.append(k26_name).append(", ").append(k26_email).append(", ")
						.append(k26_gender).append(", ").append(k26_signupDate).append(", ")
						.append(k26_lastLoginDate.toString()).append(", ").append(k26_lastLoginTime).append(", ")
						.append(k26_point).append("]").toString();
		k26_stringBuilder.setLength(0);
		return k26_result;
	}
}
