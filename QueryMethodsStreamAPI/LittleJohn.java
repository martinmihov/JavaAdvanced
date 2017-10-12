package QueryMethodsStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int small = 0;
        int medium = 0;
        int large = 0;

        Pattern pattern = Pattern.compile("[>]{1,3}-----[>]{1,2}");
        for (int i = 0; i < 4; i++) {
            String input = reader.readLine();
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                if (matcher.group().startsWith(">>>") && matcher.group().endsWith(">>")) {
                    large++;
                } else if (matcher.group().startsWith(">>")) {
                    medium++;
                } else if (matcher.group().startsWith(">")) {
                    small++;
                }
            }
        }
        StringBuilder numberDecString = new StringBuilder();
        numberDecString.append(small).append(medium).append(large);
        int numberDec = Integer.parseInt(numberDecString.toString());
        StringBuilder binarySb = new StringBuilder(Integer.toBinaryString(numberDec));
        String binary = binarySb.toString();
        String reversedBinary = binarySb.reverse().toString();
        String concat = binary + reversedBinary;
        int result = Integer.parseInt(concat,2);
        System.out.println(result);
    }
}
