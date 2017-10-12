package QueryMethodsStreamAPI;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, IntStream> students = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!input.equalsIgnoreCase("END")) {
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            List<Integer> grades = new ArrayList<>();
            for (int i = 2; i < tokens.length; i++) {
                grades.add(Integer.parseInt(tokens[i]));
            }

            students.put(firstName + " " + lastName, grades.stream().mapToInt(Integer::valueOf));

            input = reader.readLine();
        }

        students.entrySet().stream().filter(x -> x.getValue().count() < 2).forEach(x -> System.out.println(x.getKey()));
    }
}
