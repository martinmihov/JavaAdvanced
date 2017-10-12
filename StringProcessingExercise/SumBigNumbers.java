package StringProcessingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstNumber = reader.readLine();
        String secondNumber = reader.readLine();

        int leftPaddingSize = Math.abs(firstNumber.length() - secondNumber.length());

        int biggestNumber = Math.max(firstNumber.length(), secondNumber.length());

        boolean isFirstNumberBigger;

        if (biggestNumber > firstNumber.length()) {

            firstNumber = String.format("%0" + leftPaddingSize + "d%s", 0, firstNumber);
            isFirstNumberBigger = false;

        } else {
            secondNumber = String.format("%0" + leftPaddingSize + "d%s", 0, secondNumber);
            isFirstNumberBigger = true;
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(firstNumber);
        System.out.println(secondNumber);
        for (int i = biggestNumber; i > 0; i--) {
            int numReminder1 = Integer.parseInt(firstNumber.substring(i - 1, i));
            int numReminder2 = Integer.parseInt(secondNumber.substring(i - 1, i));
            int sum = numReminder1 + numReminder2;
            if (sum > 9) {
                int reminder = sum % 10;
                sb.append(reminder);
                if (isFirstNumberBigger) {
                    int value = Integer.parseInt(firstNumber.substring(i - 2, i - 1)) + 1;
                    String newValue = String.valueOf(value);
                    String oldValue = firstNumber.substring(i - 2, i - 1);
                    firstNumber.substring(i - 2, i - 1).replace(oldValue,newValue);
                } else {
                    int value = Integer.parseInt(secondNumber.substring(i - 2, i - 1)) + 1;
                    String newValue = String.valueOf(value);
                    String oldValue = secondNumber.substring(i - 2, i - 1);
//                    secondNumber.substring(i - 2, i - 1).replace(oldValue,newValue);
                    secondNumber = secondNumber.substring(0,i-2) + newValue + secondNumber.substring(i);
                }

            } else {
                sb.append(sum);
            }
        }
        System.out.println(sb.reverse());
    }
}
