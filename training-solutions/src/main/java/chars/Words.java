package chars;

public class Words {
    public String pushWord(String word) {
//        String newWord = "";
//        for (char c: word.toCharArray()) {
//            newWord += (char)(c+1);
//        }
//        return newWord;

        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + 1);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Words words = new Words();
        System.out.println(words.pushWord("alma"));
    }
}
