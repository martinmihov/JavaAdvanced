package QueryMethodsStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, LinkedHashMap<String, Integer>> officeStuff = new TreeMap<String, LinkedHashMap<String, Integer>>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String[] data = input.split(" - ");
            String companyName = data[0].substring(1);
            String product = data[2].substring(0, data[2].length() - 1);
            int quantity = Integer.parseInt(data[1]);
            if (!officeStuff.containsKey(companyName)) {
                officeStuff.put(companyName, new LinkedHashMap<>());
            }
            if (!officeStuff.get(companyName).containsKey(product)) {
                officeStuff.get(companyName).put(product,0);
            }
            officeStuff.get(companyName).put(product,officeStuff.get(companyName).get(product) + quantity);
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> company : officeStuff.entrySet()) {
            System.out.printf("%s: ", company.getKey());
            int counter = 0;
            int size = company.getValue().entrySet().size();
            for (Map.Entry<String, Integer> product : company.getValue().entrySet()) {
                counter++;
                if(size==counter){
                    System.out.printf("%s-%d", product.getKey(), product.getValue());
                } else {
                    System.out.printf("%s-%d, ", product.getKey(), product.getValue());
                }
            }
            System.out.println();
        }
    }
}
