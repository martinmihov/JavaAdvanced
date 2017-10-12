package ObjectsClassesandCollectionsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cycles = Integer.parseInt(br.readLine());

        int[] prices = new int[cycles];
        StringBuilder sb = new StringBuilder();
        int[] span = new int[cycles];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <cycles ; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }

        stack.push(0);
        sb.append(1);
        sb.append("\r\n");

        for (int i = 1; i <prices.length ; i++) {
            while(!stack.isEmpty() && prices[i] >= prices[stack.peek()]){
                stack.pop();
            }
            sb.append(stack.isEmpty() ? i+1 : i-stack.peek());
            sb.append("\r\n");
            stack.push(i);
        }

        System.out.println(sb.toString());
    }
}
