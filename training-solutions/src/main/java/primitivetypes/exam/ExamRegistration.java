package primitivetypes.exam;

import java.time.LocalDate;
import java.util.Scanner;

public class ExamRegistration {
    public static void main(String[] args) {
        Exam exam = new Exam();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jelentkezés vizsgára");
        System.out.println("Ha már nincs több jelentkező, akkor a jelentkezést az end kulcsszó megadásával tudja lezárni!");

        boolean end = Boolean.valueOf("False");

        while (end == false) {
            System.out.print("Kérem adja meg a nevét: ");
            String name = scanner.nextLine();
            if (name.equals("end")) {
                end = true;
                break;
            }
            else {
                System.out.print("A születési idejét éééé-hh-nn formában: ");
                String birthDate = scanner.nextLine();
                System.out.print("Lakhelyének irányítószámát: " );
                String zip = scanner.nextLine();
                System.out.print("Osztályzatainak átlagát: ");
                String avgRates = scanner.nextLine();
                // Ha pontokat használ valaki, akkor lecserélem kötőjelre
                if (birthDate.indexOf(".") != -1) {
                    birthDate = birthDate.replace(".","-");
                }
                // Ha valaki a nap után is pontot írt, akkor azt is kötöjelre cseréltem, de arra nincs szükség
                if (birthDate.substring(birthDate.length()-1).equals("-")) {
                    birthDate = birthDate.substring(0,birthDate.length()-1);
                }
                //Ha valaki az átlagát tizedes vesszővel adta meg, akkor cserélem pontra
                avgRates = avgRates.replace(",",".");
                Person person = new Person(name, LocalDate.parse(birthDate), Integer.valueOf(zip),Double.valueOf(avgRates));
                exam.addPerson(person);
            }
            System.out.println(end);
        }
        System.out.println(exam.getRegisteredPersons());
    }
}
