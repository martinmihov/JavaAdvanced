package QueryMethodsStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> students = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!input.equalsIgnoreCase("END")) {
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            List<Integer> grades = new ArrayList<>();
            for (int i = 2; i < tokens.length; i++) {
                grades.add(Integer.parseInt(tokens[i]));
            }

            students.put(firstName + " " + lastName, grades);

            input = reader.readLine();
        }


        students.entrySet().stream().filter(x -> x.getValue().contains(6)).forEach(x -> System.out.println(x.getKey()));
    }
}
