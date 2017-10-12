package StringProcessingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        double result =0d;

        for (int i = 0; i < input.length; i++) {
            char firstLetter = input[i].charAt(0);
            char lastLetter = input[i].charAt(input[i].length() - 1);
            double number = Integer.parseInt(input[i].substring(1, input[i].length() - 1));
            double sum = 0;
            double firstLetterPosition = 0;
            double lastLetterPostion = 0;
            if (Character.isUpperCase(firstLetter)) {
                firstLetterPosition = firstLetter - 64;
                sum = number / firstLetterPosition;
            } else {
                firstLetterPosition = firstLetter - 96;
                sum = number * firstLetterPosition;
            }
            if (Character.isUpperCase(lastLetter)) {
                lastLetterPostion = lastLetter - 64;
                sum -= lastLetterPostion;
            } else {
                lastLetterPostion = lastLetter - 96;
                sum += lastLetterPostion;
            }
            result += sum;

        }
        System.out.printf("%.2f",result);
    }
}
