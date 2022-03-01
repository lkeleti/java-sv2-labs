package covid;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CovidService {

    private CovidRepository cr;
    private Scanner scanner = new Scanner(System.in);
    private PersonValidator pv = new PersonValidator();

    public CovidService(DataSource dataSource) {
        cr = new CovidRepository(dataSource);
    }

    public void menu() {
        int choice = 0;
        while (choice != 9) {
            choice = 0;
            System.out.println("1. Regisztráció");
            System.out.println("2. Tömeges regisztráció");
            System.out.println("3. Generálás");
            System.out.println("4. Oltás");
            System.out.println("5. Oltás meghiúsulás");
            System.out.println("6. Riport");
            System.out.println("9. Kilépés");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                choosenMenu(choice);
            } catch (NumberFormatException ex) {
                System.out.println("Hibás adat! Kérem adjon meg egy számot 1-6 között, kilépéshez válassza a 9-et");
            }
        }
    }

    private void choosenMenu(int choice) {
        switch (choice) {
            case 1:
                registerPerson();
                break;
            case 2:
                registerPeople();
                break;
            case 3:
                generateListByZip();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }

    private void generateListByZip() {
        System.out.print("Melyik irányítószámhoz generáljam a listát: ");
        String zip = scanner.nextLine();
        if (!pv.isValidZip(zip)) {
            throw new IllegalArgumentException("Invalid postal code!");
        }
        System.out.println(cr.findCityByZip(zip));
        List<Person> personToVaccination = cr.generateVaccinationList(zip);

        List<String> datas = new ArrayList<>();
        datas.add("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám");
        LocalTime timeToCall = LocalTime.of(8, 0);
        for (Person person : personToVaccination) {
            datas.add(timeToCall.toString() + ";"
                    + person.getFullName() + ";"
                    + person.getZip() + ";"
                    + person.getAge() + ";"
                    + person.getEmail() + ";"
                    + person.getTaj());
            timeToCall = timeToCall.plusMinutes(30);
        }
        Path path = Path.of("src/main/resources/vaccination_list_" + zip + ".csv");
        try {
            Files.write(path, datas);

        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write to file", ioe);
        }
    }

    private void registerPerson() {
        System.out.print("Kérem írja be a TAJ számát: ");
        String taj = scanner.nextLine();
        if (!pv.isValidTaj(taj)) {
            throw new IllegalArgumentException("Invalid TAJ!");
        }

        System.out.print("Kérem írja be a Nevét: ");
        String name = scanner.nextLine();
        if (!pv.isValidName(name)) {
            throw new IllegalArgumentException("Invalid name!");
        }

        System.out.print("Kérem adja meg a lakhelye irányítószámát: ");
        String zip = scanner.nextLine();
        if (!pv.isValidZip(zip)) {
            throw new IllegalArgumentException("Invalid postal code!");
        }
        System.out.println(cr.findCityByZip(zip));

        System.out.print("Kérem adja meg az életkorát: ");
        int age = scanner.nextInt();
        if (!pv.isValidAge(age)) {
            throw new IllegalArgumentException("Invalid age!");
        }
        scanner.nextLine();

        System.out.print("Kérem adja meg az e-mail címét: ");
        String email = scanner.nextLine();
        if (!pv.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email!");
        }

        Person person = new Person(name, zip, age, email, taj);
        cr.savePerson(person);
        cr.saveCitizen(person);
    }

    private void registerPeople() {
        Path path = null;
        System.out.print("Type the path: ");
        path = Path.of("src/main/resources/" + scanner.nextLine());
        try (
                BufferedReader br = new BufferedReader(Files.newBufferedReader(path));
        ) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                registerPeopleByLine(pv, cr, line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file: " + path.toString(), ioe);
        }
    }

    private void registerPeopleByLine(PersonValidator pv, CovidRepository cr, String line) {
        String[] datas = line.split(";");
        String taj = datas[4];
        taj = taj + pv.lastNumberOfTaj(taj);
        Person person = new Person(datas[0], datas[1], Integer.parseInt(datas[2]), datas[3], taj);
        cr.savePerson(person);
        cr.saveCitizen(person);
    }
}
