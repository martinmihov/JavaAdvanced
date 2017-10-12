package StringProcessingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumBigNumbersCorrect {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstNumber = reader.readLine();
        int product = Integer.parseInt(reader.readLine());
        int additionalNumber = 0;
        int remainder;


        StringBuilder sb = new StringBuilder();
        for (int i = firstNumber.length(); i > 0; i--) {
            int numReminder1 = Integer.parseInt(firstNumber.substring(i - 1, i));
            int sum = (numReminder1 * product) + additionalNumber;
            additionalNumber = sum / 10;
            remainder = sum % 10;
            sb.append(remainder);

        }
        if (additionalNumber != 0) {
            sb.append(additionalNumber);
        }
        System.out.println(sb.reverse());
    }
}
