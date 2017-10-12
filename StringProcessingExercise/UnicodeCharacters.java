package StringProcessingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] input = reader.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {

            sb.append("\\u" +"00"+ Integer.toHexString(input[i]));
        }

        System.out.println(sb);
    }
}