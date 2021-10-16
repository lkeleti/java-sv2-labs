package stringbasic;

public class UniversityMain {
    public static void main(String[] args) {
        Person firstPerson = new Person("Nagy Tihamér","nagy.tihamer@gmail.com",
                "1126 Budapest, Váci utca 1.","123456789","0000000-11111111-22222222",
                "+36/30/123-4567");
        Person secondPerson = new Person("Kis Eleonóra", "kis.eleonora@gmail.com",
                "1130 Budapest, Váci út 1.", "987654321", "11111111-22222222-33333333",
                "+36/20-123-4567");
        Person thirdPerson = new Person("Nagy Tihamér","nagy.tihamer@gmail.com",
                "1126 Budapest, Váci utca 1.","123456789","0000000-11111111-22222222",
                "+36/30/123-4567");

        Student firstStudent = new Student(firstPerson,"nc-123456","123456789");
        Student secondStudent = new Student(secondPerson,"nc-123654","987654321");
        Student thirdStudent = new Student(thirdPerson,"nc-123456","123456789");

        University university = new University();
        university.addStudent(firstStudent);
        university.addStudent(secondStudent);
        university.addStudent(thirdStudent);

        System.out.println("Ugyanaz-e az első és a második tanuló? " +
                university.areEqual(university.getStudents().get(0), university.getStudents().get(1)));
        System.out.println("Ugyanaz-e az első és a harmadik tanuló? " +
                university.areEqual(university.getStudents().get(0), university.getStudents().get(2)));
    }
}
