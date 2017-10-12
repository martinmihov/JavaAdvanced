package AbstractionExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] matrixInfo = reader.readLine().split(", ");
        int size = Integer.parseInt(matrixInfo[0]);
        String pattern = matrixInfo[1];

        switch (pattern) {
            case "A":
                patternA(size);
                break;
            case "B":
                patternB(size);
                break;
        }
    }

    private static void patternA(int size) {
        for (int i = 1; i <= size; i++) {
            System.out.printf("%d ", i);
            for (int j = i + size; j <= size * size; j += size) {
                System.out.printf("%d ", j);
            }
            System.out.println();
        }
    }

    private static void patternB(int size) {

        int currentNumber = 1;

        int[][] matrix = new int[size][size];

        for (int col = 0; col < size; col++)
        {
            if (col % 2 == 0)
            {
                for (int row = 0; row < size; row++)
                {
                    matrix[row][col] = currentNumber;
                    currentNumber++;
                }
            }
            else
            {
                for (int row = size - 1; row >= 0; row--)
                {
                    matrix[row][col] = currentNumber;
                    currentNumber++;
                }
            }
        }
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
