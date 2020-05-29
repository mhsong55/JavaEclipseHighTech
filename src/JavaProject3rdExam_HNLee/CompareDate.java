package JavaProject3rdExam_HNLee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class CompareDate implements Comparator<Log> {

    public int compare(Log log1, Log log2) {
        // convert String to date for compare
        // exception word "last_login_date"
        int result = 0;
        try {
            if (!log1.getLast_login_date().equals("last_login_date")
                    && !log2.getLast_login_date().equals("last_login_date")) {
                SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
                Date dateA = format.parse(log1.getLast_login_date());
                Date dateB = format.parse(log2.getLast_login_date());

                result = (dateA.compareTo(dateB));
            } else {
                result = 0;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
