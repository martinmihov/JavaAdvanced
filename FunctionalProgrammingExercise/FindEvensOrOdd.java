package FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class FindEvensOrOdd {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] bounds = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Integer lowerBound = bounds[0];
        Integer upperBound = bounds[1];
        String condition = reader.readLine();
        Predicate<Integer> isOdd = x -> x % 2 != 0;
        checkContition(lowerBound,upperBound,condition,isOdd);
        String seprator = "";

        for (Integer n:checkContition(lowerBound,upperBound,condition,isOdd)) {
            System.out.print(seprator + n);
            seprator = " ";
        }

    }

    private static ArrayList<Integer> checkContition(Integer lowerBound, Integer upperBound, String condition, Predicate<Integer> isOdd) {

        ArrayList<Integer> result = new ArrayList<>();
        if(condition.equals("odd")){
            for (int i = lowerBound; i <= upperBound; i++) {
                if(isOdd.test(i)){
                    result.add(i);
                }
            }
        } else {
            for (int i = lowerBound; i <= upperBound; i++) {
                if(!isOdd.test(i)){
                    result.add(i);
                }
            }
        }
        return result;
    }

}
