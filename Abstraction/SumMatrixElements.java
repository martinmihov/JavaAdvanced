package Abstraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumMatrixElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] rowsAndCols = reader.readLine().split(", ");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        int result = 0;

        for (int i = 0; i < rows; i++) {
            String[] row = reader.readLine().split(", ");

            for (int j = 0; j < cols; j++) {
                result += Integer.parseInt(row[j]);
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(result);
    }
}
