package stringtype.registration;

public class UserValidator {
    public boolean isValidUsername(String username) {
        return username.length() == 0 ? false : true;
    }

    public boolean isValidPassword(String password1, String password2) {
        return password1.equals(password2) && password1.length() >= 8 ? true :false;
    }

    public boolean isValidEmail(String email) {
        int at = email.indexOf("@");
        int point = email.indexOf(".");
        return at != -1 && at != 0 && point != email.length()-1 && at != point-1 ? true : false;
    }

}
