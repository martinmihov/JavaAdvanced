package AbstractionExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < size; i++) {
            int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            if(numbers[i] < 0){
                primaryDiagonalSum -= (-numbers[i]);
                secondaryDiagonalSum -= (-numbers[size - 1 - i]);
            } else {
                primaryDiagonalSum += numbers[i];
                secondaryDiagonalSum += numbers[size - 1 - i];
            }

        }
        System.out.println(Math.abs(primaryDiagonalSum-secondaryDiagonalSum));

    }
}
