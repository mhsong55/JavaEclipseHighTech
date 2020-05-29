package JavaProject3rdExam_HNLee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static JavaProject3rdExam_HNLee.Main.Logs;

// requirements is point rank 100
// if used together with method LogWrite, it becomes complicated and classified separately
public class LogWriteRank100 {
    public static void logWriteRank100(String saveFilepath) {

        // block to catch various exceptions
        // if index equals 100, loop stop
        try {
            rankLoop:
            for (int i = 0; i < 101; i++) {

                FileWriter fw = new FileWriter("C:/Users/kopo/Desktop/" + saveFilepath, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.write("\uFEFF");
                pw.println(Logs.get(i));
                pw.flush();
                pw.close();
                if (i == 100) {
                    break rankLoop;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}