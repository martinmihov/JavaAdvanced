package DataRepresentationAndManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Searching {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int x = Integer.parseInt(reader.readLine());

//        System.out.println(LinearSearch(numbers,x));

        System.out.println(BinarySearch(numbers, x));
    }

    private static int BinarySearch(int[] numbers, int x) {
        int result = -1;
        int start = 0;
        int end = numbers.length - 1;
        while (end >= start) {
            int middle = (end + start) / 2;
            if (numbers[middle] > x) {
                end = middle - 1;
            } else if (numbers[middle] < x) {
                start = middle + 1;
            } else {
                return middle;
            }
        }

        return result;
    }

    private static int LinearSearch(int[] numbers, int x) {
        int result = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == x) {
                result = i;
                return result;

            }
        }
        return result;
    }
}
