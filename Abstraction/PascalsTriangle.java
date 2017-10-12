package Abstraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PascalsTriangle {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        long[][] pascal = pascalProblem(n);

        for (long[] rows : pascal) {
            for (long element : rows) {
                if (element != 0) {
                    System.out.print(element + " ");
                }
            }
            System.out.println();
        }
    }

    private static long[][] pascalProblem(int n) {
        long[][] result = new long[n][n];

        for (int row = 0; row < n; row++) {
            result[row][0] = 1;
            result[row][row] = 1;
            if (row > 1) {

                for (int col = 1; col < n; col++) {
                    long[] previousRow = result[row - 1];
                    long sum = previousRow[col - 1] + previousRow[col];
                    result[row][col] = sum;
                }
            }
        }

        return result;
    }
}
