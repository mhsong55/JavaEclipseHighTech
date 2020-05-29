package JavaProject3rdExam_HNLee;

import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    public static String compareTerm = null;
    public static List<Log> Logs = null;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // declaration of Boolean for loop
        boolean isContinue = false;

        // do- while to return to the initial menu
        // block to catch various exceptions
        do {
            try {
                System.out.println("what you want to search");
                System.out.println("[1] classify gender");
                System.out.println("[2] classify within three months");
                System.out.println("[3] classify dawn time");
                System.out.println("[4] classify point top 100");

                int searchN = sc.nextInt();
                String recordTerm = "";
                String searchTerm = "";
                String saveFilepath = "";
                String filepath = "C:/Users/kopo/Desktop/Log.csv";

                if (searchN == 1) {
                    System.out.println("select gender");
                    System.out.println("[1] Female");
                    System.out.println("[2] Male");
                    int genderN = sc.nextInt();

                    if (genderN == 1) {
                        recordTerm = "gender";
                        searchTerm = "여";
                        saveFilepath = "female.csv";
                        compareTerm = "id";
                        Logs = LogRead.logInput(filepath, compareTerm);
                        LogWrite.logWrite(recordTerm, searchTerm, saveFilepath);
                    } else if (genderN == 2) {
                        recordTerm = "gender";
                        searchTerm = "남";
                        saveFilepath = "male.csv";
                        compareTerm = "id";
                        Logs = LogRead.logInput(filepath, compareTerm);
                        LogWrite.logWrite(recordTerm, searchTerm, saveFilepath);
                    } else {
                        System.out.println("*****pressed wrong key*****\n");
                        isContinue = true;
                    }

                } else if (searchN == 2) {
                    SimpleDateFormat format = new SimpleDateFormat("M/dd/yyyy");
                    Calendar cal = Calendar.getInstance();
                    String currentMonth = format.format(cal.getTime());
                    String[] date = currentMonth.split("/");
                    int baseMonth = Integer.parseInt(date[0]);
                    int baseYear = Integer.parseInt(date[2]);
                    // base time, standard time is current time
                    System.out.println("Base date : " + currentMonth + "\n");
                    // regular expression of 3 months
                    recordTerm = "last_login_date";
                    searchTerm = baseMonth + "/[1-2]?[0-9]/" + baseYear
                            + "|" + (baseMonth - 1) + "/[1-2]?[0-9]/"
                            + baseYear + "|" + (baseMonth - 2)
                            + "/[1-2]?[0-9]/" + baseYear
                            + "|" + baseMonth + "/[3][0-1]/"
                            + baseYear + "|" + (baseMonth - 1)
                            + "/[3][0-1]/" + baseYear + "|"
                            + (baseMonth - 2) + "/[3][0-1]/" + baseYear;
                    saveFilepath = "last_login.csv";
                    compareTerm = "last_login_date";
                    Logs = LogRead.logInput(filepath, compareTerm);
                    LogWrite.logWrite(recordTerm, searchTerm, saveFilepath);

                } else if (searchN == 3) {
                    // regular expression of from 12:00 AM to 6:00 AM
                    recordTerm = "last_login_time";
                    searchTerm = "^[0-5]:[0-5][0-9] AM|^6:0+ AM|^12:[0-5][0-9] AM";
                    saveFilepath = "am.csv";
                    compareTerm = "id";
                    Logs = LogRead.logInput(filepath, compareTerm);
                    LogWrite.logWrite(recordTerm, searchTerm, saveFilepath);

                } else if (searchN == 4) {
                    saveFilepath = "best.csv";
                    compareTerm = "point";
                    Logs = LogRead.logInput(filepath, compareTerm);
                    LogWriteRank100.logWriteRank100(saveFilepath);

                } else {
                    System.out.println("*****enter correct key*****\n");
                    sc.nextLine();
                    isContinue = true;
                }

                System.out.println("saved complete your wants");

            } catch (InputMismatchException e) {
                System.out.println("*****enter correct key*****\n");
                sc.nextLine();
                isContinue = true;
            } catch (Exception e) {
                System.out.println("error - shut down the system");
                System.out.println("____________b y e___________\n\n\n");
                isContinue = false;
            }
        } while (isContinue);
    }
}
