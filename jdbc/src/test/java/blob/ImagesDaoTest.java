package blob;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

class ImagesDaoTest {
    ImagesDao imagesDao;

    @BeforeEach
    void init() {
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

        imagesDao = new ImagesDao(dataSource);
    }

    @Test
    void saveAndReadImage() {
        imagesDao.saveImage("training360.gif", ImagesDaoTest.class.getResourceAsStream("/training360.gif"));

        try (InputStream is = imagesDao.getImageByName("training360.gif");
             OutputStream os = new BufferedOutputStream(Files.newOutputStream(Path.of("src/test/resources/training360_1.gif")));
        ){
            os.write(is.readAllBytes());
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can't read image", ioe);
        }
    }
}
