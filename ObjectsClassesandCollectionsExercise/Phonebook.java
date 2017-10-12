package ObjectsClassesandCollectionsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, String> phonebook = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!input.equals("search")) {
            String[] info = input.split("-");
            String name = info[0];
            String phoneNumber = info[1];
            if (!phonebook.containsKey(name)) {
                phonebook.put(name, phoneNumber);
            }
            phonebook.put(name, phoneNumber);
            input = reader.readLine();
        }
        input = reader.readLine();
        while (!input.equals("stop")){
            if(phonebook.containsKey(input)){
                System.out.printf("%s -> %s\n",input,phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.\n",input);
            }
            input = reader.readLine();
        }
    }


}
