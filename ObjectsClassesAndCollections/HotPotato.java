package ObjectsClassesAndCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class HotPotato {
    public static void main(String[] arg) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] names = reader.readLine().split("\\s+");

        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<String> kids = new ArrayDeque<>();

        kids.addAll(Arrays.asList(names));

        while (kids.size() > 1) {
            for (int i = 1; i < n; i++) {
                kids.offer(kids.poll());
            }
            System.out.println("Removed " + kids.poll());
        }
        System.out.println("Last is " + kids.peek());
    }
}
