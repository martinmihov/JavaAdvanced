package DataRepresentationAndManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


//        int[] resultBubble = BubbleSorting(numbers);

        Arrays.stream(SelectedSorting(numbers)).forEach(x-> System.out.print(x + " "));
//        System.out.println(Arrays.toString(resultSelected));
    }

    private static int[] BubbleSorting(int[] numbers) {
        boolean swapped = true;
        do {
            swapped = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if(numbers[i] > numbers[i+1]){
                    swap(numbers,i,i+1);
                    swapped = true;
                }
            }

        } while (swapped);
        return numbers;
    }

    private static int[] SelectedSorting(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[min]) {
                    min = j;
                }
            }
            swap(numbers, min, i);
        }
        return numbers;
     }

    private static void swap(int[] numbers, int min, int index) {
        int temp = numbers[min];
        numbers[min] = numbers[index];
        numbers[index] = temp;
    }
}
