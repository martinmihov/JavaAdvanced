package ObjectsClassesAndCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class MathPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] names = reader.readLine().split("\\s+");

        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<String> kids = new ArrayDeque<>();

        for (String kid:names){
                kids.add(kid);

        }

        int cycle = 1;

        while (kids.size() > 1) {
            for (int i = 1; i < n; i++) {
                kids.offer(kids.poll());
            }
            if(isPrime(cycle)){
                System.out.println("Prime " + kids.peek());
            } else {
                System.out.println("Removed " + kids.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + kids.poll());
    }


    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }
}
