package ObjectsClassesandCollectionsExercise;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, TreeMap<String, Double[]>> dragons = new LinkedHashMap<>();

        int numberOfDragons = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfDragons; i++) {
            String[] dragonCounter = reader.readLine().split(" ");
            String type = dragonCounter[0];
            String name = dragonCounter[1];
            Double damage = 0d;
            Double health = 0d;
            Double armor = 0d;

            if (!dragonCounter[2].equals("null")) {
                damage = Double.parseDouble(dragonCounter[2]);
            } else {
                damage = 45d;
            }
            if (!dragonCounter[3].equals("null")) {
                health = Double.parseDouble(dragonCounter[3]);
            } else {
                health = 250d;
            }
            if (!dragonCounter[4].equals("null")) {
                armor = Double.parseDouble(dragonCounter[4]);
            } else {
                armor = 10d;
            }

            Double[] stats = new Double[3];
            {
                stats[0] = damage;
                stats[1] = health;
                stats[2] = armor;
            }
            if (!dragons.containsKey(type)) {

                dragons.put(type, new TreeMap<>());

            }
            TreeMap<String, Double[]> innerMap = dragons.get(type);
            innerMap.put(name, stats);

        }

        for (Map.Entry<String, TreeMap<String, Double[]>> dragon : dragons.entrySet()) {
            calcPrintAvg(dragon.getValue(), dragon.getKey());

            for (Map.Entry<String, Double[]> currDragon : dragon.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f\n",
                        currDragon.getKey(),currDragon.getValue()[0],currDragon.getValue()[1],currDragon.getValue()[2]);
            }
        }
    }

    private static void calcPrintAvg(TreeMap<String, Double[]> value, String key) {
        Double avgDmg = 0d;
        Double avgHlth = 0d;
        Double avgArm = 0d;

        for (Double[] db :value.values()) {
             avgDmg+=db[0];
             avgHlth+=db[1];
             avgArm+=db[2];

        }
        avgDmg/=value.size();
        avgHlth/=value.size();
        avgArm/=value.size();

        System.out.printf("%s::(%.2f/%.2f/%.2f)\n",key,avgDmg,avgHlth,avgArm);
    }
}
