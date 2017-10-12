package StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        String upcaseStart = "<upcase>";
        String upcaseStop = "</upcase>";

        while (text.contains(upcaseStart)) {
            int startIndex = text.indexOf(upcaseStart);
            int endIndex = text.indexOf(upcaseStop);

            String reminder = text.substring(startIndex + upcaseStart.length(),endIndex);
            String upReminder = reminder.toUpperCase();
            text = text.replaceFirst(reminder,upReminder);
            text = text.replaceFirst(upcaseStart,"");
            text = text.replaceFirst(upcaseStop, "");
        }

        System.out.println(text);

    }
}
