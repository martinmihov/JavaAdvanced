package StringProcessingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        StringBuilder sb = new StringBuilder();

        Pattern pattern = Pattern.compile("<a(\\b[^>]*.*?)</a>((.|\\n)*)", Pattern.DOTALL);
//        Pattern pattern = Pattern.compile("<a ((.|\\n)*)</a>");

        while (!text.equalsIgnoreCase("END")) {
            sb.append(text+"\n");

            text = reader.readLine();
        }

        Matcher matcher = pattern.matcher(sb);

        while (matcher.find()) {
            sb.replace(sb.indexOf("<a"), sb.indexOf("<a") + 2, "[URL");
            sb.replace(sb.indexOf("\">"),sb.indexOf("\">")+2,"\"]");
            sb.replace(sb.indexOf("</a>"), sb.indexOf("</a>") + 4, "[/URL]");
        }
        System.out.println(sb);


    }
}
