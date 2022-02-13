package advancedrs;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class employeesDaoTest {
    private EmployeesDao employeesDao;

    @BeforeEach
    void init(){
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException se) {
            throw new IllegalStateException("Can't connect to MariaDB Server", se);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        employeesDao = new EmployeesDao(dataSource);
    }

    @Test
    void testInsert() {
        employeesDao.createEmployee("Jane Doe");
        assertEquals(Arrays.asList("Jane Doe"),employeesDao.listEmployeesName());
    }

    @Test
    void testById() {
        long id = employeesDao.createEmployeeAndGetId("Jane Doe");
        assertEquals(1,id);
    }

    @Test
    void testOddNames() {
        employeesDao.createEmployee("Jane Doe");
        employeesDao.createEmployee("Jack Doe");
        employeesDao.createEmployee("John Doe");
        employeesDao.createEmployee("Joe Doe");
        employeesDao.createEmployee("Tom Doe");

        List<String> names = employeesDao.listOddEmployeesNames();
        assertEquals(3, names.size());
        assertEquals(List.of("Jack Doe", "Joe Doe", "Tom Doe"), names);
    }

    @Test
    void testUpdateName() {
        employeesDao.createEmployee("Jane Doe");
        employeesDao.createEmployee("Jack Doe");
        employeesDao.createEmployee("John Doe");
        employeesDao.createEmployee("Joe Doe");
        employeesDao.createEmployee("Tom Doe");

        employeesDao.updateNames();

        List<String> names =employeesDao.listEmployeesName();
        assertEquals(5, names.size());
        assertTrue( names.contains("Jane Doe"));
        assertTrue( names.contains("Mr. Jack Doe"));
    }
}
