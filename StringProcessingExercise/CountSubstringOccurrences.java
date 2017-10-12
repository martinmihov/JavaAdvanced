package StringProcessingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine().toLowerCase();
        String searchInText = reader.readLine().toLowerCase();


        int count = 0;

        for (int i = 0; i <= text.length() - searchInText.length(); i++) {

            if (text.substring(i, searchInText.length() + i).equals(searchInText)){
                count++;
            }
        }
        System.out.println(count);
    }
}
