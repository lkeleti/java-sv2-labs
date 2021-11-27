package dynamictypes.school;

public class SchoolMain {
    public static void main(String[] args) {
        School school = new School("School",14);
        School primarySchool = new PrimarySchool("Primary",8);
        School secondarySchool = new SecondarySchool("Secondary",4);

        System.out.println(school);
        System.out.println(primarySchool);
        System.out.println(secondarySchool);
    }
}
