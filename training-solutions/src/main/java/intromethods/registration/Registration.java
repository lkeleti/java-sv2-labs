package intromethods.registration;

import java.time.LocalDate;
import java.util.Scanner;

public class Registration {
    public String fullName(String familyName, String givenName) {
        return familyName + " " + givenName;
    }

    public LocalDate concatYearMonthDay(int year, int month, int day) {
        return LocalDate.of(year,month,day);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Registration registration = new Registration();

        System.out.print("Kérem a vezetéknevét: ");
        String familyName = scanner.nextLine();
        System.out.print("Kérem a keresztnevét: ");
        String givenName = scanner.nextLine();
        String name = registration.fullName(familyName,givenName);

        System.out.print("Kérem a születési évét: ");
        int yearOfBirth = scanner.nextInt();
        System.out.print("Hanyadik hónapban született: ");
        int monthOfBirth = scanner.nextInt();
        System.out.print("Hanyadikán született: ");
        int dayOfBirth = scanner.nextInt();
        LocalDate birthDate = registration.concatYearMonthDay(yearOfBirth, monthOfBirth, dayOfBirth);

        scanner.nextLine();
        System.out.print("Kérem adja meg az email címét: ");
        String email = scanner.nextLine();

        Person person = new Person(name, birthDate, email);

        System.out.println(person);


    }
}
