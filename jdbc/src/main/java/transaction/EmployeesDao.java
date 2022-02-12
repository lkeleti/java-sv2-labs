package transaction;

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

    public void createEmployees(List<String> names) {
        try (
                Connection conn = dataSource.getConnection();
        ) {
            conn.setAutoCommit(false);
            try  {
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employees (emp_name) VALUES (?)");
                for (String name : names) {
                    if ((name == null || name.isEmpty())) {
                        throw new IllegalArgumentException("Name can't be empty!");
                    }
                    pstmt.setString(1, name);
                    pstmt.executeUpdate();

                }
                conn.commit();
            }
            catch (IllegalArgumentException iae) {
                conn.rollback();
            }
            finally {
                conn.setAutoCommit(true);
            }

        } catch (SQLException se) {
            throw new IllegalStateException("Can't insert data", se);
        }
    }

    public long createEmployeeAndGetId(String name) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employees (emp_name) VALUES (?)",
                        Statement.RETURN_GENERATED_KEYS);
        ) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();

            return getIdByStatement(pstmt);


        } catch (SQLException se) {
            throw new IllegalStateException("Can't insert data", se);
        }
    }

    private long getIdByStatement(PreparedStatement pstmt) {
        try {
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            }
            throw new IllegalStateException("Can't get ID!");
        } catch (SQLException se) {
            throw new IllegalStateException("Can't get generated key!", se);
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
