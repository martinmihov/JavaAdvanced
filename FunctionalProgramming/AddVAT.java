package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] input = Arrays.stream(reader.readLine().split(", ")).mapToDouble(Double::parseDouble).toArray();

        UnaryOperator<Double> result = x -> x * 1.2;

        System.out.println("Prices with VAT:");
        for (double num:input) {
            System.out.println(String.format("%.2f",result.apply(num)).replace('.',','));
        }
    }
}
