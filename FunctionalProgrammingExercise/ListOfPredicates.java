package FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        BiPredicate<Integer,Integer> isDivisible = (x,y)-> x % y == 0;
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            for (Integer num:nums) {
                if(isDivisible.test(i,num)){
                    counter++;
                }
            }
            if(counter == nums.length){
                System.out.print(i + " ");
            }
            counter = 0;
        }

    }
}
