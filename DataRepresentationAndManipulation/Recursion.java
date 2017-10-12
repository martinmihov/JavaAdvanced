package DataRepresentationAndManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Recursion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

//        System.out.println(fac(Integer.parseInt(reader.readLine())));

        draw(Integer.parseInt(reader.readLine()));

    }

    private static void draw(int n) {
        if(n==0){
            return;
        }

        //PRE ACTION
        System.out.println(String.join("", Collections.nCopies(n,"*")));
        // RECURSIVE CALL
        draw(n-1);
        // POST ACTION
        System.out.println(String.join("", Collections.nCopies(n,"#")));

    }

//    private static int fac(int n) {
//        if (n == 0) {
//            return 1;
//        }
//        return n * fac(n - 1);
//    }

//    private static int sum(int[] numbers, int index) {
//        if (index == numbers.length - 1) {
//            //base case
//            return numbers[index];
//        }
//        return numbers[index] + sum(numbers, index + 1);
//    }
}
