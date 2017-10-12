package DataRepresentAndManipExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindTheMissingNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Set<Integer> fullSet = getFullSet(n);
        Set<Integer> arraySet = IntStream.of(Arrays.stream(in.nextLine().split("[, ]"))
                .filter(x -> !x.equals("")).mapToInt(Integer::parseInt)
                .toArray()).boxed().collect(Collectors.toSet());
        printMissingNumber(fullSet, arraySet);
    }

    private static void printMissingNumber(Set<Integer> fullSet, Set<Integer> arraySet) {
        fullSet.removeAll(arraySet);
        for (Integer integer : fullSet) {
            System.out.println(integer);
        }
    }

    private static Set<Integer> getFullSet(int n) {
        Set<Integer> fullSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            fullSet.add(i);
        }
        return fullSet;
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(reader.readLine());
//
//        int[] arr = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
//
//        bubbleSorting(arr);
//
//        for (int i = 0; i < n; i++) {
//            int check = i + 1;
//            if (arr[i] != check) {
//                System.out.println(check);
//                return;
//            }
//        }
//
//    }
//
//    private static int[] bubbleSorting(int[] arr) {
//        boolean swapped = true;
//        do {
//            swapped = false;
//            for (int i = 0; i < arr.length - 1; i++) {
//                if (arr[i] > arr[i + 1]) {
//                    swap(arr, i, i + 1);
//                    swapped = true;
//                }
//            }
//        } while (swapped);
//        return arr;
//    }
//
//    private static void swap(int[] arr, int min, int index) {
//        int temp = arr[min];
//        arr[min] = arr[index];
//        arr[index] = temp;
//    }
}
