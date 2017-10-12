package JavaAdvRetakeExamMay2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] cards = reader.readLine().split("\\s+");

        int counter = 1;
        int sumTotal = 0;
        int currentSeq = 0;
        String previousCardType = "";

        for (int i = 0; i < cards.length; i++) {
            String[] cardKind = cards[i].split("");

            String cardType = "";
            int cardValue = 0;

            if (cardKind[0].equals("1")) {
                cardValue = 10;
                cardType = cardKind[2];
            } else if (Integer.parseInt(cardKind[0]) >= 2 && Integer.parseInt(cardKind[0]) <= 9) {
                cardValue = Integer.parseInt(cardKind[0]);
                cardType = cardKind[1];
            } else {
                switch (cardKind[0]) {
                    case "J":
                        cardValue = 12;
                        cardType = cardKind[1];
                        break;
                    case "Q":
                        cardValue = 13;
                        cardType = cardKind[1];
                        break;
                    case "K":
                        cardValue = 14;
                        cardType = cardKind[1];
                        break;
                    case "A":
                        cardValue = 15;
                        cardType = cardKind[1];
                        break;
                    default:

                }
            }
            if (cardType.equalsIgnoreCase(previousCardType) || currentSeq == 0) {
                counter++;
                currentSeq += cardValue;
            } else if (counter == 1 && !cardType.equalsIgnoreCase(previousCardType)) {
                counter = 1;
                currentSeq = cardValue;
                sumTotal += currentSeq;
                currentSeq = 0;
            } else if (counter > 1 && !cardType.equalsIgnoreCase(previousCardType)) {
                previousCardType = cardType;
                sumTotal += currentSeq * counter;
                counter = 1;
                currentSeq = 0;
            }
        }
        System.out.println(sumTotal);
    }
}
