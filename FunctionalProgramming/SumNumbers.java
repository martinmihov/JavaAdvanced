package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        Function<Integer, Integer> func = x -> + x;

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += func.apply(numbers[i]);
        }

        System.out.println("Count = " + numbers.length);
        System.out.println("Sum = " + sum);
    }
}
