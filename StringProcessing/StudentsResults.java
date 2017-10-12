package StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentsResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(
                String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|",
                        "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));
        String[] info = reader.readLine().split("\\s+-\\s+");
        String name = info[0];
        String[] grades = info[1].split(", ");
        double jAdv = Double.parseDouble(grades[0]);
        double javaOop = Double.parseDouble(grades[1]);
        double advOop = Double.parseDouble(grades[2]);
        double avg = (jAdv + javaOop + advOop) / 3.0;
        System.out.println(
                String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",
                        name, jAdv, javaOop, advOop, avg));


    }
}
