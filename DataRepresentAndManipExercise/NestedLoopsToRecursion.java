package DataRepresentAndManipExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NestedLoopsToRecursion {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(reader.readLine());
//
//        int[] arr = new int[n];
//
//        recursion(n,1);
//    }
//
//    private static void recursion(int n,int index){
//        if(index <= n){
//            for (int i = index; i <= n; i++) {
//                recursion(n,++index);
//                System.out.printf("%d ",i);
//                if(i == n){
//                    System.out.println();
//                }
//            }
//            recursion(n,++index);
//        }


    private static int loopsCount;
    private static int loopsLength;
    private static int[] loops;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        loopsCount = Integer.parseInt(reader.readLine());
        loopsLength = loopsCount;
        loops = new int[loopsCount];

        nestetLoopsToRecursion(0);
    }

    private static void nestetLoopsToRecursion(int currentLoop) {
        if (currentLoop == loopsCount) {
            printLoops();
            return;
        }
        for (int i = 1; i <= loopsLength; i++) {
            loops[currentLoop] = i;
            nestetLoopsToRecursion(currentLoop + 1);
        }
    }

    private static void printLoops() {
        System.out.println(Arrays.toString(loops).replaceAll("[\\]\\[,]",""));
//        for (int i = 0; i < loopsLength; i++) {
//            System.out.printf("%d ", loops[i]);
//        }
//        System.out.println();
    }
}
