package StringProcessingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String phoneNumber = reader.readLine();
        Pattern pattern = Pattern.compile("^\\+359([ -])2\\1\\d{3}\\1\\d{4}$");


        while(!phoneNumber.equalsIgnoreCase("end")){
            Matcher matcher = pattern.matcher(phoneNumber);
            if(matcher.find()){
                System.out.println(matcher.group());
            }
            phoneNumber = reader.readLine();
        }
    }
}
