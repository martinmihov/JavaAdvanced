package QueryMethodsStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        String input = reader.readLine();
        Map<String, List<String>> students = new HashMap<>();
        while (true) {
            String input = reader.readLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            } else if(input.equalsIgnoreCase("")){
                System.out.println();
                break;
            } else {
                String[] info = input.split("\\s+");
                String firstName = info[0];
                String secondName = info[1];
                String group = info[2];

                if (!students.containsKey(firstName)) {
                    students.put(firstName, new ArrayList<>());
                }
                students.get(firstName).add(secondName + " " + group);
            }
//            input = reader.readLine();

        }

        List<Map.Entry<String, List<String>>> collect = students.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .filter(x -> x.getValue().toString().contains("2"))
                .collect(Collectors.toList());

        for (Map.Entry<String, List<String>> studentNames : collect) {
            for (int i = 0; i < studentNames.getValue().size(); i++) {
                System.out.println(studentNames.getKey() + " " + studentNames.getValue().get(i).substring(0, studentNames.getValue().get(i).length() - 2));
            }
        }

    }
}
