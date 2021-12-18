package masodik_reszvizsga_potvizsga.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Sentences {
    private List<String> sentences = new ArrayList<>();

    public List<String> getSentences() {
        return sentences;
    }

    public void addSentence(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!sentence.substring(0, 1).equals(sentence.substring(0, 1).toUpperCase(Locale.ROOT))) {
            throw new IllegalArgumentException("Sentence must start with capital!");
        }
        if (!checkLastChar(sentence)) {
            throw new IllegalArgumentException("Sentence must end with ending mark!");
        }
        else{
            sentences.add(sentence);
        }
    }

    private boolean checkLastChar(String sentence) {
        Character lastChar = sentence.charAt(sentence.length() - 1);
        return (lastChar == '.' || lastChar == '!' || lastChar == '?');
    }

    public String findLongestSentence() {
        if (sentences == null || sentences.isEmpty()) {
            throw new IllegalStateException("Sentences list is empty!");
        }

        String longestSentence = sentences.get(0);
        for (String sentence : sentences) {
            if (sentence.length() > longestSentence.length()) {
                longestSentence = sentence;
            }
        }
        return longestSentence;
    }
}
