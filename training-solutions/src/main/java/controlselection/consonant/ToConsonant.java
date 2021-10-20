package controlselection.consonant;

import java.util.Locale;

public class ToConsonant {
    private final char[] VOWELS = {'a', 'á', 'e', 'é', 'i', 'í', 'o', 'ó', 'ö','ő','u', 'ú', 'ű', 'ü'};

    public char changeVowels(char character) {
        char result = character;
        String characterString = String.valueOf(character);
        characterString = characterString.toLowerCase(Locale.ROOT);
        char lowerCaseCharacter = characterString.charAt(0);

        for (char c: VOWELS) {
            if (c == lowerCaseCharacter) {
                int charValue = character + 1 ;
                result = (char)charValue;
            }
        }
        return result;
    }
}
