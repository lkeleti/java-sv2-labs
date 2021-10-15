package chars;

public class LettersAndDigits {
    public void printLetterOrDigit(String text) {
        char[] chars = text.toCharArray();

        for (char c: chars) {
            if (Character.isAlphabetic(c)) {
                System.out.println(c + " : betű");
            }
            else {
                if (Character.isDigit(c)) {
                    System.out.println(c + " : számjegy");
                }
                else {
                    System.out.println(c + " : egyéb");
                }
            }
        }
    }

    public static void main(String[] args) {
        LettersAndDigits lettersAndDigits = new LettersAndDigits();
        lettersAndDigits.printLetterOrDigit("bfa68fF;X");
    }
}
