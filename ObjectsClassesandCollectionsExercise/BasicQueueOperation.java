package ObjectsClassesandCollectionsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

public class BasicQueueOperation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nsx = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nsx[0]; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < nsx[1]; i++) {
            if(queue.size() < 1){
                break;
            }
            queue.pollFirst();
        }
        if(queue.isEmpty()){
            System.out.println("0");
            return;
        }
        if(queue.contains(nsx[2])){
            System.out.println("true");
        } else if(!queue.contains(nsx[2])) {
            System.out.println(queue.stream().min(Comparator.naturalOrder()).get());
        }

    }
}
