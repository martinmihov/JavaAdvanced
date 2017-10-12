package QueryMoethodsStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OptionalDouble optionalDouble = Arrays.stream(reader.readLine().split("\\s+")).filter(n -> !n.isEmpty()).mapToDouble(Double::valueOf).filter(n -> n % 2 == 0).sorted().findFirst();

        if (optionalDouble.isPresent()) {
            System.out.printf("%.2f", optionalDouble.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
