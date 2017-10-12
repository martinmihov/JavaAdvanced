package QueryMethodsStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        Map<String, String> students = new LinkedHashMap<>();

        int counter = 1;
        while (!input.equalsIgnoreCase("END")) {
            String[] info = input.split("\\s+");
            String firstName = info[0];
            String secondName = info[1];
            students.put(firstName + counter, secondName);
            counter++;
            input = reader.readLine();

        }

        List<Map.Entry<String, String>> collect = students.entrySet()
                .stream()
                .filter(x -> x.getKey().compareTo(x.getValue()) < x.getValue().compareTo(x.getKey())).collect(Collectors.toList());
        for (Map.Entry<String, String> studentNames : collect) {
            System.out.println(studentNames.getKey().substring(0, studentNames.getKey().length() - 1) + " " + studentNames.getValue());

        }
    }
}
