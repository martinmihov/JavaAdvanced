package StringProcessingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keyString = reader.readLine();
        String text = reader.readLine();

        Pattern startPattern = Pattern.compile("^[\\w+]+?[^0-9]+");
        Pattern endPattern = Pattern.compile("[^0-9]+[\\w+]?$");
        Pattern numbersPattern = Pattern.compile("[\\d]+.[\\d+]+");

        Matcher firstKeyMatcher = startPattern.matcher(keyString);
        Matcher lastKeyMatcher = endPattern.matcher(keyString);
        Matcher numbersMatcher = numbersPattern.matcher(text);

        double result = 0D;

        while (firstKeyMatcher.find() && lastKeyMatcher.find()) {
            String firstKeyFound = firstKeyMatcher.group();
            String lastKeyFound = lastKeyMatcher.group();
            String[] betweenKeys = text.split(lastKeyFound);
            for (int i = 0; i < betweenKeys.length; i++) {
                String[] what = betweenKeys[i].split(firstKeyFound);
                if (what.length >= 2) {
                    double digits = Double.parseDouble(what[1]);
                    result += digits;
                }
            }
        }
        if(result == 0){
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        } else if(result > 0){
            System.out.printf("<p>The total value is: <em>%.2f</em></p>\n",result);
        } else {
            System.out.println("<p>A key is missing</p>\n");
        }
    }
}
