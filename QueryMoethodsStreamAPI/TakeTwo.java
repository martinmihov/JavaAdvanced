package QueryMoethodsStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> tokens = Arrays.asList(reader.readLine().split("\\s+"));

        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.valueOf(token));
        }

        numbers.stream().filter(x -> x <= 20 && x >= 10).distinct().limit(2).forEachOrdered(n-> System.out.print(n + " "));
    }
}
