package ObjectsClassesandCollectionsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        Map<String, Integer> countSymbols = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            if (!countSymbols.containsKey(text.substring(i, i + 1))) {
                countSymbols.put(text.substring(i, i + 1), 1);
            } else {
                String key = text.substring(i, i + 1);
                countSymbols.put(key, countSymbols.get(key) + 1);
            }
        }


        for (Map.Entry<String, Integer> kvp : countSymbols.entrySet()) {
            System.out.printf("%s: %d time/s\n", kvp.getKey(), kvp.getValue());

        }
    }
}
