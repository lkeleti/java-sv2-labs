package intromethods.employee;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee = new Employee("Kovács Tihamérné", 2000, 500000);
        System.out.println(employee);

        employee.raiseSalary(50000);
        System.out.println(employee);

        employee.setName("Nagy Tünde");
        System.out.println(employee.getName());
        System.out.println(employee.getHiringYear());
        System.out.println(employee.getSalary());
        System.out.println(employee);
    }
}
