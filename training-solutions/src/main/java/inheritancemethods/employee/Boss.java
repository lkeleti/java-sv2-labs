package inheritancemethods.employee;

public class Boss extends Employee{
    private final double LEADERSHIP_FACTOR = 0.1;
    private int numberOfEmployees;

    public Boss(String name, String address, double salary, int numberOfEmployees) {
        super(name, address, salary);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double getSalary() {
        double salary = super.getSalary();
        double bonus = salary * LEADERSHIP_FACTOR;
        return salary + (bonus*numberOfEmployees);
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }
}
