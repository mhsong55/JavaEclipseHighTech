package JavaProject3rdExam_HNLee;

import java.util.Comparator;

public class ComparePoint implements Comparator<Log> {

    public int compare(Log log1, Log log2) {
        // convert String to double for compare
        // exception word "point"
        double pointA = 0.0;
        double pointB = 0.0;
        if (!log1.getPoint().equals("point") && !log2.getPoint().equals("point")) {
            pointA = Double.parseDouble(log1.getPoint());
            pointB = Double.parseDouble(log2.getPoint());
        } else {
            return 0;
        }
        return Double.compare(pointA, pointB) * -1;
    }
}



