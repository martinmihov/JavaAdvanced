package ObjectsClassesandCollectionsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> data = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!input.equals("report")) {
            String[] dataInput = input.split("\\|");
            String city = dataInput[0];
            String country = dataInput[1];
            Long population = Long.parseLong(dataInput[2]);
            if (!data.containsKey(country)) {
                data.put(country, new HashMap<>());
            }
            if (!data.get(country).containsKey(city)) {
                data.get(country).put(city, population);
            }
            data.get(country).put(city, population);

            input = reader.readLine();
        }
        Map<String, Long> dataCountryPopulation = new LinkedHashMap<>();
        Map<String, Long> dataCityPopulation = new LinkedHashMap<>();

        for (Map.Entry<String, Map<String, Long>> pair : data.entrySet()) {
            String currentCountry = pair.getKey();
            dataCountryPopulation.put(currentCountry, 0L);
            for (Map.Entry<String, Long> total : data.get(currentCountry).entrySet()) {
                if(!dataCityPopulation.containsKey(total.getKey())){
                    dataCityPopulation.put(total.getKey(),total.getValue());
                } else {
                    dataCityPopulation.put(total.getKey(),dataCityPopulation.get(total.getKey()) + total.getValue());
                }
                dataCountryPopulation.put(currentCountry, dataCountryPopulation.get(currentCountry) + total.getValue());
            }
        }

        //.sorted(Map.Entry.<String,Long>comparingByValue().reversed()) !!!!!! THIS COMPARES BY VALUE
        //.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)) !!!!!!! THIS CREATES A NEW MAP BUT LOSES ORDER OF THE INPUT
        //.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new)); // !!!!! THIS ONE KEEPS ORDER WHILE CREATING A NEW MAP

        LinkedHashMap<String, Long> collectCountry = dataCountryPopulation.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        LinkedHashMap<String, Long> collectCity = dataCityPopulation.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        for (Map.Entry<String,Long> country:collectCountry.entrySet()) {
            System.out.printf("%s (total population: %d)\n",country.getKey(),country.getValue());
            for (Map.Entry<String,Long> city:collectCity.entrySet()) {
                Long sum = collectCity.values().stream().mapToLong(Number::longValue).sum();
                if(country.getValue().equals(sum)){
                    System.out.printf("=>%s: %d\n",city.getKey(),city.getValue());
                }

            }
        }
    }
}
