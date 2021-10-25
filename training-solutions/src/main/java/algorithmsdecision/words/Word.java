package algorithmsdecision.words;

import java.util.List;

public class Word {
    public boolean containsLongerWord(List<String> words, String longWord) {
        for (String word: words) {
            if (word.length() > longWord.length()) {
                return true;
            }
        }
        return false;
    }
}
