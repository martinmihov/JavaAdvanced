package AbstractionExercises;

import java.util.Scanner;

public class CollectTheCoins {

    private static int NUMBER_OF_COINS_COLLECTED = 0;
    private static int NUMBER_OF_WALLS_HIT = 0;

    public static void main(String[] args) {
        String[][] board = new String[4][];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            board[i] = scanner.nextLine().split("");
        }
        String[] commands = scanner.nextLine().split("");
        int currentRow = 0;
        int currentCol = 0;
        String debug = "";
        for (int currentCommand = 0; currentCommand < commands.length; currentCommand++) {
            switch (commands[currentCommand]) {
                case ">":
                    if (currentCol < board[currentRow].length - 1) {
                        currentCol++;
                    } else {
                        NUMBER_OF_WALLS_HIT++;
                    }
                    break;
                case "V":
                    if (currentRow < 3 && currentCol < board[currentRow + 1].length) {
                        currentRow++;
                    } else {
                        NUMBER_OF_WALLS_HIT++;
                    }
                    break;
                case "<":
                    if (currentCol > 0) {
                        currentCol--;
                    } else {
                        NUMBER_OF_WALLS_HIT++;
                    }
                    break;
                case "^":
                    if (currentRow > 0 && currentCol < board[currentRow - 1].length) {
                        currentRow--;
                    } else {
                        NUMBER_OF_WALLS_HIT++;
                    }
                    break;
            }
            if ("$".equals(board[currentRow][currentCol])) {
                NUMBER_OF_COINS_COLLECTED++;
                board[currentRow][currentCol] = "s";
            }
        }
        System.out.println("Coins = " + NUMBER_OF_COINS_COLLECTED);
        System.out.println("Walls = " + NUMBER_OF_WALLS_HIT);
    }
}