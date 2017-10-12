package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        rectangleArea(); // Problem 1
//        triangleArea(); // Problem 2
//        formattingNumbers(); // Problem 3
//        calculateExpression(); // Problem 4
//        oddAndEvenPairs(); // Problem 5
//        hitTheTarget(); // Problem 6
//        characterMultiplier(); // Problem 7
//        System.out.println(getFirstOddOrEvenElements()); // Problem 8
//        byteParty(); // Problem 9
//        xBits(); // Problem 10
//        gameOfNames(); // Problem 11
//        vehiclePark(); // Problem 12
        blurFIlter(); // Problem 13
    }

    private static String rectangleArea() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = bufferedReader.readLine().split("\\s+");

        double sideA = Double.parseDouble(numbers[0]);
        double sideB = Double.parseDouble(numbers[1]);
        Double rectangleArea = sideA * sideB;

        return String.valueOf(System.out.printf("%.2f", rectangleArea));
    }

    private static String triangleArea() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] pointA = bufferedReader.readLine().split("\\s+");
        String[] pointB = bufferedReader.readLine().split("\\s+");
        String[] pointC = bufferedReader.readLine().split("\\s+");

        int Ax = Integer.parseInt(pointA[0]);
        int Ay = Integer.parseInt(pointA[1]);

        int Bx = Integer.parseInt(pointB[0]);
        int By = Integer.parseInt(pointB[1]);

        int Cx = Integer.parseInt(pointC[0]);
        int Cy = Integer.parseInt(pointC[1]);

        int triangleArea = (Ax * (By - Cy) + Bx * (Cy - Ay) + Cx * (Ay - By)) / 2;

        return String.valueOf(System.out.printf("%d", Math.abs(triangleArea)));
    }

    private static String formattingNumbers() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = bufferedReader.readLine().split("\\s+");

        int a = Integer.parseInt(numbers[0]);
        double b = Double.parseDouble(numbers[1]);
        double c = Double.parseDouble(numbers[2]);

        String first = String.format("%-10s", Integer.toHexString(a).toUpperCase());
        String second = String.format("%010d", Integer.parseInt(Integer.toBinaryString(a)));
        String third = String.format("%10.2f", b);
        String fourth = String.format("%-10.3f", c);

        return String.valueOf(System.out.printf("|" + first + "|" + second + "|" + third + "|" + fourth + "|"));
    }

    private static String calculateExpression() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = bufferedReader.readLine().split("\\s+");

        double a = Double.parseDouble(numbers[0]);
        double b = Double.parseDouble(numbers[1]);
        double c = Double.parseDouble(numbers[2]);

        double f1Pow = (a + b + c) / Math.sqrt(c);
        double f1Brakets = (Math.pow(a, 2) + Math.pow(b, 2)) / ((Math.pow(a, 2) - Math.pow(b, 2)));
        double f1 = Math.pow(f1Brakets, f1Pow);
        double f2 = Math.pow((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3)), (a - b));
        double absAvarageValue = Math.abs(((a + b + c) / 3) - ((f1 + f2) / 2));

        return String.valueOf(System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, absAvarageValue));
    }

    private static void characterMultiplier() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split("\\s+");
        String str1 = strings[0];
        String str2 = strings[1];

        Long result = 0L;

        int forCycleLength = Math.min(str1.length(), str2.length());
        int innerCycleLength = Math.max(str1.length(), str2.length());

        for (int i = 0; i < forCycleLength; i++) {
            int sum = str1.charAt(i) * str2.charAt(i);
            result += sum;

            if (forCycleLength == str1.length()) {
                for (int j = forCycleLength; j < innerCycleLength; j++) {
                    result += str2.charAt(j);
                }
            } else {
                for (int j = forCycleLength; j < innerCycleLength; j++) {
                    result += str1.charAt(j);
                }
            }
        }
        System.out.printf("%d", result);
    }

    private static String getFirstOddOrEvenElements() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = bufferedReader.readLine().split("\\s+");
        String[] commands = bufferedReader.readLine().split("\\s+");

        List<Integer> resultCollection = new ArrayList<>();

        switch (commands[2]) {
            case "odd":
                for (int i = 0; i < numbers.length; i++) {
                    int oddNumber = Integer.parseInt(numbers[i]);

                    if (oddNumber % 2 == 1) {
                        resultCollection.add(oddNumber);
                    }
                }
                break;
            case "even":
                for (int i = 0; i < numbers.length; i++) {
                    int evenNumber = Integer.parseInt(numbers[i]);

                    if (evenNumber % 2 == 0) {
                        resultCollection.add(evenNumber);
                    }
                }
                break;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Integer number : resultCollection) {
            stringBuilder.append(number);
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    private static void gameOfNames() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        byte countOfPlayers = Byte.parseByte(bufferedReader.readLine());

        Map<String, Integer> rankingList = new HashMap<>();

        for (int i = 0; i < countOfPlayers; i++) {
            String name = bufferedReader.readLine();
            Integer playerScore = Integer.parseInt(bufferedReader.readLine());
            for (int j = 0; j < name.length(); j++) {
                if (name.charAt(j) % 2 == 1) {
                    playerScore -= name.charAt(j);
                } else {
                    playerScore += name.charAt(j);
                }
            }
            rankingList.put(name, playerScore);
        }

        rankingList
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(1)
                .forEach(x -> System.out.printf("The winner is %s - %d points", x.getKey(), x.getValue()));
    }

    private static void byteParty() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int forCycleLength = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[forCycleLength];

        for (int i = 0; i < forCycleLength; i++) {
            int b = Integer.parseInt(bufferedReader.readLine());
            numbers[i] = b;
        }

        while (true) {
            String[] commands = bufferedReader.readLine().split("\\s+");

            if (commands[0].equals("party")) {
                for (int number : numbers) {
                    System.out.println(number);
                }
                break;
            }

            int action = Integer.parseInt(commands[0]);
            int position = Integer.parseInt(commands[1]);

            switch (action) {
                case -1:
                    int mask = 1 << position;
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] ^ mask;
                    }
                    break;
                case 0:
                    int mask0 = ~(1 << position);
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] & mask0;
                    }
                    break;
                case 1:
                    int mask1 = 1 << position;
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] | mask1;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private static void xBits() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] xBits = new String[8];

        for (int i = 0; i < 8; i++) {
            String binary = String.format("%32s"
                    , Integer.toBinaryString(Integer.parseInt(reader.readLine()))).replace(' ', '0');
            xBits[i] = binary;
        }
        int counter = 0;
        for (int i = 0; i < xBits.length - 2; i++) {

            for (int j = 0; j < xBits[i].length() - 2; j++) {
                String topRow = xBits[i].charAt(j) + "" + xBits[i].charAt(j + 1) + xBits[i].charAt(j + 2);
                String mdlRow = xBits[i + 1].charAt(j) + "" + xBits[i + 1].charAt(j + 1) + xBits[i + 1].charAt(j + 2);
                String bottonRow = xBits[i + 2].charAt(j) + "" + xBits[i + 2].charAt(j + 1) + xBits[i + 2].charAt(j + 2);
                if (topRow.equals("101") && mdlRow.equals("010") && bottonRow.equals("101")) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }

    private static void oddAndEvenPairs() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.length; i += 2) {
            if (numbers.length % 2 == 1) {
                System.out.println("invalid length");
                break;
            }

            if (numbers[i + 1] % 2 == 0 && numbers[i] % 2 == 0) {
                System.out.printf("%d, %d -> both are even\n", numbers[i], numbers[i + 1]);
            } else if (numbers[i + 1] % 2 == 1 && numbers[i] % 2 == 1) {
                System.out.printf("%d, %d -> both are odd\n", numbers[i], numbers[i + 1]);
            } else {
                System.out.printf("%d, %d -> different\n", numbers[i], numbers[i + 1]);
            }
        }

    }

    private static void hitTheTarget() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(reader.readLine());

        for (int i = 1; i < 21; i++) {
            for (int j = 20; j > 0; j--) {
                if (i + j == target) {
                    System.out.printf("%d + %d = %d\n", i, j, target);
                }
            }
        }
        for (int i = 1; i < 21; i++) {
            for (int j = 20; j > 0; j--) {
                if (i - j == target) {
                    System.out.printf("%d - %d = %d\n", i, j, target);
                }
            }
        }
    }

    private static void vehiclePark() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] vehiclePark = reader.readLine().split("\\s+");

        ArrayList<String> vehicles = new ArrayList<>();

        for (int i = 0; i < vehiclePark.length; i++) {
            vehicles.add(vehiclePark[i]);
        }

        String orders = reader.readLine();

        int soldCount = 0;

        while (!orders.equals("End of customers!")) {
            String[] order = orders.split("\\s");
            Character vehType = order[0].substring(0, 1).toLowerCase().charAt(0);
            Integer seatsCount = Integer.parseInt(order[2]);
            int price = vehType * seatsCount;
            if (vehicles.contains(vehType + "" + seatsCount)) {
                System.out.printf("Yes, sold for %d$\n", price);
                soldCount++;
                vehicles.remove(vehType + "" + seatsCount);
            } else {
                System.out.println("No");
            }
            orders = reader.readLine();
        }

        System.out.print("Vehicles left:");

        for (int i = 0; i < vehicles.size(); i++) {
            System.out.print(" " + vehicles.get(i));
            if (vehicles.size() == i + 1) {
                break;
            } else {
                System.out.print(",");
            }
        }

        System.out.printf("\nVehicles sold: %d\n", soldCount);
    }

    private static void blurFIlter() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int blurAmount = Integer.parseInt(reader.readLine());

        int[] matrixSize = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        long[][] matrix = new long[matrixSize[0]][];

        for (int i = 0; i < matrixSize[0]; i++) {
            long[] matrixValue = Arrays.stream(reader.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
            matrix[i] = matrixValue;
        }

        int[] targetCell = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        try {
            matrix[targetCell[0] - 1][targetCell[1] - 1] += blurAmount;
        } catch (IndexOutOfBoundsException ex) {
        }
        try {
            matrix[targetCell[0] - 1][targetCell[1]] += blurAmount;
        } catch (IndexOutOfBoundsException ex) {
        }
        try {
            matrix[targetCell[0] - 1][targetCell[1] + 1] += blurAmount;
        } catch (IndexOutOfBoundsException ex) {
        }
        try {
            matrix[targetCell[0]][targetCell[1] - 1] += blurAmount;
        } catch (IndexOutOfBoundsException ex) {
        }
        try {
            matrix[targetCell[0]][targetCell[1]] += blurAmount;
        } catch (IndexOutOfBoundsException ex) {
        }
        try {
            matrix[targetCell[0]][targetCell[1] + 1] += blurAmount;
        } catch (IndexOutOfBoundsException ex) {
        }
        try {
            matrix[targetCell[0] + 1][targetCell[1] - 1] += blurAmount;
        } catch (IndexOutOfBoundsException ex) {
        }
        try {
            matrix[targetCell[0] + 1][targetCell[1]] += blurAmount;
        } catch (IndexOutOfBoundsException ex) {
        }
        try {
            matrix[targetCell[0] + 1][targetCell[1] + 1] += blurAmount;
        } catch (IndexOutOfBoundsException ex) {
        }
        for (int i = 0; i < matrix.length; i++) {
            String result = Arrays
                    .toString(matrix[i])
                    .replace("[","")
                    .replace("]","")
                    .replace(",","");
            System.out.println(result);
        }
    }

}
