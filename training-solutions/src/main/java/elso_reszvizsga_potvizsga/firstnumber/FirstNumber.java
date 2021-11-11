package elso_reszvizsga_potvizsga.firstnumber;

public class FirstNumber {
    public char getFirstNumber(String s) {
        for (char c: s.toCharArray()){
            if (Character.isDigit(c)){
                return c;
            }
        }
        return ' ';
    }
}
