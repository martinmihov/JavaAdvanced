package StringProcessingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsername {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(?<=[\\/\\\\() ]|^)[a-zA-Z][a-zA-Z0-9_]{2,25}(?=[\\/\\\\() ]|$)");

        String input = reader.readLine();
        Matcher matcher = pattern.matcher(input);
        List<String> names = new ArrayList<>();
        while (matcher.find()) {
            names.add(matcher.group());
        }
        int maxLength = -1;
        int firstIndex = 0;

        for (int i = 0; i < names.size() - 1; i++) {
            int currentLen = names.get(i).length() + names.get(i + 1).length();
            if (currentLen > maxLength) {
                maxLength = currentLen;
                firstIndex = i;
            }
        }
        System.out.println(names.get(firstIndex));
        System.out.println(names.get(firstIndex + 1));
    }
}
