package DataRepresentAndManipExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Arrays.stream(reverseArray(arr,0,arr.length -1)).forEach(x-> System.out.print(x + " "));

    }

    private static int[] reverseArray(int[] numbers, int index,int length) {
        if(index<length){
            int temp = numbers[index];
            numbers[index] = numbers[length];
            numbers[length] = temp;
            reverseArray(numbers,++index,--length);
        }
        return numbers;
    }
}
