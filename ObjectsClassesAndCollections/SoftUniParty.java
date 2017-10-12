package ObjectsClassesAndCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<String> guestList = new HashSet<>();

        HashSet<String> vip = new HashSet<>();
        TreeSet<String> regular = new TreeSet<>();

        Set<String> numbers = new HashSet<>();
        Collections.addAll(numbers, "1", "2", "3", "4", "5", "6", "7", "8", "9", "0");

        String input = reader.readLine();
        while (!input.equalsIgnoreCase("PARTY")) {
            String sign = Character.toString(input.charAt(0));
            if (numbers.contains(sign)) {
                vip.add(input);
            } else {
                regular.add(input);
            }
            guestList.add(input);
            input = reader.readLine();
        }
        while(!input.equalsIgnoreCase("END")){
            if(guestList.contains(input)){
                String sign = Character.toString(input.charAt(0));
                if (numbers.contains(sign)) {
                    vip.remove(input);
                    guestList.remove(input);
                } else {
                    regular.remove(input);
                    guestList.remove(input);
                }
            }
            input = reader.readLine();
        }
        System.out.println(guestList.size());
        for (String vipGuest : vip) {
            System.out.println(vipGuest);
        }
        for (String regularGuest : regular) {
            System.out.println(regularGuest);
        }
    }
}
