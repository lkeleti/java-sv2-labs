package stringbuilder;

import java.util.Locale;

public class PalindromeValidator {
    public boolean isPalindrome(String word) {
        StringBuilder sbOrig = new StringBuilder(word.toLowerCase(Locale.ROOT));
        StringBuilder sbReverse = new StringBuilder(sbOrig.reverse());
        sbOrig = new StringBuilder(word.toLowerCase(Locale.ROOT));
        return sbOrig.toString().equals(sbReverse.toString()) ? true : false;
    }

    public static void main(String[] args) {
        PalindromeValidator palindromeValidator = new PalindromeValidator();
        String word = "Kele men nem elek";
        System.out.println(word + " szöveg palindróm-e? " + palindromeValidator.isPalindrome(word));
        word = "Süt a nap";
        System.out.println(word + " szöveg palindróm-e? " + palindromeValidator.isPalindrome(word));
        word = "PAp";
        System.out.println(word + " szöveg palindróm-e? " + palindromeValidator.isPalindrome(word));
    }
}
