package stringbasic;

public class Student {
    private Person person;
    private String neptunCode;
    private String educationalId;
    private String entranceCardNumber;

    public Student(Person person, String neptunCode, String educationalId) {
        this.person = person;
        this.neptunCode = neptunCode;
        this.educationalId = educationalId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getNeptunCode() {
        return neptunCode;
    }

    public void setNeptunCode(String neptunCode) {
        this.neptunCode = neptunCode;
    }

    public String getEducationalId() {
        return educationalId;
    }

    public void setEducationalId(String educationalId) {
        this.educationalId = educationalId;
    }

    public String getEntranceCardNumber() {
        return entranceCardNumber;
    }

    public void setEntranceCardNumber(String entranceCardNumber) {
        this.entranceCardNumber = entranceCardNumber;
    }
}
