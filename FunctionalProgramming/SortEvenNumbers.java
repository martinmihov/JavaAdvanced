package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> evenNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            evenNumbers.add(numbers[i]);
        }

        evenNumbers.removeIf(x -> x % 2 == 1);

        for (int i = 0; i < evenNumbers.size(); i++) {
            if(i == evenNumbers.size() -1){
                System.out.print(evenNumbers.get(i));
            } else {
                System.out.print(evenNumbers.get(i) + ", ");
            }
        }
        System.out.println();
        evenNumbers.sort((a,b)->a.compareTo(b));
        for (int i = 0; i < evenNumbers.size(); i++) {
            if(i == evenNumbers.size() -1){
                System.out.print(evenNumbers.get(i));
            } else {
                System.out.print(evenNumbers.get(i) + ", ");
            }
        }
    }
}
