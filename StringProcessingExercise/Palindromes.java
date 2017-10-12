package StringProcessingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("[,.?!\\s+]");

        Set<String> palindromes = new TreeSet<>();

        for (int i = 0; i < input.length; i++) {
            StringBuilder sb = new StringBuilder(input[i]);
            StringBuilder reversedStringBuilder = new StringBuilder(sb);
            reversedStringBuilder = reversedStringBuilder.reverse();
            String[] notReversed = sb.toString().split(" ");
            String[] reversed = reversedStringBuilder.toString().split(" ");
            for (int j = 0; j < notReversed.length; j++) {

                if(notReversed[j].equals(reversed[j]) && !notReversed[j].equals("")){
                    palindromes.add(reversed[j]);
                }
            }
        }

        System.out.println("["+ String.join(", ",palindromes) + "]");
    }
}
