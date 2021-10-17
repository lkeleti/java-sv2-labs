package stringconcat.employee;

public class Employee {
    private String name;
    private String occupation;
    private int payment;

    public Employee(String name, String occupation, int payment) {
        this.name = name;
        this.occupation = occupation;
        this.payment = payment;
    }

    @Override
    public String toString() {
        return name + " - " + occupation +" - " + payment +" Ft";
    }
}
