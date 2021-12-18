package schoolrecords;

import java.util.*;

public class SchoolRecordsController {
    private ClassRecords classRecords;
    private List<Subject> subjects;
    private List<Tutor> tutors;

    public static void main(String[] args) {
        SchoolRecordsController schoolRecordsController = new SchoolRecordsController();
        schoolRecordsController.subjects = new ArrayList<>();
        schoolRecordsController.tutors = new ArrayList<>();
        schoolRecordsController.initSchool();
        schoolRecordsController.classRecords = new ClassRecords("First class", new Random());
        boolean end = false;
        while (!end) {
            schoolRecordsController.showMenu();
            int selectedMenu = schoolRecordsController.readMenu();
            end = schoolRecordsController.execMenuItem(selectedMenu);
        }
    }

    private void initSchool() {
        subjects.add(new Subject("földrajz"));
        subjects.add(new Subject("matematika"));
        subjects.add(new Subject("biológia"));
        subjects.add(new Subject("zene"));
        subjects.add(new Subject("fizika"));
        subjects.add(new Subject("kémia"));

        tutors.add(new Tutor("Tanár Csilla", subjects));
    }

    private void showMenu() {
        System.out.println("1. Diákok nevének listázása");
        System.out.println("2. Diák név alapján keresése");
        System.out.println("3. Diák létrehozása");
        System.out.println("4. Diák név alapján törlése");
        System.out.println("5. Diák feleltetése");
        System.out.println("6. Osztályátlag kiszámolása");
        System.out.println("7. Tantárgyi átlag kiszámolása");
        System.out.println("8. Diákok átlagának megjelenítése");
        System.out.println("9. Diák átlagának kiírása");
        System.out.println("10. Diák tantárgyhoz tartozó átlagának kiírása");
        System.out.println("11. Kilépés");
    }

    private int readMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String inputData = scanner.nextLine();

            try {
                return Integer.parseInt(inputData);
            } catch (NumberFormatException nfe) {
                System.out.println("Kérem válasszon a fenti menüpontokból!");
            }
        }
    }

    private boolean execMenuItem(int selected) {
        String studentName;
        Student student;
        Subject subject;
        switch (selected) {
            case 1:
                System.out.println(classRecords.listStudentNames());
                break;
            case 2:
                studentName = readStudentName();
                System.out.println(classRecords.findStudentByName(studentName));
                break;
            case 3:
                studentName = readStudentName();
                classRecords.addStudent(new Student(studentName));
                break;
            case 4:
                studentName = readStudentName();
                Student studentToRemove = classRecords.findStudentByName(studentName);
                classRecords.removeStudent(studentToRemove);
                break;
            case 5:
                grading();
                break;
            case 6:
                System.out.println(classRecords.calculateClassAverage());
                break;
            case 7:
                subject = readSubject(new Scanner(System.in));
                System.out.println(classRecords.calculateClassAverageBySubject(subject));
                break;
            case 8:
                printStudyResults();
                break;
            case 9:
                studentName = readStudentName();
                student = classRecords.findStudentByName(studentName);
                System.out.println(student.calculateAverage());
                break;
            case 10:
                studentName = readStudentName();
                student = classRecords.findStudentByName(studentName);
                subject = readSubject(new Scanner(System.in));
                System.out.println(student.calculateSubjectAverage(subject));
                break;
            case 11:
                return true;
        }
        return false;
    }

    private void printStudyResults() {
        List<StudyResultByName> studyResultByNames = classRecords.listStudyResults();
        for (StudyResultByName studyResultByName : studyResultByNames) {
            System.out.println(studyResultByName.getStudentName() + ": " + studyResultByName.getStudyAverage());
        }
    }

    private void grading() {
        Student studentToGrading = classRecords.repetition();
        System.out.println(studentToGrading.getName() + " fog felelni!");
        Scanner scanner = new Scanner(System.in);

        String markName = readMark(scanner);
        Subject subject = readSubject(scanner);
        Tutor tutor = readTutor(scanner);

        studentToGrading.grading(new Mark(markName, subject, tutor));
    }

    private Tutor readTutor(Scanner scanner) {
        while (true) {
            System.out.print("Kérem írja be a tanár nevét: ");
            String inputData = scanner.nextLine();
            if (inputData == null || inputData.isEmpty()) {
                System.out.println("A tanár neve nem lehet üres string!");
            } else {
                return findTutorByName(inputData);
            }
        }
    }

    private Subject readSubject(Scanner scanner) {
        while (true) {
            System.out.print("Kérem írja be a tantárgy nevét: ");
            String inputData = scanner.nextLine();
            if (inputData == null || inputData.isEmpty()) {
                System.out.println("A tantárgy nem lehet üres string!");
            } else {
                return findSubjectByName(inputData);
            }
        }
    }

    private Tutor findTutorByName(String name) {
        for (Tutor tutor : tutors) {
            if (tutor.getName().equals(name)) {
                return tutor;
            }
        }
        throw new IllegalArgumentException("This tutor not in list: " + name);
    }

    private Subject findSubjectByName(String name) {
        for (Subject subject : subjects) {
            if (subject.getSubjectName().equals(name)) {
                return subject;
            }
        }
        throw new IllegalArgumentException("This subject not in list: " + name);
    }

    private String readMark(Scanner scanner) {
        while (true) {
            System.out.print("Kérem írja be az érdemjegyet (A, B, C, D, E) ");
            String inputData = scanner.nextLine().toUpperCase(Locale.ROOT).trim();
            if (inputData.equals("A") ||
                    inputData.equals("B") ||
                    inputData.equals("C") ||
                    inputData.equals("D") ||
                    inputData.equals("E")
            ) {
                return inputData;
            } else {
                System.out.println("Az érdemjegy csak A, B, C, D, E értékek lehetnek!");
            }
        }
    }

    private String readStudentName() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Kérem a keresett diák nevét: ");
            String name = scanner.nextLine();
            if (name == null || name.isEmpty()) {
                System.out.println("A diák neve nem lehet üres string!");
            } else {
                return name;
            }
        }
    }
}
