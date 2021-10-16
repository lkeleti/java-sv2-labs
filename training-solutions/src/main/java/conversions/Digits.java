package conversions;

import java.util.ArrayList;
import java.util.List;

public class Digits {
    private List<Integer> listOfDigits = new ArrayList<>();

    public List<Integer> getListOfDigits() {
        return listOfDigits;
    }

    public void addDigitsToList(String text) {
        for (char c: text.toCharArray()) {
            if (Character.isDigit(c)) {
                listOfDigits.add(Character.getNumericValue(c));
            }
        }
    }

    public static void main(String[] args) {
        Digits digits = new Digits();
        digits.addDigitsToList("123szöveg456valami789");
        System.out.println(digits.getListOfDigits());
    }
}
