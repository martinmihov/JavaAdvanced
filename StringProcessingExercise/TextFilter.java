package StringProcessingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] banWords = reader.readLine().split(", ");
        String text = reader.readLine();

        for (int i = 0; i < banWords.length; i++) {
            Pattern pattern = Pattern.compile(banWords[i]);
            Matcher matcher = pattern.matcher(text);
            StringBuilder stars = new StringBuilder();
            for (int j = 0; j < banWords[i].length(); j++) {
                stars.append("*");
            }
            while (matcher.find()) {
                text = text.replaceAll(matcher.group(), String.format("%s", stars));
            }
        }

        System.out.println(text);
    }
}
