package DataRepresentAndManipExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationsCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        long k = Long.parseLong(reader.readLine());

        System.out.println(binomial(n, k));
    }

    private static long binomial(long n, long k) {
        if (k > n - k){
            k = n - k;
        }

        long b = 1;
        for (long i = 1, m = n; i <= k; i++, m--){
            b = b * m / i;
        }
        return b;
    }
}
