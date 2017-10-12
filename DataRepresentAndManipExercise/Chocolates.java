package DataRepresentAndManipExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Chocolates {
    private static int bestMin = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = Integer.parseInt(in.nextLine());
        int[] line = getArray(in.nextLine());
        int count = Integer.parseInt(in.nextLine());
        Arrays.sort(line);
        getMinDiff(line, count);
        System.out.printf("Min Difference is %d.", bestMin);
    }

    private static void getMinDiff(int[] line, int count) {
        findBestCouple(line, 0, line.length - 1, count);
    }

    private static void findBestCouple(int[] line, int i, int j, int count) {
        if (i + count > j + 1) {
            return;
        }
        int currentCouple = getCurrentCollection(line, count, i);
        if (bestMin > currentCouple) {
            bestMin = currentCouple;
        }
        findBestCouple(line, i + 1, j, count);
    }

    private static int getCurrentCollection(int[] line, int count, int i) {
        int first = line[i];
        int last = line[count + i - 1];
        return Math.abs(last - first);
    }

    private static int[] getArray(String s) {
        return Arrays.stream(s.split("[ ,]")).filter(x -> !x.equals("")).mapToInt(Integer::parseInt).toArray();
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int quantity = Integer.parseInt(reader.readLine());
//        int[] packets = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
//        int students = Integer.parseInt(reader.readLine());
//
//        BubbleSorting(packets);
//
//        LinearSearch(packets, students);
//    }
//
//    private static String LinearSearch(int[] numbers, int students) {
//        int currentMin = Integer.MAX_VALUE;
//        for (int i = 0; i < numbers.length - students; i++) {
//            if (numbers[i + students - 1] - numbers[i] <= currentMin) {
//                currentMin = numbers[i + students - 1] - numbers[i];
//            }
//        }
//        return String.valueOf(System.out.printf("Min Difference is %d.\n", currentMin));
//    }
//
//    private static int[] BubbleSorting(int[] numbers) {
//        boolean swapped = true;
//        do {
//            swapped = false;
//            for (int i = 0; i < numbers.length - 1; i++) {
//                if (numbers[i] > numbers[i + 1]) {
//                    swap(numbers, i, i + 1);
//                    swapped = true;
//                }
//            }
//
//        } while (swapped);
//        return numbers;
//    }
//
//    private static void swap(int[] numbers, int min, int index) {
//        int temp = numbers[min];
//        numbers[min] = numbers[index];
//        numbers[index] = temp;
//    }
}
