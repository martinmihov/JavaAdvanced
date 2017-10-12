package QueryMethodsStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentsEntrolledIn2014or2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> students = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!input.equalsIgnoreCase("END")) {
            String[] tokens = input.split("\\s+");
            String year = tokens[0];
            List<Integer> grades = new ArrayList<>();
            for (int i = 1; i < tokens.length; i++) {
                grades.add(Integer.parseInt(tokens[i]));
            }

            students.put(year, grades);

            input = reader.readLine();
        }

        students.entrySet().stream().filter(x -> x.getKey().endsWith("14") || x.getKey().endsWith("15"))
                .forEach(x -> System.out.println(String.join(" ", x.getValue().toString())));

    }
}
