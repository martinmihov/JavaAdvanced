package QueryMethodsStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> students = new HashMap<>();

        String input = reader.readLine();
        int counter = 1;
        while (!input.equalsIgnoreCase("END")) {
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];

            students.put(firstName + counter, lastName + counter);
            counter++;
            input = reader.readLine();
        }
        students.entrySet().stream() // THAT SORTS AS IT'S SUPPOSED TO F BE!
                .sorted(Map.Entry.<String, String>comparingByValue()
                        .thenComparing(Map.Entry.<String, String>comparingByKey().reversed()))
                .forEach(x -> System.out.printf("%s %s\n",
                        x.getKey().substring(0, x.getKey().length() - 1), x.getValue().substring(0, x.getValue().length() - 1)));

    }
}
