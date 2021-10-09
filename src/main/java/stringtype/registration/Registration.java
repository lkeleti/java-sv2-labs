package stringtype.registration;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        UserValidator userValidator = new UserValidator();
        String username;
        String password1;
        String password2;
        String email;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem adja meg a felhasználói nevet: ");
        username = scanner.nextLine();
        System.out.println("Kérem adja meg a jelszót: ");
        password1 = scanner.nextLine();
        System.out.println("Kérem adja meg a jelszót mégegyszer: ");
        password2 = scanner.nextLine();
        System.out.println("Kérem adja meg az email címet: ");
        email = scanner.nextLine();

        System.out.println(userValidator.isValidUsername(username));
        System.out.println(userValidator.isValidPassword(password1,password2));
        System.out.println(userValidator.isValidEmail(email));
    }
}
