package junit5fixture;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void addWord(String word) {
        words.add(word);
    }

    public void getWordsStartWith(String prefix) {
        List<String> wordsToDelete = new ArrayList<>();
        for (int i =0; i< words.size(); i++) {
            if (!words.get(i).startsWith(prefix)) {
                wordsToDelete.add(words.get(i));
            }
        }

        for (int i = 0; i < wordsToDelete.size(); i++) {
            words.remove(wordsToDelete.get(i));
        }
    }

    public void getWordsWithLength(int length) {
        List<String> wordsToDelete = new ArrayList<>();
        for (int i =0; i< words.size(); i++) {
            if (words.get(i).length() != length) {
                wordsToDelete.add(words.get(i));
            }
        }

        for (int i = 0; i < wordsToDelete.size(); i++) {
            words.remove(wordsToDelete.get(i));
        }
    }
}
