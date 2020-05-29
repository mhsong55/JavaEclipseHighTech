package JavaProject3rdExam_HNLee;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// read to Log file
public class LogRead {

    // variable field
    private static Scanner sc = null;

    public static String id = "id";
    public static String first_name = "first_name";
    public static String last_name = "last_name";
    public static String full_name = first_name + last_name;
    public static String email = "email";
    public static String gender = "gender";
    public static String signup_date = "signup_date";
    public static String last_login_date = "last_login_date";
    public static String last_login_time = "last_login_time";
    public static String point = "point";

    // method to create a list for Log contained filepath and compareTerm
    // filepath to import log files
    // compareTerm iis a standard word to compare to be sort
    public static List<Log> logInput(String filepath, String compareTerm) {
        List<Log> customerList = new ArrayList<>();

        // block to catch various exceptions
        try {
            // read file from file path
            // separated by delimiter ",", "\n"
            sc = new Scanner(new FileReader(filepath));
            sc.useDelimiter("[,\n]");

            // take input and stores it in each variable
            // until hasNext reach to Null
            // convert word as requirements
            // convert "Male" to "남" and "Female" to "여"
            while (sc.hasNext()) {
                id = sc.next();
                first_name = sc.next();
                last_name = sc.next();
                full_name = first_name + " " + last_name;
                email = sc.next();
                gender = sc.next();
                if (gender.equals("Male")) {
                    gender = "남";
                } else if (gender.equals("Female")) {
                    gender = "여";
                } else {
                    gender = "gender";
                }
                signup_date = sc.next();
                last_login_date = sc.next();
                last_login_time = sc.next();
                point = sc.next();

                // add newly created constructor to list
                customerList.add(new Log(id, full_name, email, gender, signup_date,
                        last_login_date, last_login_time, point));

                // compare and be sort according to requirements
                if (compareTerm.equals("point")) {
                    Collections.sort(customerList, new ComparePoint());
                } else if (compareTerm.equals("last_login_date")) {
                    Collections.sort(customerList, new CompareDate());
                } else {
                    Collections.sort(customerList);
                }

                if (!sc.hasNext()) {
                    System.out.println("save complete\n");
                }
            }
        } catch (Exception e) {
            System.out.println("error - 1");
        }
        return customerList;
    }
}