package FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] bounds = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = reader.readLine();

        while (!input.equalsIgnoreCase("end")) {
            switch (input) {
                case "add":
                    bounds = addNumber(bounds);
                    break;
                case "multiply":
                    bounds = multiplyNumber(bounds);
                    break;
                case "subtract":
                    bounds = subtractNumber(bounds);
                    break;
                case "print":
                    printIt(bounds);
                    break;
            }

            input = reader.readLine();
        }

    }

    private static int[] subtractNumber(int[] bounds) {
        int[] result = new int[bounds.length];

        UnaryOperator<Integer> unaryOperator = x -> x - 1;
        for (int i = 0; i < bounds.length; i++) {
            result[i] = unaryOperator.apply(bounds[i]);
        }
        return result;
    }

    private static int[] multiplyNumber(int[] bounds) {
        int[] result = new int[bounds.length];

        UnaryOperator<Integer> unaryOperator = x -> x * 2;
        for (int i = 0; i < bounds.length; i++) {
            result[i] = unaryOperator.apply(bounds[i]);
        }
        return result;
    }

    private static void printIt(int[] bounds) {
        String separator = "";
        for (Integer num : bounds) {
            System.out.print(separator + num);
            separator = " ";
        }
        System.out.println();
    }

    private static int[] addNumber(int[] nums) {
        int[] result = new int[nums.length];

        UnaryOperator<Integer> unaryOperator = x -> x + 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = unaryOperator.apply(nums[i]);
        }
        return result;
    }
}