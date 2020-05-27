package Project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import static Project.Main.Logs;

// write file to meet requirements
public class LogWrite {

    // method to write a file for Log contained recordTerm, searchTerm and saveFilepath
    // recordTerm is existing Log file's object
    // searchTerm is object to compare with recordTerm
    // saveFilepath is the path where the created file will be saved
    public static void logWrite(String recordTerm, String searchTerm, String saveFilepath) {

        // block to catch various exceptions
        // "﻿﻿﻿﻿﻿﻿﻿\uFEFF" korean broken error hedge
        // write Log file's first line
        try {
            FileWriter fw = new FileWriter("C:/Users/kopo/Desktop/" + saveFilepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.write("\uFEFF");
            pw.println("id" + "," + "full_name" + "," + "email" + "," + "gender" + "," + "signup_date"
                    + "," + "last_login_date" + "," + "last_login_time" + "," + "point");
            pw.flush();
            pw.close();

            // loop to write line by line
            for (Log log : Logs) {

                // setting values ​​for classification
                boolean eq = switch (recordTerm) {
                    case "gender" -> log.getGender().equals(searchTerm);
                    case "last_login_date" -> log.getLast_login_date().matches(searchTerm);
                    case "last_login_time" -> log.getLast_login_time().matches(searchTerm);
                    default -> false;
                };

                // write Log file line by line
                if (eq) {
                    fw = new FileWriter("C:/Users/kopo/Desktop/" + saveFilepath, true);
                    bw = new BufferedWriter(fw);
                    pw = new PrintWriter(bw);

                    pw.println(log);
                    pw.flush();
                    pw.close();
                }
            }
        } catch (Exception e) {
            System.out.println("error - 2");
        }
    }
}