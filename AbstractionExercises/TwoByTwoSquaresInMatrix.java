package AbstractionExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoByTwoSquaresInMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] matrixInfo = reader.readLine().split(" ");

        int rows = Integer.parseInt(matrixInfo[0]);
        int cols = Integer.parseInt(matrixInfo[1]);

        String[][] matrix = new String[rows][cols];

        int bestScore = 0;

        for (int i = 0; i < matrix.length; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = line[j];
            }
        }

        for (int i = 0; i < matrix.length - 1; i++) {
                for (int j = 0; j < matrix[0].length - 1; j++) {
                    if(matrix[i][j].equals(matrix[i][j + 1]) && matrix[i][j + 1].equals( matrix[i + 1][j]) &&
                            matrix[i + 1][j].equals(matrix[i + 1][j + 1]) && matrix[i + 1][j + 1].equals((matrix[i][j]))){
                        bestScore++;
                    }
                }
        }
        System.out.println(bestScore);
    }
}