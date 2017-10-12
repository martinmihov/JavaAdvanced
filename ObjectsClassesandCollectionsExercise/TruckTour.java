package ObjectsClassesandCollectionsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        Deque<Long> queue = new ArrayDeque<>();
        Deque<Long> queue2 = new ArrayDeque<>();
        for (int i = 0; i <n ; i++) {

            long[] pumpInfo = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long diff = pumpInfo[0] - pumpInfo[1];
            queue.offer(diff);
        }

        int index = 0;
        long sum = 0;
        queue2.addAll(queue);
        boolean rearrangeQueue =false;
        for (int i = 0; i <queue2.size() ; i++) {
            if (rearrangeQueue){
                rearrange(queue, queue2, index);
                rearrangeQueue = false;
            }
            long current = queue2.poll();
            sum += current;
            if (sum < 0){
                sum = 0;
                index++;
                rearrangeQueue = true;
                i=-1;
            }
        }
        System.out.println(index);
    }

    private static void rearrange(Deque<Long> queue, Deque<Long> queueCopy, int index) {
        queueCopy.clear();
        queueCopy.addAll(queue);
        for (int i = 0; i <index ; i++) {
            queueCopy.offer(queueCopy.poll());
        }


    }

}



