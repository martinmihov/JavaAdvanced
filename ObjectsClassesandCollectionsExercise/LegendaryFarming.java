package ObjectsClassesandCollectionsExercise;

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> resources = new HashMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();
        resources.put("shards", 0);
        resources.put("fragments", 0);
        resources.put("motes", 0);

        boolean notEnoughMaterial = true;
        while (notEnoughMaterial) {
            String[] command = reader.readLine().toLowerCase().split(" ");
            for (int i = 0; i < command.length; i += 2) {
                Integer quantity = Integer.parseInt(command[i]);
                String material = command[i + 1];
                if (resources.containsKey(material)) {
                    resources.put(material, resources.get(material) + quantity);
                    if (resources.get(material) >= 250) {
                        resources.put(material, resources.get(material) - 250);
                        String result = "";
                        switch (material) {
                            case "shards":
                                result = "Shadowmourne";
                                break;
                            case "fragments":
                                result = "Valanyr";
                                break;
                            case "motes":
                                result = "Dragonwrath";
                                break;
                        }
                        System.out.printf("%s obtained!\n", result);
                        notEnoughMaterial = false;
                        break;
                    }
                } else {
                    if (!junk.containsKey(material)) {
                        junk.put(material, 0);
                    }
                    junk.put(material, junk.get(material) + quantity);
                }
            }
        }
        Map<String, Integer> finalResources = resources.entrySet().stream()
                .sorted(Map.Entry.<String,Integer> comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        for (Map.Entry<String, Integer> res : finalResources.entrySet()) {
            System.out.printf("%s: %d\n", res.getKey(), res.getValue());
        }
        for (Map.Entry<String,Integer> trash:junk.entrySet()) {
            System.out.printf("%s: %d\n",trash.getKey(),trash.getValue());
        }
    }
}
