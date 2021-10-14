package literals;

import java.util.Locale;

public class LiteralsMain {
    public static void main(String[] args) {
        System.out.println(1 + "" + 2);
        System.out.println(Integer.toString(1) + Integer.toString(2));

        double quotient = 3/4;
        System.out.println(quotient); //egész számok(int) osztásakor az eredmény is egész lesz
        quotient = 3.0/4;
        System.out.println(quotient);
        quotient = 3*1.0/4;
        System.out.println(quotient);
        quotient = ((double)3) /4;
        System.out.println(quotient);
        quotient = 3/4d;
        System.out.println(quotient);

        long big = 3_244_444_444L;
        System.out.println(big);

        String word = "title".toUpperCase();
        System.out.println(word);

        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-2));
    }
}
