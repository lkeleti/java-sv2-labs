package chars;

public class Whitespace {
    public String makeWhitespaceToStar(String text) {
        char[] chars = text.toCharArray();
        String newText = "";
        for (char c: chars) {
            if (Character.isWhitespace(c)) {
                newText += '*';
            }
            else {
                newText += c;
            }
        }
        return newText;
    }

    public static void main(String[] args) {
        Whitespace whitespace = new Whitespace();
        System.out.println(whitespace.makeWhitespaceToStar("Ez egy\nspeciális\tszöveg."));
        char[] testCharArray = {'H', 'e', 'l', '\r', 'l', '\r', 'o'};
        String testText = new String(testCharArray);
        System.out.println(whitespace.makeWhitespaceToStar(testText));
    }
}
