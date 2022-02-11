package simplequery;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class EmployeesMain {
    class UserData {
        private String username;
        private String password;

        public UserData(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    private UserData readCredentials() {
        Properties properties = new Properties();
        String userName;
        String password;
        try (
                InputStream is= simpleupdate.EmployeesMain.class.getResourceAsStream("/parameters.properties");
        ) {
            properties.load(is);
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");
            return new UserData(userName,password);
        }

        catch (IOException ioe) {
            throw new IllegalStateException("Can't read parameters");
        }
    }

    private MariaDbDataSource createDatasource(UserData userData) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser(userData.getUsername());
            dataSource.setPassword(userData.getPassword());
        } catch (SQLException se) {
            throw new IllegalStateException("Can't connect to MariaDB Server", se);
        }
        return dataSource;
    }

    private Optional<String> selectNameById(MariaDbDataSource dataSource, Long id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT emp_name FROM employees WHERE id=?");
        ) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return Optional.of(rs.getString("emp_name"));
            }
            else {
                return Optional.empty();
            }

        } catch (SQLException se) {
            throw new IllegalStateException("Can't execute query", se);
        }
    }

    private List<String> selectAllName(MariaDbDataSource dataSource) {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
        ) {
            ResultSet rs = stmt.executeQuery("SELECT emp_name FROM employees;");
            List<String> result =new ArrayList<>();
            while (rs.next()) {
                result.add(rs.getString("emp_name"));
            }
            return result;

        } catch (SQLException se) {
            throw new IllegalStateException("Can't execute query", se);
        }
    }

    public static void main(String[] args) {
        EmployeesMain em = new EmployeesMain();
        UserData userData = em.readCredentials();
        MariaDbDataSource dataSource = em.createDatasource(userData);

        Optional<String> nameResult = em.selectNameById(dataSource, 1L);
        System.out.println(nameResult.orElseThrow(()->new IllegalArgumentException("Id not exists!")));

        List<String> names =  em.selectAllName(dataSource);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
