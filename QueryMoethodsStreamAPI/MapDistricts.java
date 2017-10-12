package QueryMoethodsStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, List<Integer>> cities = new HashMap<>();

        List<String> tokens = Arrays.asList(reader.readLine().split("\\s+"));

        for (String token : tokens) {
            String[] tokenArgs = token.split(":");
            String city = tokenArgs[0];
            int districtPopulation = Integer.valueOf(tokenArgs[1]);

            cities.putIfAbsent(city, new ArrayList<>());
            cities.get(city).add(districtPopulation);
        }

        int bound = Integer.parseInt(reader.readLine());

        cities.entrySet().stream().filter(getFilsterByPopulationPredicate(bound)).sorted(getSortByDescendingPopationComparator()).forEach(getPrintMapEntryConsumer());
    }

    private static Predicate<? super Map.Entry<String, List<Integer>>> getFilsterByPopulationPredicate(int bound) {
        return kv -> kv.getValue().stream().mapToInt(Integer::valueOf).sum() >= bound;
    }

    public static Comparator<? super Map.Entry<String, List<Integer>>> getSortByDescendingPopationComparator() {
        return (kv1, kv2) -> Integer.compare(kv2.getValue().stream().mapToInt(Integer::valueOf).sum(),
                kv1.getValue().stream().mapToInt(Integer::valueOf).sum());
    }

    public static Consumer<? super Map.Entry<String, List<Integer>>> getPrintMapEntryConsumer() {
        return kv -> {
            System.out.print(kv.getKey() + ": ");
            kv.getValue().stream().sorted((s1, s2) -> s2.compareTo(s1)).limit(5).forEach(dp -> System.out.print(dp + " "));
            System.out.println();
        };
    }
}
