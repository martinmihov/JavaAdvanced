package StringProcessingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        Pattern pattern = Pattern.compile("^[A-Z][a-z]+.? [A-Z][a-z]+$");


        while(!name.equalsIgnoreCase("end")){
            Matcher matcher = pattern.matcher(name);
            if(matcher.find()){
                System.out.println(matcher.group());
            }
            name = reader.readLine();
        }
    }
}
