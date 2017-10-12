package FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                even.add(numbers[i]);
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                odd.add(numbers[i]);
            }
        }
        even.sort(Comparator.naturalOrder());
        odd.sort(Comparator.naturalOrder());
        for (Integer num : even) {
            sb.append(num);
            sb.append(" ");
        }
        for (Integer num:odd) {
            sb.append(num);
            sb.append(" ");
        }
        System.out.println(String.join(" ", sb.toString()));
    }
}
