package transaction;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void createEmployeesTest() {
        employeesDao.createEmployees(List.of("Jack Doe", "Jane Doe", "Joe Doe", "John Doe"));
        assertEquals(4, employeesDao.listEmployeesName().size());
    }

    @Test
    void createInvalidEmployeesTest() {
        employeesDao.createEmployees(List.of("Jack Doe", "Jane Doe", "", "John Doe"));
        assertEquals(0, employeesDao.listEmployeesName().size());
    }
}
