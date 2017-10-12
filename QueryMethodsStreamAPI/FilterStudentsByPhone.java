package QueryMethodsStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> students = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!input.equalsIgnoreCase("END")) {
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            String phone = tokens[2];

            students.put(firstName + " " + lastName, phone);

            input = reader.readLine();
        }

        students.entrySet().stream().filter(x -> x.getValue().startsWith("02") || x.getValue().startsWith("+3592")).forEach(x -> System.out.println(x.getKey()));
    }
}
