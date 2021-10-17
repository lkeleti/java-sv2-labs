package stringseparate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codes {
    public String getCodesStartWithLetter(List<String> codes) {
        StringBuilder newCodes = new StringBuilder();
        for (String code : codes) {
            char firstChar;
            firstChar = code.charAt(0);
            if (Character.isAlphabetic(firstChar)) {
                newCodes.append(code);
                newCodes.append(", ");
            }
        }
        newCodes.delete(newCodes.length()-2,newCodes.length());
        return newCodes.toString();
    }

    public static void main(String[] args) {
        Codes codes = new Codes();
        List<String> codeList = new ArrayList<>(Arrays.asList("T57fbj", "xtcu45", "f578GVHd","57fbj", "2tcu45", "578GVHd"));
        System.out.println(codes.getCodesStartWithLetter(codeList));
    }
}
