package covid;

public class Person {

    private String fullName;
    private String zip;
    private int age;
    private String email;
    private String taj;

    public Person(String fullName, String zip, int age, String email, String taj) {
        this.fullName = fullName;
        this.zip = zip;
        this.age = age;
        this.email = email;
        this.taj = taj;
    }

    public String getFullName() {
        return fullName;
    }

    public String getZip() {
        return zip;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getTaj() {
        return taj;
    }
}
