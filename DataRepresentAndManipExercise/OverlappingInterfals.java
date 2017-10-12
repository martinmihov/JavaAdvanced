package DataRepresentAndManipExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class OverlappingInterfals {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> intervals = getIntervals();
        System.out.println(checkForOverlap(intervals));
    }

    private static boolean checkForOverlap(TreeMap<Integer, Integer> intervals) {
        Map.Entry<Integer, Integer> first = intervals.firstEntry();
        intervals.remove(intervals.firstKey());
        int prevEnd = first.getValue();

        for (Map.Entry<Integer, Integer> integerIntegerEntry : intervals.entrySet()) {
            int currStart = integerIntegerEntry.getKey();
            if (prevEnd >= currStart) {
                return true;
            }
            prevEnd = integerIntegerEntry.getValue();
        }

        return false;
    }

    private static TreeMap<Integer, Integer> getIntervals() {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        TreeMap<Integer, Integer> intervals = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] currentLine = in.nextLine().split(",");
            intervals.put(Integer.parseInt(currentLine[0]), Integer.parseInt(currentLine[1]));
        }
        return intervals;
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(reader.readLine());
//
//        int[] arr = new int[n * 2];
//
//        for (int i = 0; i < n * 2; i += 2) {
//            int[] temp = Arrays.stream(reader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
//            arr[i] = temp[0];
//            arr[i + 1] = temp[1];
//        }
//        SelectedSorting(arr);
//        int result = arr.length/(arr[0] + arr[1]);
//        System.out.println(isOverlap(arr,result));
//
//    }
//    private static boolean isOverlap(int[] arr,int n){
//        for (int i = 1; i < n; i++) {
//            if(arr[i-1] > arr[i]){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private static int[] SelectedSorting(int[] numbers) {
//        for (int i = 0; i < numbers.length - 1; i++) {
//            int min = i;
//
//            for (int j = i + 1; j < numbers.length; j++) {
//                if (numbers[j] < numbers[min]) {
//                    min = j;
//                }
//            }
//            swap(numbers, min, i);
//        }
//        return numbers;
//    }
//
//    private static void swap(int[] numbers, int min, int index) {
//        int temp = numbers[min];
//        numbers[min] = numbers[index];
//        numbers[index] = temp;
//    }



}
