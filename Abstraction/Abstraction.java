package Abstraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Abstraction {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = reader.readLine();
        }
        int[] linesSorted = encryptArray(lines);
        Arrays.sort(linesSorted);

        print(linesSorted);

    }

    private static void print(int[] a ){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static int[] encryptArray(String[] lines) {
        List<Character> vowels = new ArrayList();
        Collections.addAll(vowels,'a','e','i','o','u');
        int[] results = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                if(vowels.contains(lines[i].charAt(j))){
                    results[i] += lines[i].length() * lines[i].charAt(j);
                } else {
                    results[i] += lines[i].charAt(j) / lines[i].length();
                }
            }
        }
        return results;
    }
}
