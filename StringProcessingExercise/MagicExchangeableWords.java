package StringProcessingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        char[] first = input[0].toCharArray();
        char[] second = input[1].toCharArray();

        Set<Character> sb1 = new HashSet<>();
        Set<Character> sb2 = new HashSet<>();

        for (int i = 0; i < second.length; i++) {
            sb1.add(second[i]);
        }
        for (int i = 0; i < first.length; i++) {
            sb2.add(first[i]);
        }


        if(sb1.size() != sb2.size()){
            System.out.println("false");
        } else{
            System.out.println("true");
        }
    }
}
