package QueryMoethodsStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] bounds = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        List<Integer> collect = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).filter(x -> (x >= bounds[0] && x <= bounds[1]) || (x >= bounds[1] && x <= bounds[0])).collect(Collectors.toList());

        for (Integer n : collect) {
            System.out.print(n + " ");
        }


    }
}
