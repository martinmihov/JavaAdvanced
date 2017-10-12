package FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] names = reader.readLine().split(" ");

        Predicate<String> isLess = x -> x.length() <= n;

        for (String name : names) {
            if (isLess.test(name)) {
                System.out.println(name);
            }
        }
    }
}
