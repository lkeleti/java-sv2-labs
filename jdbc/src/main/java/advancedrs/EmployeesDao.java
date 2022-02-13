package advancedrs;

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

    public List<String> listOddEmployeesNames() {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT emp_name FROM employees ORDER BY emp_name;");
                ){
            List<String> names = new ArrayList<>();
            if (rs.next()){
                names.add(rs.getString("emp_name"));
            }
            while (rs.relative(2)) {
                names.add(rs.getString("emp_name"));
            }
            return names;
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can't execute SELECT", se);
        }
    }

    public void updateNames() {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT id, emp_name FROM employees;")
        ){
            while (rs.next()){
                String name = rs.getString("emp_name");
                if (!name.startsWith("Jane")) {
                    rs.updateString("emp_name","Mr. " + name);
                    rs.updateRow();
                }
            }
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can't execute query");
        }
    }
}


