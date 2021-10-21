package introexceptionfirstexception;

import java.util.Arrays;
import java.util.List;

public class Message {
    public static String decode(List<String> message) {
        StringBuilder result = new StringBuilder();
        for (String charCode: message) {
            result.append((char)Integer.parseInt(charCode));
        }
        return result.toString();
    }
    public static void main(String[] args) {
        List<String> codedMessage = Arrays.asList("76", "101", "103", "121", "101", "110", "32", "115", "122", "233", "112", "32", "110", "97", "112", "111", "100", "33");
        System.out.println(decode(codedMessage));
        List<String> anotherCodedMessage = Arrays.asList("69", "122", "32", "101", "103", "121", "32", "104", "105", "98", "225", "115", "32", "252", "122", "101", "110", "101", "116", "46");
        // Az volt a hiba, hogy a 101-es kód helyett 1O1 kód szerepelt 'O' betűvel
        System.out.println(decode(anotherCodedMessage));
    }

}
