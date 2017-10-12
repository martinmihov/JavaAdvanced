package StringProcessingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keyWord = reader.readLine();
        String text = reader.readLine();

        Pattern pattern = Pattern.compile("([A-Z][\\w\\W]*?\\b" + keyWord + "\\b[\\w\\W]*?[.!?])");

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

//        int index = 0;
//        int start = 0;
//        for (int i = start; i < text.length(); i++) {
//            int dot = text.indexOf(".");
//            int excl = text.indexOf("!");
//            int question = text.indexOf("?");
//            index = Math.min(Math.min(dot, excl), Math.min(question, dot));
//            if (index > start) {
//                String sentence = text.substring(start, index + 1);
//                if (sentence.contains(" " + keyWord + " ")) {
//                    System.out.println(sentence.trim());
//                }
//                text = text.substring(index + 1);
//            }
////            start = index + 1;
//        }
    }
}
