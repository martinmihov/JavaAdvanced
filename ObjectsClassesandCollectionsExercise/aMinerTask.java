package ObjectsClassesandCollectionsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class aMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        Map<String, Integer> preciousMetals = new LinkedHashMap<>();

        while (!text.equals("stop")) {
            if (!preciousMetals.containsKey(text)) {
                preciousMetals.put(text, Integer.parseInt(reader.readLine()));
            } else {
                String key = text;
                preciousMetals.put(key, preciousMetals.get(key) + Integer.parseInt(reader.readLine()));
            }
            text = reader.readLine();
        }
        for (Map.Entry<String, Integer> kvp : preciousMetals.entrySet())
        {
            System.out.printf("%s -> %d\n", kvp.getKey(), kvp.getValue());
        }
    }
}

