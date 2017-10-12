package ObjectsClassesAndCollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Set<String> cars = new HashSet<>();

        while(!input.equalsIgnoreCase("END")){
            String[] car = input.split(", ");

            if(car[0].equalsIgnoreCase("IN")){
                cars.add(car[1]);
            } else {
                cars.remove(car[1]);
            }

            input = reader.readLine();
        }
        if(cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        for (String car:cars) {
            System.out.println(car);
        }
    }
}
