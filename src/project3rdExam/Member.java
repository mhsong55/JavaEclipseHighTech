package project3rdExam;

public class Member {
	private int id;
	private String name;
	private String email;
	private String gender;
	private String signupDate;
	private String lastLoginDate;
	private String lastLoginTime;
	private double point;
	
	public Member() {}
	
	public Member(int id, String name, String email, String gender, String signupDate, String lastLoginDate,
			String lastLoginTime, double point) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.signupDate = signupDate;
		this.lastLoginDate = lastLoginDate;
		this.lastLoginTime = lastLoginTime;
		this.point = point;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSignupDate() {
		return signupDate;
	}
	public void setSignupDate(String signupDate) {
		this.signupDate = signupDate;
	}
	public String getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	
	
}
