package QueryMoethodsStreamAPI;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class FirstName {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.asList(scanner.nextLine().split("\\s+"));

        HashSet<Character> letters = new HashSet<>();

        Stream.of(scanner.nextLine().split("\\s+"))
                .map(s -> s.toLowerCase().charAt(0))
                .forEach(c -> letters.add(c));

        Optional<String> first = names.stream()
                .filter(s -> letters.contains(s.toLowerCase().charAt(0)))
                .sorted()
                .findFirst();

        if (first.isPresent())
            System.out.println(first.get());
        else
            System.out.println("No match");


    }
}
