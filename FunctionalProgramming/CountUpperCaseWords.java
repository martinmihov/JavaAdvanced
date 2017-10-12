package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Predicate;

public class CountUpperCaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        String[] textAsList = text.split(" ");

        ArrayList<String> result = new ArrayList<>();

        Predicate<String> isUpperCase = s ->  s.charAt(0) == s.toUpperCase().charAt(0);

        for (int i = 0; i < textAsList.length; i++) {
            if(isUpperCase.test(textAsList[i])){
                result.add(textAsList[i]);
            }
        }

        System.out.println(result.size());
        for (String t:result) {
            System.out.println(t);
        }
    }
}
