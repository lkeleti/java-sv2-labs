package simpleupdate;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class EmployeesMain {
    /*
    create schema if not exists employees default character set utf8 collate utf8_hungarian_ci;
    create user 'employees'@'localhost' identified by 'employees';
    grant all on employees.* to 'employees'@'localhost';
    FLUSH PRIVILEGES;

    create table employees(id bigint auto_increment, emp_name varchar(255), constraint pk_employees primary key(id));
     */

    public static void main(String[] args) {
        Properties properties = new Properties();
        String userName;
        String password;
        try (
                InputStream is= EmployeesMain.class.getResourceAsStream("/parameters.properties");
        ) {
            properties.load(is);
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");
        }

        catch (IOException ioe) {
            throw new IllegalStateException("Can't read parameters");
        }

        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser(userName);
            dataSource.setPassword(password);
        } catch (SQLException se) {
            throw new IllegalStateException("Can't connect to MariaDB Server", se);
        }

        try (

                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO employees (emp_name) VALUES (?)");
        ) {
            stmt.setString(1, "Not Doe");
            stmt.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Can't insert data", se);
        }
    }
}
