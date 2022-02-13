package metadata;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetaDataDao {
    private DataSource dataSource;

    public MetaDataDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getTableNames() {
        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData mdata = conn.getMetaData();
            return getTableNames(mdata);
        } catch (SQLException se) {
            throw new IllegalStateException("Can't read matadatas", se);
        }
    }

    private List<String> getTableNames(DatabaseMetaData mdata) throws SQLException {
        try (ResultSet rs = mdata.getTables(null, null, null, null)) {
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                names.add(rs.getString(3));
            }
            return names;
        }
    }
}
