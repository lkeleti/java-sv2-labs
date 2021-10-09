package introdate;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new Employee(1980,1,20,"John Doe");
        System.out.println(employee.getName() +"\n" + employee.getDateOfBirth() +"\n"+
                employee.getBeginEmployment());
    }
}
