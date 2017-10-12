package QueryMethodsStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> students = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!input.equalsIgnoreCase("END")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            Integer age = Integer.parseInt(tokens[2]);

            students.put(name, age);

            input = reader.readLine();
        }

        students.entrySet()
                .stream()
                .filter(x -> x.getValue() >= 18 && x.getValue() <= 24)
                .forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
    }
}
