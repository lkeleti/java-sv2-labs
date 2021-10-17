package stringconcat.employee;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee = new Employee("Kis Géza", "minőségellenőr", 520_000);
        System.out.println(employee.toString());
    }


}
