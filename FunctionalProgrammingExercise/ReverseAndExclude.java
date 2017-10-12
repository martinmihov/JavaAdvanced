package FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        int[] numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> numsReversed = new ArrayList<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            numsReversed.add(numbers[i]);
        }

        int n = Integer.parseInt(reader.readLine());

        numsReversed.removeIf(x -> x % n == 0);

        String separator = "";
        for (Integer num : numsReversed) {
            System.out.print(separator + num);
            separator = " ";
        }
    }
}
