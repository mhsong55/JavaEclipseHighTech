package JavaProject3rdExam_HNLee;

public class Log implements Comparable<Log> {

    // Log file's Object variable field
    private String id = "id";
    private String first_name = "first_name";
    private String last_name = "last_name";
    private String full_name = first_name + last_name;
    private String email = "email";
    private String gender = "gender";
    private String signup_date = "signup_date";
    private String last_login_date = "last_login_date";
    private String last_login_time = "last_login_time";
    private String point = "point";
    public static String compareTerm = "";

    // Log file's constructor
    public Log(String id, String full_name, String email, String gender, String signup_date,
               String last_login_date, String last_login_time, String point) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.gender = gender;
        this.signup_date = signup_date;
        this.last_login_date = last_login_date;
        this.last_login_time = last_login_time;
        this.point = point;
    }

    // Override method to compare to "id"
    @Override
    public int compareTo(Log o) {
        int result = 0;

        // convert String to int for compare
        // exception word "id"
        if (!this.id.equals("id") && !o.id.equals("id")) {
            int id = Integer.parseInt(this.id);
            int anotherId = Integer.parseInt(o.id);
            result = Integer.compare(id, anotherId);
        } else {
            result = 0;
        }
        return result;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getFull_name() {
        return full_name;
    }
    public void setFull_name(String full_name) {
        this.full_name = full_name;
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
    public String getSignup_date() {
        return signup_date;
    }
    public void setSignup_date(String signup_date) {
        this.signup_date = signup_date;
    }
    public String getLast_login_date() {
        return last_login_date;
    }
    public void setLast_login_date(String last_login_date) {
        this.last_login_date = last_login_date;
    }
    public String getLast_login_time() {
        return last_login_time;
    }
    public void setLast_login_time(String last_login_time) {
        this.last_login_time = last_login_time;
    }
    public String getPoint() {
        return point;
    }
    public void setPoint(String point) {
        this.point = point;
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public String toString() {
        return (id + ',' + full_name + ',' + email + ',' + gender + ',' + signup_date + ','
                + last_login_date + ',' + last_login_time + ',' + point);
    }

}

