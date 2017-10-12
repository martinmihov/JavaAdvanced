package ObjectsClassesandCollectionsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Set<String>> cardsPerPerson = new LinkedHashMap<>();

        String text = reader.readLine();

        while (!text.equals("JOKER")) {
            String[] info = text.split(": ");
            String name = info[0];
            String[] cards = info[1].split(", ");
            Set<String> listedCards = new HashSet<>();
            for (int i = 0; i < cards.length; i++) {
                listedCards.add(cards[i]);
            }
            if (!cardsPerPerson.containsKey(name)) {
                cardsPerPerson.put(name, listedCards);
            } else if (cardsPerPerson.containsKey(name)) {
                for (int i = 0; i < cards.length; i++) {
                    if (!cardsPerPerson.get(name).contains(cards[i])) {
                        cardsPerPerson.get(name).add(cards[i]);
                    }
                }
            }
            text = reader.readLine();
        }

        for (Map.Entry<String, Set<String>> kvp : cardsPerPerson.entrySet()) {
            Integer valueOfHand = 0;
            for (String str : kvp.getValue()) {
                String[] hand = str.split("");
                if (hand[0].equals("1")) {
                    Integer power = getPower("10");
                    valueOfHand += getValueOfHand(power, hand[2]);
                } else {
                    Integer power = getPower(hand[0]);
                    valueOfHand += getValueOfHand(power, hand[1]);
                }
            }
            System.out.printf("%s: %d\n", kvp.getKey(), valueOfHand);
        }
    }

    private static Integer getValueOfHand(Integer power, String s) {
        switch (s) {
            case "C":
                return power;
            case "D":
                return 2 * power;
            case "H":
                return 3 * power;
            case "S":
                return 4 * power;
            default:
                return Integer.parseInt(s) * power;
        }
    }

    private static Integer getPower(String power) {
        switch (power) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(power);
        }
    }
}
