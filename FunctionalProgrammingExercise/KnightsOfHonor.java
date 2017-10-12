package FunctionalProgrammingExercise;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] names = reader.readLine().split(" ");

        Consumer<String> print = x-> System.out.printf("Sir %s\n",x);
        for (String name:names) {
            print.accept(name);
        }
    }
}
