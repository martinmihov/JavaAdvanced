package DataRepresentAndManipExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] line = getArray(in.nextLine());
        int x = Integer.parseInt(in.nextLine());
        System.out.println(doBinarySearch(line, x));
    }

    private static int[] getArray(String s) {
        String[] split = s.split("\\s+");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }

    private static int doBinarySearch(int[] line, int x) {
        return doBinarySearch(line, 0, line.length - 1, x);
    }

    private static int doBinarySearch(int[] line, int i, int j, int x) {
        if (i > j) {
            return -1;
        }
        int middle = (i + j) / 2;
        if (line[middle] == x) {
            return middle;
        } else if (line[middle] > x) {
            return doBinarySearch(line, 0, middle - 1, x);
        } else {
            return doBinarySearch(line, middle + 1, j, x);
        }

    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int[] arr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        int n = Integer.parseInt(reader.readLine());
//
//        System.out.println(binarySearch(arr, n, 0, arr.length));
//    }
//
//    private static int binarySearch(int[] arr, int n, int lo, int hi) {
//        if (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            if (n < arr[mid]) {
//                return binarySearch(arr, n, lo, mid);
//            } else if (n > arr[mid]) {
//                return binarySearch(arr, n, mid+1, hi);
//            } else {
//                return mid;
//            }
//        } else {
//            return -1;
//        }
//    }

}
