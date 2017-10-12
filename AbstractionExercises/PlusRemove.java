package AbstractionExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PlusRemove {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<char[]> orignalMatrix = new ArrayList<>();
        List<char[]> copyMatrix = new ArrayList<>();

        while (true) {
            String input = reader.readLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }

            orignalMatrix.add(input.toCharArray());
            copyMatrix.add(input.toUpperCase().toCharArray());
        }
        manipulateMatrix(orignalMatrix, copyMatrix);
        printMatrix(orignalMatrix);
    }

    private static void printMatrix(List<char[]> orignalMatrix) {
        for (char[] anOriginalMatrix : orignalMatrix) {
            System.out.println(String.valueOf(anOriginalMatrix).replace("\0", ""));
        }
    }

    private static void manipulateMatrix(List<char[]> orignalMatrix, List<char[]> copyMatrix) {
        for (int i = 0; i < orignalMatrix.size() - 2; i++) {
            for (int j = 0; j < orignalMatrix.get(i).length; j++) {
                try {
                    char a = copyMatrix.get(i)[j];
                    char b = copyMatrix.get(i + 1)[j - 1];
                    char c = copyMatrix.get(i + 1)[j];
                    char d = copyMatrix.get(i + 1)[j + 1];
                    char e = copyMatrix.get(i + 2)[j];
                    if (a == b && b == c && c == d && d == e) {
                        orignalMatrix.get(i)[j] = '\0';
                        orignalMatrix.get(i + 1)[j - 1] = '\0';
                        orignalMatrix.get(i + 1)[j] = '\0';
                        orignalMatrix.get(i + 1)[j + 1] = '\0';
                        orignalMatrix.get(i + 2)[j] = '\0';
                    }
                } catch (IndexOutOfBoundsException e) {
                }
            }
        }
    }
}
