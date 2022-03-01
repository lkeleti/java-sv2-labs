package covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

public class CovidMain {

    public static void main(String[] args) {

        MariaDbDataSource dataSource = new MariaDbDataSource();

        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUserName("covid");
            dataSource.setPassword("covid");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can't connect to MariaDb", sqle);
        }

        CovidService covidService = new CovidService(dataSource);
        covidService.menu();
    }
}
