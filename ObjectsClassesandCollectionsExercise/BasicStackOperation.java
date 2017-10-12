package ObjectsClassesandCollectionsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicStackOperation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] nsx = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = nsx[0]; i > 0; i--) {
            stack.offer(numbers[i - 1]);
        }

        for (int i = 0; i < nsx[1]; i++) {
            stack.pop();
        }

        if(stack.isEmpty()){
            System.out.println("0");
            return;
        }
        if(stack.contains(nsx[2])){
            System.out.println("true");
        } else {
            System.out.println(stack.iterator().next());
        }
    }
}
