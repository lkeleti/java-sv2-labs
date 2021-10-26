package recursion;

import java.util.Locale;

public class Vowels {
    public enum VowelEnum {
        A,Á,E,É,I,Í,O,Ó,Ö,Ő,U,Ú,Ü,Ű
    }
    public int isVowel(String c) {
        for (VowelEnum item: VowelEnum.values()){
            if (c.toUpperCase(Locale.ROOT).equals(item.name())) {
                return 1;
            }
        }
        return 0;
    }

    public int getNumberOfVowels(String word) {
        if (word.length() == 0) {
            return 0;
        }
            else {
                return getNumberOfVowels(word.substring(1,word.length())) + isVowel(word.substring(0,1));
        }
    }
}
