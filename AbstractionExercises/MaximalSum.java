package AbstractionExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] matrixInfo = reader.readLine().split(" ");

        int rows = Integer.parseInt(matrixInfo[0]);
        int cols = Integer.parseInt(matrixInfo[1]);

        int[][] matrix = new int[rows][cols];

        int bestScore = Integer.MIN_VALUE;

        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);

            }
        }

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[0].length - 2; j++) {
                int sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                        matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] +
                        matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (bestScore < sum) {
                    bestScore = sum;
                    startRow = i;
                    startCol = j;
                }
            }
        }

        System.out.println("Sum = " + bestScore);
        System.out.println(matrix[startRow][startCol] + " " + matrix[startRow][startCol + 1] + " " + matrix[startRow][startCol + 2]);
        System.out.println(matrix[startRow + 1][startCol] + " " + matrix[startRow + 1][startCol + 1] + " " + matrix[startRow + 1][startCol + 2]);
        System.out.println(matrix[startRow + 2][startCol] + " " + matrix[startRow + 2][startCol + 1] + " " + matrix[startRow + 2][startCol + 2]);
    }
}
