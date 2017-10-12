package ObjectsClassesAndCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, double[]> listStudents = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            double[] stgrades = Arrays.stream(reader.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
//            double sum = 0d;
//            for (int j = 0; j < stgrades.length; j++) {
//                sum += stgrades[j];
//            }
//            double average = sum/stgrades.length;
            listStudents.put(input, stgrades);
        }

        for (Map.Entry<String, double[]> student: listStudents.entrySet()) {
            System.out.printf("%s is graduated with %f\n", student.getKey(),student.getValue());
        }

    }
}


