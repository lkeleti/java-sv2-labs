package architecture;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {

    private MariaDbDataSource dataSource;

    public EmployeesDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createEmployee(String name) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employees (emp_name) VALUES (?)");
        ) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Can't insert data", se);
        }
    }

    public List<String> listEmployeesName() {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT emp_name FROM employees;");
        ) {
            List<String> result = new ArrayList<>();
            while (rs.next()) {
                result.add(rs.getString(1));
            }
            return result;
        } catch (SQLException se) {
            throw new IllegalStateException("Can't execute SELECT", se);
        }
    }

    public String findNameById(Long id) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT emp_name FROM employees WHERE id =?;");
        ) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("emp_name");
            }
            throw new IllegalArgumentException("Can't find employee with id: " + id);
        } catch (SQLException se) {
            throw new IllegalStateException("Can't execute SELECT", se);
        }
    }
}
