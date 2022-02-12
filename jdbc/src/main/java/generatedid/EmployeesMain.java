package generatedid;

import architecture.EmployeesDao;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
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
                InputStream is = simpleupdate.EmployeesMain.class.getResourceAsStream("/parameters.properties");
        ) {
            properties.load(is);
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");
            return new UserData(userName, password);
        } catch (IOException ioe) {
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
    public static void main(String[] args) {
        EmployeesMain em = new EmployeesMain();
        UserData userData = em.readCredentials();
        MariaDbDataSource dataSource = em.createDatasource(userData);

        architecture.EmployeesDao ed = new EmployeesDao(dataSource);
        //ed.createEmployee("New John Doe");
        System.out.println(ed.listEmployeesName());
        System.out.println(ed.findNameById(1L));
        //System.out.println(ed.findNameById(10L));
    }
}
