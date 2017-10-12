package AbstractionExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        printingMatrix(rows, cols, fillMatrix(rows, cols));

    }

    private static String[][] fillMatrix(int rows, int cols) {


        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = "" + (char)('a' + i) + (char)('a' + i + j) + (char)('a' + i);
            }
        }
        return matrix;
    }

    private static void printingMatrix(int rows, int cols, String[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//        char a = 'a';
//        char b = 'b';
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                System.out.print(a);
//                if(j == 0){
//                    System.out.print(a);
//                } else {
//                    System.out.print(b);
//                }
//                System.out.print(a);
//                System.out.print(" ");
//                b++;
//            }
//            System.out.println();
//            a++;
//            b = a;
//        }